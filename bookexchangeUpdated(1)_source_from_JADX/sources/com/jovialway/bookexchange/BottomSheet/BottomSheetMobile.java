package com.jovialway.bookexchange.BottomSheet;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.jovialway.bookexchange.C1214R;
import com.mukesh.OtpView;

public class BottomSheetMobile extends BottomSheetDialogFragment {
    private BottomSheetListner bListner;
    String codeSent;
    Context context;
    EditText countryCodeET;
    FirebaseAuth mAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        }

        public void onVerificationFailed(FirebaseException e) {
        }

        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            BottomSheetMobile.this.otpCode = s;
        }
    };
    String otpCode;
    TextView otpTV;
    /* access modifiers changed from: private */
    public OtpView otpView;
    String otpg;
    EditText phoneET;
    TextView registrar;
    TextInputLayout til;

    public interface BottomSheetListner {
        void onButtonClicked(String str);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C1214R.layout.bottom_mobile, container, false);
        this.otpView = (OtpView) v.findViewById(C1214R.C1217id.otp_view);
        this.phoneET = (EditText) v.findViewById(C1214R.C1217id.phoneET);
        this.registrar = (TextView) v.findViewById(C1214R.C1217id.registrar);
        this.til = (TextInputLayout) v.findViewById(C1214R.C1217id.til);
        this.otpTV = (TextView) v.findViewById(C1214R.C1217id.otpTV);
        this.countryCodeET = (EditText) v.findViewById(C1214R.C1217id.countryCodeET);
        this.context = getContext();
        this.mAuth = FirebaseAuth.getInstance();
        this.phoneET.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
        this.phoneET.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (BottomSheetMobile.this.phoneET.getText().toString().trim().length() > 1) {
                    BottomSheetMobile.this.countryCodeET.setVisibility(0);
                }
            }

            public void afterTextChanged(Editable s) {
                if (BottomSheetMobile.this.phoneET.getText().toString().trim().length() == 11) {
                    BottomSheetMobile.this.sendVerificationCode();
                    BottomSheetMobile.this.til.setVisibility(4);
                    BottomSheetMobile.this.countryCodeET.setVisibility(4);
                    BottomSheetMobile.this.otpTV.setVisibility(0);
                    BottomSheetMobile.this.otpView.setVisibility(0);
                    BottomSheetMobile.this.otpView.requestFocus();
                }
            }
        });
        return v;
    }

    public void onAttach(Context context2) {
        super.onAttach(context2);
        try {
            this.bListner = (BottomSheetListner) context2;
        } catch (ClassCastException e) {
            throw new ClassCastException(context2.toString() + "must impliment");
        }
    }

    /* access modifiers changed from: private */
    public void sendVerificationCode() {
        String number = this.phoneET.getText().toString();
        String phoneNumber = this.countryCodeET.getText().toString() + number;
        if (phoneNumber.isEmpty()) {
            this.phoneET.setError("Please Enter a Phone Number");
            this.phoneET.requestFocus();
        } else if (phoneNumber.length() < 11) {
            this.phoneET.setError("Enter Valid Phone Number WITHOUT Country Code");
            this.phoneET.requestFocus();
        }
    }
}
