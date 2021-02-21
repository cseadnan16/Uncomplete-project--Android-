package com.google.android.material.transition;

import android.content.Context;
import android.transition.Transition;
import androidx.core.view.GravityCompat;
import com.google.android.material.animation.AnimationUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialSharedAxis extends MaterialTransitionSet<Transition> {

    /* renamed from: X */
    public static final int f63X = 0;

    /* renamed from: Y */
    public static final int f64Y = 1;

    /* renamed from: Z */
    public static final int f65Z = 2;
    private final int axis;
    private final boolean forward;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public /* bridge */ /* synthetic */ Transition getPrimaryTransition() {
        return super.getPrimaryTransition();
    }

    public /* bridge */ /* synthetic */ Transition getSecondaryTransition() {
        return super.getSecondaryTransition();
    }

    public /* bridge */ /* synthetic */ void setSecondaryTransition(Transition transition) {
        super.setSecondaryTransition(transition);
    }

    public static MaterialSharedAxis create(Context context, int axis2, boolean forward2) {
        MaterialSharedAxis materialSharedAxis = new MaterialSharedAxis(axis2, forward2);
        materialSharedAxis.initialize(context);
        return materialSharedAxis;
    }

    private MaterialSharedAxis(int axis2, boolean forward2) {
        this.axis = axis2;
        this.forward = forward2;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    /* access modifiers changed from: package-private */
    public Transition getDefaultPrimaryTransition() {
        int i = this.axis;
        if (i == 0) {
            return new SlideDistance(this.context, this.forward ? GravityCompat.END : GravityCompat.START);
        } else if (i == 1) {
            return new SlideDistance(this.context, this.forward ? 80 : 48);
        } else if (i == 2) {
            return new Scale(this.forward);
        } else {
            throw new IllegalArgumentException("Invalid axis: " + this.axis);
        }
    }

    /* access modifiers changed from: package-private */
    public Transition getDefaultSecondaryTransition() {
        return new FadeThrough();
    }

    public int getAxis() {
        return this.axis;
    }

    public boolean isEntering() {
        return this.forward;
    }
}
