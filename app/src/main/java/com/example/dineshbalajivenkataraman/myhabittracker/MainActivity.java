package com.example.dineshbalajivenkataraman.myhabittracker;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbHelper = new DBHelper(this);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);
        dbHelper.insertHabit(DBContract.DBEntry.HABIT_MEDITATION,
                DBContract.DBEntry.LOCATION_INSIDE,
                dateInt,
                DBContract.DBEntry.TIME_MORNING,
                "30 Min");
        dbHelper.insertHabit(DBContract.DBEntry.HABIT_READING,
                DBContract.DBEntry.HABIT_READING,
                dateInt,
                DBContract.DBEntry.TIME_NIGHT,
                "20 Min");
        dbHelper.insertHabit(DBContract.DBEntry.HABIT_CODING,
                DBContract.DBEntry.LOCATION_INSIDE,
                dateInt,
                DBContract.DBEntry.TIME_EVENING,
                "30 Min");
        dbHelper.insertHabit(DBContract.DBEntry.HABIT_RUNNING,
                DBContract.DBEntry.LOCATION_OUTSIDE,
                dateInt,
                DBContract.DBEntry.TIME_EVENING,
                "40 Min");
        dbHelper.insertHabit(DBContract.DBEntry.HABIT_SWIMMING,
                DBContract.DBEntry.LOCATION_OUTSIDE,
                dateInt,
                DBContract.DBEntry.TIME_MORNING,
                "60 Min");
        dbHelper.insertHabit(DBContract.DBEntry.HABIT_TENNIS,
                DBContract.DBEntry.LOCATION_OUTSIDE,
                dateInt,
                DBContract.DBEntry.TIME_EVENING,
                "10 Min");
        Cursor cursor = dbHelper.readHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                    " " + cursor.getInt(2) + " " + cursor.getInt(3) + " " + cursor.getInt(4) + " " + cursor.getString(5));
        }

    }
}
