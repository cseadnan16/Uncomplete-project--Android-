package com.jovialway.bookexchange.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.jovialway.bookexchange.BottomSheet.SubscribeSheet;
import com.jovialway.bookexchange.C1214R;

public class SubscribeActivity extends AppCompatActivity {
    ImageView checkseven;
    Button confirm;
    LinearLayout lifetime;
    ImageView lifetimecheck;
    LinearLayout oneyear;
    ImageView oneyearcheck;
    String pakage = "7 Days";
    TextView plandetails;
    TextView plantitle;
    LinearLayout sevendays;
    ImageView thirtycheck;
    LinearLayout thirtydays;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1214R.layout.activity_subscribe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon((int) C1214R.mipmap.ic_launcher_round);
        actionBar.setTitle((CharSequence) "Subscription");
        getWindow().getDecorView().setSystemUiVisibility(8192);
        getWindow().setStatusBarColor(-1);
        this.sevendays = (LinearLayout) findViewById(C1214R.C1217id.sevendays);
        this.thirtydays = (LinearLayout) findViewById(C1214R.C1217id.thirtydays);
        this.oneyear = (LinearLayout) findViewById(C1214R.C1217id.oneyear);
        this.lifetime = (LinearLayout) findViewById(C1214R.C1217id.lifetime);
        this.lifetimecheck = (ImageView) findViewById(C1214R.C1217id.lifetimecheck);
        this.oneyearcheck = (ImageView) findViewById(C1214R.C1217id.oneyearcheck);
        this.thirtycheck = (ImageView) findViewById(C1214R.C1217id.thirtycheck);
        this.checkseven = (ImageView) findViewById(C1214R.C1217id.checkseven);
        this.confirm = (Button) findViewById(C1214R.C1217id.confirm);
        this.plantitle = (TextView) findViewById(C1214R.C1217id.plantitle);
        this.plandetails = (TextView) findViewById(C1214R.C1217id.plandetails);
        this.sevendays.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SubscribeActivity.this.checkseven.setVisibility(0);
                SubscribeActivity.this.thirtycheck.setVisibility(4);
                SubscribeActivity.this.oneyearcheck.setVisibility(4);
                SubscribeActivity.this.lifetimecheck.setVisibility(4);
                SubscribeActivity.this.plantitle.setVisibility(4);
                SubscribeActivity.this.plandetails.setVisibility(4);
                SubscribeActivity.this.confirm.setVisibility(4);
                SubscribeActivity.this.pakage = "";
                SubscribeActivity.this.pakage = "";
            }
        });
        this.thirtydays.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SubscribeActivity.this.checkseven.setVisibility(4);
                SubscribeActivity.this.thirtycheck.setVisibility(0);
                SubscribeActivity.this.oneyearcheck.setVisibility(4);
                SubscribeActivity.this.lifetimecheck.setVisibility(4);
                SubscribeActivity.this.plantitle.setVisibility(0);
                SubscribeActivity.this.plandetails.setVisibility(0);
                SubscribeActivity.this.confirm.setVisibility(0);
                SubscribeActivity.this.pakage = "";
                SubscribeActivity.this.pakage = "30 Days Subscription!\n Worth : 50tk";
                SubscribeActivity.this.plandetails.setText(SubscribeActivity.this.pakage);
            }
        });
        this.oneyear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SubscribeActivity.this.checkseven.setVisibility(4);
                SubscribeActivity.this.thirtycheck.setVisibility(4);
                SubscribeActivity.this.oneyearcheck.setVisibility(0);
                SubscribeActivity.this.lifetimecheck.setVisibility(4);
                SubscribeActivity.this.plantitle.setVisibility(0);
                SubscribeActivity.this.plandetails.setVisibility(0);
                SubscribeActivity.this.confirm.setVisibility(0);
                SubscribeActivity.this.pakage = "";
                SubscribeActivity.this.pakage = "1 Year Subscription!\n Worth : 500tk";
                SubscribeActivity.this.plandetails.setText(SubscribeActivity.this.pakage);
            }
        });
        this.lifetime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SubscribeActivity.this.checkseven.setVisibility(4);
                SubscribeActivity.this.thirtycheck.setVisibility(4);
                SubscribeActivity.this.oneyearcheck.setVisibility(4);
                SubscribeActivity.this.lifetimecheck.setVisibility(0);
                SubscribeActivity.this.plantitle.setVisibility(0);
                SubscribeActivity.this.plandetails.setVisibility(0);
                SubscribeActivity.this.confirm.setVisibility(0);
                SubscribeActivity.this.pakage = "";
                SubscribeActivity.this.pakage = "Life Time Subscription!\n Worth : 1100tk";
                SubscribeActivity.this.plandetails.setText(SubscribeActivity.this.pakage);
            }
        });
        this.confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new SubscribeSheet().show(SubscribeActivity.this.getSupportFragmentManager(), "subscribde");
            }
        });
    }
}
