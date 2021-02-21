package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.C1130R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Slider extends View {
    /* access modifiers changed from: private */
    public static final int DEF_STYLE_RES = C1130R.style.Widget_MaterialComponents_Slider;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value must be equal to valueFrom plus a multiple of stepSize when using stepSize";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize must be 0, or a factor of the valueFrom-valueTo range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value must be greater or equal to valueFrom, and lower or equal to valueTo";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom must be smaller than valueTo";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo must be greater than valueFrom";
    private static final int HALO_ALPHA = 63;
    public static final int LABEL_FLOATING = 0;
    public static final int LABEL_GONE = 2;
    public static final int LABEL_WITHIN_BOUNDS = 1;
    private static final String TAG = Slider.class.getSimpleName();
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private AccessibilityEventSender accessibilityEventSender;
    /* access modifiers changed from: private */
    public final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    private final Paint activeTicksPaint;
    private final Paint activeTrackPaint;
    private final List<OnChangeListener> changeListeners;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;
    private ColorStateList haloColor;
    private final Paint haloPaint;
    private int haloRadius;
    private final Paint inactiveTicksPaint;
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private final TooltipDrawableFactory labelMaker;
    private int labelPadding;
    private final List<TooltipDrawable> labels;
    private MotionEvent lastEvent;
    private final int scaledTouchSlop;
    private float stepSize;
    private final MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;
    private final Paint thumbPaint;
    /* access modifiers changed from: private */
    public int thumbRadius;
    private ColorStateList tickColorActive;
    private ColorStateList tickColorInactive;
    private float[] ticksCoordinates;
    private float touchDownX;
    private final List<OnSliderTouchListener> touchListeners;
    private float touchPosition;
    private ColorStateList trackColorActive;
    private ColorStateList trackColorInactive;
    private int trackHeight;
    /* access modifiers changed from: private */
    public int trackSidePadding;
    private int trackTop;
    /* access modifiers changed from: private */
    public int trackWidth;
    /* access modifiers changed from: private */
    public float valueFrom;
    /* access modifiers changed from: private */
    public float valueTo;
    /* access modifiers changed from: private */
    public ArrayList<Float> values;
    private int widgetHeight;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelBehavior {
    }

    public interface LabelFormatter {
        String getFormattedValue(float f);
    }

    public interface OnChangeListener {
        void onValueChange(Slider slider, float f, boolean z);
    }

    public interface OnSliderTouchListener {
        void onStartTrackingTouch(Slider slider);

        void onStopTrackingTouch(Slider slider);
    }

    private interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    public static final class BasicLabelFormatter implements LabelFormatter {
        private static final int BILLION = 1000000000;
        private static final int MILLION = 1000000;
        private static final int THOUSAND = 1000;
        private static final long TRILLION = 1000000000000L;

        public String getFormattedValue(float value) {
            if (value >= 1.0E12f) {
                return String.format(Locale.US, "%.1fT", new Object[]{Float.valueOf(value / 1.0E12f)});
            } else if (value >= 1.0E9f) {
                return String.format(Locale.US, "%.1fB", new Object[]{Float.valueOf(value / 1.0E9f)});
            } else if (value >= 1000000.0f) {
                return String.format(Locale.US, "%.1fM", new Object[]{Float.valueOf(value / 1000000.0f)});
            } else if (value >= 1000.0f) {
                return String.format(Locale.US, "%.1fK", new Object[]{Float.valueOf(value / 1000.0f)});
            } else {
                return String.format(Locale.US, "%.0f", new Object[]{Float.valueOf(value)});
            }
        }
    }

    public Slider(Context context) {
        this(context, (AttributeSet) null);
    }

    public Slider(Context context, AttributeSet attrs) {
        this(context, attrs, C1130R.attr.sliderStyle);
    }

    public Slider(Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(MaterialThemeOverlay.wrap(context, attrs, defStyleAttr, DEF_STYLE_RES), attrs, defStyleAttr);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.isLongPress = false;
        this.thumbDrawable = new MaterialShapeDrawable();
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.inactiveTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.activeTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.thumbPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        this.inactiveTicksPaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        this.activeTicksPaint.setStrokeCap(Paint.Cap.ROUND);
        loadResources(context2.getResources());
        this.labelMaker = new TooltipDrawableFactory() {
            public TooltipDrawable createTooltipDrawable() {
                TypedArray a = ThemeEnforcement.obtainStyledAttributes(Slider.this.getContext(), attrs, C1130R.styleable.Slider, defStyleAttr, Slider.DEF_STYLE_RES, new int[0]);
                TooltipDrawable d = Slider.parseLabelDrawable(Slider.this.getContext(), a);
                a.recycle();
                return d;
            }
        };
        processAttributes(context2, attrs, defStyleAttr);
        setFocusable(true);
        this.thumbDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper2 = new AccessibilityHelper();
        this.accessibilityHelper = accessibilityHelper2;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper2);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private void loadResources(Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(C1130R.dimen.mtrl_slider_widget_height);
        this.trackSidePadding = resources.getDimensionPixelOffset(C1130R.dimen.mtrl_slider_track_side_padding);
        this.trackTop = resources.getDimensionPixelOffset(C1130R.dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(C1130R.dimen.mtrl_slider_label_padding);
    }

    private void processAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        ColorStateList colorStateList5;
        Context context2 = context;
        TypedArray a = ThemeEnforcement.obtainStyledAttributes(context, attrs, C1130R.styleable.Slider, defStyleAttr, DEF_STYLE_RES, new int[0]);
        this.valueFrom = a.getFloat(C1130R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = a.getFloat(C1130R.styleable.Slider_android_valueTo, 1.0f);
        setValue(a.getFloat(C1130R.styleable.Slider_android_value, this.valueFrom));
        this.stepSize = a.getFloat(C1130R.styleable.Slider_android_stepSize, 0.0f);
        boolean hasTrackColor = a.hasValue(C1130R.styleable.Slider_trackColor);
        int trackColorInactiveRes = hasTrackColor ? C1130R.styleable.Slider_trackColor : C1130R.styleable.Slider_trackColorInactive;
        int trackColorActiveRes = hasTrackColor ? C1130R.styleable.Slider_trackColor : C1130R.styleable.Slider_trackColorActive;
        ColorStateList trackColorInactive2 = MaterialResources.getColorStateList(context2, a, trackColorInactiveRes);
        if (trackColorInactive2 != null) {
            colorStateList = trackColorInactive2;
        } else {
            colorStateList = AppCompatResources.getColorStateList(context2, C1130R.C1131color.material_slider_inactive_track_color);
        }
        setTrackColorInactive(colorStateList);
        ColorStateList trackColorActive2 = MaterialResources.getColorStateList(context2, a, trackColorActiveRes);
        if (trackColorActive2 != null) {
            colorStateList2 = trackColorActive2;
        } else {
            colorStateList2 = AppCompatResources.getColorStateList(context2, C1130R.C1131color.material_slider_active_track_color);
        }
        setTrackColorActive(colorStateList2);
        this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(context2, a, C1130R.styleable.Slider_thumbColor));
        ColorStateList haloColor2 = MaterialResources.getColorStateList(context2, a, C1130R.styleable.Slider_haloColor);
        if (haloColor2 != null) {
            colorStateList3 = haloColor2;
        } else {
            colorStateList3 = AppCompatResources.getColorStateList(context2, C1130R.C1131color.material_slider_halo_color);
        }
        setHaloColor(colorStateList3);
        boolean hasTickColor = a.hasValue(C1130R.styleable.Slider_tickColor);
        int tickColorInactiveRes = hasTickColor ? C1130R.styleable.Slider_tickColor : C1130R.styleable.Slider_tickColorInactive;
        int tickColorActiveRes = hasTickColor ? C1130R.styleable.Slider_tickColor : C1130R.styleable.Slider_tickColorActive;
        ColorStateList tickColorInactive2 = MaterialResources.getColorStateList(context2, a, tickColorInactiveRes);
        if (tickColorInactive2 != null) {
            colorStateList4 = tickColorInactive2;
        } else {
            colorStateList4 = AppCompatResources.getColorStateList(context2, C1130R.C1131color.material_slider_inactive_tick_marks_color);
        }
        setTickColorInactive(colorStateList4);
        ColorStateList tickColorActive2 = MaterialResources.getColorStateList(context2, a, tickColorActiveRes);
        if (tickColorActive2 != null) {
            colorStateList5 = tickColorActive2;
        } else {
            colorStateList5 = AppCompatResources.getColorStateList(context2, C1130R.C1131color.material_slider_active_tick_marks_color);
        }
        setTickColorActive(colorStateList5);
        boolean z = hasTrackColor;
        setThumbRadius(a.getDimensionPixelSize(C1130R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(a.getDimensionPixelSize(C1130R.styleable.Slider_haloRadius, 0));
        setThumbElevation(a.getDimension(C1130R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(a.getDimensionPixelSize(C1130R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = a.getInt(C1130R.styleable.Slider_labelBehavior, 0);
        a.recycle();
        validateValueFrom();
        validateValueTo();
        validateStepSize();
    }

    /* access modifiers changed from: private */
    public static TooltipDrawable parseLabelDrawable(Context context, TypedArray a) {
        return TooltipDrawable.createFromAttributes(context, (AttributeSet) null, 0, a.getResourceId(C1130R.styleable.Slider_labelStyle, C1130R.style.Widget_MaterialComponents_Tooltip));
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) {
            Log.e(TAG, EXCEPTION_ILLEGAL_VALUE_FROM);
            throw new IllegalArgumentException(EXCEPTION_ILLEGAL_VALUE_FROM);
        }
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) {
            Log.e(TAG, EXCEPTION_ILLEGAL_VALUE_TO);
            throw new IllegalArgumentException(EXCEPTION_ILLEGAL_VALUE_TO);
        }
    }

    private void validateStepSize() {
        float f = this.stepSize;
        if (f < 0.0f) {
            Log.e(TAG, EXCEPTION_ILLEGAL_STEP_SIZE);
            throw new IllegalArgumentException(EXCEPTION_ILLEGAL_STEP_SIZE);
        } else if (f > 0.0f && ((double) (((this.valueTo - this.valueFrom) / f) % 1.0f)) > THRESHOLD) {
            Log.e(TAG, EXCEPTION_ILLEGAL_STEP_SIZE);
            throw new IllegalArgumentException(EXCEPTION_ILLEGAL_STEP_SIZE);
        }
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public void setValueFrom(float valueFrom2) {
        this.valueFrom = valueFrom2;
        validateValueFrom();
    }

    public float getValueTo() {
        return this.valueTo;
    }

    public void setValueTo(float valueTo2) {
        this.valueTo = valueTo2;
        validateValueTo();
    }

    public float getValue() {
        if (this.values.size() <= 1) {
            return this.values.get(0).floatValue();
        }
        throw new IllegalStateException("More than one value is set on the Slider. Use getValues() instead.");
    }

    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public void setValue(float value) {
        setValues(Float.valueOf(value));
    }

    public void setValues(Float... values2) {
        ArrayList<Float> list = new ArrayList<>();
        Collections.addAll(list, values2);
        setValuesInternal(list);
    }

    public void setValues(List<Float> values2) {
        setValuesInternal(new ArrayList(values2));
    }

    private void setValuesInternal(ArrayList<Float> values2) {
        if (!values2.isEmpty()) {
            Collections.sort(values2);
            if (this.values.size() != values2.size() || !this.values.equals(values2)) {
                Iterator<Float> it = values2.iterator();
                while (it.hasNext()) {
                    if (!isValueValid(it.next().floatValue())) {
                        return;
                    }
                }
                this.values = values2;
                this.focusedThumbIdx = 0;
                updateHaloHotspot();
                createLabelPool();
                dispatchOnChangedProgramatically();
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            this.labels.subList(this.values.size(), this.labels.size()).clear();
        }
        while (this.labels.size() < this.values.size()) {
            this.labels.add(this.labelMaker.createTooltipDrawable());
        }
        int i = 1;
        if (this.labels.size() == 1) {
            i = 0;
        }
        int strokeWidth = i;
        for (TooltipDrawable label : this.labels) {
            label.setStrokeWidth((float) strokeWidth);
        }
    }

    private boolean isValueValid(float value) {
        float f = this.valueFrom;
        if (value < f || value > this.valueTo) {
            Log.e(TAG, EXCEPTION_ILLEGAL_VALUE);
            return false;
        }
        float f2 = this.stepSize;
        if (f2 <= 0.0f || ((double) (((f - value) / f2) % 1.0f)) <= THRESHOLD) {
            return true;
        }
        Log.e(TAG, EXCEPTION_ILLEGAL_DISCRETE_VALUE);
        return false;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public void setStepSize(float stepSize2) {
        if (this.stepSize != stepSize2) {
            this.stepSize = stepSize2;
            validateStepSize();
            if (this.trackWidth > 0) {
                calculateTicksCoordinates();
            }
            postInvalidate();
        }
    }

    public float getMaximumValue() {
        ArrayList<Float> arrayList = this.values;
        return arrayList.get(arrayList.size() - 1).floatValue();
    }

    public float getMinimumValue() {
        return this.values.get(0).floatValue();
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public void setFocusedThumbIndex(int index) {
        if (index < 0 || index >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = index;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(index);
        postInvalidate();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public void addOnChangeListener(OnChangeListener listener) {
        this.changeListeners.add(listener);
    }

    public void removeOnChangeListener(OnChangeListener listener) {
        this.changeListeners.remove(listener);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void addOnSliderTouchListener(OnSliderTouchListener listener) {
        this.touchListeners.add(listener);
    }

    public void removeOnSliderTouchListener(OnSliderTouchListener listener) {
        this.touchListeners.remove(listener);
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public void setLabelFormatter(LabelFormatter formatter2) {
        this.formatter = formatter2;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    public void setThumbElevation(float elevation) {
        this.thumbDrawable.setElevation(elevation);
    }

    public void setThumbElevationResource(int elevation) {
        setThumbElevation(getResources().getDimension(elevation));
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public void setThumbRadius(int radius) {
        if (radius != this.thumbRadius) {
            this.thumbRadius = radius;
            this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, (float) this.thumbRadius).build());
            MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
            int i = this.thumbRadius;
            materialShapeDrawable.setBounds(0, 0, i * 2, i * 2);
            postInvalidate();
        }
    }

    public void setThumbRadiusResource(int radius) {
        setThumbRadius(getResources().getDimensionPixelSize(radius));
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public void setHaloRadius(int radius) {
        if (radius != this.haloRadius) {
            this.haloRadius = radius;
            if (!shouldDrawCompatHalo()) {
                Drawable background = getBackground();
                if (background instanceof RippleDrawable) {
                    DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
                    return;
                }
                return;
            }
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(int radius) {
        setHaloRadius(getResources().getDimensionPixelSize(radius));
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public void setLabelBehavior(int labelBehavior2) {
        if (this.labelBehavior != labelBehavior2) {
            this.labelBehavior = labelBehavior2;
            requestLayout();
        }
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public int getTrackHeight() {
        return this.trackHeight;
    }

    public void setTrackHeight(int trackHeight2) {
        if (this.trackHeight != trackHeight2) {
            this.trackHeight = trackHeight2;
            invalidateTrack();
            postInvalidate();
        }
    }

    public ColorStateList getHaloColor() {
        return this.haloColor;
    }

    public void setHaloColor(ColorStateList haloColor2) {
        if (!haloColor2.equals(this.haloColor)) {
            this.haloColor = haloColor2;
            if (!shouldDrawCompatHalo()) {
                Drawable background = getBackground();
                if (background instanceof RippleDrawable) {
                    ((RippleDrawable) background).setColor(haloColor2);
                    return;
                }
                return;
            }
            this.haloPaint.setColor(getColorForState(haloColor2));
            this.haloPaint.setAlpha(63);
            invalidate();
        }
    }

    public ColorStateList getThumbColor() {
        return this.thumbDrawable.getFillColor();
    }

    public void setThumbColor(ColorStateList thumbColor) {
        this.thumbDrawable.setFillColor(thumbColor);
    }

    public ColorStateList getTickColor() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public void setTickColor(ColorStateList tickColor) {
        setTickColorInactive(tickColor);
        setTickColorActive(tickColor);
    }

    public ColorStateList getTickColorActive() {
        return this.tickColorActive;
    }

    public void setTickColorActive(ColorStateList tickColor) {
        if (!tickColor.equals(this.tickColorActive)) {
            this.tickColorActive = tickColor;
            this.activeTicksPaint.setColor(getColorForState(tickColor));
            invalidate();
        }
    }

    public ColorStateList getTickColorInactive() {
        return this.tickColorInactive;
    }

    public void setTickColorInactive(ColorStateList tickColor) {
        if (!tickColor.equals(this.tickColorInactive)) {
            this.tickColorInactive = tickColor;
            this.inactiveTicksPaint.setColor(getColorForState(tickColor));
            invalidate();
        }
    }

    public ColorStateList getTrackColor() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public void setTrackColor(ColorStateList trackColor) {
        setTrackColorInactive(trackColor);
        setTrackColorActive(trackColor);
    }

    public ColorStateList getTrackColorActive() {
        return this.trackColorActive;
    }

    public void setTrackColorActive(ColorStateList trackColor) {
        if (!trackColor.equals(this.trackColorActive)) {
            this.trackColorActive = trackColor;
            this.activeTrackPaint.setColor(getColorForState(trackColor));
            invalidate();
        }
    }

    public ColorStateList getTrackColorInactive() {
        return this.trackColorInactive;
    }

    public void setTrackColorInactive(ColorStateList trackColor) {
        if (!trackColor.equals(this.trackColorInactive)) {
            this.trackColorInactive = trackColor;
            this.inactiveTrackPaint.setColor(getColorForState(trackColor));
            invalidate();
        }
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setLayerType(enabled ? 0 : 2, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable label : this.labels) {
            label.setRelativeToView(ViewUtils.getContentView(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 != null) {
            removeCallbacks(accessibilityEventSender2);
        }
        for (TooltipDrawable label : this.labels) {
            ViewUtils.getContentViewOverlay(this).remove(label);
            label.detachView(ViewUtils.getContentView(this));
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.widgetHeight;
        int i2 = 0;
        if (this.labelBehavior == 1) {
            i2 = this.labels.get(0).getIntrinsicHeight();
        }
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(i + i2, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.trackWidth = w - (this.trackSidePadding * 2);
        if (this.stepSize > 0.0f) {
            calculateTicksCoordinates();
        }
        updateHaloHotspot();
    }

    private void calculateTicksCoordinates() {
        int tickCount = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != tickCount * 2) {
            this.ticksCoordinates = new float[(tickCount * 2)];
        }
        float interval = ((float) this.trackWidth) / ((float) (tickCount - 1));
        for (int i = 0; i < tickCount * 2; i += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i] = ((float) this.trackSidePadding) + (((float) (i / 2)) * interval);
            fArr2[i + 1] = (float) calculateTop();
        }
    }

    /* access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (!shouldDrawCompatHalo() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int x = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) this.trackWidth)) + ((float) this.trackSidePadding));
                int y = calculateTop();
                int i = this.haloRadius;
                DrawableCompat.setHotspotBounds(background, x - i, y - i, x + i, i + y);
            }
        }
    }

    /* access modifiers changed from: private */
    public int calculateTop() {
        int i = this.trackTop;
        int i2 = 0;
        if (this.labelBehavior == 1) {
            i2 = this.labels.get(0).getIntrinsicHeight();
        }
        return i + i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int top = calculateTop();
        drawInactiveTrack(canvas, this.trackWidth, top);
        if (getMaximumValue() > this.valueFrom) {
            drawActiveTrack(canvas, this.trackWidth, top);
        }
        if (this.stepSize > 0.0f) {
            drawTicks(canvas);
        }
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawHalo(canvas, this.trackWidth, top);
            if (this.activeThumbIdx != -1) {
                ensureLabels();
            }
        }
        drawThumbs(canvas, this.trackWidth, top);
    }

    private float[] getActiveRange() {
        float left = normalizeValue(this.values.size() == 1 ? this.valueFrom : getMinimumValue());
        float right = normalizeValue(getMaximumValue());
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return new float[]{right, left};
        }
        return new float[]{left, right};
    }

    private void drawInactiveTrack(Canvas canvas, int width, int top) {
        float[] activeRange = getActiveRange();
        int i = this.trackSidePadding;
        float right = ((float) i) + (activeRange[1] * ((float) width));
        if (right < ((float) (i + width))) {
            canvas.drawLine(right, (float) top, (float) (i + width), (float) top, this.inactiveTrackPaint);
        }
        int i2 = this.trackSidePadding;
        float left = ((float) i2) + (activeRange[0] * ((float) width));
        if (left > ((float) i2)) {
            canvas.drawLine((float) i2, (float) top, left, (float) top, this.inactiveTrackPaint);
        }
    }

    /* access modifiers changed from: private */
    public float normalizeValue(float value) {
        float f = this.valueFrom;
        float normalized = (value - f) / (this.valueTo - f);
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return 1.0f - normalized;
        }
        return normalized;
    }

    private void drawActiveTrack(Canvas canvas, int width, int top) {
        float[] activeRange = getActiveRange();
        int i = this.trackSidePadding;
        float right = ((float) i) + (activeRange[1] * ((float) width));
        canvas.drawLine(((float) i) + (activeRange[0] * ((float) width)), (float) top, right, (float) top, this.activeTrackPaint);
    }

    private void drawTicks(Canvas canvas) {
        float[] activeRange = getActiveRange();
        int leftPivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
        int rightPivotIndex = pivotIndex(this.ticksCoordinates, activeRange[1]);
        canvas.drawPoints(this.ticksCoordinates, 0, leftPivotIndex * 2, this.inactiveTicksPaint);
        canvas.drawPoints(this.ticksCoordinates, leftPivotIndex * 2, (rightPivotIndex * 2) - (leftPivotIndex * 2), this.activeTicksPaint);
        float[] fArr = this.ticksCoordinates;
        canvas.drawPoints(fArr, rightPivotIndex * 2, fArr.length - (rightPivotIndex * 2), this.inactiveTicksPaint);
    }

    private void drawThumbs(Canvas canvas, int width, int top) {
        if (!isEnabled()) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(((float) this.trackSidePadding) + (normalizeValue(it.next().floatValue()) * ((float) width)), (float) top, (float) this.thumbRadius, this.thumbPaint);
            }
        }
        Iterator<Float> it2 = this.values.iterator();
        while (it2.hasNext()) {
            canvas.save();
            int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(it2.next().floatValue()) * ((float) width)));
            int i = this.thumbRadius;
            canvas.translate((float) (normalizeValue - i), (float) (top - i));
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void maybeDrawHalo(Canvas canvas, int width, int top) {
        if (shouldDrawCompatHalo()) {
            int centerX = (int) (((float) this.trackSidePadding) + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) width)));
            if (Build.VERSION.SDK_INT < 28) {
                int i = this.haloRadius;
                canvas.clipRect((float) (centerX - i), (float) (top - i), (float) (centerX + i), (float) (i + top), Region.Op.UNION);
            }
            canvas.drawCircle((float) centerX, (float) top, (float) this.haloRadius, this.haloPaint);
        }
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        float x = event.getX();
        float f = (x - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
        this.touchPosition = f;
        float max = Math.max(0.0f, f);
        this.touchPosition = max;
        this.touchPosition = Math.min(1.0f, max);
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x;
            if (!isInScrollingContainer()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                    onStartTrackingTouch();
                }
            }
        } else if (actionMasked == 1) {
            this.thumbIsPressed = false;
            MotionEvent motionEvent = this.lastEvent;
            if (motionEvent != null && motionEvent.getActionMasked() == 0 && this.lastEvent.getX() == event.getX() && this.lastEvent.getY() == event.getY()) {
                pickActiveThumb();
            }
            if (this.activeThumbIdx != -1) {
                snapTouchPosition();
                this.activeThumbIdx = -1;
            }
            for (TooltipDrawable label : this.labels) {
                ViewUtils.getContentViewOverlay(this).remove(label);
            }
            onStopTrackingTouch();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (Math.abs(x - this.touchDownX) < ((float) this.scaledTouchSlop)) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                onStartTrackingTouch();
            }
            if (pickActiveThumb()) {
                this.thumbIsPressed = true;
                snapTouchPosition();
                updateHaloHotspot();
                invalidate();
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(event);
        return true;
    }

    private static int pivotIndex(float[] coordinates, float position) {
        return Math.round(((float) ((coordinates.length / 2) - 1)) * position);
    }

    private double snapPosition(float position) {
        float f = this.stepSize;
        if (f <= 0.0f) {
            return (double) position;
        }
        int stepCount = (int) ((this.valueTo - this.valueFrom) / f);
        return ((double) Math.round(((float) stepCount) * position)) / ((double) stepCount);
    }

    private boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float touchValue = getValueOfTouchPosition();
        float touchX = valueToX(touchValue);
        float leftXBound = Math.min(touchX, this.touchDownX);
        float rightXBound = Math.max(touchX, this.touchDownX);
        this.activeThumbIdx = 0;
        float activeThumbDiff = Math.abs(this.values.get(0).floatValue() - touchValue);
        int i = 0;
        while (i < this.values.size()) {
            float valueDiff = Math.abs(this.values.get(i).floatValue() - touchValue);
            float valueX = valueToX(this.values.get(i).floatValue());
            float valueDiffX = Math.abs(valueX - touchX);
            float activeValueDiffX = Math.abs(valueToX(this.values.get(this.activeThumbIdx).floatValue()) - touchX);
            if (leftXBound >= valueX || rightXBound <= valueX) {
                int i2 = this.scaledTouchSlop;
                if (valueDiffX >= ((float) i2) || activeValueDiffX >= ((float) i2) || ((double) Math.abs(valueDiffX - activeValueDiffX)) <= THRESHOLD) {
                    if (valueDiff < activeThumbDiff) {
                        activeThumbDiff = valueDiff;
                        this.activeThumbIdx = i;
                    }
                    i++;
                } else {
                    this.activeThumbIdx = -1;
                    return false;
                }
            } else {
                this.activeThumbIdx = i;
                return true;
            }
        }
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private boolean snapActiveThumbToValue(float value) {
        return snapThumbToValue(this.activeThumbIdx, value);
    }

    /* access modifiers changed from: private */
    public boolean snapThumbToValue(int idx, float value) {
        if (((double) Math.abs(value - this.values.get(idx).floatValue())) < THRESHOLD) {
            return false;
        }
        this.values.set(idx, Float.valueOf(value));
        Collections.sort(this.values);
        if (idx == this.activeThumbIdx) {
            idx = this.values.indexOf(Float.valueOf(value));
        }
        this.activeThumbIdx = idx;
        this.focusedThumbIdx = idx;
        dispatchOnChangedFromUser(idx);
        return true;
    }

    private float getValueOfTouchPosition() {
        double position = snapPosition(this.touchPosition);
        if (ViewCompat.getLayoutDirection(this) == 1) {
            position = 1.0d - position;
        }
        float f = this.valueTo;
        float f2 = this.valueFrom;
        return (float) ((((double) (f - f2)) * position) + ((double) f2));
    }

    private float valueToX(float value) {
        return (normalizeValue(value) * ((float) this.trackWidth)) + ((float) this.trackSidePadding);
    }

    private void ensureLabels() {
        if (this.labelBehavior != 2) {
            Iterator<TooltipDrawable> labelItr = this.labels.iterator();
            for (int i = 0; i < this.values.size() && labelItr.hasNext(); i++) {
                if (i != this.focusedThumbIdx) {
                    setValueForLabel(labelItr.next(), this.values.get(i).floatValue());
                }
            }
            if (labelItr.hasNext() != 0) {
                setValueForLabel(labelItr.next(), this.values.get(this.focusedThumbIdx).floatValue());
                return;
            }
            throw new IllegalStateException("Not enough labels to display all the values");
        }
    }

    /* access modifiers changed from: private */
    public String formatValue(float value) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(value);
        }
        return String.format(((float) ((int) value)) == value ? "%.0f" : "%.2f", new Object[]{Float.valueOf(value)});
    }

    private void setValueForLabel(TooltipDrawable label, float value) {
        label.setText(formatValue(value));
        int left = (this.trackSidePadding + ((int) (normalizeValue(value) * ((float) this.trackWidth)))) - (label.getIntrinsicWidth() / 2);
        int top = calculateTop() - (this.labelPadding + this.thumbRadius);
        label.setBounds(left, top - label.getIntrinsicHeight(), label.getIntrinsicWidth() + left, top);
        Rect rect = new Rect(label.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        label.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(label);
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth((float) this.trackHeight);
        this.activeTrackPaint.setStrokeWidth((float) this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
        this.activeTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
    }

    private boolean isInScrollingContainer() {
        for (ViewParent p = getParent(); p instanceof ViewGroup; p = p.getParent()) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void dispatchOnChangedProgramatically() {
        for (OnChangeListener listener : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                listener.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void dispatchOnChangedFromUser(int idx) {
        for (OnChangeListener listener : this.changeListeners) {
            listener.onValueChange(this, this.values.get(idx).floatValue(), true);
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null && accessibilityManager2.isEnabled()) {
            scheduleAccessibilityEventSender(idx);
        }
    }

    private void onStartTrackingTouch() {
        for (OnSliderTouchListener listener : this.touchListeners) {
            listener.onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        for (OnSliderTouchListener listener : this.touchListeners) {
            listener.onStopTrackingTouch(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (TooltipDrawable label : this.labels) {
            if (label.isStateful()) {
                label.setState(getDrawableState());
            }
        }
        if (this.thumbDrawable.isStateful()) {
            this.thumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    private int getColorForState(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    /* access modifiers changed from: package-private */
    public void forceDrawCompatHalo(boolean force) {
        this.forceDrawCompatHalo = force;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isEnabled()) {
            if (this.values.size() == 1) {
                this.activeThumbIdx = 0;
            }
            if (this.activeThumbIdx != -1) {
                this.isLongPress |= event.isLongPress();
                Float increment = calculateIncrementForKey(event, keyCode);
                if (increment != null) {
                    if (ViewCompat.getLayoutDirection(this) == 1) {
                        increment = Float.valueOf(-increment.floatValue());
                    }
                    if (snapActiveThumbToValue(MathUtils.clamp(this.values.get(this.activeThumbIdx).floatValue() + increment.floatValue(), this.valueFrom, this.valueTo))) {
                        updateHaloHotspot();
                        postInvalidate();
                    }
                    return true;
                }
            } else if (keyCode != 61) {
                if (keyCode != 66) {
                    if (keyCode != 69) {
                        if (keyCode != 81) {
                            switch (keyCode) {
                                case 21:
                                    break;
                                case 22:
                                    break;
                                case 23:
                                    break;
                            }
                        }
                        moveFocus(1);
                        return true;
                    }
                    moveFocus(-1);
                    return true;
                }
                this.activeThumbIdx = this.focusedThumbIdx;
                postInvalidate();
                return true;
            } else if (event.hasNoModifiers()) {
                moveFocus(1);
                return true;
            } else if (!event.isShiftPressed()) {
                return false;
            } else {
                moveFocus(-1);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        this.isLongPress = false;
        return super.onKeyUp(keyCode, event);
    }

    private void moveFocus(int direction) {
        int i = this.focusedThumbIdx + direction;
        this.focusedThumbIdx = i;
        int clamp = MathUtils.clamp(i, 0, this.values.size() - 1);
        this.focusedThumbIdx = clamp;
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = clamp;
        }
        updateHaloHotspot();
        postInvalidate();
    }

    private Float calculateIncrementForKey(KeyEvent event, int keyCode) {
        float increment = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
        if (keyCode != 21) {
            if (keyCode != 22) {
                if (keyCode != 61) {
                    if (keyCode != 81) {
                        if (keyCode != 69) {
                            if (keyCode != 70) {
                                return null;
                            }
                        }
                    }
                } else if (event.isShiftPressed()) {
                    return Float.valueOf(-increment);
                } else {
                    return Float.valueOf(increment);
                }
            }
            return Float.valueOf(increment);
        }
        increment = -increment;
        return Float.valueOf(increment);
    }

    private float calculateStepIncrement() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return 1.0f;
        }
        return f;
    }

    /* access modifiers changed from: private */
    public float calculateStepIncrement(int stepFactor) {
        float increment = calculateStepIncrement();
        float numSteps = (this.valueTo - this.valueFrom) / increment;
        if (numSteps <= ((float) stepFactor)) {
            return increment;
        }
        return ((float) Math.round(numSteps / ((float) stepFactor))) * increment;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (!gainFocus) {
            this.activeThumbIdx = -1;
            for (TooltipDrawable label : this.labels) {
                ViewUtils.getContentViewOverlay(this).remove(label);
            }
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(Integer.MIN_VALUE);
            return;
        }
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public boolean dispatchHoverEvent(MotionEvent event) {
        return this.accessibilityHelper.dispatchHoverEvent(event) || super.dispatchHoverEvent(event);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    private void scheduleAccessibilityEventSender(int idx) {
        AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 == null) {
            this.accessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender2);
        }
        this.accessibilityEventSender.setVirtualViewId(idx);
        postDelayed(this.accessibilityEventSender, 200);
    }

    private class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        /* access modifiers changed from: package-private */
        public void setVirtualViewId(int virtualViewId2) {
            this.virtualViewId = virtualViewId2;
        }

        public void run() {
            Slider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        SliderState sliderState = (SliderState) state;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        this.values = sliderState.values;
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
        dispatchOnChangedProgramatically();
    }

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() {
            public SliderState createFromParcel(Parcel source) {
                return new SliderState(source);
            }

            public SliderState[] newArray(int size) {
                return new SliderState[size];
            }
        };
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        SliderState(Parcelable superState) {
            super(superState);
        }

        private SliderState(Parcel source) {
            super(source);
            this.valueFrom = source.readFloat();
            this.valueTo = source.readFloat();
            source.readList(this.values, Float.class.getClassLoader());
            this.stepSize = source.readFloat();
            this.hasFocus = source.createBooleanArray()[0];
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeFloat(this.valueFrom);
            dest.writeFloat(this.valueTo);
            dest.writeList(this.values);
            dest.writeFloat(this.stepSize);
            dest.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    private class AccessibilityHelper extends ExploreByTouchHelper {
        Rect bounds = new Rect();

        AccessibilityHelper() {
            super(Slider.this);
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float x, float y) {
            for (int i = 0; i < Slider.this.getValues().size(); i++) {
                updateBoundsForVirturalViewId(i);
                if (this.bounds.contains((int) x, (int) y)) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            for (int i = 0; i < Slider.this.getValues().size(); i++) {
                virtualViewIds.add(Integer.valueOf(i));
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat info) {
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            float value = Slider.this.getValues().get(virtualViewId).floatValue();
            if (Slider.this.isEnabled()) {
                if (value > Slider.this.valueFrom) {
                    info.addAction(8192);
                }
                if (value < Slider.this.valueTo) {
                    info.addAction(4096);
                }
            }
            info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, Slider.this.valueFrom, Slider.this.valueTo, value));
            info.setClassName(SeekBar.class.getName());
            StringBuilder contentDescription = new StringBuilder();
            contentDescription.append(Slider.this.getContentDescription());
            if (contentDescription.length() != 0) {
                contentDescription.append(",");
            }
            Context context = Slider.this.getContext();
            int i = C1130R.string.mtrl_slider_range_content_description;
            Slider slider = Slider.this;
            Slider slider2 = Slider.this;
            contentDescription.append(context.getString(i, new Object[]{slider.formatValue(slider.getMinimumValue()), slider2.formatValue(slider2.getMaximumValue())}));
            info.setContentDescription(contentDescription.toString());
            updateBoundsForVirturalViewId(virtualViewId);
            info.setBoundsInParent(this.bounds);
        }

        private void updateBoundsForVirturalViewId(int virtualViewId) {
            int access$800 = Slider.this.trackSidePadding;
            Slider slider = Slider.this;
            int x = access$800 + ((int) (slider.normalizeValue(slider.getValues().get(virtualViewId).floatValue()) * ((float) Slider.this.trackWidth)));
            int y = Slider.this.calculateTop();
            this.bounds.set(x - Slider.this.thumbRadius, y - Slider.this.thumbRadius, Slider.this.thumbRadius + x, Slider.this.thumbRadius + y);
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            if (!Slider.this.isEnabled()) {
                return false;
            }
            if (action == 4096 || action == 8192) {
                float increment = Slider.this.calculateStepIncrement(20);
                if (action == 8192) {
                    increment = -increment;
                }
                if (ViewCompat.getLayoutDirection(Slider.this) == 1) {
                    increment = -increment;
                }
                float clamped = MathUtils.clamp(((Float) Slider.this.values.get(virtualViewId)).floatValue() + increment, Slider.this.valueFrom, Slider.this.valueTo);
                if (!Slider.this.snapThumbToValue(virtualViewId, clamped)) {
                    return false;
                }
                Slider.this.updateHaloHotspot();
                Slider.this.postInvalidate();
                if (Slider.this.values.indexOf(Float.valueOf(clamped)) != virtualViewId) {
                    sendEventForVirtualView(Slider.this.values.indexOf(Float.valueOf(clamped)), 8);
                } else {
                    invalidateVirtualView(virtualViewId);
                }
                return true;
            } else if (action != 16908349 || arguments == null || !arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                return false;
            } else {
                if (!Slider.this.snapThumbToValue(virtualViewId, arguments.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    return false;
                }
                Slider.this.updateHaloHotspot();
                Slider.this.postInvalidate();
                invalidateVirtualView(virtualViewId);
                return true;
            }
        }
    }
}
