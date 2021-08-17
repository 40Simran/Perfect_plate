package com.example.perfect_plate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RedeemActivity extends AppCompatActivity {

    View redeem1,redeem2,redeem3;
    TextView platinum, gold, silver;
    DBHelper dbHelper;
    int s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);

        redeem1 = findViewById(R.id.redeem1);
        redeem2 = findViewById(R.id.redeem2);
        redeem3 = findViewById(R.id.redeem3);
        platinum = findViewById(R.id.platinum);
        gold = findViewById(R.id.gold);
        silver = findViewById(R.id.silver);
        dbHelper = new DBHelper(this);
        redeem1.setEnabled(false);
        redeem2.setEnabled(false);
        redeem3.setEnabled(false);
        showdata();
        if (s > 5){
            redeem1.setEnabled(true);
            redeem1.setBackgroundResource(R.drawable.editext_border);
        }else if (s > 20){
            redeem2.setEnabled(true);
            redeem2.setBackgroundResource(R.drawable.editext_border);
        }else if (s >50){
            redeem3.setEnabled(true);
            redeem3.setBackgroundResource(R.drawable.editext_border);
        }
        redeem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(RedeemActivity.this,ReedemSuccessActivity.class);
            startActivity(i);
            }
        });
        redeem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RedeemActivity.this,ReedemSuccessActivity.class);
                startActivity(i);
            }
        });
        redeem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RedeemActivity.this,ReedemSuccessActivity.class);
                startActivity(i);
            }
        });

        bottomnav();
    }
    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.redeem);

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
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                }
                return false;
            }
        });
    }
    public void showdata()
    {
        Cursor result = dbHelper.getAll();
        while(result.moveToNext()){
            String n = result.getString(1);
            String m = result.getString(2);
            String p = result.getString(3);
             s = result.getInt(5);

        }

    }
    @Override
    public void onBackPressed() {
    }
}