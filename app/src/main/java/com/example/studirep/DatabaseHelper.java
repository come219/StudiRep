package com.example.studirep;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipes";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "RECIPE_TABLE";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_RECIPE_NAME = "RECIPE_NAME";
    private static final String COLUMN_RECIPE_INGREDIENT = "RECIPE_INGREDIENT";
    private static final String COLUMN_RECIPE_METHOD = "RECIPE_METHOD";
    private static final String COLUMN_RECIPE_COOKTIME = "RECIPE_COOKTIME";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //setting column names and data types
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_RECIPE_NAME + " TEXT,"
                + COLUMN_RECIPE_INGREDIENT + " TEXT,"
                + COLUMN_RECIPE_COOKTIME + " INTEGER,"
                + COLUMN_RECIPE_METHOD + " TEXT )";
        db.execSQL(query);
    }

    //adding a new recipe to the database

    void addRecipe(String recipeName, String recipeIngredient, String cookTime, String method){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();//take pairs of values and associate with them.
        values.put(COLUMN_RECIPE_NAME, recipeName);
        values.put(COLUMN_RECIPE_INGREDIENT, recipeIngredient);
        values.put(COLUMN_RECIPE_COOKTIME, cookTime);
        values.put(COLUMN_RECIPE_METHOD, method);

        db.insert(TABLE_NAME, null, values);
        //if(insert ==-1){
        //Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        //}
        //else{
        //Toast.makeText(context,"Added Successfully",Toast.LENGTH_SHORT).show();
        //}
        db.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<RecipeModal> readRecipes() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorRecipe = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<RecipeModal> recipeModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorRecipe.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                recipeModalArrayList.add(new RecipeModal(cursorRecipe.getString(1),
                        cursorRecipe.getString(3),
                        cursorRecipe.getString(2),
                        cursorRecipe.getString(4)));
            } while (cursorRecipe.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorRecipe.close();
        return recipeModalArrayList;
    }



    // deleting a recipe
    public void deleteRecipe(String recipeName) {

        SQLiteDatabase db = this.getWritableDatabase();

        // delete course by comparing with our course name.
        db.delete(TABLE_NAME, "name=?", new String[]{recipeName});
        db.close();
    }

    public void updateRecipe(String initialRecipeName, String recipeName, String recipeIngredient,
                             String cookTime, String method) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COLUMN_RECIPE_NAME, recipeName);
        values.put(COLUMN_RECIPE_INGREDIENT, recipeIngredient);
        values.put(COLUMN_RECIPE_COOKTIME, cookTime);
        values.put(COLUMN_RECIPE_METHOD, method);
        db.update(TABLE_NAME, values, "RECIPE_NAME = ? ", new String[]{initialRecipeName});
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this checks if the database already exists.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}