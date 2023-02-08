package com.example.practicetestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        to hide action bar
        getSupportActionBar().hide();
//        go to next activity  to splash Screen
        final Intent i= new Intent(SplashActivity.this,MainActivity.class);

//        to throw a handler to show this activity for limited time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(i);
                finish();
            }
        },2000);



    }
}