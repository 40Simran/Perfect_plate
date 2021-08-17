package com.example.perfect_plate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    DBHelper dbHelper;
    TextView name, mail, phone, coins;
    Button logOut;
    SharedPreference sharedPreference;
    Activity context=this;
    ImageView r1,r2,r3;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
         dbHelper = new DBHelper(this);

        name = findViewById(R.id.tv_name);
        mail = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        coins = findViewById(R.id.coins);
        r1=findViewById(R.id.sil);
        r2=findViewById(R.id.gol);
        r3=findViewById(R.id.pl);
        sharedPreference=new SharedPreference();

        logOut = findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreference.clearSharedPreference(context);
                Intent i= new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        showdata();
       bottomnav();
    }
    public void showdata()
    {
        Cursor result = dbHelper.getAll();
        while(result.moveToNext()){
            String n = result.getString(1);
            String m = result.getString(2);
            String p = result.getString(3);

            int s = result.getInt(5);
            if (s > 5){
                r1.setVisibility(View.VISIBLE);
            }else if (s > 20){
                r1.setVisibility(View.VISIBLE);
                r2.setVisibility(View.VISIBLE);

            }else if (s >50){
                r1.setVisibility(View.VISIBLE);
                r2.setVisibility(View.VISIBLE);
                r3.setVisibility(View.VISIBLE);

            }
            name.setText(n);
            mail.setText(m);
            phone.setText(p);
            coins.setText("$" +s);
             }

    }

    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mapsearch:
                        startActivity(new Intent(getApplicationContext(),SearchActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.restaurant:
                        startActivity(new Intent(getApplicationContext(),ResListActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.redeem:
                        startActivity(new Intent(getApplicationContext(),RedeemActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}