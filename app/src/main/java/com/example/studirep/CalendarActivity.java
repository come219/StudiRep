/**
 * CalendarActivity.java
 * StudiRep
 * 19024625
 * 19129576
 */
package com.example.studirep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * CalendarActivity is where the user will be able to see the calendar, and add events to it.
 */
public class CalendarActivity extends AppCompatActivity {

    //Declaring variables for calendar.
    private int year;
    private int month;
    private int day;

    private int hour;
    private int minute;
    private TimePickerDialog.OnTimeSetListener mTimeListener;

    private DatePickerDialog.OnDateSetListener mDateListener;
    private Button DateButton;
    private Button TimeButton;
    private Button SubmitButton;


    String iDate = "";
    String iEvent = "";
    int     iEvent_type = 1;
    String iStart_time = "";
    String iEvent_duration = "";
    String iEvent_detail = "";

    private Spinner DropDown;
    private static final String[] paths = {"Work", "Lectures", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!! you are in the calendar activity");

        //Required android initialisation.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar cal = new Calendar();


        DropDown = (Spinner) findViewById(R.id.bEventDropDown);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CalendarActivity.this,
                android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DropDown.setAdapter(adapter);
        DropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        DateButton = findViewById(R.id.bAddDate);
        DateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(CalendarActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth, mDateListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }


        });


        TimeButton = findViewById(R.id.bAddTime);
        TimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TimePickerDialog dialog = new TimePickerDialog(CalendarActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth, mTimeListener, hour, minute);

                TimePickerDialog dialog = new TimePickerDialog(CalendarActivity.this, mTimeListener, hour, minute, false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();

            }

        });

        SubmitButton = findViewById(R.id.bSubmitButton);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /**
                 * Date String
                 */

                String tempyear  = Integer.toString(year);
                String tempmonth = Integer.toString(month);
                String tempday   = Integer.toString(day);

                String fulldate;

                fulldate = (tempday += tempmonth);
                fulldate += tempyear;

                iDate = fulldate;





                /**
                 * Time String
                 */
                String temphr = Integer.toString(hour);
                String tempmin = Integer.toString(minute);

                temphr += tempmin;


                //String temptemp ="1111";

                //0000
                //iStart_time.concat(temptemp);

                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!" + temphr);


                //iStart_time.concat(temptemp);


                iStart_time += temphr;

                // String a =""
                //         , b ="", c = "";
                // String.format(a, b, c);






                /**
                 * parse data to calendar
                 */
               cal.createTempEvent(   iDate,
                                     iEvent,
                                iEvent_type,
                                iStart_time,
                            iEvent_duration,
                              iEvent_detail);




               //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
               //dialog.show();
            }


        });
    }
}