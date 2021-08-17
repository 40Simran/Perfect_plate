package com.example.perfect_plate;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText name,email,phone,password,conpassword;
    TextView signupstatus;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        conpassword = findViewById(R.id.confirm_password);
        signUp = findViewById(R.id.createAcc);
        signupstatus = findViewById(R.id.signupstatus);

        dbHelper = new DBHelper(this);

        insertdata();
    }
        public void insertdata (){
            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pass = password.getText().toString();
                    if (name.getText().toString().equals("") || email.getText().toString().equals("") || phone.getText().toString().equals("") ||
                            password.getText().toString().equals("") || conpassword.getText().toString().equals("")) {
                        signupstatus.setText("All fields are mandatory.");
                        signupstatus.setTextColor(Color.parseColor("#ff0000"));
                    } else {
                        boolean res = dbHelper.insert(name.getText().toString(), email.getText().toString(), phone.getText().toString(), password.getText().toString());
                        if (res) {
                            signupstatus.setTextColor(Color.parseColor("#00ff00"));
                            signupstatus.setText("Account created successfully");
                            name.setText("");
                            email.setText("");
                            phone.setText("");
                            password.setText("");
                            conpassword.setText("");
                            try {
                                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                            } catch (Exception e) {
                                System.out.println("Task failed");
                            }
                        }

                    }
                }
            });

        }
    }
