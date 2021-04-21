package com.example.studirep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodActivity extends AppCompatActivity {

    private Button FridgeButton;
    private Button RecipeButton;
    private ImageView HomepageButton;

    private ImageView CalendarButton;
    private TextView CalendarButtonText;
    private ImageView FoodButton;
    private TextView FoodText;
    private ImageView CommunityButton;
    private TextView CommunityText;
    private ImageView WorkoutButton;
    private TextView WorkoutText;
    private ImageView SettingsButton;
    private TextView SettingsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       /**
         * Button to change view to see the fridge
         *
         */
        FridgeButton = findViewById(R.id.bFridgeButton);
        FridgeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, FridgeActivity.class);
                FoodActivity.this.startActivity(i);

                System.out.println("You attempting to go to the fridge menu!!!!!!!");

                //setContentView(R.layout.activity_fridge);

            }

        });
        //Referencing xml elements

        HomepageButton = (ImageView) findViewById(R.id.bHomePageButton);
        HomepageButton.setImageResource(R.drawable.studirep_logo);

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


        /**
         * Button to change view to see the Recipe
         *
         */
        RecipeButton = findViewById(R.id.bRecipeButton);
        RecipeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, Recipe.class);
                FoodActivity.this.startActivity(i);

                System.out.println("You attempting to go to the recipe menu!!!!!!!");

            }

        });


        /**
         * Button to change view back to the homepage
         *
         */
        HomepageButton = findViewById(R.id.bHomePageButton);
        HomepageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, HomePageActivity.class);
                FoodActivity.this.startActivity(i);

                System.out.println("You are going back to home page!!!!!!!!!!!!!!!");
                //setContentView(R.layout.homepage_main);

            }

        });


        CalendarButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to calendar page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, CalendarActivity.class);
                FoodActivity.this.startActivity(i);
            }
        });



        FoodButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to food page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, FoodActivity.class);
                FoodActivity.this.startActivity(i);

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
                Intent i = new Intent(FoodActivity.this, WorkoutActivity.class);
                FoodActivity.this.startActivity(i);
                //setContentView(R.layout.activity_workout_main);
            }
        });





    }

}
