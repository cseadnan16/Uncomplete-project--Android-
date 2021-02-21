package com.example.adnan.countryprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = (ImageView) findViewById(R.id.image_id);
        textView = (TextView) findViewById(R.id.text_ID);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String CountryName = bundle.getString("name");
            showDetails(CountryName);
        }
    }


    void showDetails(String CountryName){

        if(CountryName.equals("Bangladesh")){
            imageView.setImageResource(R.drawable.bd_assembly);
            textView.setText(R.string.bd_history);
        }

        if(CountryName.equals("India")){
            imageView.setImageResource(R.drawable.india_image);
            textView.setText(R.string.ind_history);
        }

        if(CountryName.equals("Pakistan")){
            imageView.setImageResource(R.drawable.quaid_e_azam);
            textView.setText(R.string.pak_history);
        }
    }
}
