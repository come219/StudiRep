package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private EditText recipeNameEdt, recipeIngredientEdt, recipeCookTimeEdt, recipeMethodEdt;
    private Button updateButton;
    private com.example.searching.DatabaseHandler databaseHandler;
    String recipeName, recipeIngredient, cookTime, method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        recipeNameEdt = findViewById(R.id.idEdtRecipeName);
        recipeIngredientEdt = findViewById(R.id.idEdtRecipeIngredient);
        recipeCookTimeEdt = findViewById(R.id.idEdtCookTime);
        recipeMethodEdt = findViewById(R.id.idEdtMethod);
        updateButton = findViewById(R.id.idUpdateRecipe);


        databaseHandler = new com.example.searching.DatabaseHandler(UpdateActivity.this);

        recipeName = getIntent().getStringExtra("name");
        recipeIngredient = getIntent().getStringExtra("ingredient");
        cookTime = getIntent().getStringExtra("cookTime");
        method = getIntent().getStringExtra("method");

        recipeNameEdt.setText(recipeName);
        recipeIngredientEdt.setText(recipeIngredient);
        recipeCookTimeEdt.setText(cookTime);
        recipeMethodEdt.setText(method);


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //databaseHandler.updateRecipe(recipeName, recipeNameEdt.getText().toString(), recipeIngredientEdt.getText().toString(), recipeCookTimeEdt.getText().toString(), recipeMethodEdt.getText().toString());
                databaseHandler.updateRecipe(recipeName, recipeNameEdt.getText().toString(), recipeIngredientEdt.getText().toString(), recipeCookTimeEdt.getText().toString(), recipeMethodEdt.getText().toString());
                Toast.makeText(UpdateActivity.this, "Recipe Updated..", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateActivity.this, com.example.searching.MainActivity.class);
                startActivity(i);
            }
        });
    }
}