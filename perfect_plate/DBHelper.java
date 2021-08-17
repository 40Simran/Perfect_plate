package com.example.perfect_plate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "perfectplate.db";
    public static final String Table_Name1 = "signup";
   public static final String Table_Name2 = "book";
    public static final String col_id = "Id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";
    public static final String SCORE = "score";

    public static final String restaurant = "restaurant";
    public static final String arrange = "arragementType";
    public static final String chairs = "Chairs";
    public static final String food = "food";
    public static final String table = "table_no";

    public DBHelper(@Nullable Context context) {

        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + Table_Name1 + " ( Id INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT , "+ EMAIL + " TEXT, "+ PHONE + " TEXT, " + PASSWORD + " TEXT, " + SCORE + " INTEGER )";
        db.execSQL(query);

       String query1 = "CREATE TABLE " + Table_Name2 + " ( " + restaurant + " TEXT , "+ arrange + " TEXT, "+ chairs + " TEXT, " + food + " TEXT ,"+ table +" TEXT )";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE " + Table_Name1;
        db.execSQL(query);

     //   String query1 = "DROP TABLE " + Table_Name2;
     //   db.execSQL(query1);
    }

    public boolean insert(String name,String email,String phone, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(PHONE, phone);
        contentValues.put(PASSWORD, password);
        return db.insert(Table_Name1, null, contentValues) != -1;
    }

  public boolean insertBook(String res_name,String arrangement,String chair, String foods, String number) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(restaurant, res_name);
        contentValues.put(arrange, arrangement);
        contentValues.put(chairs, chair);
        contentValues.put(food, foods);
      contentValues.put(table, number);
        return db.insert(Table_Name2, null, contentValues) != -1;
    }

    public Cursor getAll() {

        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + Table_Name1, null);
    }
   public Cursor getAllbook() {

        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + Table_Name2, null);
    }

    public int update(String name, int score) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(SCORE, score);

        return db.update(Table_Name1, contentValues, "NAME = ?", new String[] {name});
    }

    public Cursor Showdata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ Table_Name1,null);
        return cursor;
    }
    public Cursor Showdetails()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor1 = db.rawQuery("select * from "+ Table_Name2,null);
        return cursor1;
    }
}

