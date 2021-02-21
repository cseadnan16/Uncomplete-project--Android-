package com.mukesh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

public class OtpView extends AppCompatEditText {
    private static final int BLINK = 500;
    private static final boolean DBG = false;
    private static final int DEFAULT_COUNT = 4;
    private static final int[] FILLED_STATE = {C1221R.attr.state_filled};
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private static final int[] SELECTED_STATE = {16842913};
    private static final int VIEW_TYPE_LINE = 1;
    private static final int VIEW_TYPE_NONE = 2;
    private static final int VIEW_TYPE_RECTANGLE = 0;
    /* access modifiers changed from: private */
    public final TextPaint animatorTextPaint;
    private Blink blink;
    private int cursorColor;
    private float cursorHeight;
    private int cursorLineColor;
    private int cursorWidth;
    private ValueAnimator defaultAddAnimator;
    /* access modifiers changed from: private */
    public boolean drawCursor;
    private boolean hideLineWhenFilled;
    private boolean isAnimationEnable;
    private boolean isCursorVisible;
    private Drawable itemBackground;
    private int itemBackgroundResource;
    private final RectF itemBorderRect;
    private final PointF itemCenterPoint;
    private final RectF itemLineRect;
    private ColorStateList lineColor;
    private int lineWidth;
    private String maskingChar;
    private OnOtpCompletionListener onOtpCompletionListener;
    private int otpViewItemCount;
    private int otpViewItemHeight;
    private int otpViewItemRadius;
    private int otpViewItemSpacing;
    private int otpViewItemWidth;
    private final Paint paint;
    private final Path path;
    private boolean rtlTextDirection;
    private final Rect textRect;
    private int viewType;

    public OtpView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OtpView(Context context, AttributeSet attrs) {
        this(context, attrs, C1221R.attr.otpViewStyle);
    }

