package com.example.android_1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class Show_Products extends AppCompatActivity {
    ListView my_ListView;
    dbManger dataBase = new dbManger(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__products);
        Cursor getDataCursor= dataBase.fetchData();
        my_ListView = findViewById(R.id.list_view);

        try {
            String[] from = {"p_id", "p_name", "p_quantity", "p_catogery", "p_company", "p_expiry"};
            int[] to = {R.id.viewp_id, R.id.viewp_name, R.id.viewp_quantity, R.id.viewp_catogery, R.id.viewp_company, R.id.viewp_expiry};

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.show_product_layout, getDataCursor, from, to, 1);
            my_ListView.setAdapter(adapter);
        }catch (Exception asd){
            System.out.println(getDataCursor);
            System.out.println(asd);

        }

    }
}