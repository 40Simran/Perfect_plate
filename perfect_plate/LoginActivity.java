package com.example.perfect_plate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button login,signup;
    TextView register,loginStatus;
    EditText nameph,pass;
    DBHelper dbHelper;
    String name,passwordStr;
    private SharedPreference sharedPreference;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signUp);
        register=findViewById(R.id.register);
        nameph=findViewById(R.id.phoneRname);
        pass=findViewById(R.id.passwordd);
        loginStatus=findViewById(R.id.loginStatus);
        dbHelper = new DBHelper(this);
        sharedPreference = new SharedPreference();
        sharedPreference.clearSharedPreference(context);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = dbHelper.getAll();
                String record ="";

                if (!pass.getText().toString().equals("") || !nameph.getText().toString().equals("")) {
                    while (result.moveToNext()) {
                        name = result.getString(1);
                        passwordStr = result.getString(4);
                        record += "NAME: " + name + ", PASSWORD: " + pass + "\n";

                        if (pass.getText().toString().equals(passwordStr) && nameph.getText().toString().equals(name)) {
                            loginStatus.setText("");
                            sharedPreference.save(context, nameph.getText().toString());
                            Intent i= new Intent(LoginActivity.this,SearchActivity.class);
                            startActivity(i);
                        }

                        else if (!pass.getText().toString().equals(passwordStr) && !nameph.getText().toString().equals(name)){
                            loginStatus.setText("Invalid credentials");
                            loginStatus.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    loginStatus.setText("");
                                }
                            }, 2000);
                        }
                    }
                }
                else {
                    loginStatus.setText("Enter a valid Name/Password");
                    loginStatus.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loginStatus.setText("");
                        }
                    }, 2000);
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this,ContactViewActivity.class);
                startActivity(i);
            }
        });
    }
}