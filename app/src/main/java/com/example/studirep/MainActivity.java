package com.example.studirep;

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
import android.widget.Toast;

/**
 *
 *     =======BACKLOG=======
 *     =====================
 *
 *
 *
 *
 * ---------------------------------
 *
 * Documentation
 *
 * 3 buttons for activity_food
 *     Home
 *     Hamza
 *     Nicola
 * Clean up code
 *
 *          Remove set content view
 *
 * Understand what DatabaseHelper does
 *
 * Images / front-end
 *
 *
 * ----------------------------------------
 *
 *
 X Calendar layout (remove constraint)
 *   Work on later
 *
 X See date and time when inputting event
 *
 * Ensure that all content views move between each other
 * (Between the other group)
 *
 *  ----------------------------------------
 *
 X Fix and ensure homepage activity goes to account page activity, and vice versa
 *
 *
 * Read and write account username and password to and from file
 *
 * Home page display real calendar
 *
 * Calendar, add misc. event
 * (add it programmatically)
 *
 X Calendar, view calendar activity
 *
 * Revise and rework code (remove login and content main xml)
 *
 X Combine code with others
 *
 *
 *
 *
 *
 */

    
public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    boolean isValid = false;

    String adminUsername = "Admin";
    String adminPassword = "12345";

    Calendar thisCalendar = new Calendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        eName = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin =  findViewById(R.id.bLogin);
        thisCalendar.displayCalendarText();
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();
                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter details correctly.", Toast.LENGTH_SHORT).show();
                }

                else{
                    isValid = validate(inputName, inputPassword);

                    if (!isValid) {
                        Toast.makeText(MainActivity.this, "Incorrect details entered.", Toast.LENGTH_SHORT).show();


                    }
                    else {
                        Toast.makeText(MainActivity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                        // setContentView(R.layout.homepage_main);
                        // startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                        Intent i = new Intent(MainActivity.this, HomePageActivity.class);
                        MainActivity.this.startActivity(i);
                    }

                }
            }
        });

    }
    private boolean validate(String name, String password){
        if(name.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        }
        else {
            return false;
        }


    }
}


