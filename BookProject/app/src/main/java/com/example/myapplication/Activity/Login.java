package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DialogBox.LoginFailedAlartDialog;
import com.example.myapplication.Model.SessionData;
import com.example.myapplication.R;
import com.example.myapplication.SessionClass.SessionClass;
import com.example.myapplication.loginModel.LoginResponse;
import com.example.myapplication.networking.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText login_email, login_password;
    TextView sign_in;
    Button bottomSinUp;
    private String TAG = "LoginActivity ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);

        bottomSinUp = findViewById(R.id.bottomSinUp);

        sign_in = findViewById(R.id.sign_in);


        bottomSinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login_email.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                if (email.equals("")) {
                    login_email.setError("Enter Your Email");
                } else if (password.equals("")) {
                    login_password.setError("Enter Your password");
                } else {

                    doLogin(email, password);
//                    if (email.equals( "habib") && password.equals( "1234" ) ){
//                        Intent intent = new Intent( Login.this, MainActivity.class );
//                        startActivity( intent );
//                        finish();
//                    }else {
//                        Toast.makeText( Login.this, "your email or password is incorrect. please try again", Toast.LENGTH_SHORT ).show();
//                    }


                }
            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, NumberAuthentication.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void doLogin(String email, String password) {
        Call<LoginResponse> call = RetrofitClient.getInstance().getApiInterface().userLogin(email, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null && loginResponse.getStatus() == 1) {
                        Log.e(TAG, "onResponse: " + loginResponse.getToken().getOriginal().getAccessToken());
                        Log.e(TAG, "onResponse: " + loginResponse.getToken().getOriginal().getAccessToken().length());
                        Toast.makeText(Login.this, loginResponse.getUserId().toString(), Toast.LENGTH_SHORT).show();

                        int userID = loginResponse.getUserId();
                        String UserToken = loginResponse.getToken().getOriginal().getAccessToken();
                        String UserName = loginResponse.getUserInformation().getName();
                        String UserEmail = loginResponse.getUserInformation().getEmail();
                        String UserAddress = loginResponse.getUserInformation().getAddress();
                        String UserMobile = loginResponse.getUserInformation().getMobile();

                        SessionData sessionData = new SessionData();

                        sessionData.setId( userID );
                        sessionData.setToken( UserToken );
                        sessionData.setName( UserName );
                        sessionData.setEmail( UserEmail );
                        sessionData.setAddress( UserAddress );
                        sessionData.setMobile( UserMobile );
                        //SessionData.(getApplicationContext()).userLogin(sessionData);

                        SessionClass.getInstance(getApplicationContext()).userLogin(sessionData);


                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
//                        Toast.makeText(Login.this, loginResponse.getStatus(), Toast.LENGTH_SHORT).show();
                        loginfailed();
//                        showCustomDialog();
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loginfailed() {
        LoginFailedAlartDialog LoginFailedAlartDialog=new LoginFailedAlartDialog();
        LoginFailedAlartDialog.show(getSupportFragmentManager(), "LoginFailedAlartDialog");

    }



}
