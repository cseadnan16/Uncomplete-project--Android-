package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import okio.Source;

public abstract class RequestHandler {
    public abstract boolean canHandleRequest(Request request);

    public abstract Result load(Request request, int i) throws IOException;

    public static final class Result {
        private final Bitmap bitmap;
        private final int exifOrientation;
        private final Picasso.LoadedFrom loadedFrom;
        private final Source source;

        public Result(Bitmap bitmap2, Picasso.LoadedFrom loadedFrom2) {
            this((Bitmap) C0967Utils.checkNotNull(bitmap2, "bitmap == null"), (Source) null, loadedFrom2, 0);
        }

        public Result(Source source2, Picasso.LoadedFrom loadedFrom2) {
            this((Bitmap) null, (Source) C0967Utils.checkNotNull(source2, "source == null"), loadedFrom2, 0);
        }

        Result(Bitmap bitmap2, Source source2, Picasso.LoadedFrom loadedFrom2, int exifOrientation2) {
            if ((bitmap2 != null) != (source2 == null ? false : true)) {
                this.bitmap = bitmap2;
                this.source = source2;
                this.loadedFrom = (Picasso.LoadedFrom) C0967Utils.checkNotNull(loadedFrom2, "loadedFrom == null");
                this.exifOrientation = exifOrientation2;
                return;
            }
            throw new AssertionError();
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public Source getSource() {
            return this.source;
        }

        public Picasso.LoadedFrom getLoadedFrom() {
            return this.loadedFrom;
        }

        /* access modifiers changed from: package-private */
        public int getExifOrientation() {
            return this.exifOrientation;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRetryCount() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean airplaneMode, NetworkInfo info) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsReplay() {
        return false;
    }

    static BitmapFactory.Options createBitmapOptions(Request data) {
        boolean justBounds = data.hasSize();
        boolean hasConfig = data.config != null;
        BitmapFactory.Options options = null;
        if (justBounds || hasConfig || data.purgeable) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = justBounds;
            options.inInputShareable = data.purgeable;
            options.inPurgeable = data.purgeable;
            if (hasConfig) {
                options.inPreferredConfig = data.config;
            }
        }
        return options;
    }

    static boolean requiresInSampleSize(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void calculateInSampleSize(int reqWidth, int reqHeight, BitmapFactory.Options options, Request request) {
        calculateInSampleSize(reqWidth, reqHeight, options.outWidth, options.outHeight, options, request);
    }

    static void calculateInSampleSize(int reqWidth, int reqHeight, int width, int height, BitmapFactory.Options options, Request request) {
        int i;
        int sampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            if (reqHeight == 0) {
                sampleSize = (int) Math.floor((double) (((float) width) / ((float) reqWidth)));
            } else if (reqWidth == 0) {
                sampleSize = (int) Math.floor((double) (((float) height) / ((float) reqHeight)));
            } else {
                int heightRatio = (int) Math.floor((double) (((float) height) / ((float) reqHeight)));
                int widthRatio = (int) Math.floor((double) (((float) width) / ((float) reqWidth)));
                if (request.centerInside) {
                    i = Math.max(heightRatio, widthRatio);
                } else {
                    i = Math.min(heightRatio, widthRatio);
                }
                sampleSize = i;
            }
        }
        options.inSampleSize = sampleSize;
        options.inJustDecodeBounds = false;
    }
}
