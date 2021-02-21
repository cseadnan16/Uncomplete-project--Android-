package com.example.adnan.intentdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        textView = (TextView) findViewById(R.id.text_ID);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null)
        {
            String value = bundle.getString("tag");
            textView.setText(value);
        }
    }
}
