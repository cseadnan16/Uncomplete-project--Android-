package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

final class ActiveResources {
    private static final int MSG_CLEAN_REF = 1;
    final Map<Key, ResourceWeakReference> activeEngineResources = new HashMap();

    /* renamed from: cb */
    private volatile DequeuedResourceCallback f47cb;
    private Thread cleanReferenceQueueThread;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private EngineResource.ResourceListener listener;
    private final Handler mainHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            if (msg.what != 1) {
                return false;
            }
            ActiveResources.this.cleanupActiveReference((ResourceWeakReference) msg.obj);
            return true;
        }
    });
    private ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    ActiveResources(boolean isActiveResourceRetentionAllowed2) {
        this.isActiveResourceRetentionAllowed = isActiveResourceRetentionAllowed2;
    }

    /* access modifiers changed from: package-private */
    public void setListener(EngineResource.ResourceListener listener2) {
        this.listener = listener2;
    }

    /* access modifiers changed from: package-private */
    public void activate(Key key, EngineResource<?> resource) {
        ResourceWeakReference removed = this.activeEngineResources.put(key, new ResourceWeakReference(key, resource, getReferenceQueue(), this.isActiveResourceRetentionAllowed));
        if (removed != null) {
            removed.reset();
        }
    }

    /* access modifiers changed from: package-private */
    public void deactivate(Key key) {
        ResourceWeakReference removed = this.activeEngineResources.remove(key);
        if (removed != null) {
            removed.reset();
        }
    }

    /* access modifiers changed from: package-private */
    public EngineResource<?> get(Key key) {
        ResourceWeakReference activeRef = this.activeEngineResources.get(key);
        if (activeRef == null) {
            return null;
        }
        EngineResource<?> active = (EngineResource) activeRef.get();
        if (active == null) {
            cleanupActiveReference(activeRef);
        }
        return active;
    }

    /* access modifiers changed from: package-private */
    public void cleanupActiveReference(ResourceWeakReference ref) {
        Util.assertMainThread();
        this.activeEngineResources.remove(ref.key);
        if (ref.isCacheable && ref.resource != null) {
            EngineResource<?> newResource = new EngineResource<>(ref.resource, true, false);
            newResource.setResourceListener(ref.key, this.listener);
            this.listener.onResourceReleased(ref.key, newResource);
        }
    }

    private ReferenceQueue<EngineResource<?>> getReferenceQueue() {
        if (this.resourceReferenceQueue == null) {
            this.resourceReferenceQueue = new ReferenceQueue<>();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    ActiveResources.this.cleanReferenceQueue();
                }
            }, "glide-active-resources");
            this.cleanReferenceQueueThread = thread;
            thread.start();
        }
        return this.resourceReferenceQueue;
    }

    /* access modifiers changed from: package-private */
    public void cleanReferenceQueue() {
        while (!this.isShutdown) {
            try {
                this.mainHandler.obtainMessage(1, (ResourceWeakReference) this.resourceReferenceQueue.remove()).sendToTarget();
                DequeuedResourceCallback current = this.f47cb;
                if (current != null) {
                    current.onResourceDequeued();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setDequeuedResourceCallback(DequeuedResourceCallback cb) {
        this.f47cb = cb;
    }

    /* access modifiers changed from: package-private */
    public void shutdown() {
        this.isShutdown = true;
        Thread thread = this.cleanReferenceQueueThread;
        if (thread != null) {
            thread.interrupt();
            try {
                this.cleanReferenceQueueThread.join(TimeUnit.SECONDS.toMillis(5));
                if (this.cleanReferenceQueueThread.isAlive()) {
                    throw new RuntimeException("Failed to join in time");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final boolean isCacheable;
        final Key key;
        Resource<?> resource;

        ResourceWeakReference(Key key2, EngineResource<?> referent, ReferenceQueue<? super EngineResource<?>> queue, boolean isActiveResourceRetentionAllowed) {
            super(referent, queue);
            this.key = (Key) Preconditions.checkNotNull(key2);
            this.resource = (!referent.isCacheable() || !isActiveResourceRetentionAllowed) ? null : (Resource) Preconditions.checkNotNull(referent.getResource());
            this.isCacheable = referent.isCacheable();
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.resource = null;
            clear();
        }
    }
}
