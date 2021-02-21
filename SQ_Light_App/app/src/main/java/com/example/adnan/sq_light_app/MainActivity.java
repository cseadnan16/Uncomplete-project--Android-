package com.example.adnan.sq_light_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText, ageEditText, genderEditText;
    Button addButton, showAllDataButton;
    MyDatabaseDEmo myDatabaseDEmo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseDEmo = new MyDatabaseDEmo(this);
        SQLiteDatabase sqLiteDatabase =  myDatabaseDEmo.getWritableDatabase();

        nameEditText = (EditText) findViewById(R.id.nameEditTextID);
        ageEditText = (EditText) findViewById(R.id.ageEditTextID);
        genderEditText = (EditText) findViewById(R.id.genderEditTextID);
        addButton = (Button) findViewById(R.id.addButtonID);
        showAllDataButton = (Button) findViewById(R.id.showAllDataButtonID);

        addButton.setOnClickListener(this);
        showAllDataButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();

        if (v.getId() == R.id.addButtonID){
            long rowID = myDatabaseDEmo.insertData(name, age, gender);
            if (rowID == -1){
                Toast.makeText(getApplicationContext(),"Unsuccessfull",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(),"Row "+rowID+ " is successfully inserted",Toast.LENGTH_LONG).show();
            }
        }

       if (v.getId() == R.id.showAllDataButtonID){
           Cursor cursor = myDatabaseDEmo.displayAllData();
           if (cursor.getCount()==0){
               // thre is no data, we will display message
               showData("Error", "No Data Found");
               return;
           }
           StringBuffer stringBuffer = new StringBuffer();
           while (cursor.moveToNext()){
               stringBuffer.append("ID : "+cursor.getString(0)+"\n");
               stringBuffer.append("Name : "+cursor.getString(1)+"\n");
               stringBuffer.append("Age : "+cursor.getString(2)+"\n");
               stringBuffer.append("Gender : "+cursor.getString(3)+"\n\n\n");
           }
           showData("Result Set", stringBuffer.toString());
       }
    }
    public void showData(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setTitle(message);
        builder.setCancelable(true);
        builder.show();
    }
}
