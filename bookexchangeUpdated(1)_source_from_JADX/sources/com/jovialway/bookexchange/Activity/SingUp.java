package com.jovialway.bookexchange.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.Model.SessionData;
import com.jovialway.bookexchange.NetWork.RetrofitClient;
import com.jovialway.bookexchange.Otp.PhoneActivity;
import com.jovialway.bookexchange.RegisterModel.RegisterResponse;
import com.jovialway.bookexchange.SessionClass.C1220SessionClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingUp extends AppCompatActivity {
    EditText Password;
    /* access modifiers changed from: private */
    public String TAG = "RegisterActivity ";
    EditText confirm_password;
    String mobile;
    ProgressBar progressBar;
    Button sign_up;
    EditText userEmail;
    EditText userName;
    EditText userPhone;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1214R.layout.activity_sing_up);
        this.userName = (EditText) findViewById(C1214R.C1217id.userName);
        this.userEmail = (EditText) findViewById(C1214R.C1217id.userEmail);
        this.Password = (EditText) findViewById(C1214R.C1217id.password);
        this.confirm_password = (EditText) findViewById(C1214R.C1217id.confirm_password);
        this.userPhone = (EditText) findViewById(C1214R.C1217id.userPhone);
        this.sign_up = (Button) findViewById(C1214R.C1217id.sign_up);
        this.progressBar = (ProgressBar) findViewById(C1214R.C1217id.progressBar);
        String stringExtra = getIntent().getStringExtra("phonenumber");
        this.mobile = stringExtra;
        if (stringExtra != null) {
            this.userPhone.setText(stringExtra);
            this.userPhone.setCompoundDrawablesWithIntrinsicBounds(C1214R.C1216drawable.ic_phone, 0, C1214R.C1216drawable.check, 0);
            this.userPhone.setFocusable(false);
            this.userPhone.setClickable(false);
        } else {
            this.userPhone.setText("Phone Number");
            this.userPhone.setCompoundDrawablesWithIntrinsicBounds(C1214R.C1216drawable.ic_phone, 0, 0, 0);
            this.userPhone.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SingUp.this.startActivity(new Intent(SingUp.this, PhoneActivity.class));
                }
            });
            this.userPhone.setFocusable(false);
            this.userPhone.setClickable(false);
        }
        this.sign_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = SingUp.this.userName.getText().toString();
                String email = SingUp.this.userEmail.getText().toString();
                String password = SingUp.this.Password.getText().toString();
                String ConfirmPassword = SingUp.this.confirm_password.getText().toString();
                SingUp.this.sign_up.setVisibility(8);
                SingUp.this.progressBar.setVisibility(0);
                if (name.equals("")) {
                    SingUp.this.userName.setError("Enter Your Name");
                    SingUp.this.sign_up.setVisibility(0);
                    SingUp.this.progressBar.setVisibility(8);
                } else if (email.equals("")) {
                    SingUp.this.userEmail.setError("Enter Your Email");
                    SingUp.this.sign_up.setVisibility(0);
                    SingUp.this.progressBar.setVisibility(8);
                } else if (password.equals("")) {
                    SingUp.this.Password.setError("Enter Your password");
                    SingUp.this.sign_up.setVisibility(0);
                    SingUp.this.progressBar.setVisibility(8);
                } else if (ConfirmPassword.equals("")) {
                    SingUp.this.confirm_password.setError("Enter Your password");
                    SingUp.this.sign_up.setVisibility(0);
                    SingUp.this.progressBar.setVisibility(8);
                } else if (!password.equals(ConfirmPassword)) {
                    Toast.makeText(SingUp.this, "Password not match!", 0).show();
                    SingUp.this.sign_up.setVisibility(0);
                    SingUp.this.progressBar.setVisibility(8);
                } else {
                    SingUp singUp = SingUp.this;
                    singUp.doRegister(name, email, singUp.mobile, password);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void doRegister(String name, String email, String mobile2, String password) {
        RetrofitClient.getInstance().getApiInterface().userRegister(name, email, mobile2, password).enqueue(new Callback<RegisterResponse>() {
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    String access$100 = SingUp.this.TAG;
                    Log.d(access$100, "onResponse: " + response.code());
                    RegisterResponse registerResponse = response.body();
                    if (registerResponse == null || registerResponse.getStatus().intValue() != 1) {
                        Toast.makeText(SingUp.this, registerResponse.getStatus().intValue(), 1).show();
                        return;
                    }
                    String access$1002 = SingUp.this.TAG;
                    Log.e(access$1002, "onResponse: " + registerResponse.getToken().getOriginal().getAccessToken());
                    String access$1003 = SingUp.this.TAG;
                    Log.e(access$1003, "onResponse: " + registerResponse.getToken().getOriginal().getAccessToken().length());
                    SingUp.this.sign_up.setVisibility(0);
                    SingUp.this.progressBar.setVisibility(8);
                    int userID = registerResponse.getUserId().intValue();
                    String UserToken = registerResponse.getToken().getOriginal().getAccessToken();
                    SessionData sessionData = new SessionData();
                    sessionData.setId(userID);
                    sessionData.setToken(UserToken);
                    C1220SessionClass.getInstance(SingUp.this.getApplicationContext()).userLogin(sessionData);
                    Toast.makeText(SingUp.this, registerResponse.getUserId().toString(), 1).show();
                    SingUp.this.startActivity(new Intent(SingUp.this, MainActivity.class));
                    SingUp.this.finish();
                    return;
                }
                String access$1004 = SingUp.this.TAG;
                Log.d(access$1004, "onResponse: " + response.code());
            }

            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(SingUp.this, t.getLocalizedMessage(), 0).show();
            }
        });
    }
}
