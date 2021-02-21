package com.jovialway.bookexchange.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.Fragment.ProfileFragment;
import com.jovialway.bookexchange.Model.SessionData;
import com.jovialway.bookexchange.NetWork.RetrofitClient;
import com.jovialway.bookexchange.SessionClass.C1220SessionClass;
import com.jovialway.bookexchange.loginModel.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    /* access modifiers changed from: private */
    public String TAG = "LoginActivity ";
    Button bottomSinUp;
    Context context;
    EditText login_email;
    EditText login_password;
    TextView sign_in;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1214R.layout.activity_login);
        getWindow().getDecorView().setSystemUiVisibility(8192);
        this.context = getBaseContext();
        this.login_email = (EditText) findViewById(C1214R.C1217id.login_email);
        this.login_password = (EditText) findViewById(C1214R.C1217id.login_password);
        this.bottomSinUp = (Button) findViewById(C1214R.C1217id.bottomSinUp);
        this.sign_in = (TextView) findViewById(C1214R.C1217id.sign_in);
        this.bottomSinUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = Login.this.login_email.getText().toString().trim();
                String password = Login.this.login_password.getText().toString().trim();
                if (email.equals("")) {
                    Login.this.login_email.setError("Enter Your Email");
                } else if (password.equals("")) {
                    Login.this.login_password.setError("Enter Your password");
                } else {
                    Login.this.doLogin(email, password);
                }
            }
        });
        this.sign_in.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login.this.startActivity(new Intent(Login.this, SingUp.class));
                Login.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    public void doLogin(String email, String password) {
        RetrofitClient.getInstance().getApiInterface().userLogin(email, password).enqueue(new Callback<LoginResponse>() {
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    String access$100 = Login.this.TAG;
                    Log.d(access$100, "onResponse: " + response.code());
                    LoginResponse loginResponse = response.body();
                    if (loginResponse == null || loginResponse.getStatus().intValue() != 1) {
                        Login.this.loginfailed();
                        return;
                    }
                    String access$1002 = Login.this.TAG;
                    Log.e(access$1002, "onResponse: " + loginResponse.getToken().getOriginal().getAccessToken());
                    String access$1003 = Login.this.TAG;
                    Log.e(access$1003, "onResponse: " + loginResponse.getToken().getOriginal().getAccessToken().length());
                    Login login = Login.this;
                    Toast.makeText(login, "Log In " + loginResponse.getUserInformation().getName(), 0).show();
                    int userID = loginResponse.getUserId().intValue();
                    String UserToken = loginResponse.getToken().getOriginal().getAccessToken();
                    String UserName = loginResponse.getUserInformation().getName();
                    String UserEmail = loginResponse.getUserInformation().getEmail();
                    String UserAddress = loginResponse.getUserInformation().getAddress();
                    String UserMobile = loginResponse.getUserInformation().getMobile();
                    SessionData sessionData = new SessionData();
                    sessionData.setId(userID);
                    sessionData.setToken(UserToken);
                    sessionData.setName(UserName);
                    sessionData.setEmail(UserEmail);
                    sessionData.setAddress(UserAddress);
                    sessionData.setMobile(UserMobile);
                    C1220SessionClass.getInstance(Login.this.getApplicationContext()).userLogin(sessionData);
                    Login.this.context.startActivity(new Intent(Login.this.context, ProfileFragment.class));
                    Login.this.finish();
                    return;
                }
                String access$1004 = Login.this.TAG;
                Log.d(access$1004, "onResponse: " + response.code());
            }

            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, t.getLocalizedMessage(), 0).show();
            }
        });
    }

    public void loginfailed() {
        Toast.makeText(this, "ffff", 0).show();
    }
}
