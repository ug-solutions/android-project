package com.example.android.myapplication;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, email,DOB;
    Button register, cancel;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        DOB = findViewById(R.id.DOB);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);
        databaseHelper = new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();
                String DOBValue = DOB.getText().toString();

                if(usernameValue.length() > 1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("username",usernameValue);
                    contentValues.put("password",passwordValue);
                    contentValues.put("email",emailValue);
                    contentValues.put("DOB",DOBValue);

                    databaseHelper.insertUser(contentValues);
                    Toast.makeText(RegisterActivity.this,"User Registered",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(RegisterActivity.this,"Enter the Values",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
