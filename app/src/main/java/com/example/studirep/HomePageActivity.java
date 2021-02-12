package com.example.studirep;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity {

    private Button AccountButton;
    private Button HomeButton;
    private Button CalendarButton;
    private TextView test;
    private ImageView CalendarImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AccountButton =  findViewById(R.id.bAccountButton);
       // test = findViewById(R.id.test1234);

        CalendarImage = (ImageView) findViewById(R.id.CalendarView);
        CalendarImage.setImageResource(R.drawable.basic_calendar);





        System.out.println("This is home page activity.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        AccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // setContentView(R.layout.accountpage_main);
                    System.out.println("This button has been clicked.!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    Intent i = new Intent(HomePageActivity.this, AccountPageActivity.class);
                    HomePageActivity.this.startActivity(i);

                }


        });
        HomeButton =  findViewById(R.id.bHomePageButton);
        HomeButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //setContentView(R.layout.homepage_main);

                System.out.println("You are going back to home page!!!!!!!!!!!!!!!");
            }


        });

        CalendarButton =  findViewById(R.id.bCalendar);
        CalendarButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //setContentView(R.layout.homepage_main);
                Intent i = new Intent(HomePageActivity.this, CalendarActivity.class);
                HomePageActivity.this.startActivity(i);

            }


        });


    }




}