    public OtpView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.animatorTextPaint = new TextPaint();
        this.cursorLineColor = ViewCompat.MEASURED_STATE_MASK;
        this.textRect = new Rect();
        this.itemBorderRect = new RectF();
        this.itemLineRect = new RectF();
        this.path = new Path();
        this.itemCenterPoint = new PointF();
        this.isAnimationEnable = false;
        Resources res = getResources();
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.animatorTextPaint.set(getPaint());
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, C1221R.styleable.OtpView, defStyleAttr, 0);
        this.viewType = typedArray.getInt(C1221R.styleable.OtpView_viewType, 2);
        this.otpViewItemCount = typedArray.getInt(C1221R.styleable.OtpView_itemCount, 4);
        this.otpViewItemHeight = (int) typedArray.getDimension(C1221R.styleable.OtpView_itemHeight, (float) res.getDimensionPixelSize(C1221R.dimen.otp_view_item_size));
        this.otpViewItemWidth = (int) typedArray.getDimension(C1221R.styleable.OtpView_itemWidth, (float) res.getDimensionPixelSize(C1221R.dimen.otp_view_item_size));
        this.otpViewItemSpacing = typedArray.getDimensionPixelSize(C1221R.styleable.OtpView_itemSpacing, res.getDimensionPixelSize(C1221R.dimen.otp_view_item_spacing));
        this.otpViewItemRadius = (int) typedArray.getDimension(C1221R.styleable.OtpView_itemRadius, 0.0f);
        this.lineWidth = (int) typedArray.getDimension(C1221R.styleable.OtpView_lineWidth, (float) res.getDimensionPixelSize(C1221R.dimen.otp_view_item_line_width));
        this.lineColor = typedArray.getColorStateList(C1221R.styleable.OtpView_lineColor);
        this.isCursorVisible = typedArray.getBoolean(C1221R.styleable.OtpView_android_cursorVisible, true);
        this.cursorColor = typedArray.getColor(C1221R.styleable.OtpView_cursorColor, getCurrentTextColor());
        this.cursorWidth = typedArray.getDimensionPixelSize(C1221R.styleable.OtpView_cursorWidth, res.getDimensionPixelSize(C1221R.dimen.otp_view_cursor_width));
        this.itemBackground = typedArray.getDrawable(C1221R.styleable.OtpView_android_itemBackground);
        this.hideLineWhenFilled = typedArray.getBoolean(C1221R.styleable.OtpView_hideLineWhenFilled, false);
        this.rtlTextDirection = typedArray.getBoolean(C1221R.styleable.OtpView_rtlTextDirection, false);
        this.maskingChar = typedArray.getString(C1221R.styleable.OtpView_maskingChar);
        typedArray.recycle();
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList != null) {
            this.cursorLineColor = colorStateList.getDefaultColor();
        }
        updateCursorHeight();
        checkItemRadius();
        setMaxLength(this.otpViewItemCount);
        this.paint.setStrokeWidth((float) this.lineWidth);
        setupAnimator();
        super.setCursorVisible(false);
        setTextIsSelectable(false);
    }

    public void setTypeface(Typeface tf, int style) {
        super.setTypeface(tf, style);
    }

    public void setTypeface(Typeface tf) {
        super.setTypeface(tf);
        TextPaint textPaint = this.animatorTextPaint;
        if (textPaint != null) {
            textPaint.set(getPaint());
        }
    }

    private void setMaxLength(int maxLength) {
        setFilters(maxLength >= 0 ? new InputFilter[]{new InputFilter.LengthFilter(maxLength)} : NO_FILTERS);
    }

    private void setupAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
        this.defaultAddAnimator = ofFloat;
        ofFloat.setDuration(150);
        this.defaultAddAnimator.setInterpolator(new DecelerateInterpolator());
        this.defaultAddAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = ((Float) animation.getAnimatedValue()).floatValue();
                OtpView.this.animatorTextPaint.setTextSize(OtpView.this.getTextSize() * scale);
                OtpView.this.animatorTextPaint.setAlpha((int) (255.0f * scale));
                OtpView.this.postInvalidate();
            }
        });
    }

    private void checkItemRadius() {
        int i = this.viewType;
        if (i == 1) {
            if (((float) this.otpViewItemRadius) > ((float) this.lineWidth) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than lineWidth when viewType is line");
            }
        } else if (i == 0) {
            if (((float) this.otpViewItemRadius) > ((float) this.otpViewItemWidth) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than itemWidth");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int height;
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int boxHeight = this.otpViewItemHeight;
        if (widthMode == 1073741824) {
            width = widthSize;
        } else {
            int width2 = this.otpViewItemCount;
            width = ViewCompat.getPaddingEnd(this) + ((width2 - 1) * this.otpViewItemSpacing) + (width2 * this.otpViewItemWidth) + ViewCompat.getPaddingStart(this);
            if (this.otpViewItemSpacing == 0) {
                width -= (this.otpViewItemCount - 1) * this.lineWidth;
            }
        }
        if (heightMode == 1073741824) {
            height = heightSize;
        } else {
            height = getPaddingTop() + boxHeight + getPaddingBottom();
        }
        setMeasuredDimension(width, height);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        ValueAnimator valueAnimator;
        OnOtpCompletionListener onOtpCompletionListener2;
        if (start != text.length()) {
            moveSelectionToEnd();
        }
        if (text.length() == this.otpViewItemCount && (onOtpCompletionListener2 = this.onOtpCompletionListener) != null) {
            onOtpCompletionListener2.onOtpCompleted(text.toString());
        }
        makeBlink();
        if (this.isAnimationEnable) {
            if ((lengthAfter - lengthBefore > 0) && (valueAnimator = this.defaultAddAnimator) != null) {
                valueAnimator.end();
                this.defaultAddAnimator.start();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            moveSelectionToEnd();
            makeBlink();
        }
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (getText() != null && selEnd != getText().length()) {
            moveSelectionToEnd();
        }
    }

    private void moveSelectionToEnd() {
        if (getText() != null) {
            setSelection(getText().length());
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList == null || colorStateList.isStateful()) {
            updateColors();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.save();
        updatePaints();
        drawOtpView(canvas);
        canvas.restore();
    }

    private void updatePaints() {
        this.paint.setColor(this.cursorLineColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth((float) this.lineWidth);
        getPaint().setColor(getCurrentTextColor());
    }

    private void drawOtpView(Canvas canvas) {
        int nextItemToFill;
        if (this.rtlTextDirection) {
            nextItemToFill = this.otpViewItemCount - 1;
        } else if (getText() != null) {
            nextItemToFill = getText().length();
        } else {
            nextItemToFill = 0;
        }
        int i = 0;
        while (i < this.otpViewItemCount) {
            boolean itemFilled = false;
            boolean itemSelected = isFocused() && nextItemToFill == i;
            if (i < nextItemToFill) {
                itemFilled = true;
            }
            int[] itemState = null;
            if (itemFilled) {
                itemState = FILLED_STATE;
            } else if (itemSelected) {
                itemState = SELECTED_STATE;
            }
            this.paint.setColor(itemState != null ? getLineColorForState(itemState) : this.cursorLineColor);
            updateItemRectF(i);
            updateCenterPoint();
            canvas.save();
            if (this.viewType == 0) {
                updateOtpViewBoxPath(i);
                canvas.clipPath(this.path);
            }
            drawItemBackground(canvas, itemState);
            canvas.restore();
            if (itemSelected) {
                drawCursor(canvas);
            }
            int i2 = this.viewType;
            if (i2 == 0) {
                drawOtpBox(canvas, i);
            } else if (i2 == 1) {
                drawOtpLine(canvas, i);
            }
            if (this.rtlTextDirection) {
                if (getText().length() >= this.otpViewItemCount - i) {
                    drawInput(canvas, i);
                } else if (!TextUtils.isEmpty(getHint()) && getHint().length() == this.otpViewItemCount) {
                    drawHint(canvas, i);
                }
            } else if (getText().length() > i) {
                drawInput(canvas, i);
            } else if (!TextUtils.isEmpty(getHint()) && getHint().length() == this.otpViewItemCount) {
                drawHint(canvas, i);
            }
            i++;
        }
        if (isFocused() && getText() != null && getText().length() != this.otpViewItemCount && this.viewType == 0) {
            int index = getText().length();
            updateItemRectF(index);
            updateCenterPoint();
            updateOtpViewBoxPath(index);
            this.paint.setColor(getLineColorForState(SELECTED_STATE));
            drawOtpBox(canvas, index);
        }
    }

    private void drawInput(Canvas canvas, int i) {
        if (this.maskingChar != null && (isNumberInputType(getInputType()) || isPasswordInputType(getInputType()))) {
            drawMaskingText(canvas, i, Character.toString(this.maskingChar.charAt(0)));
        } else if (isPasswordInputType(getInputType())) {
            drawCircle(canvas, i);
        } else {
            drawText(canvas, i);
        }
    }

    private int getLineColorForState(int... states) {
        ColorStateList colorStateList = this.lineColor;
        return colorStateList != null ? colorStateList.getColorForState(states, this.cursorLineColor) : this.cursorLineColor;
    }

    private void drawItemBackground(Canvas canvas, int[] backgroundState) {
        if (this.itemBackground != null) {
            float delta = ((float) this.lineWidth) / 2.0f;
            this.itemBackground.setBounds(Math.round(this.itemBorderRect.left - delta), Math.round(this.itemBorderRect.top - delta), Math.round(this.itemBorderRect.right + delta), Math.round(this.itemBorderRect.bottom + delta));
            if (this.viewType != 2) {
                this.itemBackground.setState(backgroundState != null ? backgroundState : getDrawableState());
            }
            this.itemBackground.draw(canvas);
        }
    }

    private void updateOtpViewBoxPath(int i) {
        boolean drawRightCorner = false;
        boolean drawLeftCorner = false;
        if (this.otpViewItemSpacing != 0) {
            drawRightCorner = true;
            drawLeftCorner = true;
        } else {
            if (i == 0 && i != this.otpViewItemCount - 1) {
                drawLeftCorner = true;
            }
            if (i == this.otpViewItemCount - 1 && i != 0) {
                drawRightCorner = true;
            }
        }
        RectF rectF = this.itemBorderRect;
        int i2 = this.otpViewItemRadius;
        updateRoundRectPath(rectF, (float) i2, (float) i2, drawLeftCorner, drawRightCorner);
    }

    private void drawOtpBox(Canvas canvas, int i) {
        if (getText() == null || !this.hideLineWhenFilled || i >= getText().length()) {
            canvas.drawPath(this.path, this.paint);
        }
    }

    private void drawOtpLine(Canvas canvas, int i) {
        int i2;
        if (getText() == null || !this.hideLineWhenFilled || i >= getText().length()) {
            boolean drawRight = true;
            boolean drawLeft = true;
            if (this.otpViewItemSpacing == 0 && (i2 = this.otpViewItemCount) > 1) {
                if (i == 0) {
                    drawRight = false;
                } else if (i == i2 - 1) {
                    drawLeft = false;
                } else {
                    drawRight = false;
                    drawLeft = false;
                }
            }
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setStrokeWidth(((float) this.lineWidth) / 10.0f);
            float halfLineWidth = ((float) this.lineWidth) / 2.0f;
            this.itemLineRect.set(this.itemBorderRect.left - halfLineWidth, this.itemBorderRect.bottom - halfLineWidth, this.itemBorderRect.right + halfLineWidth, this.itemBorderRect.bottom + halfLineWidth);
            RectF rectF = this.itemLineRect;
            int i3 = this.otpViewItemRadius;
            updateRoundRectPath(rectF, (float) i3, (float) i3, drawLeft, drawRight);
            canvas.drawPath(this.path, this.paint);
        }
    }

    private void drawCursor(Canvas canvas) {
        if (this.drawCursor) {
            float cx = this.itemCenterPoint.x;
            float y = this.itemCenterPoint.y - (this.cursorHeight / 2.0f);
            int color = this.paint.getColor();
            float width = this.paint.getStrokeWidth();
            this.paint.setColor(this.cursorColor);
            this.paint.setStrokeWidth((float) this.cursorWidth);
            canvas.drawLine(cx, y, cx, y + this.cursorHeight, this.paint);
            this.paint.setColor(color);
            this.paint.setStrokeWidth(width);
        }
    }

    private void updateRoundRectPath(RectF rectF, float rx, float ry, boolean l, boolean r) {
        updateRoundRectPath(rectF, rx, ry, l, r, r, l);
    }

    private void updateRoundRectPath(RectF rectF, float rx, float ry, boolean tl, boolean tr, boolean br, boolean bl) {
        RectF rectF2 = rectF;
        float f = rx;
        float f2 = ry;
        this.path.reset();
        float l = rectF2.left;
        float t = rectF2.top;
        float lw = (rectF2.right - l) - (f * 2.0f);
        float lh = (rectF2.bottom - t) - (2.0f * f2);
        this.path.moveTo(l, t + f2);
        if (tl) {
            this.path.rQuadTo(0.0f, -f2, f, -f2);
        } else {
            this.path.rLineTo(0.0f, -f2);
            this.path.rLineTo(f, 0.0f);
        }
        this.path.rLineTo(lw, 0.0f);
        if (tr) {
            this.path.rQuadTo(f, 0.0f, f, f2);
        } else {
            this.path.rLineTo(f, 0.0f);
            this.path.rLineTo(0.0f, f2);
        }
        this.path.rLineTo(0.0f, lh);
        if (br) {
            this.path.rQuadTo(0.0f, f2, -f, f2);
        } else {
            this.path.rLineTo(0.0f, f2);
            this.path.rLineTo(-f, 0.0f);
        }
        this.path.rLineTo(-lw, 0.0f);
        if (bl) {
            this.path.rQuadTo(-f, 0.0f, -f, -f2);
        } else {
            this.path.rLineTo(-f, 0.0f);
            this.path.rLineTo(0.0f, -f2);
        }
        this.path.rLineTo(0.0f, -lh);
        this.path.close();
    }

    private void updateItemRectF(int i) {
        float halfLineWidth = ((float) this.lineWidth) / 2.0f;
        int scrollX = getScrollX() + ViewCompat.getPaddingStart(this);
        int i2 = this.otpViewItemSpacing;
        float left = ((float) (scrollX + ((this.otpViewItemWidth + i2) * i))) + halfLineWidth;
        if (i2 == 0 && i > 0) {
            left -= (float) (this.lineWidth * i);
        }
        float right = (((float) this.otpViewItemWidth) + left) - ((float) this.lineWidth);
        float top = ((float) (getScrollY() + getPaddingTop())) + halfLineWidth;
        this.itemBorderRect.set(left, top, right, (((float) this.otpViewItemHeight) + top) - ((float) this.lineWidth));
    }

    private void drawText(Canvas canvas, int i) {
        int reversedCharPosition;
        Paint paint2 = getPaintByIndex(i);
        paint2.setColor(getCurrentTextColor());
        if (this.rtlTextDirection) {
            int reversedPosition = this.otpViewItemCount - i;
            if (getText() == null) {
                reversedCharPosition = reversedPosition;
            } else {
                reversedCharPosition = reversedPosition - getText().length();
            }
            if (reversedCharPosition <= 0 && getText() != null) {
                drawTextAtBox(canvas, paint2, getText(), Math.abs(reversedCharPosition));
            }
        } else if (getText() != null) {
            drawTextAtBox(canvas, paint2, getText(), i);
        }
    }

    private void drawMaskingText(Canvas canvas, int i, String maskingChar2) {
        int reversedCharPosition;
        Paint paint2 = getPaintByIndex(i);
        paint2.setColor(getCurrentTextColor());
        if (this.rtlTextDirection) {
            int reversedPosition = this.otpViewItemCount - i;
            if (getText() == null) {
                reversedCharPosition = reversedPosition;
            } else {
                reversedCharPosition = reversedPosition - getText().length();
            }
            if (reversedCharPosition <= 0 && getText() != null) {
                drawTextAtBox(canvas, paint2, getText().toString().replaceAll(".", maskingChar2), Math.abs(reversedCharPosition));
            }
        } else if (getText() != null) {
            drawTextAtBox(canvas, paint2, getText().toString().replaceAll(".", maskingChar2), i);
        }
    }

    private void drawHint(Canvas canvas, int i) {
        Paint paint2 = getPaintByIndex(i);
        paint2.setColor(getCurrentHintTextColor());
        if (this.rtlTextDirection) {
            int reversedCharPosition = (this.otpViewItemCount - i) - getHint().length();
            if (reversedCharPosition <= 0) {
                drawTextAtBox(canvas, paint2, getHint(), Math.abs(reversedCharPosition));
                return;
            }
            return;
        }
        drawTextAtBox(canvas, paint2, getHint(), i);
    }

    private void drawTextAtBox(Canvas canvas, Paint paint2, CharSequence text, int charAt) {
        int i = charAt;
        paint2.getTextBounds(text.toString(), i, i + 1, this.textRect);
        float cx = this.itemCenterPoint.x;
        float cy = this.itemCenterPoint.y;
        Canvas canvas2 = canvas;
        CharSequence charSequence = text;
        int i2 = charAt;
        canvas2.drawText(charSequence, i2, i + 1, (cx - (Math.abs((float) this.textRect.width()) / 2.0f)) - ((float) this.textRect.left), ((Math.abs((float) this.textRect.height()) / 2.0f) + cy) - ((float) this.textRect.bottom), paint2);
    }

    private void drawCircle(Canvas canvas, int i) {
        Paint paint2 = getPaintByIndex(i);
        float cx = this.itemCenterPoint.x;
        float cy = this.itemCenterPoint.y;
        if (!this.rtlTextDirection) {
            canvas.drawCircle(cx, cy, paint2.getTextSize() / 2.0f, paint2);
        } else if ((this.otpViewItemCount - i) - getHint().length() <= 0) {
            canvas.drawCircle(cx, cy, paint2.getTextSize() / 2.0f, paint2);
        }
    }

    private Paint getPaintByIndex(int i) {
        if (getText() == null || !this.isAnimationEnable || i != getText().length() - 1) {
            return getPaint();
        }
        this.animatorTextPaint.setColor(getPaint().getColor());
        return this.animatorTextPaint;
    }

    private void drawAnchorLine(Canvas canvas) {
        float cx = this.itemCenterPoint.x;
        float cy = this.itemCenterPoint.y;
        this.paint.setStrokeWidth(1.0f);
        float cx2 = cx - (this.paint.getStrokeWidth() / 2.0f);
        float cy2 = cy - (this.paint.getStrokeWidth() / 2.0f);
        this.path.reset();
        this.path.moveTo(cx2, this.itemBorderRect.top);
        this.path.lineTo(cx2, this.itemBorderRect.top + Math.abs(this.itemBorderRect.height()));
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
        this.path.moveTo(this.itemBorderRect.left, cy2);
        this.path.lineTo(this.itemBorderRect.left + Math.abs(this.itemBorderRect.width()), cy2);
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
        this.paint.setStrokeWidth((float) this.lineWidth);
    }

    private void updateColors() {
        int color;
        boolean shouldInvalidate = false;
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList != null) {
            color = colorStateList.getColorForState(getDrawableState(), 0);
        } else {
            color = getCurrentTextColor();
        }
        if (color != this.cursorLineColor) {
            this.cursorLineColor = color;
            shouldInvalidate = true;
        }
        if (shouldInvalidate) {
            invalidate();
        }
    }

    private void updateCenterPoint() {
        this.itemCenterPoint.set(this.itemBorderRect.left + (Math.abs(this.itemBorderRect.width()) / 2.0f), this.itemBorderRect.top + (Math.abs(this.itemBorderRect.height()) / 2.0f));
    }

    private static boolean isPasswordInputType(int inputType) {
        int variation = inputType & 4095;
        return variation == 129 || variation == 225 || variation == 18;
    }

    private static boolean isNumberInputType(int inputType) {
        return inputType == 2;
    }

    /* access modifiers changed from: protected */
    public MovementMethod getDefaultMovementMethod() {
        return DefaultMovementMethod.getInstance();
    }

    public void setLineColor(int color) {
        this.lineColor = ColorStateList.valueOf(color);
        updateColors();
    }

    public void setLineColor(ColorStateList colors) {
        if (colors != null) {
            this.lineColor = colors;
            updateColors();
            return;
        }
        throw new IllegalArgumentException("Color cannot be null");
    }

    public ColorStateList getLineColors() {
        return this.lineColor;
    }

    public int getCurrentLineColor() {
        return this.cursorLineColor;
    }

    public void setLineWidth(int borderWidth) {
        this.lineWidth = borderWidth;
        checkItemRadius();
        requestLayout();
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public void setItemCount(int count) {
        this.otpViewItemCount = count;
        setMaxLength(count);
        requestLayout();
    }

    public int getItemCount() {
        return this.otpViewItemCount;
    }

    public void setItemRadius(int itemRadius) {
        this.otpViewItemRadius = itemRadius;
        checkItemRadius();
        requestLayout();
    }

    public int getItemRadius() {
        return this.otpViewItemRadius;
    }

    public void setItemSpacing(int itemSpacing) {
        this.otpViewItemSpacing = itemSpacing;
        requestLayout();
    }

    public int getItemSpacing() {
        return this.otpViewItemSpacing;
    }

    public void setItemHeight(int itemHeight) {
        this.otpViewItemHeight = itemHeight;
        updateCursorHeight();
        requestLayout();
    }

    public int getItemHeight() {
        return this.otpViewItemHeight;
    }

    public void setItemWidth(int itemWidth) {
        this.otpViewItemWidth = itemWidth;
        checkItemRadius();
        requestLayout();
    }

    public int getItemWidth() {
        return this.otpViewItemWidth;
    }

    public void setAnimationEnable(boolean enable) {
        this.isAnimationEnable = enable;
    }

    public void setHideLineWhenFilled(boolean hideLineWhenFilled2) {
        this.hideLineWhenFilled = hideLineWhenFilled2;
    }

    public void setTextSize(float size) {
        super.setTextSize(size);
        updateCursorHeight();
    }

    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        updateCursorHeight();
    }

    public void setOtpCompletionListener(OnOtpCompletionListener otpCompletionListener) {
        this.onOtpCompletionListener = otpCompletionListener;
    }

    public void setItemBackgroundResources(int resId) {
        if (resId == 0 || this.itemBackgroundResource == resId) {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), resId, getContext().getTheme());
            this.itemBackground = drawable;
            setItemBackground(drawable);
            this.itemBackgroundResource = resId;
        }
    }

    public void setItemBackgroundColor(int color) {
        Drawable drawable = this.itemBackground;
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable.mutate()).setColor(color);
            this.itemBackgroundResource = 0;
            return;
        }
        setItemBackground(new ColorDrawable(color));
    }

    public void setItemBackground(Drawable background) {
        this.itemBackgroundResource = 0;
        this.itemBackground = background;
        invalidate();
    }

    public void setCursorWidth(int width) {
        this.cursorWidth = width;
        if (isCursorVisible()) {
            invalidateCursor(true);
        }
    }

    public int getCursorWidth() {
        return this.cursorWidth;
    }

    public void setCursorColor(int color) {
        this.cursorColor = color;
        if (isCursorVisible()) {
            invalidateCursor(true);
        }
    }

    public int getCursorColor() {
        return this.cursorColor;
    }

    public void setMaskingChar(String maskingChar2) {
        this.maskingChar = maskingChar2;
        requestLayout();
    }

    public String getMaskingChar() {
        return this.maskingChar;
    }

    public void setCursorVisible(boolean visible) {
        if (this.isCursorVisible != visible) {
            this.isCursorVisible = visible;
            invalidateCursor(visible);
            makeBlink();
        }
    }

    public boolean isCursorVisible() {
        return this.isCursorVisible;
    }

    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        if (screenState == 1) {
            resumeBlink();
        } else if (screenState == 0) {
            suspendBlink();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeBlink();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        suspendBlink();
    }

    /* access modifiers changed from: private */
    public boolean shouldBlink() {
        return isCursorVisible() && isFocused();
    }

    private void makeBlink() {
        if (shouldBlink()) {
            if (this.blink == null) {
                this.blink = new Blink();
            }
            removeCallbacks(this.blink);
            this.drawCursor = false;
            postDelayed(this.blink, 500);
            return;
        }
        Blink blink2 = this.blink;
        if (blink2 != null) {
            removeCallbacks(blink2);
        }
    }

    private void suspendBlink() {
        Blink blink2 = this.blink;
        if (blink2 != null) {
            blink2.cancel();
            invalidateCursor(false);
        }
    }

    private void resumeBlink() {
        Blink blink2 = this.blink;
        if (blink2 != null) {
            blink2.unCancel();
            makeBlink();
        }
    }

    /* access modifiers changed from: private */
    public void invalidateCursor(boolean showCursor) {
        if (this.drawCursor != showCursor) {
            this.drawCursor = showCursor;
            invalidate();
        }
    }

    private void updateCursorHeight() {
        int delta = dpToPx() * 2;
        this.cursorHeight = ((float) this.otpViewItemHeight) - getTextSize() > ((float) delta) ? getTextSize() + ((float) delta) : getTextSize();
    }

    private class Blink implements Runnable {
        private boolean cancelled;

        private Blink() {
        }

        public void run() {
            if (!this.cancelled) {
                OtpView.this.removeCallbacks(this);
                if (OtpView.this.shouldBlink()) {
                    OtpView otpView = OtpView.this;
                    otpView.invalidateCursor(!otpView.drawCursor);
                    OtpView.this.postDelayed(this, 500);
                }
            }
        }

        /* access modifiers changed from: private */
        public void cancel() {
            if (!this.cancelled) {
                OtpView.this.removeCallbacks(this);
                this.cancelled = true;
            }
        }

        /* access modifiers changed from: private */
        public void unCancel() {
            this.cancelled = false;
        }
    }

    private int dpToPx() {
        return (int) ((getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }
}
