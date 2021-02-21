package com.example.studirep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddRecipeActivity extends AppCompatActivity {
    //buttons and text references
    Button btnView,btnAdd;
    EditText recipeName,mainIngredient,recipeMethod,recipeTime;
    ListView recipeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnView=findViewById(R.id.btnView);
        btnAdd=findViewById(R.id.btnAdd);
        recipeName=findViewById(R.id.recipeName);
        recipeMethod=findViewById(R.id.recipeMethod);
        mainIngredient=findViewById(R.id.mainIngredient);
        recipeList = findViewById(R.id.recipeList);
        recipeTime=findViewById(R.id.recipeTime);

        //Below are button listeners for all the buttons.
        btnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Recipe recipe;
                try{
                    recipe = new Recipe(-1,recipeName.getText().toString(),mainIngredient.getText().toString(),recipeMethod.getText().toString(),Integer.parseInt(recipeTime.getText().toString()));
                    Toast.makeText(AddRecipeActivity.this,recipe.toString(),Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(AddRecipeActivity.this,"Error creating recipe",Toast.LENGTH_SHORT).show();
                    recipe = new Recipe(-1,"error","error","error",0);

                }

                DatabaseHelper databaseHelper =  new DatabaseHelper(AddRecipeActivity.this);
                boolean success = databaseHelper.addOne(recipe);
                Toast.makeText(AddRecipeActivity.this,"Success"+success,Toast.LENGTH_SHORT).show();


            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddRecipeActivity.this,"Add Button",Toast.LENGTH_SHORT).show();

            }
        });

    }

}
