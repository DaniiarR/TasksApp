package com.example.tasksapp.data;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static AppDatabase INSTANCE;

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            Log.i(LOG_TAG, "No existing database found. Will try to create a new one");
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "tasksDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public abstract TaskDao taskDao();
}
