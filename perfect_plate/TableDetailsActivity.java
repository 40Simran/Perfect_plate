package com.example.perfect_plate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class TableDetailsActivity extends AppCompatActivity{
    DBHelper dbHelper;
    private Spinner spinner1, spinner2,spinner3,spinner4;
    Button book;
    TextView res_name;
    TextView a_display,f_display,s_display,t_display;
    Button cofirmButton;
    String res_nam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_details);
        addArrgement();
        addSeats();
        addFood();
        addTable();
      //  bottomnav();

        Bundle bundle=getIntent().getExtras();
        res_nam=bundle.getString("res_name");
        res_name=findViewById(R.id.ress_name);
        res_name.setText(res_nam);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);

        book=findViewById(R.id.btnSubmit);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*setContentView(R.layout.activity_booking_details);
                a_display=(TextView)findViewById(R.id.arrangementID);
                f_display=(TextView)findViewById(R.id.foodsTypeID);
                s_display=(TextView)findViewById(R.id.seatsID);
                t_display=(TextView)findViewById(R.id.tableNumberID);


                a_display.setText("Arrangement Type: "+String.valueOf(spinner1.getSelectedItem()));
                f_display.setText("Food Type: " +String.valueOf(spinner2.getSelectedItem()));
                s_display.setText("Seats: " +String.valueOf(spinner3.getSelectedItem()));
                t_display.setText("Table Number: " +String.valueOf(spinner4.getSelectedItem()));*/

                Intent intent=new Intent(TableDetailsActivity.this, BookingDetails.class);
                intent.putExtra("res_name",res_nam);
                intent.putExtra("at",String.valueOf(spinner1.getSelectedItem()));
                intent.putExtra("st",String.valueOf(spinner2.getSelectedItem()));
                intent.putExtra("ft",String.valueOf(spinner3.getSelectedItem()));
                intent.putExtra("tn",String.valueOf(spinner4.getSelectedItem()));
                startActivity(intent);

                }
        });

    }
    public void addArrgement()
    {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Birthday Party");
        list.add("Family");
        list.add("Couple date");
        list.add("Normal");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }
    public void addSeats()
    {
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("single");
        list.add("Double");
        list.add("Thiple");
        list.add("More than four");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
    public void addFood()
    {
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        List<String> list = new ArrayList<String>();
        list.add("Vegetarian");
        list.add("Non-vegetarian");
        list.add("Chinese");
        list.add("Italian");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter);
    }
    public void addTable()
    {
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}