package com.example.perfect_plate;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class BookingDetails extends AppCompatActivity {
    TextView a_display,f_display,s_display,t_display,ress_name;
    String res_nam,at,st,ft,tn;
    private static int TIMEOUT = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        a_display=(TextView)findViewById(R.id.arrangementID);
        f_display=(TextView)findViewById(R.id.foodsTypeID);
        s_display=(TextView)findViewById(R.id.seatsID);
        t_display=(TextView)findViewById(R.id.tableNumberID);
        ress_name=findViewById(R.id.ress_name);
        Bundle bundle=getIntent().getExtras();
        res_nam=bundle.getString("res_nam");
        at=bundle.getString("at");
        ft=bundle.getString("ft");
        st=bundle.getString("st");
        tn=bundle.getString("tn");

        a_display.setText("Arrangement Type: "+at);
        f_display.setText("Food Type: " +ft);
        s_display.setText("Seats: " + st);
        t_display.setText("Table Number: " +tn);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(BookingDetails.this, succesfullActivity.class);
                startActivity(intent);

            }
        },TIMEOUT);

    }
}