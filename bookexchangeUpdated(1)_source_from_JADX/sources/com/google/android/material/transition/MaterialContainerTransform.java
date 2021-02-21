package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.C1130R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.transition.TransitionUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialContainerTransform extends Transition {
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS = {PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
    private int containerColor = 0;
    private boolean drawDebugEnabled = false;
    private int drawingViewId = 16908290;
    private ShapeAppearanceModel endShapeAppearanceModel;
    private View endView;
    private int endViewId = -1;
    private int fadeMode = 0;
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode = 0;
    /* access modifiers changed from: private */
    public boolean holdAtEndEnabled = false;
    private ProgressThresholds scaleMaskProgressThresholds;
    private ProgressThresholds scaleProgressThresholds;
    private int scrimColor;
    private ProgressThresholds shapeMaskProgressThresholds;
    private ShapeAppearanceModel startShapeAppearanceModel;
    private View startView;
    private int startViewId = -1;
    private int transitionDirection = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FitMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionDirection {
    }

    public MaterialContainerTransform(Context context) {
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.scrimColor = getDefaultScrimColor(context);
    }

    public int getStartViewId() {
        return this.startViewId;
    }

    public void setStartViewId(int startViewId2) {
        this.startViewId = startViewId2;
    }

    public int getEndViewId() {
        return this.endViewId;
    }

    public void setEndViewId(int endViewId2) {
        this.endViewId = endViewId2;
    }

    public View getStartView() {
        return this.startView;
    }

    public void setStartView(View startView2) {
        this.startView = startView2;
    }

    public View getEndView() {
        return this.endView;
    }

    public void setEndView(View endView2) {
        this.endView = endView2;
    }

    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    public void setStartShapeAppearanceModel(ShapeAppearanceModel startShapeAppearanceModel2) {
        this.startShapeAppearanceModel = startShapeAppearanceModel2;
    }

    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    public void setEndShapeAppearanceModel(ShapeAppearanceModel endShapeAppearanceModel2) {
        this.endShapeAppearanceModel = endShapeAppearanceModel2;
    }

    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    public void setDrawingViewId(int drawingViewId2) {
        this.drawingViewId = drawingViewId2;
    }

    public int getContainerColor() {
        return this.containerColor;
    }

    public void setContainerColor(int containerColor2) {
        this.containerColor = containerColor2;
    }

    public int getScrimColor() {
        return this.scrimColor;
    }

    public void setScrimColor(int scrimColor2) {
        this.scrimColor = scrimColor2;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    public void setTransitionDirection(int transitionDirection2) {
        this.transitionDirection = transitionDirection2;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    public void setFadeMode(int fadeMode2) {
        this.fadeMode = fadeMode2;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    public void setFitMode(int fitMode2) {
        this.fitMode = fitMode2;
    }

    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public void setFadeProgressThresholds(ProgressThresholds fadeProgressThresholds2) {
        this.fadeProgressThresholds = fadeProgressThresholds2;
    }

    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    public void setScaleProgressThresholds(ProgressThresholds scaleProgressThresholds2) {
        this.scaleProgressThresholds = scaleProgressThresholds2;
    }

    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    public void setScaleMaskProgressThresholds(ProgressThresholds scaleMaskProgressThresholds2) {
        this.scaleMaskProgressThresholds = scaleMaskProgressThresholds2;
    }

    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    public void setShapeMaskProgressThresholds(ProgressThresholds shapeMaskProgressThresholds2) {
        this.shapeMaskProgressThresholds = shapeMaskProgressThresholds2;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setHoldAtEndEnabled(boolean holdAtEndEnabled2) {
        this.holdAtEndEnabled = holdAtEndEnabled2;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public void setDrawDebugEnabled(boolean drawDebugEnabled2) {
        this.drawDebugEnabled = drawDebugEnabled2;
    }

    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    private static void captureValues(TransitionValues transitionValues, View viewOverride, int viewIdOverride, ShapeAppearanceModel shapeAppearanceModelOverride) {
        if (viewIdOverride != -1) {
            transitionValues.view = TransitionUtils.findDescendantOrAncestorById(transitionValues.view, viewIdOverride);
        } else if (viewOverride != null) {
            transitionValues.view = viewOverride;
        } else if (transitionValues.view.getTag() instanceof View) {
            transitionValues.view.setTag((Object) null);
            transitionValues.view = (View) transitionValues.view.getTag();
        }
        View snapshotView = transitionValues.view;
        if (ViewCompat.isLaidOut(snapshotView) || snapshotView.getWidth() != 0 || snapshotView.getHeight() != 0) {
            RectF bounds = snapshotView.getParent() == null ? TransitionUtils.getRelativeBounds(snapshotView) : TransitionUtils.getLocationOnScreen(snapshotView);
            transitionValues.values.put(PROP_BOUNDS, bounds);
            transitionValues.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(snapshotView, bounds, shapeAppearanceModelOverride));
        }
    }

    private static ShapeAppearanceModel captureShapeAppearance(View view, RectF bounds, ShapeAppearanceModel shapeAppearanceModelOverride) {
        return TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(view, shapeAppearanceModelOverride), bounds);
    }

    private static ShapeAppearanceModel getShapeAppearance(View view, ShapeAppearanceModel shapeAppearanceModelOverride) {
        if (shapeAppearanceModelOverride != null) {
            return shapeAppearanceModelOverride;
        }
        if (view.getTag() instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag();
        }
        Context context = view.getContext();
        int transitionShapeAppearanceResId = getTransitionShapeAppearanceResId(context);
        if (transitionShapeAppearanceResId != -1) {
            return ShapeAppearanceModel.builder(context, transitionShapeAppearanceResId, 0).build();
        }
        if (view instanceof Shapeable) {
            return ((Shapeable) view).getShapeAppearanceModel();
        }
        return ShapeAppearanceModel.builder().build();
    }

    private static int getTransitionShapeAppearanceResId(Context context) {
        TypedArray a = context.obtainStyledAttributes(new int[]{C1130R.attr.transitionShapeAppearance});
        int transitionShapeAppearanceResId = a.getResourceId(0, -1);
        a.recycle();
        return transitionShapeAppearanceResId;
    }

    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        View drawingView;
        View boundingView;
        TransitionValues transitionValues = startValues;
        TransitionValues transitionValues2 = endValues;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View startView2 = transitionValues.view;
        View endView2 = transitionValues2.view;
        View drawingBaseView = endView2.getParent() != null ? endView2 : startView2;
        if (this.drawingViewId == drawingBaseView.getId()) {
            boundingView = drawingBaseView;
            drawingView = (View) drawingBaseView.getParent();
        } else {
            boundingView = null;
            drawingView = TransitionUtils.findAncestorById(drawingBaseView, this.drawingViewId);
        }
        RectF startBounds = (RectF) Preconditions.checkNotNull(transitionValues.values.get(PROP_BOUNDS));
        RectF endBounds = (RectF) Preconditions.checkNotNull(transitionValues2.values.get(PROP_BOUNDS));
        RectF drawingViewBounds = TransitionUtils.getLocationOnScreen(drawingView);
        float offsetX = -drawingViewBounds.left;
        float offsetY = -drawingViewBounds.top;
        RectF drawableBounds = calculateDrawableBounds(drawingView, boundingView, offsetX, offsetY);
        startBounds.offset(offsetX, offsetY);
        endBounds.offset(offsetX, offsetY);
        boolean entering = isEntering(startBounds, endBounds);
        View boundingView2 = boundingView;
        boolean entering2 = entering;
        RectF drawableBounds2 = drawableBounds;
        float f = offsetY;
        float f2 = offsetX;
        RectF rectF = drawingViewBounds;
        RectF rectF2 = endBounds;
        final TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), startView2, startBounds, (ShapeAppearanceModel) transitionValues.values.get(PROP_SHAPE_APPEARANCE), endView2, endBounds, (ShapeAppearanceModel) transitionValues2.values.get(PROP_SHAPE_APPEARANCE), this.containerColor, this.scrimColor, entering2, FadeModeEvaluators.get(this.fadeMode, entering), FitModeEvaluators.get(this.fitMode, entering, startBounds, endBounds), buildThresholdsGroup(entering), this.drawDebugEnabled);
        transitionDrawable.setBounds(Math.round(drawableBounds2.left), Math.round(drawableBounds2.top), Math.round(drawableBounds2.right), Math.round(drawableBounds2.bottom));
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                transitionDrawable.setProgress(animation.getAnimatedFraction());
            }
        });
        View view = boundingView2;
        final View view2 = drawingView;
        View view3 = drawingBaseView;
        final TransitionDrawable transitionDrawable2 = transitionDrawable;
        View endView3 = endView2;
        final View endView4 = startView2;
        View view4 = startView2;
        final View startView3 = endView3;
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animation) {
                view2.getOverlay().add(transitionDrawable2);
                endView4.setAlpha(0.0f);
                startView3.setAlpha(0.0f);
            }

            public void onAnimationEnd(Animator animation) {
                if (!MaterialContainerTransform.this.holdAtEndEnabled) {
                    endView4.setAlpha(1.0f);
                    startView3.setAlpha(1.0f);
                    view2.getOverlay().remove(transitionDrawable2);
                }
            }
        });
        return animator;
    }

    private static int getDefaultScrimColor(Context context) {
        return MaterialColors.getColor(context, C1130R.attr.scrimBackground, ContextCompat.getColor(context, C1130R.C1131color.mtrl_scrim_color));
    }

    private static RectF calculateDrawableBounds(View drawingView, View boundingView, float offsetX, float offsetY) {
        if (boundingView == null) {
            return new RectF(0.0f, 0.0f, (float) drawingView.getWidth(), (float) drawingView.getHeight());
        }
        RectF drawableBounds = TransitionUtils.getLocationOnScreen(boundingView);
        drawableBounds.offset(offsetX, offsetY);
        return drawableBounds;
    }

    private boolean isEntering(RectF startBounds, RectF endBounds) {
        int i = this.transitionDirection;
        if (i != 0) {
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
        } else if (TransitionUtils.calculateArea(endBounds) > TransitionUtils.calculateArea(startBounds)) {
            return true;
        } else {
            return false;
        }
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean entering) {
        PathMotion pathMotion = getPathMotion();
        if ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) {
            return getThresholdsOrDefault(entering, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
        }
        return getThresholdsOrDefault(entering, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean entering, ProgressThresholdsGroup defaultEnterThresholds, ProgressThresholdsGroup defaultReturnThresholds) {
        ProgressThresholdsGroup defaultThresholds = entering ? defaultEnterThresholds : defaultReturnThresholds;
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, defaultThresholds.fade), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, defaultThresholds.scale), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, defaultThresholds.scaleMask), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, defaultThresholds.shapeMask));
    }

    private static final class TransitionDrawable extends Drawable {
        private final Paint containerPaint;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
        private final boolean drawDebugEnabled;
        private final RectF endBounds;
        private final ShapeAppearanceModel endShapeAppearanceModel;
        /* access modifiers changed from: private */
        public final View endView;
        private final boolean entering;
        private final FadeModeEvaluator fadeModeEvaluator;
        private FadeModeResult fadeModeResult;
        private final FitModeEvaluator fitModeEvaluator;
        private FitModeResult fitModeResult;
        private final MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final ProgressThresholdsGroup progressThresholds;
        private final Paint scrimPaint;
        private final RectF startBounds;
        private final ShapeAppearanceModel startShapeAppearanceModel;
        /* access modifiers changed from: private */
        public final View startView;

        private TransitionDrawable(PathMotion pathMotion, View startView2, RectF startBounds2, ShapeAppearanceModel startShapeAppearanceModel2, View endView2, RectF endBounds2, ShapeAppearanceModel endShapeAppearanceModel2, int containerColor, int scrimColor, boolean entering2, FadeModeEvaluator fadeModeEvaluator2, FitModeEvaluator fitModeEvaluator2, ProgressThresholdsGroup progressThresholds2, boolean drawDebugEnabled2) {
            RectF rectF = startBounds2;
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[2];
            this.containerPaint = new Paint();
            this.scrimPaint = new Paint();
            this.debugPaint = new Paint();
            this.debugPath = new Path();
            this.progress = 0.0f;
            this.startView = startView2;
            this.startBounds = rectF;
            this.startShapeAppearanceModel = startShapeAppearanceModel2;
            this.endView = endView2;
            this.endBounds = endBounds2;
            this.endShapeAppearanceModel = endShapeAppearanceModel2;
            this.entering = entering2;
            this.fadeModeEvaluator = fadeModeEvaluator2;
            this.fitModeEvaluator = fitModeEvaluator2;
            this.progressThresholds = progressThresholds2;
            this.drawDebugEnabled = drawDebugEnabled2;
            this.containerPaint.setColor(containerColor);
            this.currentStartBounds = new RectF(rectF);
            this.currentStartBoundsMasked = new RectF(this.currentStartBounds);
            this.currentEndBounds = new RectF(this.currentStartBounds);
            this.currentEndBoundsMasked = new RectF(this.currentEndBounds);
            PointF startPoint = getMotionPathPoint(startBounds2);
            PointF endPoint = getMotionPathPoint(endBounds2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(startPoint.x, startPoint.y, endPoint.x, endPoint.y), false);
            this.motionPathMeasure = pathMeasure;
            this.motionPathLength = pathMeasure.getLength();
            this.scrimPaint.setStyle(Paint.Style.FILL);
            this.scrimPaint.setShader(TransitionUtils.createColorShader(scrimColor));
            this.debugPaint.setStyle(Paint.Style.STROKE);
            this.debugPaint.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        public void draw(Canvas canvas) {
            if (this.scrimPaint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.scrimPaint);
            }
            int debugCanvasSave = this.drawDebugEnabled ? canvas.save() : -1;
            this.maskEvaluator.clip(canvas);
            if (this.containerPaint.getColor() != 0) {
                canvas.drawRect(getBounds(), this.containerPaint);
            }
            if (this.fadeModeResult.endOnTop) {
                drawStartView(canvas);
                drawEndView(canvas);
            } else {
                drawEndView(canvas);
                drawStartView(canvas);
            }
            if (this.drawDebugEnabled) {
                canvas.restoreToCount(debugCanvasSave);
                drawDebugCumulativePath(canvas, this.currentStartBounds, this.debugPath, -65281);
                drawDebugRect(canvas, this.currentStartBoundsMasked, InputDeviceCompat.SOURCE_ANY);
                drawDebugRect(canvas, this.currentStartBounds, -16711936);
                drawDebugRect(canvas, this.currentEndBoundsMasked, -16711681);
                drawDebugRect(canvas, this.currentEndBounds, -16776961);
            }
        }

        private void drawStartView(Canvas canvas) {
            TransitionUtils.transform(canvas, getBounds(), this.currentStartBounds.left, this.currentStartBounds.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new TransitionUtils.CanvasOperation() {
                public void run(Canvas canvas) {
                    TransitionDrawable.this.startView.draw(canvas);
                }
            });
        }

        private void drawEndView(Canvas canvas) {
            TransitionUtils.transform(canvas, getBounds(), this.currentEndBounds.left, this.currentEndBounds.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new TransitionUtils.CanvasOperation() {
                public void run(Canvas canvas) {
                    TransitionDrawable.this.endView.draw(canvas);
                }
            });
        }

        public void setAlpha(int alpha) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        public void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        public int getOpacity() {
            return -3;
        }

        /* access modifiers changed from: private */
        public void setProgress(float progress2) {
            if (this.progress != progress2) {
                updateProgress(progress2);
            }
        }

        private void updateProgress(float progress2) {
            float f = progress2;
            this.progress = f;
            this.scrimPaint.setAlpha((int) (this.entering ? TransitionUtils.lerp(0.0f, 255.0f, f) : TransitionUtils.lerp(255.0f, 0.0f, f)));
            this.motionPathMeasure.getPosTan(this.motionPathLength * f, this.motionPathPosition, (float[]) null);
            float[] fArr = this.motionPathPosition;
            float motionPathX = fArr[0];
            float motionPathY = fArr[1];
            FitModeResult evaluate = this.fitModeEvaluator.evaluate(progress2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scale.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scale.end))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = evaluate;
            this.currentStartBounds.set(motionPathX - (evaluate.currentStartWidth / 2.0f), motionPathY, (this.fitModeResult.currentStartWidth / 2.0f) + motionPathX, this.fitModeResult.currentStartHeight + motionPathY);
            this.currentEndBounds.set(motionPathX - (this.fitModeResult.currentEndWidth / 2.0f), motionPathY, (this.fitModeResult.currentEndWidth / 2.0f) + motionPathX, this.fitModeResult.currentEndHeight + motionPathY);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float maskStartFraction = ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scaleMask.start))).floatValue();
            float maskEndFraction = ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scaleMask.end))).floatValue();
            boolean shouldMaskStartBounds = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            RectF maskBounds = shouldMaskStartBounds ? this.currentStartBoundsMasked : this.currentEndBoundsMasked;
            float maskProgress = TransitionUtils.lerp(0.0f, 1.0f, maskStartFraction, maskEndFraction, f);
            float maskMultiplier = shouldMaskStartBounds ? maskProgress : 1.0f - maskProgress;
            this.fitModeEvaluator.applyMask(maskBounds, maskMultiplier, this.fitModeResult);
            RectF rectF = maskBounds;
            float f2 = maskMultiplier;
            float f3 = maskEndFraction;
            this.maskEvaluator.evaluate(progress2, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, this.progressThresholds.shapeMask);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.fade.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.fade.end))).floatValue());
            invalidateSelf();
        }

        private static PointF getMotionPathPoint(RectF bounds) {
            return new PointF(bounds.centerX(), bounds.top);
        }

        private void drawDebugCumulativePath(Canvas canvas, RectF bounds, Path path, int color) {
            PointF point = getMotionPathPoint(bounds);
            if (this.progress == 0.0f) {
                path.reset();
                path.moveTo(point.x, point.y);
                return;
            }
            path.lineTo(point.x, point.y);
            this.debugPaint.setColor(color);
            canvas.drawPath(path, this.debugPaint);
        }

        private void drawDebugRect(Canvas canvas, RectF bounds, int color) {
            this.debugPaint.setColor(color);
            canvas.drawRect(bounds, this.debugPaint);
        }
    }

    public static class ProgressThresholds {
        final float end;
        final float start;

        public ProgressThresholds(float start2, float end2) {
            this.start = start2;
            this.end = end2;
        }
    }

    private static class ProgressThresholdsGroup {
        /* access modifiers changed from: private */
        public final ProgressThresholds fade;
        /* access modifiers changed from: private */
        public final ProgressThresholds scale;
        /* access modifiers changed from: private */
        public final ProgressThresholds scaleMask;
        /* access modifiers changed from: private */
        public final ProgressThresholds shapeMask;

        private ProgressThresholdsGroup(ProgressThresholds fade2, ProgressThresholds scale2, ProgressThresholds scaleMask2, ProgressThresholds shapeMask2) {
            this.fade = fade2;
            this.scale = scale2;
            this.scaleMask = scaleMask2;
            this.shapeMask = shapeMask2;
        }
    }
}
