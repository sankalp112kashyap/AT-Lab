//package
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText emailfield;
    EditText mobilefield;
    EditText passwordfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailfield = (EditText) findViewById(R.id.email);
        mobilefield = (EditText) findViewById(R.id.mobile);
        passwordfield = (EditText) findViewById(R.id.password);

    }


    public void onSubmitButtonPressed(View view){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String email = emailfield.getText().toString();
        String mobile = mobilefield.getText().toString();
        String password = passwordfield.getText().toString();
        String mobilepattern =  "[0-9]{10}";

        if(email.isEmpty()){
            Toast.makeText(this, "Enter valid email id", Toast.LENGTH_SHORT).show();
        }
        else{
            if(email.trim().matches(email)){
                Toast.makeText(this , "Valid emailId", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();
            }
        }

        if(mobile.isEmpty()){
            Toast.makeText(this, "Enter valid mobile number", Toast.LENGTH_SHORT).show();
        }
        else{
            if(mobile.matches(mobilepattern)){
                Toast.makeText(this, "Valid phone number", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show();
            }
        }


    }
}


