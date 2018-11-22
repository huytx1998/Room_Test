package com.example.huy.myfirstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "tasks.db";
    public static final String TABLE_NAME = "tasks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_TIME = "appointedTime";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        SQLiteDatabase database = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(date);

        db.execSQL("CREATE TABLE IF NOT EXISTS tasks(_id INTEGER PRIMARY KEY AUTOINCREMENT, description TEXT, appointedTime TEXT)");
        db.execSQL("insert into tasks(description, appointedTime) values(\"Main-1\"," +
                " \"" + formattedDate + "T13:22\")");
        db.execSQL("insert into tasks(description, appointedTime) values(\"Main-2\"," +
                " \"" + formattedDate + "T14:50\")");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(db);
    }

}