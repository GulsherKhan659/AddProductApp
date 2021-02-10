package com.example.android_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
   // Button btn_add,btn_show;
   Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Btn_Click(View v){
             switch (v.getId()){
              case R.id.Add_btn:
                  intent =new Intent(this,Add_Products.class);
                  startActivity(intent);
                  break;
              case R.id.ssp:

                  intent =new Intent(this,Show_Products.class);
                  TextView search=findViewById(R.id.show_text);
                     if(!search.getText().toString().isEmpty()){
                  intent.putExtra("cat",search.getText().toString());
                  startActivity(intent);
                     }else{
                         search.setHint("Please Enter Data First");
                     }

                  break;
              case R.id.Show_btn:
                  intent =new Intent(this,Show_Products.class);
                  intent.putExtra("cat","");
                  startActivity(intent);
                 break;
                        }
    }
}
