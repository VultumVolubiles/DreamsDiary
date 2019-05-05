package com.example.dreamsdiary;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    private static App instance;
    private static DiaryDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db =  Room.databaseBuilder(getApplicationContext(),
                DiaryDatabase.class, "database").allowMainThreadQueries().build();
    }

    public static App getInstance() {
        return instance;
    }

    public DiaryDatabase getDatabase() {
        return db;
    }
}
