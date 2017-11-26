package com.example.dineshbalajivenkataraman.myhabittracker;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "habitTracker.db";
    private static final int DATABASE_VERSION = 1;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_TRACKING_DIARY = "CREATE TABLE " + DBContract.DBEntry.TABLE_NAME +
                "(" + DBContract.DBEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DBContract.DBEntry.COLUMN_HABIT + " INTEGER NOT NULL," +
                DBContract.DBEntry.COLUMN_LOCATION + " INTEGER NOT NULL," +
                DBContract.DBEntry.COLUMN_DATE + " INTEGER NOT NULL," +
                DBContract.DBEntry.COLUMN_TIMING + " INTEGER NOT NULL," +
                DBContract.DBEntry.COLUMN_COMMENT + " STRING);";
        Log.v("DBHelper", "create table: " + CREATE_TABLE_TRACKING_DIARY);
        sqLiteDatabase.execSQL(CREATE_TABLE_TRACKING_DIARY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertHabit(int habit, int location, int date, int timing, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.DBEntry.COLUMN_HABIT, habit);
        values.put(DBContract.DBEntry.COLUMN_LOCATION, location);
        values.put(DBContract.DBEntry.COLUMN_DATE, date);
        values.put(DBContract.DBEntry.COLUMN_TIMING, timing);
        values.put(DBContract.DBEntry.COLUMN_COMMENT, comment);
        db.insert(DBContract.DBEntry.TABLE_NAME, null, values);
    }
    public Cursor readHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projections = {
                DBContract.DBEntry._ID,
                DBContract.DBEntry.COLUMN_HABIT,
                DBContract.DBEntry.COLUMN_LOCATION,
                DBContract.DBEntry.COLUMN_DATE,
                DBContract.DBEntry.COLUMN_TIMING,
                DBContract.DBEntry.COLUMN_COMMENT
        };
        Cursor cursor = db.query(DBContract.DBEntry.TABLE_NAME,
                projections,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }
}
