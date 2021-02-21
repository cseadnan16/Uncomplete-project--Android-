package com.example.adnan.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText1, editText2;
    private Button addButton, subButton;
    private TextView resulttextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.edittext1ID);
        editText2 = (EditText) findViewById(R.id.edittext2ID);

        addButton = (Button) findViewById(R.id.add_buttonID);
        subButton = (Button) findViewById(R.id.sub_buttonID);

        resulttextView = (TextView) findViewById(R.id.textViewID);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        try{
            String number1 = editText1.getText().toString();
            String number2 = editText2.getText().toString();

            //converting double
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            if(v.getId()==R.id.add_buttonID)
            {
                double sum = num1+num2;
                resulttextView.setText("Result = "+sum);
            }
            else
            {
                double sub = num1-num2;
                resulttextView.setText("Result = "+sub);
            }

        }catch (Exception e){
            Toast.makeText(MainActivity.this,"Please enter the number",Toast.LENGTH_SHORT).show();
        }

    }
}