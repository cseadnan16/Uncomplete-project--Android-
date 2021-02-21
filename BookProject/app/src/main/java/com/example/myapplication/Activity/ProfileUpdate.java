package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.AdPostRecylerViewResponce.AdRecylerViewResponse;
import com.example.myapplication.AdPostResponce.AdPostResponce;
import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Fragment.ProfileFragment;
import com.example.myapplication.Model.SessionData;
import com.example.myapplication.ProfileModel.ProfileResponse;
import com.example.myapplication.ProfileUpdateModel.ProfileUpdateResponce;
import com.example.myapplication.R;
import com.example.myapplication.SessionClass.SessionClass;
import com.example.myapplication.loginModel.LoginResponse;
import com.example.myapplication.networking.RetrofitClient;

public class ProfileUpdate extends AppCompatActivity {

    EditText user_name,email,address;
    ImageButton back;
    Button bottonUpdate;
    TextView Token;

    String TAG="ProfileUpdate";

    String token,Name,Email,Address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.profile_update );

       

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.7));

        user_name = findViewById( R.id.user_name );
        email = findViewById( R.id.email );
        bottonUpdate = findViewById( R.id.bottonUpdate );
        address = findViewById( R.id.address );

        back = findViewById( R.id.back );


        token = getIntent().getStringExtra("token");




        Call <ProfileResponse> call = RetrofitClient.getInstance(token).getApiInterface().profileData();
        call.enqueue(new Callback <ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response <ProfileResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    ProfileResponse profileResponse = response.body();
                    if (profileResponse != null && profileResponse.getStatus() == 1) {

                        Toast.makeText(ProfileUpdate.this, profileResponse.getId().toString(), Toast.LENGTH_SHORT).show();

                        Name = profileResponse.getName();
                        Email = profileResponse.getEmail();
                        Address = profileResponse.getAddress().toString();

                        user_name.setText(Name);
                        email.setText(Email);
                        address.setText(Address);


                    } else {
                        Toast.makeText(ProfileUpdate.this,profileResponse.getStatus(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText(ProfileUpdate.this,"Data Featching Faild", Toast.LENGTH_SHORT).show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bottonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = user_name.getText().toString();
                Email = email.getText().toString();
                Address = address.getText().toString();


                Call<ProfileUpdateResponce> call = RetrofitClient.getInstance(token).getApiInterface().profileUpdateData(Name,Email,Address);
                call.enqueue(new Callback<ProfileUpdateResponce>() {
                    @Override
                    public void onResponse(Call<ProfileUpdateResponce> call, Response<ProfileUpdateResponce> response) {
                        if (response.isSuccessful()) {

                            ProfileUpdateResponce profileUpdateResponce = response.body();
                            if (profileUpdateResponce != null && profileUpdateResponce.getStatus() == 1) {


                                Log.e(TAG, "Name: " + Name);
                                Log.e(TAG, "Email: " + Email);
                                Log.e(TAG, "Address: " + Address);
                                Toast.makeText(ProfileUpdate.this, "Profile Update", Toast.LENGTH_SHORT).show();

                                SessionData sessionData = new SessionData();

                                sessionData.setName( Name );
                                sessionData.setEmail( Email );
                                sessionData.setAddress( Address );
                                //SessionData.(getApplicationContext()).userLogin(sessionData);

                                SessionClass.getInstance(getApplicationContext()).userLogin(sessionData);

                                finish();


                            } else {
                                Toast.makeText(ProfileUpdate.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(ProfileUpdate.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ProfileUpdateResponce> call, Throwable t) {

                    }
                });


            }
        });



    }
}
