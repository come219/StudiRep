package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView lv;
    private ArrayList<Workout>wodList;
    private ArrayList<String>titleList; //to hold the title
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);

        //put the workouts list in th woddlits
        wodList=DataHelper.loadWorkout(this);
        titleList= new ArrayList<>();
        for(int i=0; i<wodList.size(); i++){
            String str=wodList.get(i).getTitle();
            titleList.add(str);
        }

        //to pass in strings we need to put in
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleList);
        lv.setAdapter((ListAdapter) adapter);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(MainActivity.this, DetailActivity.class);
        String title = wodList.get(position).getTitle();
        String wod = wodList.get(position).getWod();
        String video = wodList.get(position).getVideo();

        //works as keys
        intent.putExtra("EXTRA_TITLE", title);
        intent.putExtra("EXTRA_WOD", wod);
        intent.putExtra("video", video);

        startActivity(intent);
    }
}