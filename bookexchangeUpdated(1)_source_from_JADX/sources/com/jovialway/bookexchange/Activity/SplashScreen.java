package com.jovialway.bookexchange.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.SessionClass.C1220SessionClass;

public class SplashScreen extends AppCompatActivity {
    C1220SessionClass sessionClass;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1214R.layout.splash_screen);
        getWindow().setFlags(1024, 1024);
        C1220SessionClass instance = C1220SessionClass.getInstance(this);
        this.sessionClass = instance;
        if (instance.isLoggedIn()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    SplashScreen.this.finish();
                }
            }, 2000);
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    SplashScreen.this.finish();
                }
            }, 2000);
        }
    }
}
