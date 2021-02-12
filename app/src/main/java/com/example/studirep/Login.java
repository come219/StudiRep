package com.example.studirep;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    boolean isValid = false;

    String adminUsername = "Admin";
    String adminPassword = "12345";




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eName = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin =  findViewById(R.id.bLogin);
        System.out.println("boo11111");
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();
                System.out.println("boo22222");
                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter details correctly.", Toast.LENGTH_SHORT).show();
                }

                else{
                        isValid = validate(inputName, inputPassword);

                        if (!isValid) {
                            Toast.makeText(Login.this, "Incorrect details entered.", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(Login.this, "Login successful.", Toast.LENGTH_SHORT).show();

                            //Intent intent = new Intent(Login.this,SecondFragment.class);
                            //Login.this.startActivity(intent);

                        }

                    }
                }
            });

    }
    private boolean validate(String name, String password){
        if(name.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        }

        return false;

    }

}
