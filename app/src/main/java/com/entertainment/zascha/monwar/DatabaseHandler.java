package com.entertainment.zascha.monwar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Sascha on 22.05.2016.
 */
public class DatabaseHandler {

    private static final String LOG_TAG = DatabaseHandler.class.getSimpleName();

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public DatabaseHandler(Context context){
        Log.d(LOG_TAG,"DB Helper creation");
        dbHelper = new DatabaseHelper(context);
    }
}
