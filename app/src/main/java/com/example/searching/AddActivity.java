package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText recipe_name,ingredient,method,cooktime;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        recipe_name = findViewById(R.id.recipe_name);
        ingredient=findViewById(R.id.ingredient);
        method=findViewById(R.id.method);
        cooktime=findViewById(R.id.cooktime);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDb = new DatabaseHelper(AddActivity.this);
                myDb.addRecipe(recipe_name.getText().toString().trim(),ingredient.getText().toString().trim(), Integer.valueOf(cooktime.getText().toString().trim()), method.getText().toString().trim());


            }
        });
    }
}