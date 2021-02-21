package com.example.studirep;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String RECIPE_TABLE = "RECIPE_TABLE";
    public static final String COLUMN_RECIPE_NAME = "RECIPE_NAME";
    public static final String COLUMN_RECIPE_INGREDIENT = "RECIPE_INGREDIENT";
    public static final String COLUMN_RECIPE_METHOD = "RECIPE_METHOD";
    public static final String COLUMN_RECIPE_COOKTIME = "RECIPE_COOKTIME";
    public static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "recipe.db", null, 1);
    }

    //THIS IS CALLED THE FIRST TIME DATABASE IS ACCESED.THERE SHOULD BE CODE TO CREATE A NEW DATABASE HERE.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + RECIPE_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RECIPE_NAME + " TEXT," + COLUMN_RECIPE_INGREDIENT + " TEXT," + COLUMN_RECIPE_COOKTIME + " TEXT," + COLUMN_RECIPE_METHOD + " INT )";
        db.execSQL(createTableStatement);
    }

    //THIS CALLED IF DATABASE NUMBERCHANGES.IT PREVENTS USER APPS FROM BREAKING WHEN DATA DESIGN CHANGES.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(Recipe recipe){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();//take pairs of calue and asscociate with them.
        cv.put(COLUMN_RECIPE_NAME,recipe.getRecipeName());
        cv.put(COLUMN_RECIPE_INGREDIENT,recipe.getRecipeIngredient());
        cv.put(COLUMN_RECIPE_METHOD,recipe.getRecipeMethod());
        cv.put(COLUMN_RECIPE_COOKTIME,recipe.getRecipeTime());

        long insert = db.insert(RECIPE_TABLE, null, cv);
        if(insert ==1){
            return false;//is was fail to be inserted
        }
        else{
            return true; //successful insertion
        }


    }
}
