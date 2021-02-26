/**
 * MainActivity.java
 * StudiRep
 * 19024625
 * 19129576
 */

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
 * MainActivity which points to main
 *
 */
public class MainActivity extends AppCompatActivity {


    //Define variables which will be used to login.
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    boolean isValid = false;

    //String data which will be compared to user input to allow successful login to main app.
    String adminUsername = "Admin";
    String adminPassword = "12345";

    //Initialising calendar object.
    Calendar thisCalendar = new Calendar();


    /**
     * onCreate function for main.
     *
     * @param savedInstanceState    State which the program is currently running in.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Required android initialisation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Referencing xml elements
        eName = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin =  findViewById(R.id.bLogin);

        //Function to display calendar text
        thisCalendar.displayCalendarText();

        /**
         *Function to compare user input with login data, and to prove authenticity.
         *
         */
        eLogin.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {


                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                //Checks if user input is empty
                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter details correctly.", Toast.LENGTH_SHORT).show();
                }

                //
                else{

                    //Function to return a boolean variable to compare to.
                    isValid = validate(inputName, inputPassword);

                    //If user input is false.
                    if (!isValid) {
                        Toast.makeText(MainActivity.this, "Incorrect details entered.", Toast.LENGTH_SHORT).show();
                    }

                    //If user input is true, sends state to HomePageActivity.
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

    /**
     * Function to validate user input and return a boolean value.
     * @param name      Variable for username
     * @param password  Variable for password
     * @return          Returns boolean value
     */
    private boolean validate(String name, String password){
        if(name.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        }
        else {
            return false;
        }


    }
}


