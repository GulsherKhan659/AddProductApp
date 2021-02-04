package com.example.android_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbManger extends SQLiteOpenHelper {
    private String table_name ="Products";
    private String col_1  = "p_id";
    private String col_2  = "p_name";
    private String col_3  = "p_quantity";
    private String col_4  = "p_catogery";
    private String col_5  = "p_company";
    private String col_6  = "p_expiry";


    public dbManger(@Nullable Context context) {
        super(context, "Application_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE "+table_name+"("+col_1+"INTEGER PRIMARY KEY ,"+col_2+"TEXT,"+col_3+"INTEGER,"+col_4+"TEXT,"+col_5+"TEXT,"+col_6+"TEXT);";
        db.execSQL(query);
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // Method for Insert
    void insertData(ProductBean product){
       SQLiteDatabase db = getWritableDatabase();
       ContentValues values = new ContentValues();

       values.put(col_2,product.getName());
       values.put(col_3,product.getQuantity());
       values.put(col_4,product.getCatogery());
       values.put(col_5,product.getCompany());
       values.put(col_6,product.getExpiry());

       db.insert(table_name,null,values);
    }

    //Method for Fetch
    Cursor fetchData(){
        SQLiteDatabase db = getWritableDatabase();
        return db.query(table_name,null,null,null,null,null,null,null);
    }

}
