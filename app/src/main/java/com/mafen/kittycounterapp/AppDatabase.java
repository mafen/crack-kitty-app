package com.mafen.kittycounterapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;




import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {DataItem.class}, version = 1 ,exportSchema = false )
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataDao dataDao();

    private static volatile AppDatabase INSTANCE;


    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    /**
     * @param context the context of the calling activity
     * @return the instance, that the different activities can use to access the local database
     * via the repository
     */
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "data_database")
                            .createFromAsset("databases/data_database.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;


    }
}