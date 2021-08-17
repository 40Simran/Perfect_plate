package com.example.perfect_plate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIMEOUT = 2000;
    SharedPreference sharedPreference;
    Activity context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        sharedPreference=new SharedPreference();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPreference.getValue(context) != null){
                    Intent i= new Intent(SplashActivity.this,SearchActivity.class);
                    startActivity(i);
                }
                else if (ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    Intent i= new Intent(SplashActivity.this, LoginActivity.class);

                    startActivity(i);
                    finish();

                }else {
                    ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

                    if (ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        Intent i= new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(i);

                    }
                }

            }
        },SPLASH_TIMEOUT);
    }
}