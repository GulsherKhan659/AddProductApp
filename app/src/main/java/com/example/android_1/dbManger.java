package com.example.android_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbManger extends SQLiteOpenHelper {
    private  final String table_name ="Products";
    private  final String col_1  = "p_id";
    private  final String col_2  = "p_name";
    private  final String col_3  = "p_quantity";
    private  final String col_4  = "p_catogery";
    private  final String col_5  = "p_company";
    private  final String col_6  = "p_expiry";


    public dbManger(@Nullable Context context) {
        super(context, "Applicatio_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE "+table_name+"("+col_1+ "INTEGER PRIMARY KEY,"+col_2+"TEXT,"+col_3+"INTEGER,"+col_4+"TEXT,"+col_5+"TEXT,"+col_6+"TEXT);";
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // Method for Insert
    public void insertData(ProductBean product){
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
    public Cursor fetchData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor allUsers = db.query(table_name,null,null,null,null,null,null,null);
        return allUsers;
        }

}
