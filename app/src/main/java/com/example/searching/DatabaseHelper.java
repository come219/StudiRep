package com.example.searching;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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


    // This adds a recipe to the database.
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

    // this deletes the recipe by clicking on the recipe

    public boolean deleteRecipe(Recipe recipe){
        //this id finding the customer variable and is it is there delete.
        SQLiteDatabase db =this.getWritableDatabase();
        String queryString = " DELETE FROM " + RECIPE_TABLE + " WHERE " + COLUMN_ID + " = " + recipe.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }

    }

    // this is supposed to get the recipe to display it when the searched for by an ingredient.
    public Cursor getRecipe(Recipe recipe){
        //this id finding the customer variable and is it is there and displaying it.
        SQLiteDatabase db =this.getReadableDatabase();
        String queryString = " SELECT * FROM " + RECIPE_TABLE + " WHERE " + COLUMN_RECIPE_INGREDIENT + " = " + recipe.getRecipeIngredient();
        Cursor cursor = db.rawQuery(queryString, null);

        return cursor;
    }







   // gets all the recipes on a database and .
    public List<Recipe> getEveryone() {

        List<Recipe> returnList = new ArrayList<>();
        //Getting data from database.
        String queryString = "SELECT *FROM "+ RECIPE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()) {
            //looping through cursor and creating new customer objects.
            do {
                int id = cursor.getInt(0);
                String recipeName = cursor.getString(1);
                String recipeIngredient = cursor.getString(2);
                String recipeMethod = cursor.getString(3);
                int recipeTime = cursor.getInt(4);

                Recipe newRecipe = new Recipe(id,recipeName,recipeIngredient, recipeMethod, recipeTime);
                returnList.add(newRecipe);

            }while(cursor.moveToNext());

        }
        else{
            //do not add anything to the list
        }
        cursor.close();
        db.close();
        return returnList;

    }

    /*


    public List<Recipe> getRecipe( String keyword) {

        List<Recipe> returnList = new ArrayList<>();
        //Getting data from database.
        String queryString = "select * from " + RECIPE_TABLE + "where" + COLUMN_RECIPE_INGREDIENT +"like ?", new String[]{"%" + keyword + "&"};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()) {
            //looping through cursor and creating new customer objects.
            do {
                int id = cursor.getInt(0);
                String recipeName = cursor.getString(1);
                String recipeIngredient = cursor.getString(2);
                String recipeMethod = cursor.getString(3);
                int recipeTime = cursor.getInt(4);

                Recipe newRecipe = new Recipe(id,recipeName,recipeIngredient, recipeMethod, recipeTime);
                returnList.add(newRecipe);

            }while(cursor.moveToNext());

        }
        else{
            //do not add anything to the list
        }
        cursor.close();
        db.close();
        return returnList;

    }

     */






}
