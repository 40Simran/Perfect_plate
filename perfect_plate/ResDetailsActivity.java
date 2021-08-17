package com.example.perfect_plate;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResDetailsActivity extends AppCompatActivity {

    ImageView imageView,star1,star2,star3,star4,star5;
    String address;
    int rating;
    TextView addresss;
    Button book;
    String res_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_details);
        addresss=findViewById(R.id.addresss);
        star1=findViewById(R.id.star1);
        star2=findViewById(R.id.star2);
        star3=findViewById(R.id.star3);
        star4=findViewById(R.id.star4);
        star5=findViewById(R.id.star5);
        book=findViewById(R.id.bookatable);
        Bundle bundle=getIntent().getExtras();
        res_name=bundle.getString("res_name");
        address=bundle.getString("add");
        rating=bundle.getInt("rating");
        addresss.setText(address);
        if (rating==1){
            star1.setVisibility(View.VISIBLE);
        } else if (rating==2){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
        }
        else if (rating==3){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);

        }else if (rating==4){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);
            star4.setVisibility(View.VISIBLE);

        }else if (rating==5){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);
            star4.setVisibility(View.VISIBLE);
            star5.setVisibility(View.VISIBLE);

        }
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResDetailsActivity.this,TableDetailsActivity.class);
                intent.putExtra("res_name",res_name);
                startActivity(intent);
            }
        });
    }
}