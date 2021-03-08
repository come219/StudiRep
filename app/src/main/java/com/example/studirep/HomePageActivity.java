/**
 * HomePageActivity.java
 * StudiRep
 * 19024625
 * 19129576
 */


package com.example.studirep;

import android.content.Intent;
import android.media.Image;
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
 * Landing page for the app, where you can go between all the different activities.
 */
public class HomePageActivity extends AppCompatActivity {

    // Variables for creating buttons to switch to between views.



    private Button CalendarButton;
    private Button FoodButton;
    private Button WorkoutButton;


    //Placeholder image to show where calendar will be on the screen.
    private ImageView CalendarImage;
    private ImageView HomeButton;
    private ImageView AccountButton;


    /**
     * onCreate function for home page
     *
     * @param savedInstanceState    State which the program is currently running in.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Required android initialisation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Referencing xml elements
        CalendarImage = (ImageView) findViewById(R.id.CalendarView);
        CalendarImage.setImageResource(R.drawable.basic_calendar);

        AccountButton = (ImageView) findViewById(R.id.bAccountButton);
        AccountButton.setImageResource(R.drawable.account);

        HomeButton = (ImageView) findViewById(R.id.bHomePageButton);
        HomeButton.setImageResource(R.drawable.studirep_logo);

        CalendarButton = findViewById(R.id.bCalendar);

        FoodButton = findViewById(R.id.bFood);

        WorkoutButton = findViewById(R.id.bWorkout);


        //Debug test in order to know what activity we are on.
        System.out.println("This is home page activity.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");



        AccountButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to account page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                // setContentView(R.layout.accountpage_main);
                System.out.println("This button has been clicked.!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                Intent i = new Intent(HomePageActivity.this, AccountPageActivity.class);
                HomePageActivity.this.startActivity(i);
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
            }
        });



        CalendarButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to calendar page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePageActivity.this, CalendarActivity.class);
                HomePageActivity.this.startActivity(i);
            }
        });



        FoodButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to food page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePageActivity.this, FoodActivity.class);
                HomePageActivity.this.startActivity(i);

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
                Intent i = new Intent(HomePageActivity.this, WorkoutActivity.class);
                HomePageActivity.this.startActivity(i);
                //setContentView(R.layout.activity_workout_main);
            }
        });

    }};
