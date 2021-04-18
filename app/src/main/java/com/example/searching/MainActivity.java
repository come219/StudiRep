package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText recipeNameEdt, recipeIngredientEdt, recipeCookTimeEdt, recipeMethodEdt;
    private Button addRecipeButton, readRecipesButton, addFood;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeNameEdt = findViewById(R.id.idEdtRecipeName);
        recipeIngredientEdt = findViewById(R.id.idEdtRecipeIngredient);
        recipeCookTimeEdt = findViewById(R.id.idEdtCookTime);
        recipeMethodEdt = findViewById(R.id.idEdtMethod);
        addRecipeButton = findViewById(R.id.idBtnAdd);
        readRecipesButton = findViewById(R.id.idBtnReadRecipe);
        addFood = findViewById(R.id.inputFood);

        databaseHandler = new DatabaseHandler(MainActivity.this);

        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting data from edit text fields.
                String recipeName = recipeNameEdt.getText().toString();
                String recipeIngredient = recipeIngredientEdt.getText().toString();
                String cookTime = recipeCookTimeEdt.getText().toString();
                String method = recipeMethodEdt.getText().toString();

                // checking if the input boxes are empty or not.
                if (recipeName.isEmpty() && recipeIngredient.isEmpty() && cookTime.isEmpty() && method.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                //passing values

                databaseHandler.addRecipe(recipeName, recipeIngredient, cookTime, method);

                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                recipeNameEdt.setText("");
                recipeIngredientEdt.setText("");
                recipeCookTimeEdt.setText("");
                recipeMethodEdt.setText("");
            }
        });

        readRecipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewRecipes.class);
                startActivity(i);
            }
        });

        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, addFoodList.class);
                startActivity(i);
            }
        });




    }
}