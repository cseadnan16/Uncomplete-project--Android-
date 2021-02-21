package com.mukesh;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

class DefaultMovementMethod implements MovementMethod {
    private static DefaultMovementMethod sInstance;

    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new DefaultMovementMethod();
        }
        return sInstance;
    }

    private DefaultMovementMethod() {
    }

    public void initialize(TextView widget, Spannable text) {
        Selection.setSelection(text, 0);
    }

    public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onKeyOther(TextView view, Spannable text, KeyEvent event) {
        return false;
    }

    public void onTakeFocus(TextView widget, Spannable text, int direction) {
    }

    public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event) {
        return false;
    }

    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        return false;
    }

    public boolean onGenericMotionEvent(TextView widget, Spannable text, MotionEvent event) {
        return false;
    }

    public boolean canSelectArbitrarily() {
        return false;
    }
}
