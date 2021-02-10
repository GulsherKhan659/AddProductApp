package com.example.android_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbManger extends SQLiteOpenHelper {
    public static  final String table_name ="Products";
    public static  final String col_1  = "_id";
    public static  final String col_2  = "p_name";
    public static  final String col_3  = "p_quantity";
    public static  final String col_4  = "p_catogery";
    public static  final String col_5  = "p_company";
    public static  final String col_6  = "p_expiry";
    private
    Context gcontext;





    public dbManger(@Nullable Context context) {
        super(context, "Applicatio_DB", null, 1);
        this.gcontext = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE "+table_name+"("+col_1+ " INTEGER PRIMARY KEY,"+col_2+" TEXT,"+col_3+" INTEGER,"+col_4+" TEXT,"+col_5+" TEXT,"+col_6+" TEXT);";
         db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // Method for Insert
    public long  insertData(ProductBean product){
       SQLiteDatabase db = getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(col_2,product.getName());
       values.put(col_3,product.getQuantity());
       values.put(col_4,product.getCatogery());
       values.put(col_5,product.getCompany());
       values.put(col_6,product.getExpiry());
     return  db.insert(table_name,null,values);
    }

    //Method for Fetch
    public Cursor fetchData(String catogery){
        SQLiteDatabase db = getWritableDatabase();

        if(catogery.isEmpty()){
            Toast.makeText(gcontext,"Empty Rec",Toast.LENGTH_LONG).show();

            return db.query(table_name,null,null,null,null,null,null,null);

        }else {
            String [] cat = {catogery};
            Toast.makeText(gcontext,catogery,Toast.LENGTH_LONG).show();

            return db.query(table_name,null,col_4+"=?",cat,null,null,null,null);

        }
        }

}
