package com.entertainment.zascha.monwar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sascha on 22.05.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private final String LOG_TAG = DatabaseHelper.class.getSimpleName();

    public DatabaseHelper(Context context){
        super(context,"MonsterDatabse",null,1);
        Log.d(LOG_TAG, "" + getDatabaseName() + "wurde erfolgreich erstellt");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
