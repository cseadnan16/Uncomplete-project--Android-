package com.google.android.material.transition;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    /* access modifiers changed from: private */
    public static WeakReference<View> capturedSharedElement;
    private boolean entering = true;
    /* access modifiers changed from: private */
    public Drawable originalWindowBackground;
    private Rect returnEndBounds;
    private boolean transparentWindowBackgroundEnabled = true;

    public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
        capturedSharedElement = new WeakReference<>(sharedElement);
        return super.onCaptureSharedElementSnapshot(sharedElement, viewToGlobalMatrix, screenBounds);
    }

    public View onCreateSnapshotView(Context context, Parcelable snapshot) {
        View snapshotView = super.onCreateSnapshotView(context, snapshot);
        WeakReference<View> weakReference = capturedSharedElement;
        if (weakReference != null && (weakReference.get() instanceof Shapeable)) {
            snapshotView.setTag(((Shapeable) capturedSharedElement.get()).getShapeAppearanceModel());
        }
        return snapshotView;
    }

    public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
        View sharedElement;
        Activity activity;
        if (!names.isEmpty() && !sharedElements.isEmpty() && (sharedElement = sharedElements.get(names.get(0))) != null && (activity = ContextUtils.getActivity(sharedElement.getContext())) != null) {
            Window window = activity.getWindow();
            if (this.entering) {
                setUpEnterTransform(window);
            } else {
                setUpReturnTransform(activity, window);
            }
        }
    }

    public void onSharedElementStart(List<String> list, List<View> sharedElements, List<View> sharedElementSnapshots) {
        if (!sharedElements.isEmpty() && !sharedElementSnapshots.isEmpty()) {
            sharedElements.get(0).setTag(sharedElementSnapshots.get(0));
        }
        if (!this.entering && !sharedElements.isEmpty() && this.returnEndBounds != null) {
            View sharedElement = sharedElements.get(0);
            sharedElement.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
            sharedElement.layout(this.returnEndBounds.left, this.returnEndBounds.top, this.returnEndBounds.right, this.returnEndBounds.bottom);
        }
    }

    public void onSharedElementEnd(List<String> list, List<View> sharedElements, List<View> list2) {
        if (!sharedElements.isEmpty() && (sharedElements.get(0).getTag() instanceof View)) {
            sharedElements.get(0).setTag((Object) null);
        }
        if (!this.entering && !sharedElements.isEmpty()) {
            this.returnEndBounds = TransitionUtils.getRelativeBoundsRect(sharedElements.get(0));
        }
        this.entering = false;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    public void setTransparentWindowBackgroundEnabled(boolean transparentWindowBackgroundEnabled2) {
        this.transparentWindowBackgroundEnabled = transparentWindowBackgroundEnabled2;
    }

    private void setUpEnterTransform(final Window window) {
        Transition transition = window.getSharedElementEnterTransition();
        if (transition instanceof MaterialContainerTransform) {
            MaterialContainerTransform transform = (MaterialContainerTransform) transition;
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, transform);
                transform.addListener(new TransitionListenerAdapter() {
                    public void onTransitionStart(Transition transition) {
                        Drawable unused = MaterialContainerTransformSharedElementCallback.this.originalWindowBackground = window.getDecorView().getBackground();
                        window.setBackgroundDrawable(new ColorDrawable(0));
                    }

                    public void onTransitionEnd(Transition transition) {
                        if (MaterialContainerTransformSharedElementCallback.this.originalWindowBackground != null) {
                            window.setBackgroundDrawable(MaterialContainerTransformSharedElementCallback.this.originalWindowBackground);
                        }
                    }
                });
            }
        }
    }

    private void setUpReturnTransform(final Activity activity, final Window window) {
        Transition transition = window.getSharedElementReturnTransition();
        if (transition instanceof MaterialContainerTransform) {
            MaterialContainerTransform transform = (MaterialContainerTransform) transition;
            transform.setHoldAtEndEnabled(true);
            transform.addListener(new TransitionListenerAdapter() {
                public void onTransitionEnd(Transition transition) {
                    if (!(MaterialContainerTransformSharedElementCallback.capturedSharedElement == null || MaterialContainerTransformSharedElementCallback.capturedSharedElement.get() == null)) {
                        ((View) MaterialContainerTransformSharedElementCallback.capturedSharedElement.get()).setAlpha(1.0f);
                        WeakReference unused = MaterialContainerTransformSharedElementCallback.capturedSharedElement = null;
                    }
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
            });
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, transform);
                transform.addListener(new TransitionListenerAdapter() {
                    public void onTransitionStart(Transition transition) {
                        window.setBackgroundDrawable(new ColorDrawable(0));
                    }
                });
            }
        }
    }

    private static void updateBackgroundFadeDuration(Window window, MaterialContainerTransform transform) {
        window.setTransitionBackgroundFadeDuration(transform.getDuration() * 2);
    }
}
