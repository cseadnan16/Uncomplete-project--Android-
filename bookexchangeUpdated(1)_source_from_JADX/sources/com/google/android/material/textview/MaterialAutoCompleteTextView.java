package com.google.android.material.textview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.C1130R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private final AccessibilityManager accessibilityManager;
    /* access modifiers changed from: private */
    public final ListPopupWindow modalListPopup;

    public MaterialAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1130R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, defStyleAttr, 0), attributeSet, defStyleAttr);
        Context context2 = getContext();
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.modalListPopup = listPopupWindow;
        listPopupWindow.setModal(true);
        this.modalListPopup.setAnchorView(this);
        this.modalListPopup.setInputMethodMode(2);
        this.modalListPopup.setAdapter(getAdapter());
        this.modalListPopup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View selectedView, int position, long id) {
                MaterialAutoCompleteTextView.this.updateText(position < 0 ? MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItem() : MaterialAutoCompleteTextView.this.getAdapter().getItem(position));
                AdapterView.OnItemClickListener userOnitemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (userOnitemClickListener != null) {
                    if (selectedView == null || position < 0) {
                        selectedView = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedView();
                        position = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemPosition();
                        id = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemId();
                    }
                    userOnitemClickListener.onItemClick(MaterialAutoCompleteTextView.this.modalListPopup.getListView(), selectedView, position, id);
                }
                MaterialAutoCompleteTextView.this.modalListPopup.dismiss();
            }
        });
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager2;
        if (getInputType() != 0 || (accessibilityManager2 = this.accessibilityManager) == null || !accessibilityManager2.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.modalListPopup.show();
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T adapter) {
        super.setAdapter(adapter);
        this.modalListPopup.setAdapter(getAdapter());
    }

    public CharSequence getHint() {
        TextInputLayout textInputLayout = findTextInputLayoutAncestor();
        if (textInputLayout == null || !textInputLayout.isProvidingHint()) {
            return super.getHint();
        }
        return textInputLayout.getHint();
    }

    private TextInputLayout findTextInputLayoutAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void updateText(Object selectedItem) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(selectedItem), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter((ListAdapter) null);
        setText(convertSelectionToString(selectedItem));
        setAdapter(adapter);
    }
}
