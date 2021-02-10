package com.example.android_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Add_Products extends AppCompatActivity {
    TextView expiry_Date;
    Button add_btn;
    EditText name;
    Spinner quantity,company,catogery;
    Context context =this;
    String product_company,product_catogery,product_name;
    int product_quantity;
    String product_expiry ="";
    dbManger dataBase = new dbManger(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__products);
        name = findViewById(R.id.p_name);
        company = findViewById(R.id.p_company);
        quantity = findViewById(R.id.p_quantity);
        catogery = findViewById(R.id.p_catogery);
        add_btn = findViewById(R.id.p_btn);
        expiry_Date = findViewById(R.id.p_expiry);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                product_name = name.getText().toString();
                product_quantity = Integer.parseInt(quantity.getSelectedItem().toString());
                product_catogery = catogery.getSelectedItem().toString();
                product_company  = company.getSelectedItem().toString();
                if(product_name.isEmpty() || product_quantity < 1 || product_catogery.isEmpty() || product_company.isEmpty() || product_expiry.isEmpty()){
                    //conditions to avoid null or empty values
                     System.out.println("EmptyField");

                }else{

                   //dataBase is object of dbManger class & insertData is method of this class
                  ProductBean product =new ProductBean();
                  product.setName(product_name);
                  product.setQuantity(product_quantity);
                  product.setCatogery(product_catogery);
                  product.setCompany(product_company);
                  product.setExpiry(product_expiry);
                    if(dataBase.insertData(product)>0){
                        System.out.println("Insert Successfull");
                    }
                }




            }
        });



        expiry_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });

    }

    // Add Products Method Starts

    // Add Products Method End

    //Date Picker Method Starts
    public void datePicker() {
        //For Get Current Date
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month =calendar.get(Calendar.MONTH);
        int year =calendar.get(Calendar.YEAR);
        // Date Picker Dialog
        DatePickerDialog date_picker = new DatePickerDialog(context,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                product_expiry = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                expiry_Date.setText(product_expiry);
            }
        }, year, month, day);
        date_picker.show();
                  }
    //Date Picker Method End


                 }