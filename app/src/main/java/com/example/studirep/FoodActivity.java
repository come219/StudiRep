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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FridgeButton = findViewById(R.id.bFridgeButton);
        FridgeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, FridgeActivity.class);
                FoodActivity.this.startActivity(i);
            }

        });

        RecipeButton = findViewById(R.id.bRecipeeButton);
        RecipeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, AddRecipeActivity.class);
                FoodActivity.this.startActivity(i);
            }

        });





    }

}
