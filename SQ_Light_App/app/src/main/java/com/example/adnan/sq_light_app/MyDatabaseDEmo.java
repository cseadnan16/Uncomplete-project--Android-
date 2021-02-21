package com.example.adnan.sq_light_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseDEmo extends SQLiteOpenHelper {

    private static final int VERSION_NUMBER = 6;
    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "Student_info";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String GENDER = "gender";
    private  static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String CREATE_TABLE = "CREATE TABLE Student_info(id integer primary key autoincrement, name varchar(255), age INTEGER, gender VARCHAR(255));";

    private Context context;
    public MyDatabaseDEmo(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Toast.makeText(context, "On Create is Called", Toast.LENGTH_LONG).show();
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context, "Exception test: "+e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context, "On upgrade is Called", Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "Exception test: "+e, Toast.LENGTH_LONG).show();
        }

    }

    public long insertData (String name, String age, String gende){
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gende);

        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return rowId;
    }

    public Cursor displayAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL, null);
        return cursor;
    }
}
