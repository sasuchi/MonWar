package com.entertainment.zascha.monwar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sascha on 22.05.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = DatabaseHelper.class.getSimpleName();

    public static final String DB_NAME = "MonWarDB.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "MonsterTable";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_STATONE = "_str";
    public static final String COLUMN_STATTWO = "_agi";
    public static final String COLUMN_STATTHREE = "_int";

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME +
                                            "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            COLUMN_NAME + " TEXT NOT NULL " +
                                            COLUMN_STATONE + " INTEGER NOT NULL " +
                                            COLUMN_STATTWO + " INTEGER NOT NULL " +
                                            COLUMN_STATTHREE + " INTEGER NOT NULL);";



    public DatabaseHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
        Log.d(LOG_TAG, "" + getDatabaseName() + "wurde erfolgreich erstellt");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            Log.d(LOG_TAG, "" + SQL_CREATE + "");
            db.execSQL(SQL_CREATE);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Fail on table creation" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
