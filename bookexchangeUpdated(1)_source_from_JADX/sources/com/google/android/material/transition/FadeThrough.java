package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

public class FadeThrough extends Visibility {
    static final float PROGRESS_THRESHOLD = 0.35f;

    public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        return createFadeThroughAnimator(view, 0.0f, 1.0f, PROGRESS_THRESHOLD, 1.0f);
    }

    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        return createFadeThroughAnimator(view, 1.0f, 0.0f, 0.0f, PROGRESS_THRESHOLD);
    }

    private static Animator createFadeThroughAnimator(View view, float startValue, float endValue, float startFraction, float endFraction) {
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final View view2 = view;
        final float f = startValue;
        final float f2 = endValue;
        final float f3 = startFraction;
        final float f4 = endFraction;
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                view2.setAlpha(TransitionUtils.lerp(f, f2, f3, f4, ((Float) animation.getAnimatedValue()).floatValue()));
            }
        });
        return animator;
    }
}
