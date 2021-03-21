/**
 * AccountPageActivity.java
 * StudiRep
 * 19024625
 * 19129576
 */
package com.example.studirep;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.widget.ImageView;


/**
 * AccountPageActivity is the state where user can see and edit account details.
 */
public class AccountPageActivity extends AppCompatActivity {

    // Private button created in order to go back to the home page activity
    private ImageView HomePageButton;
    private ImageView CalendarButton;
    private ImageView AccountButton;
    private ImageView FoodButton;
    private ImageView WorkoutButton;
    private ImageView CommunityButton;

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

        AccountButton = (ImageView) findViewById(R.id.bAccountButton);
        AccountButton.setImageResource(R.drawable.account);

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



        FoodButton = (ImageView) findViewById(R.id.bFood);
        FoodButton.setImageResource(R.drawable.food);

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

        WorkoutButton = (ImageView) findViewById(R.id.bWorkout);
        WorkoutButton.setImageResource(R.drawable.workout);

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


