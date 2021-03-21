package com.example.studirep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
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

import com.example.studirep.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AddRecipeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    DatabaseHelper myDB;
    ArrayList<String> recipeId,recipe_name,ingredient,cooktime,method;
    CustomAdapter customAdapter;


    //buttons and text references

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener((v) -> {
            Intent intent = new Intent(AddRecipeActivity.this, AddActivity.class);
            startActivity(intent);
        });

        myDB = new DatabaseHelper(AddRecipeActivity.this);
        recipeId = new ArrayList<>();
        recipe_name = new ArrayList<>();
        ingredient = new ArrayList<>();
        cooktime = new ArrayList<>();
        method = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(AddRecipeActivity.this, recipeId, recipe_name, ingredient, cooktime,method);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AddRecipeActivity.this));

    }



    void storeDataInArrays(){
        Cursor cursor=myDB.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                recipeId.add(cursor.getString(0));
                recipe_name.add(cursor.getString(1));
                ingredient.add(cursor.getString(2));
                cooktime.add(cursor.getString(4));
                method.add(cursor.getString(3));

            }
        }
    }
}
