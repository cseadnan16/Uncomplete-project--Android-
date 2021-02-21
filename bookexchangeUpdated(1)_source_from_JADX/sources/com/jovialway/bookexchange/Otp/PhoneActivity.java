package com.jovialway.bookexchange.Otp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.CountryData;

public class PhoneActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public EditText editText;
    /* access modifiers changed from: private */
    public Spinner spinner;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1214R.layout.activity_phone);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon((int) C1214R.mipmap.ic_launcher_round);
        actionBar.setTitle((CharSequence) "Mobile Number Verify");
        getWindow().getDecorView().setSystemUiVisibility(8192);
        getWindow().setStatusBarColor(-1);
        Spinner spinner2 = (Spinner) findViewById(C1214R.C1217id.spinnerCountries);
        this.spinner = spinner2;
        spinner2.setAdapter(new ArrayAdapter(this, 17367049, CountryData.countryNames));
        this.editText = (EditText) findViewById(C1214R.C1217id.editTextPhone);
        findViewById(C1214R.C1217id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[PhoneActivity.this.spinner.getSelectedItemPosition()];
                String number = PhoneActivity.this.editText.getText().toString().trim();
                if (number.isEmpty() || number.length() < 10) {
                    PhoneActivity.this.editText.setError("Valid number is required");
                    PhoneActivity.this.editText.requestFocus();
                    return;
                }
                Intent intent = new Intent(PhoneActivity.this, OtpActivity.class);
                intent.putExtra("phonenumber", "+" + code + number);
                PhoneActivity.this.startActivity(intent);
            }
        });
    }
}
