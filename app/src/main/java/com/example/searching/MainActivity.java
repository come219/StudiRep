package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    //buttons and text references
    Button btnView,btnAdd;
    EditText recipeName,mainIngredient,recipeMethod,recipeTime,searchRecipe;
    ListView recipeList;
    ArrayAdapter recipeArrayAdapter;

    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnView = findViewById(R.id.btnView);
        btnAdd = findViewById(R.id.btnAdd);
        recipeName = findViewById(R.id.recipeName);
        recipeMethod = findViewById(R.id.recipeMethod);
        mainIngredient = findViewById(R.id.mainIngredient);
        recipeList = findViewById(R.id.recipeList);
        recipeTime = findViewById(R.id.recipeTime);
        searchRecipe = findViewById(R.id.searchRecipe);

        databaseHelper = new DatabaseHelper(MainActivity.this);
        ShowRecipeList(databaseHelper);

        //Below are button listeners for all the buttons.
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Recipe recipe;
                try {

                    //add recipe
                    recipe = new Recipe(-1, recipeName.getText().toString(), mainIngredient.getText().toString(), recipeMethod.getText().toString(), Integer.parseInt(recipeTime.getText().toString()));
                    //Toast.makeText(MainActivity.this, recipe.toString(), Toast.LENGTH_SHORT).show();
                    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                    boolean success = databaseHelper.addOne(recipe);
                    Toast.makeText(MainActivity.this, "Success" + success, Toast.LENGTH_SHORT).show();
                 // if the user enters in wrong inpu will cause an error mesdage to be made.
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error creating recipe", Toast.LENGTH_SHORT).show();
                    //recipe = new Recipe(-1, "error", "error", "error", 0);

                }

                //DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                //boolean success = databaseHelper.addOne(recipe);
                //Toast.makeText(MainActivity.this, "Success" + success, Toast.LENGTH_SHORT).show();
                ShowRecipeList(databaseHelper);


            }
        });
        btnView.setOnClickListener((v) -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);


            ShowRecipeList(databaseHelper);
            //Toast.makeText(MainActivity.this, everyone.toString(),Toast.LENGTH_SHORT).show();
        });

        //deleting a recipe from the visible list and from the database
        
        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Recipe recipeClick = (Recipe) parent.getItemAtPosition(position);
                databaseHelper.deleteRecipe(recipeClick);
                ShowRecipeList(databaseHelper);
                Toast.makeText(MainActivity.this, "Deleted" + recipeClick.toString(),Toast.LENGTH_SHORT).show();
            }
        });

         // this is supposed to show the recipes that have been searched for.

        searchRecipe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.recipeArrayAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    // adapater to be able to show all the recipes.
    private void ShowRecipeList(DatabaseHelper databaseHelper2) {

        recipeArrayAdapter = new ArrayAdapter<Recipe>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper2.getEveryone());
        recipeList.setAdapter(recipeArrayAdapter);

    }

}
