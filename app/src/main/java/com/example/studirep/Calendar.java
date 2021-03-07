package com.example.studirep;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Struct;
import java.io.IOException;
import java.io.FileWriter;
//Class created in order to add an event to the Calendar

public class Calendar {
    public Calendar() {



       /* try {
            File CalendarData = new File(Environment.getExternalStorageDirectory() + "/" + File.separator + "CalendarData.txt");
            CalendarData.createNewFile();


            if (CalendarData.exists()) {
                System.out.println("CalendarData.txt has been created");
                OutputStream fo = new FileOutputStream(CalendarData);
                fo.write(Integer.parseInt("dsadasd"));
                fo.close();


            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("CalendarData.txt file creation encountered an error." + e.getMessage());
            e.printStackTrace();
        }*/





    }
    public String date = "";
    public String event;
    public int event_type;
    public String start_time = "";
    public int event_duration;
    public String event_details;

    public static void displayCalendarText() {
        System.out.println("Calendar class.");

    }

    public void createTempEvent(String mDate, String mEvent, int mEvent_type, String mStart_time, String mEvent_duration, String mEvent_detail)
    {
        //Event type {1 = lectures, 2 = seminar, 3 = self study }
        if(mEvent_type == 1 || mEvent_type == 2 || mEvent_type == 3)
        {
            event_type = mEvent_type;

        }

        //if(mStart_time.length() == 4)
        if(true)
        {
            //start_time = Integer.parseInt(mStart_time);

            start_time = mStart_time;

        }

        if(true)
        {
            date =  mDate;
        }

        if(mEvent_duration.length() == 4)
        {
            event_duration = Integer.parseInt(mEvent_duration);

        }

        if(mEvent_detail.length() != 0)
        {

            event_details = mEvent_detail;

        }



        System.out.println("date(ddmmyy),eventtype,time(xx:xx),duration(xx:xx)");

        System.out.println(date + "," + event_type +  "," + start_time + "," + event_duration + "," + event_details);


    }




    public static void createEvent(int mDate, String mEvent, int mEvent_type, int mStart_time, int mEvent_duration, String mEvent_details) {

    }
}




