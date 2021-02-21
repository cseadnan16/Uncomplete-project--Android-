package com.jovialway.bookexchange.Activity;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jovialway.bookexchange.BottomSheet.BottomSheetLogIn;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.SessionClass.C1220SessionClass;

public class BookDetailsActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    TextView addresstv;
    TextView bookNametv;
    String bookame;
    TextView categorytv;
    String currency;
    TextView currencytv;
    TextView datetv;
    TextView descriptiontv;
    String exchangeWith;
    TextView exchangeWithtv;
    Button interested;
    String mail;
    String mobile;
    String publisher;
    TextView publishertv;
    C1220SessionClass sessionClass;
    String writer;
    TextView writertv;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1214R.layout.activity_book_details);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon((int) C1214R.mipmap.ic_launcher_round);
        actionBar.setTitle((CharSequence) "Book Details");
        getWindow().getDecorView().setSystemUiVisibility(8192);
        getWindow().setStatusBarColor(-1);
        this.sessionClass = C1220SessionClass.getInstance(this);
        this.interested = (Button) findViewById(C1214R.C1217id.interested);
        this.bookNametv = (TextView) findViewById(C1214R.C1217id.bookName);
        this.writertv = (TextView) findViewById(C1214R.C1217id.writer);
        this.categorytv = (TextView) findViewById(C1214R.C1217id.category);
        this.publishertv = (TextView) findViewById(C1214R.C1217id.publisher);
        this.descriptiontv = (TextView) findViewById(C1214R.C1217id.description);
        this.addresstv = (TextView) findViewById(C1214R.C1217id.address);
        this.exchangeWithtv = (TextView) findViewById(C1214R.C1217id.exchangewith);
        this.currencytv = (TextView) findViewById(C1214R.C1217id.currency);
        this.datetv = (TextView) findViewById(C1214R.C1217id.ad_date);
        Intent intent = getIntent();
        this.bookame = intent.getStringExtra("bookName");
        this.writer = intent.getStringExtra("writer");
        String category = intent.getStringExtra("category");
        this.publisher = intent.getStringExtra("publisher");
        String description = intent.getStringExtra("description");
        this.exchangeWith = intent.getStringExtra("exchangeWith");
        this.currency = intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY);
        String date = intent.getStringExtra("date");
        String dev = intent.getStringExtra("dev");
        String subdev = intent.getStringExtra("subdev");
        String adrs = intent.getStringExtra("adrs");
        this.mail = intent.getStringExtra("mail");
        String stringExtra = intent.getStringExtra("ad_id");
        this.mobile = intent.getStringExtra("mobile");
        this.bookNametv.setText(this.bookame);
        this.writertv.setText(this.writer);
        this.publishertv.setText(this.publisher);
        this.categorytv.setText(category);
        this.descriptiontv.setText(description);
        this.addresstv.setText(adrs + ", " + subdev + ", " + dev);
        this.exchangeWithtv.setText(this.exchangeWith);
        this.currencytv.setText(this.currency);
        this.datetv.setText(date);
        this.interested.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (BookDetailsActivity.this.sessionClass.isLoggedIn()) {
                    BookDetailsActivity.this.callDialog();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            new BottomSheetLogIn().show(BookDetailsActivity.this.getSupportFragmentManager(), FirebaseAnalytics.Event.LOGIN);
                        }
                    }, 1000);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void callDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(C1214R.layout.interest_dialoge);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
        ((ImageView) dialog.findViewById(C1214R.C1217id.call)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BookDetailsActivity.this.makephoneCall();
                dialog.dismiss();
            }
        });
        ((ImageView) dialog.findViewById(C1214R.C1217id.mail)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BookDetailsActivity.this.sendmail();
                dialog.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendmail() {
        Log.i("Send email", "");
        String[] TO = {this.mail};
        Intent emailIntent = new Intent("android.intent.action.SEND");
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra("android.intent.extra.EMAIL", TO);
        emailIntent.putExtra("android.intent.extra.SUBJECT", "About " + this.bookame);
        emailIntent.putExtra("android.intent.extra.TEXT", "I am Interested About " + this.bookame + ", Writer-" + this.writer + ", Publisher-" + this.publisher + ". You want to Exchagne with " + this.exchangeWith + " this books or " + this.currency + "tk.");
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "There is no email client installed.", 0).show();
        }
    }

    /* access modifiers changed from: private */
    public void makephoneCall() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, "android.permission.CALL_PHONE");
        getPackageManager();
        if (checkSelfPermission != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CALL_PHONE"}, 1);
            return;
        }
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.mobile)));
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length < 0) {
                int i = grantResults[0];
                getPackageManager();
                if (i == 0) {
                    makephoneCall();
                    return;
                }
            }
            Toast.makeText(this, "Call Permission Denied from Phone", 0).show();
        }
    }
}
