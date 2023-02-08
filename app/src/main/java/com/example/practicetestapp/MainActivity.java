package com.example.practicetestapp;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        to change the support actionbar color
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));


        EditText edtHeight, edtIn, edtWeight;
        TextView txtResult;
        Button btnBmi, btnReset;
        LinearLayout llResult;


        edtHeight = findViewById(R.id.edtHeight);
        edtIn = findViewById(R.id.edtIn);
        edtWeight = findViewById(R.id.edtWeight);
        txtResult = findViewById(R.id.txtResult);
        btnBmi = findViewById(R.id.btnBmi);
        llResult = findViewById(R.id.llResult);
        btnReset = findViewById(R.id.btnReset);


        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int ft = Integer.parseInt(edtHeight.getText().toString());
             int in =Integer.parseInt(edtIn.getText().toString());
             int wt = Integer.parseInt(edtWeight.getText().toString());


             int totalIn = ft* 12 + in; //convert to inch
             double totalCm = totalIn * 2.53;//convert in to centimeter
             double totalM= totalCm/100; // convert in to meter

             double bmi = wt/Math.pow(totalM,2);

             if(bmi>25)
             {
                 txtResult.setText("You are Overweight");
                 llResult.setBackgroundColor(getResources().getColor(R.color.colorOw));// set runtime background color first get resource
             } else if(bmi< 18)
             {
                 txtResult.setText("You are Underweight");
                 llResult.setBackgroundColor(getResources().getColor(R.color.colorUw));

             } else
             {
                 txtResult.setText("You are Healthy");
                 llResult.setBackgroundColor(getResources().getColor(R.color.colorH));
             }
            }
        });



        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHeight.setText("");
                edtIn.setText("");
                edtWeight.setText("");
                txtResult.setText("");
                llResult.setBackgroundColor(getResources().getColor(R.color.background));

            }
        });




    }
}