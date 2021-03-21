package com.example.searching;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Recipe.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "RECIPE_TABLE";
    private static final String COLUMN_RECIPE_NAME = "RECIPE_NAME";
    private static final String COLUMN_RECIPE_INGREDIENT = "RECIPE_INGREDIENT";
    private static final String COLUMN_RECIPE_METHOD = "RECIPE_METHOD";
    private static final String COLUMN_RECIPE_COOKTIME = "RECIPE_COOKTIME";
    private static final String COLUMN_ID = "ID";

    DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RECIPE_NAME + " TEXT," + COLUMN_RECIPE_INGREDIENT + " TEXT," + COLUMN_RECIPE_COOKTIME + " TEXT," + COLUMN_RECIPE_METHOD + " INT )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addRecipe(String name, String ingredient, int cooktime, String method){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();//take pairs of calue and asscociate with them.
        cv.put(COLUMN_RECIPE_NAME, name);
        cv.put(COLUMN_RECIPE_INGREDIENT,ingredient);
        cv.put(COLUMN_RECIPE_METHOD,cooktime);
        cv.put(COLUMN_RECIPE_COOKTIME,method);

        long insert = db.insert(TABLE_NAME, null, cv);
        if(insert ==-1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Added Successfully",Toast.LENGTH_SHORT).show();
        }


    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =null;

        if(db != null){
            cursor = db.rawQuery(query,null);

        }
        return cursor;
    }

    void updateData(String row_id,String recipe_name,String recipe_ingredient,int cooktime,String method){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_RECIPE_NAME,recipe_name);
        cv.put(COLUMN_RECIPE_INGREDIENT,recipe_ingredient);
        cv.put(COLUMN_RECIPE_METHOD,method);
        cv.put(COLUMN_RECIPE_COOKTIME,cooktime);


        long result = db.update(TABLE_NAME,cv,"ID=?",new String[]{row_id});
        if(result==-1){
            Toast.makeText(context,"Failed to Update.",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully Update!",Toast.LENGTH_SHORT).show();
        }
    }
}