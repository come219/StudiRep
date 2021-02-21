package com.example.studirep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class FoodActivity extends AppCompatActivity {

    private Button FridgeButton;
    private Button RecipeButton;
    private Button HomepageButton;


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
                /*Intent i = new Intent(FoodActivity.this, FridgeActivity.class);
                FoodActivity.this.startActivity(i);*/

                System.out.println("You attempting to go to the fridge menu!!!!!!!");

                setContentView(R.layout.activity_fridge);

            }

        });

        /**
         * Button to change view to see the Recipe
         *
         */
        RecipeButton = findViewById(R.id.bRecipeButton);
        RecipeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Intent i = new Intent(FoodActivity.this, AddRecipeActivity.class);
                //FoodActivity.this.startActivity(i);

                System.out.println("You attempting to go to the recipe menu!!!!!!!");

                setContentView(R.layout.activity_recipe);
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
                //Intent i = new Intent(FoodActivity.this, HomePageActivity.class);
                //FoodActivity.this.startActivity(i);

                setContentView(R.layout.homepage_main);
                System.out.println("You are going back to home page!!!!!!!!!!!!!!!");
            }

        });





    }

}
