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
import android.widget.TextView;
import android.widget.Toast;


/**
 * AccountPageActivity is the state where user can see and edit account details.
 */
public class AccountPageActivity extends AppCompatActivity {

    // Private button created in order to go back to the home page activity
    private ImageView HomePageButton;
    private ImageView ProfilePhoto;

    //Image views which will be used as buttons to switch between all the different activities.
    private ImageView CalendarImage;
    private ImageView HomeButton;
    private ImageView AccountButton;
    private ImageView CalendarButton;
    private ImageView FoodButton;
    private ImageView CommunityButton;
    private ImageView WorkoutButton;
    private ImageView SettingsButton;

    private TextView name;
    private TextView dob;
    private TextView desc;

    private String s_name = "Karen Karen";
    private String s_dob = "01/01/01";
    private String s_desc = "Likes to go on long walks by the beach.\n Live, life, love";





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

        name = (TextView) findViewById(R.id.AccountText);
        name.setText(s_name);

        dob = (TextView) findViewById(R.id.AccountText2);
        dob.setText(s_dob );

        desc = (TextView) findViewById(R.id.AccountText3);
        desc.setText(s_desc);

        ProfilePhoto = (ImageView) findViewById(R.id.ProfilePhoto);
        ProfilePhoto.setImageResource(R.drawable.dp);


        System.out.println("This is account page activity.");

        // Following code will run if the home button is clicked
        HomePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountPageActivity.this, HomePageActivity.class);
                AccountPageActivity.this.startActivity(i);
            }
        });

        //Referencing xml elements
        CalendarImage = (ImageView) findViewById(R.id.bCalendar);
        CalendarImage.setImageResource(R.drawable.basic_calendar);

        AccountButton = (ImageView) findViewById(R.id.bAccountButton);
        AccountButton.setImageResource(R.drawable.account);

        HomeButton = (ImageView) findViewById(R.id.bHomePageButton);
        HomeButton.setImageResource(R.drawable.studirep_logo);

        CalendarButton = (ImageView) findViewById(R.id.bCalendar);
        CalendarButton.setImageResource(R.drawable.basic_calendar);

        FoodButton = (ImageView) findViewById(R.id.bFood);
        FoodButton.setImageResource(R.drawable.food);

        WorkoutButton = (ImageView) findViewById(R.id.bWorkout);
        WorkoutButton.setImageResource(R.drawable.workout);

        CommunityButton = (ImageView) findViewById(R.id.bCommunity);
        CommunityButton.setImageResource(R.drawable.community);

        SettingsButton = (ImageView) findViewById(R.id.bSettings);
        SettingsButton.setImageResource(R.drawable.settings);

        AccountButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to account page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                // setContentView(R.layout.accountpage_main);
                System.out.println("This button has been clicked.!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                Intent i = new Intent(AccountPageActivity.this, AccountPageActivity.class);
                AccountPageActivity.this.startActivity(i);
            }
        });



        HomeButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to home page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.homepage_main);
                System.out.println("You are going back to home page!!!!!!!!!!!!!!!");
                Intent i = new Intent(AccountPageActivity.this, HomePageActivity.class);
                AccountPageActivity.this.startActivity(i);
            }
        });



        CalendarButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to calendar page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountPageActivity.this, CalendarActivity.class);
                AccountPageActivity.this.startActivity(i);
            }
        });



        FoodButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to food page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountPageActivity.this, FoodActivity.class);
                AccountPageActivity.this.startActivity(i);

                System.out.println("You are trying to go to the Food page############################");


            }
        });



        WorkoutButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to workout page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountPageActivity.this, WorkoutActivity.class);
                AccountPageActivity.this.startActivity(i);
                //setContentView(R.layout.activity_workout_main);
            }
        });


    }
}