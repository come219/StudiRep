package com.example.studirep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class ViewRecipes extends AppCompatActivity {

    private ArrayList<RecipeModal> recipeModalArrayList;
    private DatabaseHelper databaseHandler;
    private RecipeAdapter recipeAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipes);

        recipeModalArrayList = new ArrayList<>();
        databaseHandler = new DatabaseHelper(ViewRecipes.this);

        recipeModalArrayList = databaseHandler.readRecipes();

        recipeAdapter = new RecipeAdapter(recipeModalArrayList, ViewRecipes.this);
        recyclerView = findViewById(R.id.idViewRecipes);

        LinearLayoutManager linearLayoutManger = new LinearLayoutManager(ViewRecipes.this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManger);

        recyclerView.setAdapter(recipeAdapter);

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text){
        ArrayList<RecipeModal> filteredList = new ArrayList<>();
        for(RecipeModal recipe: recipeModalArrayList){
            if( recipe.getRecipeName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(recipe);
            }
        }
        recipeAdapter.filterList(filteredList);

    }
}