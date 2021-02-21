package com.google.android.material.transition;

import android.content.Context;
import android.transition.Fade;
import android.transition.Transition;
import com.google.android.material.animation.AnimationUtils;

public class MaterialFade extends MaterialTransitionSet<Fade> {
    private static final long DEFAULT_DURATION_ENTER = 150;
    private static final long DEFAULT_DURATION_ENTER_FADE = 45;
    private static final long DEFAULT_DURATION_RETURN = 75;
    private static final float DEFAULT_START_SCALE = 0.8f;

    public /* bridge */ /* synthetic */ Transition getSecondaryTransition() {
        return super.getSecondaryTransition();
    }

    public /* bridge */ /* synthetic */ void setSecondaryTransition(Transition transition) {
        super.setSecondaryTransition(transition);
    }

    public static MaterialFade create(Context context) {
        return create(context, true);
    }

    public static MaterialFade create(Context context, boolean entering) {
        MaterialFade materialFade = new MaterialFade(entering);
        materialFade.initialize(context);
        if (entering) {
            ((Fade) materialFade.getPrimaryTransition()).setDuration(DEFAULT_DURATION_ENTER_FADE);
        }
        return materialFade;
    }

    private MaterialFade(boolean entering) {
        setDuration(entering ? 150 : 75);
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    /* access modifiers changed from: package-private */
    public Fade getDefaultPrimaryTransition() {
        return new Fade();
    }

    /* access modifiers changed from: package-private */
    public Transition getDefaultSecondaryTransition() {
        Scale scale = new Scale();
        scale.setMode(1);
        scale.setIncomingStartScale(DEFAULT_START_SCALE);
        return scale;
    }
}
