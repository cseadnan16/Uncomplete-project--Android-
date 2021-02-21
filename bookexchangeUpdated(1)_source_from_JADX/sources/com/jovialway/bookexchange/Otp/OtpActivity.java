package com.jovialway.bookexchange.Otp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.jovialway.bookexchange.Activity.SingUp;
import com.jovialway.bookexchange.C1214R;
import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public EditText editText;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            String unused = OtpActivity.this.verificationid = s;
        }

        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                OtpActivity.this.progressBar.setVisibility(0);
                OtpActivity.this.verifyCode(code);
            }
        }

        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(OtpActivity.this, e.getMessage(), 1).show();
        }
    };
    String phonenumber;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    TextView tryAgain;
    /* access modifiers changed from: private */
    public String verificationid;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1214R.layout.activity_otp);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon((int) C1214R.mipmap.ic_launcher_round);
        actionBar.setTitle((CharSequence) "OTP Verify");
        getWindow().getDecorView().setSystemUiVisibility(8192);
        getWindow().setStatusBarColor(-1);
        this.mAuth = FirebaseAuth.getInstance();
        this.progressBar = (ProgressBar) findViewById(C1214R.C1217id.progressbar);
        this.editText = (EditText) findViewById(C1214R.C1217id.editTextCode);
        this.tryAgain = (TextView) findViewById(C1214R.C1217id.tryTV);
        String stringExtra = getIntent().getStringExtra("phonenumber");
        this.phonenumber = stringExtra;
        sendVerificationCode(stringExtra);
        findViewById(C1214R.C1217id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String code = OtpActivity.this.editText.getText().toString().trim();
                if (code.isEmpty() || code.length() < 6) {
                    OtpActivity.this.editText.setError("Enter code...");
                    OtpActivity.this.editText.requestFocus();
                    return;
                }
                OtpActivity.this.verifyCode(code);
            }
        });
        this.tryAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OtpActivity.this, PhoneActivity.class);
                intent.setFlags(268468224);
                OtpActivity.this.startActivity(intent);
                OtpActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    public void verifyCode(String code) {
        signInWithCredential(PhoneAuthProvider.getCredential(this.verificationid, code));
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        this.mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(OtpActivity.this, SingUp.class);
                    intent.putExtra("phonenumber", OtpActivity.this.phonenumber);
                    intent.setFlags(268468224);
                    OtpActivity.this.startActivity(intent);
                    return;
                }
                Toast.makeText(OtpActivity.this, task.getException().getMessage(), 1).show();
            }
        });
    }

    private void sendVerificationCode(String number) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number, 60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD, this.mCallBack);
    }
}
