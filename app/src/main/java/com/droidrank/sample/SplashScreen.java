package com.droidrank.sample;

import android.annotation.TargetApi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        new Handler().postDelayed(new Runnable() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {


                    Intent Homeintent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(Homeintent);
                    finish();
                }

        }, SPLASH_TIME_OUT);
    }
}
