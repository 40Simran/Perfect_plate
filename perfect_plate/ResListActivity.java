package com.example.perfect_plate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ResListActivity extends AppCompatActivity {

    ListView listView;
    String[] restaurants = {"Mum's Kitchen", "Urban Cafe", "Tikki shack", "Prism"};
    String[] address = {"Hyderabad", "Goa", "Nagpur", "Pune"};
    Integer[] image = {R.drawable.res1, R.drawable.res2, R.drawable.res3, R.drawable.res4};
    Integer[] rating = {3, 2, 4, 5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_list);
        bottomnav();
        listView=findViewById(R.id.listView);
        CustomListView customListView=new CustomListView(this, restaurants,address,image,rating);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ResListActivity.this,ResDetailsActivity.class);
                intent.putExtra("res_name", restaurants[position]);
                intent.putExtra("add",address[position]);
                intent.putExtra("rating",rating[position]);
                startActivity(intent);
            }
        });

    }

    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.restaurant);

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
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.redeem:
                        startActivity(new Intent(getApplicationContext(),RedeemActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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

    @Override
    public void onBackPressed() {
    }
}