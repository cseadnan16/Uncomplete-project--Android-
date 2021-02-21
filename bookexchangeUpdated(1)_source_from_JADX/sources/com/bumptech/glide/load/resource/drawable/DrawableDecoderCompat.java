package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, int id) {
        return getDrawable(context, id, (Resources.Theme) null);
    }

    public static Drawable getDrawable(Context context, int id, Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context, id);
            }
        } catch (NoClassDefFoundError e) {
            shouldCallAppCompatResources = false;
        } catch (Resources.NotFoundException e2) {
        }
        return loadDrawableV4(context, id, theme != null ? theme : context.getTheme());
    }

    private static Drawable loadDrawableV7(Context context, int id) {
        return AppCompatResources.getDrawable(context, id);
    }

    private static Drawable loadDrawableV4(Context context, int id, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), id, theme);
    }
}
