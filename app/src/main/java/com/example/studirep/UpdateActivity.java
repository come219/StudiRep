package com.example.studirep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText recipe_name, ingredient, cooktime,method;
    Button update_button;

    String id,recipeName,recipeIngredient,recipeMethod;
    int cookTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        recipe_name=findViewById(R.id.recipe_name2);
        ingredient=findViewById(R.id.ingredient2);
        cooktime=findViewById(R.id.cooktime2);
        method=findViewById(R.id.method2);
        update_button=findViewById(R.id.update_button);
        update_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //And only then we call this
                DatabaseHelper myDB = new DatabaseHelper(UpdateActivity.this);
                myDB.updateData(id,recipeName,recipeIngredient,cookTime,recipeMethod);

            }
        });
        //First we call this
        getAndSetIntentData();
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id")&&getIntent().hasExtra("recipeName")&&getIntent().hasExtra("recipeIngredient")&&getIntent().hasExtra("cookTime")&&getIntent().hasExtra("recipeMethod")) {
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            recipeName = getIntent().getStringExtra("recipeName");
            recipeIngredient = getIntent().getStringExtra("recipeIngredient");
            cookTime = Integer.parseInt(getIntent().getStringExtra("cookTime"));
            recipeMethod = getIntent().getStringExtra("recipeMethod");

            //Setting Intent Data
            recipe_name.setText(recipeName);
            ingredient.setText(recipeIngredient);
            cooktime.setText(cookTime);
            method.setText(recipeMethod);
        }else{
            Toast.makeText(this,"No data.",Toast.LENGTH_SHORT).show();
        }
    }
}