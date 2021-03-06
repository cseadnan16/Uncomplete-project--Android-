package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.util.List;

public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;
    private final Context context;

    public ResourceDrawableDecoder(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public boolean handles(Uri source, Options options) {
        return source.getScheme().equals("android.resource");
    }

    public Resource<Drawable> decode(Uri source, int width, int height, Options options) {
        int resId = loadResourceIdFromUri(source);
        String packageName = source.getAuthority();
        return NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(packageName.equals(this.context.getPackageName()) ? this.context : getContextForPackage(source, packageName), resId));
    }

    private Context getContextForPackage(Uri source, String packageName) {
        try {
            return this.context.createPackageContext(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + source, e);
        }
    }

    private int loadResourceIdFromUri(Uri source) {
        List<String> segments = source.getPathSegments();
        Integer result = null;
        if (segments.size() == 2) {
            String packageName = source.getAuthority();
            String resourceName = segments.get(1);
            result = Integer.valueOf(this.context.getResources().getIdentifier(resourceName, segments.get(0), packageName));
        } else if (segments.size() == 1) {
            try {
                result = Integer.valueOf(segments.get(0));
            } catch (NumberFormatException e) {
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + source);
        } else if (result.intValue() != 0) {
            return result.intValue();
        } else {
            throw new IllegalArgumentException("Failed to obtain resource id for: " + source);
        }
    }
}
