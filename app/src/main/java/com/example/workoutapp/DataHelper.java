package com.example.workoutapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataHelper {
    public static ArrayList<Workout> loadWorkout(Context context){
        ArrayList<Workout> workouts=new ArrayList<>();
        String json="";

        try {
            InputStream is= context.getAssets().open("data.json");
            int size= is.available();
            byte[] buffer= new byte[size];
            is.read(buffer);
            is.close();
            json= new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray= obj.getJSONArray("Benchmark");

            for(int i=0; i<jsonArray.length(); i++){  //it will start from 0 ....
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                Workout workout=new Workout();

                workout.setTitle(jsonObject.getString("title"));
                workout.setWod(jsonObject.getString("wod"));
                workout.setVideo(jsonObject.getString("video"));

                workouts.add(workout);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return workouts;
    }

}
