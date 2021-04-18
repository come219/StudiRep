package com.example.studirep;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;









public class WorkoutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView HomeButton;
    private ListView WorkoutList;
    private ArrayList<Workout>wodList;
    private ArrayList<String>titleList; //to hold the title
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_main);
        WorkoutList = findViewById(R.id.WorkoutListView);

        //put the workouts list in the woddlits
        wodList=DataHelper.loadWorkout(this);
        titleList= new ArrayList<>();
        for(int i=0; i<wodList.size(); i++){
            String str=wodList.get(i).getTitle();
            titleList.add(str);
        }

        //to pass in strings we need to put in
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleList);
        WorkoutList.setAdapter((ListAdapter) adapter);

        WorkoutList.setOnItemClickListener(this);



        //Referencing xml elements

        HomeButton = (ImageView) findViewById(R.id.bHomePageButton);
        HomeButton.setImageResource(R.drawable.studirep_logo);


        HomeButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick function to send state to home page
             * @param v View is a state
             */
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.homepage_main);
                System.out.println("You are going back to home page!!!!!!!!!!!!!!!");

                Intent i = new Intent(WorkoutActivity.this, HomePageActivity.class);
                WorkoutActivity.this.startActivity(i);

            }
        });



















    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(WorkoutActivity.this, DetailActivity.class);
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