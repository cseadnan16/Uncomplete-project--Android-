package com.example.adnan.buttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login_button, logout_button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout_button = (Button) findViewById(R.id.ButtonID);
        logout_button = findViewById(R.id.ButtonID_2);
        textView = findViewById(R.id.TextID);

        login_button.setOnClickListener(this);
        logout_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ButtonID)
        {
            textView.setText("Login Button is clicked");
        }
        else
        {
            textView.setText("Logout Button is clicked");
        }

    }
}
