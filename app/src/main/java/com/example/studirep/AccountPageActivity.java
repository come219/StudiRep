/**
 * AccountPageActivity.java
 * StudiRep
 * 19024625
 * 19129576
 */
package com.example.studirep;

import android.accounts.Account;
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
import android.widget.ImageView;
import android.widget.Toast;


/**
 * AccountPageActivity is the state where user can see and edit account details.
 */
public class AccountPageActivity extends AppCompatActivity {

    // Private button created in order to go back to the home page activity
    private ImageView HomePageButton;


    /**
     * onCreate function for account page
     *
     * @param savedInstanceState    State which the program is currently running in.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Required android initialisation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountpage_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Referencing xml elements
        HomePageButton = (ImageView) findViewById(R.id.bHomePageButton);
        HomePageButton.setImageResource(R.drawable.studirep_logo);


        System.out.println("This is account page activity.");

        // Following code will run if the home button is clicked
        HomePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountPageActivity.this, HomePageActivity.class);
                AccountPageActivity.this.startActivity(i);
            }
        });
    }
}


