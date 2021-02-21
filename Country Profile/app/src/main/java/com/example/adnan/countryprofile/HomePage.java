package com.example.adnan.countryprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    private Button button_bangladesh, button_india, button_pakistan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        button_bangladesh = (Button) findViewById(R.id.button_BD);
        button_india = (Button) findViewById(R.id.button_IND);
        button_pakistan = (Button) findViewById(R.id.button_PAK);

        button_bangladesh.setOnClickListener(this);
        button_india.setOnClickListener(this);
        button_pakistan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()== R.id.button_BD){
            Intent intent_BD = new Intent(HomePage.this, Profile.class);
            intent_BD.putExtra("name", "Bangladesh");
            startActivity(intent_BD);
        }

        if(v.getId()== R.id.button_IND){
            Intent intent_IND = new Intent(HomePage.this, Profile.class);
            intent_IND.putExtra("name", "India");
            startActivity(intent_IND);
        }

        if(v.getId()== R.id.button_PAK){
            Intent intent_PAK = new Intent(HomePage.this, Profile.class);
            intent_PAK.putExtra("name", "Pakistan");
            startActivity(intent_PAK);
        }
    }
}
