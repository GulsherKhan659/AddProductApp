package com.example.android_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Show_Products extends AppCompatActivity {
    ListView my_ListView;
    Cursor getDataCursor;
    dbManger dataBase = new dbManger(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__products);
        Intent intent = getIntent();
        //////////////////////////////////////////

        String catogery = intent.getStringExtra("cat").toString();

        Toast.makeText(this,catogery,Toast.LENGTH_LONG).show();
        getDataCursor= dataBase.fetchData(catogery);
        my_ListView = findViewById(R.id.list_view);

        ///////////////////////////////////////////////////
            String[] from = {dbManger.col_1, dbManger.col_2,dbManger.col_3,dbManger.col_4,dbManger.col_5,dbManger.col_6};
            int[] to = {R.id.viewp_id, R.id.viewp_name, R.id.viewp_quantity, R.id.viewp_catogery, R.id.viewp_company, R.id.viewp_expiry};

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.show_product_layout, getDataCursor, from, to, 1);
            my_ListView.setAdapter(adapter);


    }
}