package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RequestOptions implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;
    private DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isCacheable = true;
    private boolean isLocked;
    private boolean isScaleOnlyOrNoTransform = true;
    private boolean isTransformationAllowed = true;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Options options = new Options();
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority = Priority.NORMAL;
    private Class<?> resourceClass = Object.class;
    private Key signature = EmptySignature.obtain();
    private float sizeMultiplier = 1.0f;
    private Resources.Theme theme;
    private Map<Class<?>, Transformation<?>> transformations = new HashMap();
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;

    public static RequestOptions sizeMultiplierOf(float sizeMultiplier2) {
        return new RequestOptions().sizeMultiplier(sizeMultiplier2);
    }

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy2) {
        return new RequestOptions().diskCacheStrategy(diskCacheStrategy2);
    }

    public static RequestOptions priorityOf(Priority priority2) {
        return new RequestOptions().priority(priority2);
    }

    public static RequestOptions placeholderOf(Drawable placeholder) {
        return new RequestOptions().placeholder(placeholder);
    }

    public static RequestOptions placeholderOf(int placeholderId2) {
        return new RequestOptions().placeholder(placeholderId2);
    }

    public static RequestOptions errorOf(Drawable errorDrawable) {
        return new RequestOptions().error(errorDrawable);
    }

    public static RequestOptions errorOf(int errorId2) {
        return new RequestOptions().error(errorId2);
    }

    public static RequestOptions skipMemoryCacheOf(boolean skipMemoryCache) {
        if (skipMemoryCache) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions overrideOf(int width, int height) {
        return new RequestOptions().override(width, height);
    }

    public static RequestOptions overrideOf(int size) {
        return overrideOf(size, size);
    }

    public static RequestOptions signatureOf(Key signature2) {
        return new RequestOptions().signature(signature2);
    }

    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new RequestOptions().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new RequestOptions().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    public static RequestOptions centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new RequestOptions().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    public static RequestOptions circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new RequestOptions().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    public static RequestOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new RequestOptions().transform(transformation);
    }

    public static RequestOptions noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new RequestOptions().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    public static <T> RequestOptions option(Option<T> option, T value) {
        return new RequestOptions().set(option, value);
    }

    public static RequestOptions decodeTypeOf(Class<?> resourceClass2) {
        return new RequestOptions().decode(resourceClass2);
    }

    public static RequestOptions formatOf(DecodeFormat format) {
        return new RequestOptions().format(format);
    }

    public static RequestOptions frameOf(long frameTimeMicros) {
        return new RequestOptions().frame(frameTimeMicros);
    }

    public static RequestOptions downsampleOf(DownsampleStrategy strategy) {
        return new RequestOptions().downsample(strategy);
    }

    public static RequestOptions timeoutOf(int timeout) {
        return new RequestOptions().timeout(timeout);
    }

    public static RequestOptions encodeQualityOf(int quality) {
        return new RequestOptions().encodeQuality(quality);
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat format) {
        return new RequestOptions().encodeFormat(format);
    }

    public static RequestOptions noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }

    private static boolean isSet(int fields2, int flag) {
        return (fields2 & flag) != 0;
    }

    public RequestOptions sizeMultiplier(float sizeMultiplier2) {
        if (this.isAutoCloneEnabled) {
            return clone().sizeMultiplier(sizeMultiplier2);
        }
        if (sizeMultiplier2 < 0.0f || sizeMultiplier2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = sizeMultiplier2;
        this.fields |= 2;
        return selfOrThrowIfLocked();
    }

    public RequestOptions useUnlimitedSourceGeneratorsPool(boolean flag) {
        if (this.isAutoCloneEnabled) {
            return clone().useUnlimitedSourceGeneratorsPool(flag);
        }
        this.useUnlimitedSourceGeneratorsPool = flag;
        this.fields |= 262144;
        return selfOrThrowIfLocked();
    }

    public RequestOptions useAnimationPool(boolean flag) {
        if (this.isAutoCloneEnabled) {
            return clone().useAnimationPool(flag);
        }
        this.useAnimationPool = flag;
        this.fields |= 1048576;
        return selfOrThrowIfLocked();
    }

    public RequestOptions onlyRetrieveFromCache(boolean flag) {
        if (this.isAutoCloneEnabled) {
            return clone().onlyRetrieveFromCache(flag);
        }
        this.onlyRetrieveFromCache = flag;
        this.fields |= 524288;
        return selfOrThrowIfLocked();
    }

    public RequestOptions diskCacheStrategy(DiskCacheStrategy strategy) {
        if (this.isAutoCloneEnabled) {
            return clone().diskCacheStrategy(strategy);
        }
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(strategy);
        this.fields |= 4;
        return selfOrThrowIfLocked();
    }

    public RequestOptions priority(Priority priority2) {
        if (this.isAutoCloneEnabled) {
            return clone().priority(priority2);
        }
        this.priority = (Priority) Preconditions.checkNotNull(priority2);
        this.fields |= 8;
        return selfOrThrowIfLocked();
    }

    public RequestOptions placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        this.fields |= 64;
        return selfOrThrowIfLocked();
    }

    public RequestOptions placeholder(int resourceId) {
        if (this.isAutoCloneEnabled) {
            return clone().placeholder(resourceId);
        }
        this.placeholderId = resourceId;
        this.fields |= 128;
        return selfOrThrowIfLocked();
    }

    public RequestOptions fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        this.fields |= 8192;
        return selfOrThrowIfLocked();
    }

    public RequestOptions fallback(int resourceId) {
        if (this.isAutoCloneEnabled) {
            return clone().fallback(resourceId);
        }
        this.fallbackId = resourceId;
        this.fields |= 16384;
        return selfOrThrowIfLocked();
    }

    public RequestOptions error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        this.fields |= 16;
        return selfOrThrowIfLocked();
    }

    public RequestOptions error(int resourceId) {
        if (this.isAutoCloneEnabled) {
            return clone().error(resourceId);
        }
        this.errorId = resourceId;
        this.fields |= 32;
        return selfOrThrowIfLocked();
    }

    public RequestOptions theme(Resources.Theme theme2) {
        if (this.isAutoCloneEnabled) {
            return clone().theme(theme2);
        }
        this.theme = theme2;
        this.fields |= 32768;
        return selfOrThrowIfLocked();
    }

    public RequestOptions skipMemoryCache(boolean skip) {
        if (this.isAutoCloneEnabled) {
            return clone().skipMemoryCache(true);
        }
        this.isCacheable = !skip;
        this.fields |= 256;
        return selfOrThrowIfLocked();
    }

    public RequestOptions override(int width, int height) {
        if (this.isAutoCloneEnabled) {
            return clone().override(width, height);
        }
        this.overrideWidth = width;
        this.overrideHeight = height;
        this.fields |= 512;
        return selfOrThrowIfLocked();
    }

    public RequestOptions override(int size) {
        return override(size, size);
    }

    public RequestOptions signature(Key signature2) {
        if (this.isAutoCloneEnabled) {
            return clone().signature(signature2);
        }
        this.signature = (Key) Preconditions.checkNotNull(signature2);
        this.fields |= 1024;
        return selfOrThrowIfLocked();
    }

    public RequestOptions clone() {
        try {
            RequestOptions result = (RequestOptions) super.clone();
            Options options2 = new Options();
            result.options = options2;
            options2.putAll(this.options);
            HashMap hashMap = new HashMap();
            result.transformations = hashMap;
            hashMap.putAll(this.transformations);
            result.isLocked = false;
            result.isAutoCloneEnabled = false;
            return result;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> RequestOptions set(Option<T> option, T value) {
        if (this.isAutoCloneEnabled) {
            return clone().set(option, value);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(value);
        this.options.set(option, value);
        return selfOrThrowIfLocked();
    }

    public RequestOptions decode(Class<?> resourceClass2) {
        if (this.isAutoCloneEnabled) {
            return clone().decode(resourceClass2);
        }
        this.resourceClass = (Class) Preconditions.checkNotNull(resourceClass2);
        this.fields |= 4096;
        return selfOrThrowIfLocked();
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public RequestOptions encodeFormat(Bitmap.CompressFormat format) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(format));
    }

    public RequestOptions encodeQuality(int quality) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(quality));
    }

    public RequestOptions frame(long frameTimeMicros) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(frameTimeMicros));
    }

    public RequestOptions format(DecodeFormat format) {
        Preconditions.checkNotNull(format);
        return set(Downsampler.DECODE_FORMAT, format).set(GifOptions.DECODE_FORMAT, format);
    }

    public RequestOptions disallowHardwareConfig() {
        return set(Downsampler.ALLOW_HARDWARE_CONFIG, false);
    }

    public RequestOptions downsample(DownsampleStrategy strategy) {
        return set(Downsampler.DOWNSAMPLE_STRATEGY, Preconditions.checkNotNull(strategy));
    }

    public RequestOptions timeout(int timeoutMs) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(timeoutMs));
    }

    public RequestOptions optionalCenterCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, (Transformation<Bitmap>) new CenterCrop());
    }

    public RequestOptions centerCrop() {
        return transform(DownsampleStrategy.CENTER_OUTSIDE, (Transformation<Bitmap>) new CenterCrop());
    }

    public RequestOptions optionalFitCenter() {
        return optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public RequestOptions fitCenter() {
        return scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public RequestOptions optionalCenterInside() {
        return optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public RequestOptions centerInside() {
        return scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public RequestOptions optionalCircleCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, (Transformation<Bitmap>) new CircleCrop());
    }

    public RequestOptions circleCrop() {
        return transform(DownsampleStrategy.CENTER_INSIDE, (Transformation<Bitmap>) new CircleCrop());
    }

    /* access modifiers changed from: package-private */
    public final RequestOptions optionalTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return clone().optionalTransform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation, false);
    }

    /* access modifiers changed from: package-private */
    public final RequestOptions transform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return clone().transform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    private RequestOptions scaleOnlyTransform(DownsampleStrategy strategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(strategy, transformation, true);
    }

    private RequestOptions optionalScaleOnlyTransform(DownsampleStrategy strategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(strategy, transformation, false);
    }

    private RequestOptions scaleOnlyTransform(DownsampleStrategy strategy, Transformation<Bitmap> transformation, boolean isTransformationRequired2) {
        RequestOptions result = isTransformationRequired2 ? transform(strategy, transformation) : optionalTransform(strategy, transformation);
        result.isScaleOnlyOrNoTransform = true;
        return result;
    }

    public RequestOptions transform(Transformation<Bitmap> transformation) {
        return transform(transformation, true);
    }

    public RequestOptions transforms(Transformation<Bitmap>... transformations2) {
        return transform((Transformation<Bitmap>) new MultiTransformation((Transformation<T>[]) transformations2), true);
    }

    public RequestOptions optionalTransform(Transformation<Bitmap> transformation) {
        return transform(transformation, false);
    }

    private RequestOptions transform(Transformation<Bitmap> transformation, boolean isRequired) {
        if (this.isAutoCloneEnabled) {
            return clone().transform(transformation, isRequired);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, isRequired);
        transform(Bitmap.class, transformation, isRequired);
        transform(Drawable.class, drawableTransformation, isRequired);
        transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), isRequired);
        transform(GifDrawable.class, new GifDrawableTransformation(transformation), isRequired);
        return selfOrThrowIfLocked();
    }

    public <T> RequestOptions optionalTransform(Class<T> resourceClass2, Transformation<T> transformation) {
        return transform(resourceClass2, transformation, false);
    }

    private <T> RequestOptions transform(Class<T> resourceClass2, Transformation<T> transformation, boolean isRequired) {
        if (this.isAutoCloneEnabled) {
            return clone().transform(resourceClass2, transformation, isRequired);
        }
        Preconditions.checkNotNull(resourceClass2);
        Preconditions.checkNotNull(transformation);
        this.transformations.put(resourceClass2, transformation);
        int i = this.fields | 2048;
        this.fields = i;
        this.isTransformationAllowed = true;
        int i2 = i | 65536;
        this.fields = i2;
        this.isScaleOnlyOrNoTransform = false;
        if (isRequired) {
            this.fields = i2 | 131072;
            this.isTransformationRequired = true;
        }
        return selfOrThrowIfLocked();
    }

    public <T> RequestOptions transform(Class<T> resourceClass2, Transformation<T> transformation) {
        return transform(resourceClass2, transformation, true);
    }

    public RequestOptions dontTransform() {
        if (this.isAutoCloneEnabled) {
            return clone().dontTransform();
        }
        this.transformations.clear();
        int i = this.fields & -2049;
        this.fields = i;
        this.isTransformationRequired = false;
        int i2 = i & -131073;
        this.fields = i2;
        this.isTransformationAllowed = false;
        this.fields = i2 | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return selfOrThrowIfLocked();
    }

    public RequestOptions dontAnimate() {
        return set(GifOptions.DISABLE_ANIMATION, true);
    }

    public RequestOptions apply(RequestOptions other) {
        if (this.isAutoCloneEnabled) {
            return clone().apply(other);
        }
        if (isSet(other.fields, 2)) {
            this.sizeMultiplier = other.sizeMultiplier;
        }
        if (isSet(other.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = other.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(other.fields, 1048576)) {
            this.useAnimationPool = other.useAnimationPool;
        }
        if (isSet(other.fields, 4)) {
            this.diskCacheStrategy = other.diskCacheStrategy;
        }
        if (isSet(other.fields, 8)) {
            this.priority = other.priority;
        }
        if (isSet(other.fields, 16)) {
            this.errorPlaceholder = other.errorPlaceholder;
        }
        if (isSet(other.fields, 32)) {
            this.errorId = other.errorId;
        }
        if (isSet(other.fields, 64)) {
            this.placeholderDrawable = other.placeholderDrawable;
        }
        if (isSet(other.fields, 128)) {
            this.placeholderId = other.placeholderId;
        }
        if (isSet(other.fields, 256)) {
            this.isCacheable = other.isCacheable;
        }
        if (isSet(other.fields, 512)) {
            this.overrideWidth = other.overrideWidth;
            this.overrideHeight = other.overrideHeight;
        }
        if (isSet(other.fields, 1024)) {
            this.signature = other.signature;
        }
        if (isSet(other.fields, 4096)) {
            this.resourceClass = other.resourceClass;
        }
        if (isSet(other.fields, 8192)) {
            this.fallbackDrawable = other.fallbackDrawable;
        }
        if (isSet(other.fields, 16384)) {
            this.fallbackId = other.fallbackId;
        }
        if (isSet(other.fields, 32768)) {
            this.theme = other.theme;
        }
        if (isSet(other.fields, 65536)) {
            this.isTransformationAllowed = other.isTransformationAllowed;
        }
        if (isSet(other.fields, 131072)) {
            this.isTransformationRequired = other.isTransformationRequired;
        }
        if (isSet(other.fields, 2048)) {
            this.transformations.putAll(other.transformations);
            this.isScaleOnlyOrNoTransform = other.isScaleOnlyOrNoTransform;
        }
        if (isSet(other.fields, 524288)) {
            this.onlyRetrieveFromCache = other.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i = this.fields & -2049;
            this.fields = i;
            this.isTransformationRequired = false;
            this.fields = i & -131073;
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= other.fields;
        this.options.putAll(other.options);
        return selfOrThrowIfLocked();
    }

    public boolean equals(Object o) {
        if (!(o instanceof RequestOptions)) {
            return false;
        }
        RequestOptions other = (RequestOptions) o;
        if (Float.compare(other.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == other.errorId && Util.bothNullOrEqual(this.errorPlaceholder, other.errorPlaceholder) && this.placeholderId == other.placeholderId && Util.bothNullOrEqual(this.placeholderDrawable, other.placeholderDrawable) && this.fallbackId == other.fallbackId && Util.bothNullOrEqual(this.fallbackDrawable, other.fallbackDrawable) && this.isCacheable == other.isCacheable && this.overrideHeight == other.overrideHeight && this.overrideWidth == other.overrideWidth && this.isTransformationRequired == other.isTransformationRequired && this.isTransformationAllowed == other.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == other.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == other.onlyRetrieveFromCache && this.diskCacheStrategy.equals(other.diskCacheStrategy) && this.priority == other.priority && this.options.equals(other.options) && this.transformations.equals(other.transformations) && this.resourceClass.equals(other.resourceClass) && Util.bothNullOrEqual(this.signature, other.signature) && Util.bothNullOrEqual(this.theme, other.theme)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Util.hashCode((Object) this.theme, Util.hashCode((Object) this.signature, Util.hashCode((Object) this.resourceClass, Util.hashCode((Object) this.transformations, Util.hashCode((Object) this.options, Util.hashCode((Object) this.priority, Util.hashCode((Object) this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, Util.hashCode(this.overrideWidth, Util.hashCode(this.overrideHeight, Util.hashCode(this.isCacheable, Util.hashCode((Object) this.fallbackDrawable, Util.hashCode(this.fallbackId, Util.hashCode((Object) this.placeholderDrawable, Util.hashCode(this.placeholderId, Util.hashCode((Object) this.errorPlaceholder, Util.hashCode(this.errorId, Util.hashCode(this.sizeMultiplier)))))))))))))))))))));
    }

    public RequestOptions lock() {
        this.isLocked = true;
        return this;
    }

    public RequestOptions autoClone() {
        if (!this.isLocked || this.isAutoCloneEnabled) {
            this.isAutoCloneEnabled = true;
            return lock();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    private RequestOptions selfOrThrowIfLocked() {
        if (!this.isLocked) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    /* access modifiers changed from: protected */
    public boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final Key getSignature() {
        return this.signature;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    /* access modifiers changed from: package-private */
    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    private boolean isSet(int flag) {
        return isSet(this.fields, flag);
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }
}
