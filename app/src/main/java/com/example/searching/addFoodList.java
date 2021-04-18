package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class addFoodList extends AppCompatActivity {

    ArrayList<foodItem> foodItemList;
    private RecyclerView recyclerView;
    private foodAdapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_list);
        dataLoad();
        recycleViewBuild();
        addButton();
        Button buttonSave = findViewById(R.id.insertButton);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }
    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(foodItemList);
        editor.putString("food list", json);
        editor.apply();
    }
    private void dataLoad() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("food list", null);
        Type type = new TypeToken<ArrayList<foodItem>>() {}.getType();
        foodItemList = gson.fromJson(json, type);
        if (foodItemList == null) {
            foodItemList = new ArrayList<>();
        }
    }
    private void recycleViewBuild() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        Adapter = new foodAdapter(foodItemList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(Adapter);
    }
    private void addButton() {
        Button buttonInsert = findViewById(R.id.addButton);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText foodName = findViewById(R.id.foodNameInput);
                EditText foodType = findViewById(R.id.foodTypeInput);
                EditText foodWeight = findViewById(R.id.foodWeightInput);
                insertFoodItem(foodName.getText().toString(), foodType.getText().toString(), Integer.parseInt(foodWeight.getText().toString()));
            }
        });
    }
    private void insertFoodItem(String foodNameInput, String foodTypeInput, int foodWeightInput) {
        foodItemList.add(new foodItem(foodNameInput, foodWeightInput, foodTypeInput));
        Adapter.notifyItemInserted(foodItemList.size());
    }


}