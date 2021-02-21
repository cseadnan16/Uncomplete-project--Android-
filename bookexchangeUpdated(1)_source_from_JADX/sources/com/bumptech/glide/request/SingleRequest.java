package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    private static final Pools.Pool<SingleRequest<?>> POOL = FactoryPools.simple(150, new FactoryPools.Factory<SingleRequest<?>>() {
        public SingleRequest<?> create() {
            return new SingleRequest<>();
        }
    });
    private static final String TAG = "Request";
    private TransitionFactory<? super R> animationFactory;
    private Context context;
    private Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private RequestListener<R> requestListener;
    private RequestOptions requestOptions;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private Target<R> target;
    private RequestListener<R> targetListener;
    private Class<R> transcodeClass;
    private int width;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    public static <R> SingleRequest<R> obtain(Context context2, GlideContext glideContext2, Object model2, Class<R> transcodeClass2, RequestOptions requestOptions2, int overrideWidth2, int overrideHeight2, Priority priority2, Target<R> target2, RequestListener<R> targetListener2, RequestListener<R> requestListener2, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> animationFactory2) {
        SingleRequest<R> request = POOL.acquire();
        if (request == null) {
            request = new SingleRequest<>();
        }
        request.init(context2, glideContext2, model2, transcodeClass2, requestOptions2, overrideWidth2, overrideHeight2, priority2, target2, targetListener2, requestListener2, requestCoordinator2, engine2, animationFactory2);
        return request;
    }

    SingleRequest() {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
    }

    private void init(Context context2, GlideContext glideContext2, Object model2, Class<R> transcodeClass2, RequestOptions requestOptions2, int overrideWidth2, int overrideHeight2, Priority priority2, Target<R> target2, RequestListener<R> targetListener2, RequestListener<R> requestListener2, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> animationFactory2) {
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = model2;
        this.transcodeClass = transcodeClass2;
        this.requestOptions = requestOptions2;
        this.overrideWidth = overrideWidth2;
        this.overrideHeight = overrideHeight2;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = targetListener2;
        this.requestListener = requestListener2;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = animationFactory2;
        this.status = Status.PENDING;
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public void recycle() {
        assertNotCallingCallbacks();
        this.context = null;
        this.glideContext = null;
        this.model = null;
        this.transcodeClass = null;
        this.requestOptions = null;
        this.overrideWidth = -1;
        this.overrideHeight = -1;
        this.target = null;
        this.requestListener = null;
        this.targetListener = null;
        this.requestCoordinator = null;
        this.animationFactory = null;
        this.loadStatus = null;
        this.errorDrawable = null;
        this.placeholderDrawable = null;
        this.fallbackDrawable = null;
        this.width = -1;
        this.height = -1;
        POOL.release(this);
    }

    public void begin() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                this.width = this.overrideWidth;
                this.height = this.overrideHeight;
            }
            onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
        } else if (this.status == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (this.status == Status.COMPLETE) {
            onResourceReady(this.resource, DataSource.MEMORY_CACHE);
        } else {
            this.status = Status.WAITING_FOR_SIZE;
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                onSizeReady(this.overrideWidth, this.overrideHeight);
            } else {
                this.target.getSize(this);
            }
            if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                this.target.onLoadStarted(getPlaceholderDrawable());
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        this.status = Status.CANCELLED;
        Engine.LoadStatus loadStatus2 = this.loadStatus;
        if (loadStatus2 != null) {
            loadStatus2.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public void clear() {
        Util.assertMainThread();
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        if (this.status != Status.CLEARED) {
            cancel();
            Resource<R> resource2 = this.resource;
            if (resource2 != null) {
                releaseResource(resource2);
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
        }
    }

    public boolean isPaused() {
        return this.status == Status.PAUSED;
    }

    public void pause() {
        clear();
        this.status = Status.PAUSED;
    }

    private void releaseResource(Resource<?> resource2) {
        this.engine.release(resource2);
        this.resource = null;
    }

    public boolean isRunning() {
        return this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
    }

    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    public boolean isResourceSet() {
        return isComplete();
    }

    public boolean isCancelled() {
        return this.status == Status.CANCELLED || this.status == Status.CLEARED;
    }

    public boolean isFailed() {
        return this.status == Status.FAILED;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable2 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable2;
            if (placeholderDrawable2 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable2 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable2;
            if (fallbackDrawable2 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int resourceId) {
        return DrawableDecoderCompat.getDrawable(this.glideContext, resourceId, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable error = null;
            if (this.model == null) {
                error = getFallbackDrawable();
            }
            if (error == null) {
                error = getErrorDrawable();
            }
            if (error == null) {
                error = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(error);
        }
    }

    public void onSizeReady(int width2, int height2) {
        this.stateVerifier.throwIfRecycled();
        if (IS_VERBOSE_LOGGABLE) {
            logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
        }
        if (this.status == Status.WAITING_FOR_SIZE) {
            this.status = Status.RUNNING;
            float sizeMultiplier = this.requestOptions.getSizeMultiplier();
            this.width = maybeApplySizeMultiplier(width2, sizeMultiplier);
            this.height = maybeApplySizeMultiplier(height2, sizeMultiplier);
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
            }
            Engine engine2 = this.engine;
            float f = sizeMultiplier;
            GlideContext glideContext2 = this.glideContext;
            Engine.LoadStatus load = engine2.load(glideContext2, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this);
            this.loadStatus = load;
            if (this.status != Status.RUNNING) {
                this.loadStatus = null;
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    private static int maybeApplySizeMultiplier(int size, float sizeMultiplier) {
        return size == Integer.MIN_VALUE ? size : Math.round(((float) size) * sizeMultiplier);
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || !requestCoordinator2.isAnyResourceSet();
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestSuccess(this);
        }
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestFailed(this);
        }
    }

    public void onResourceReady(Resource<?> resource2, DataSource dataSource) {
        this.stateVerifier.throwIfRecycled();
        this.loadStatus = null;
        if (resource2 == null) {
            onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
            return;
        }
        Object received = resource2.get();
        if (received == null || !this.transcodeClass.isAssignableFrom(received.getClass())) {
            releaseResource(resource2);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.transcodeClass);
            sb.append(" but instead got ");
            String str = "";
            sb.append(received != null ? received.getClass() : str);
            sb.append("{");
            sb.append(received);
            sb.append("} inside Resource{");
            sb.append(resource2);
            sb.append("}.");
            if (received == null) {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            sb.append(str);
            onLoadFailed(new GlideException(sb.toString()));
        } else if (!canSetResource()) {
            releaseResource(resource2);
            this.status = Status.COMPLETE;
        } else {
            onResourceReady(resource2, received, dataSource);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0093, code lost:
        if (r8.targetListener.onResourceReady(r10, r8.model, r8.target, r11, r6) == false) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0080, code lost:
        if (r8.requestListener.onResourceReady(r10, r8.model, r8.target, r11, r6) == false) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onResourceReady(com.bumptech.glide.load.engine.Resource<R> r9, R r10, com.bumptech.glide.load.DataSource r11) {
        /*
            r8 = this;
            boolean r6 = r8.isFirstReadyResource()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r8.status = r0
            r8.resource = r9
            com.bumptech.glide.GlideContext r0 = r8.glideContext
            int r0 = r0.getLogLevel()
            r1 = 3
            if (r0 > r1) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Finished loading "
            r0.append(r1)
            java.lang.Class r1 = r10.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = " from "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " for "
            r0.append(r1)
            java.lang.Object r1 = r8.model
            r0.append(r1)
            java.lang.String r1 = " with size ["
            r0.append(r1)
            int r1 = r8.width
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            int r1 = r8.height
            r0.append(r1)
            java.lang.String r1 = "] in "
            r0.append(r1)
            long r1 = r8.startTime
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r1)
            r0.append(r1)
            java.lang.String r1 = " ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Glide"
            android.util.Log.d(r1, r0)
        L_0x006b:
            r0 = 1
            r8.isCallingCallbacks = r0
            r7 = 0
            com.bumptech.glide.request.RequestListener<R> r0 = r8.requestListener     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x0082
            com.bumptech.glide.request.RequestListener<R> r0 = r8.requestListener     // Catch:{ all -> 0x00a7 }
            java.lang.Object r2 = r8.model     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.request.target.Target<R> r3 = r8.target     // Catch:{ all -> 0x00a7 }
            r1 = r10
            r4 = r11
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a7 }
            if (r0 != 0) goto L_0x00a0
        L_0x0082:
            com.bumptech.glide.request.RequestListener<R> r0 = r8.targetListener     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x0095
            com.bumptech.glide.request.RequestListener<R> r0 = r8.targetListener     // Catch:{ all -> 0x00a7 }
            java.lang.Object r2 = r8.model     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.request.target.Target<R> r3 = r8.target     // Catch:{ all -> 0x00a7 }
            r1 = r10
            r4 = r11
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a7 }
            if (r0 != 0) goto L_0x00a0
        L_0x0095:
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r0 = r8.animationFactory     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.request.transition.Transition r0 = r0.build(r11, r6)     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.request.target.Target<R> r1 = r8.target     // Catch:{ all -> 0x00a7 }
            r1.onResourceReady(r10, r0)     // Catch:{ all -> 0x00a7 }
        L_0x00a0:
            r8.isCallingCallbacks = r7
            r8.notifyLoadSuccess()
            return
        L_0x00a7:
            r0 = move-exception
            r8.isCallingCallbacks = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    public void onLoadFailed(GlideException e) {
        onLoadFailed(e, 5);
    }

    /* JADX INFO: finally extract failed */
    private void onLoadFailed(GlideException e, int maxLogLevel) {
        this.stateVerifier.throwIfRecycled();
        int logLevel = this.glideContext.getLogLevel();
        if (logLevel <= maxLogLevel) {
            Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", e);
            if (logLevel <= 4) {
                e.logRootCauses(GLIDE_TAG);
            }
        }
        this.loadStatus = null;
        this.status = Status.FAILED;
        this.isCallingCallbacks = true;
        try {
            if ((this.requestListener == null || !this.requestListener.onLoadFailed(e, this.model, this.target, isFirstReadyResource())) && (this.targetListener == null || !this.targetListener.onLoadFailed(e, this.model, this.target, isFirstReadyResource()))) {
                setErrorPlaceholder();
            }
            this.isCallingCallbacks = false;
            notifyLoadFailed();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEquivalentTo(com.bumptech.glide.request.Request r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bumptech.glide.request.SingleRequest
            r1 = 0
            if (r0 == 0) goto L_0x0049
            r0 = r5
            com.bumptech.glide.request.SingleRequest r0 = (com.bumptech.glide.request.SingleRequest) r0
            int r2 = r4.overrideWidth
            int r3 = r0.overrideWidth
            if (r2 != r3) goto L_0x0047
            int r2 = r4.overrideHeight
            int r3 = r0.overrideHeight
            if (r2 != r3) goto L_0x0047
            java.lang.Object r2 = r4.model
            java.lang.Object r3 = r0.model
            boolean r2 = com.bumptech.glide.util.Util.bothModelsNullEquivalentOrEquals(r2, r3)
            if (r2 == 0) goto L_0x0047
            java.lang.Class<R> r2 = r4.transcodeClass
            java.lang.Class<R> r3 = r0.transcodeClass
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0047
            com.bumptech.glide.request.RequestOptions r2 = r4.requestOptions
            com.bumptech.glide.request.RequestOptions r3 = r0.requestOptions
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0047
            com.bumptech.glide.Priority r2 = r4.priority
            com.bumptech.glide.Priority r3 = r0.priority
            if (r2 != r3) goto L_0x0047
            com.bumptech.glide.request.RequestListener<R> r2 = r4.requestListener
            if (r2 == 0) goto L_0x0041
            com.bumptech.glide.request.RequestListener<R> r2 = r0.requestListener
            if (r2 == 0) goto L_0x0047
            goto L_0x0045
        L_0x0041:
            com.bumptech.glide.request.RequestListener<R> r2 = r0.requestListener
            if (r2 != 0) goto L_0x0047
        L_0x0045:
            r1 = 1
            goto L_0x0048
        L_0x0047:
        L_0x0048:
            return r1
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    private void logV(String message) {
        Log.v(TAG, message + " this: " + this.tag);
    }
}
