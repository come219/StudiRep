package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //buttons and text refferences
    Button btnView,btnAdd;
    EditText recipeName,mainIngredient,recipeMethod,recipeTime;
    ListView recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnView=findViewById(R.id.btnView);
        btnAdd=findViewById(R.id.btnAdd);
        recipeName=findViewById(R.id.recipeName) ;
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
                    Toast.makeText(MainActivity.this,recipe.toString(),Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this,"Error creating recipe",Toast.LENGTH_SHORT).show();
                    recipe = new Recipe(-1,"error","error","error",0);

                }

                DatabaseHelper databaseHelper =  new DatabaseHelper(MainActivity.this);
                boolean success = databaseHelper.addOne(recipe);
                Toast.makeText(MainActivity.this,"Success"+success,Toast.LENGTH_SHORT).show();


            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Add Button",Toast.LENGTH_SHORT).show();

            }
        });

    }
}