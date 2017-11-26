package com.example.dineshbalajivenkataraman.myhabittracker;
import android.provider.BaseColumns;
public class DBContract {
    public DBContract() {
    }
    public class DBEntry implements BaseColumns{
        public final static String TABLE_NAME = "my_tracking_diary";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT = "habit";
        public final static String COLUMN_LOCATION = "location";
        public final static String COLUMN_DATE = "date";
        public final static String COLUMN_TIMING = "time";
        public final static String COLUMN_COMMENT = "comment";
        /**
         * Possible values for the Habit - Meditation, Reading, Coding for Inside and Running, Swimming and Tennis for Outside.
         */
        public final static int HABIT_MEDITATION = 0;
        public final static int HABIT_READING = 1;
        public final static int HABIT_CODING = 2;
        public final static int HABIT_RUNNING = 3;
        public final static int HABIT_SWIMMING = 4;
        public final static int HABIT_TENNIS= 5;
        /**
         * Possible values for the Time - Morning- Evening or Night.
         */
        public final static int TIME_MORNING= 6;
        public final static int TIME_EVENING= 7;
        public final static int TIME_NIGHT= 8;
        /**
         * Possible values for the Location -  Inside or Outside.
         */
        public final static int LOCATION_INSIDE= 9;
        public final static int LOCATION_OUTSIDE= 10;
    }
}
