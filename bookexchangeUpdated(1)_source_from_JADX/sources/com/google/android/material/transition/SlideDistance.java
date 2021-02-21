package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.C1130R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SlideDistance extends Visibility {
    private int slideDistance;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistance(Context context, int slideEdge2) {
        this.slideEdge = slideEdge2;
        this.slideDistance = context.getResources().getDimensionPixelSize(C1130R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideEdge(int slideEdge2) {
        this.slideEdge = slideEdge2;
    }

    public int getSlideDistance() {
        return this.slideDistance;
    }

    public void setSlideDistance(int slideDistance2) {
        this.slideDistance = slideDistance2;
    }

    public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        return createTranslationAppearAnimator(sceneRoot, view);
    }

    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        return createTranslationDisappearAnimator(sceneRoot, view);
    }

    private Animator createTranslationAppearAnimator(View sceneRoot, View view) {
        int i = this.slideEdge;
        if (i == 3) {
            return createTranslationXAnimator(view, (float) this.slideDistance, 0.0f);
        }
        if (i == 5) {
            return createTranslationXAnimator(view, (float) (-this.slideDistance), 0.0f);
        }
        if (i == 48) {
            return createTranslationYAnimator(view, (float) (-this.slideDistance), 0.0f);
        }
        if (i == 80) {
            return createTranslationYAnimator(view, (float) this.slideDistance, 0.0f);
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view, (float) (isRtl(sceneRoot) ? this.slideDistance : -this.slideDistance), 0.0f);
        } else if (i == 8388613) {
            return createTranslationXAnimator(view, (float) (isRtl(sceneRoot) ? -this.slideDistance : this.slideDistance), 0.0f);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + this.slideEdge);
        }
    }

    private Animator createTranslationDisappearAnimator(View sceneRoot, View view) {
        int i = this.slideEdge;
        if (i == 3) {
            return createTranslationXAnimator(view, 0.0f, (float) (-this.slideDistance));
        }
        if (i == 5) {
            return createTranslationXAnimator(view, 0.0f, (float) this.slideDistance);
        }
        if (i == 48) {
            return createTranslationYAnimator(view, 0.0f, (float) this.slideDistance);
        }
        if (i == 80) {
            return createTranslationYAnimator(view, 0.0f, (float) (-this.slideDistance));
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view, 0.0f, (float) (isRtl(sceneRoot) ? -this.slideDistance : this.slideDistance));
        } else if (i == 8388613) {
            return createTranslationXAnimator(view, 0.0f, (float) (isRtl(sceneRoot) ? this.slideDistance : -this.slideDistance));
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + this.slideEdge);
        }
    }

    private static Animator createTranslationXAnimator(View view, float startTranslation, float endTranslation) {
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{startTranslation, endTranslation})});
    }

    private static Animator createTranslationYAnimator(View view, float startTranslation, float endTranslation) {
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{startTranslation, endTranslation})});
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }
}
