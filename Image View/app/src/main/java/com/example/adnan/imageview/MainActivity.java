package com.example.adnan.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView image1, image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = (ImageView) findViewById(R.id.image1ID);
        image2 = (ImageView) findViewById(R.id.image2ID);

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.image1ID){
            Toast.makeText(MainActivity.this,"Adnan's 1st look",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Adnan's 2nd look",Toast.LENGTH_SHORT).show();
        }
    }
}
