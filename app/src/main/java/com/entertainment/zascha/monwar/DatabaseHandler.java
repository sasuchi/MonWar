package com.entertainment.zascha.monwar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sascha on 22.05.2016.
 */
public class DatabaseHandler {

    private static final String LOG_TAG = DatabaseHandler.class.getSimpleName();

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] columns = {DatabaseHelper.COLUMN_NAME,
            DatabaseHelper.COLUMN_STATONE,
            DatabaseHelper.COLUMN_STATTWO,
            DatabaseHelper.COLUMN_STATTHREE};

    public DatabaseHandler(Context context) {
        Log.d(LOG_TAG, "DB Helper creation");
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        Log.d(LOG_TAG, "Referenzabfrage");
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Pfad:" + database.getPath());
    }

    public void close() {
        dbHelper.close();
        Log.d(LOG_TAG, "DB erfolgreich geschlossen");
    }

    public Monster createDatabaseHandler(String name, int[] stats) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_STATONE, stats[0]);
        values.put(DatabaseHelper.COLUMN_STATTWO, stats[1]);
        values.put(DatabaseHelper.COLUMN_STATTHREE, stats[2]);

        long insertID = database.insert(DatabaseHelper.TABLE_NAME, null, values);

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, DatabaseHelper.COLUMN_ID
                + "=" + insertID, null, null, null, null);

        cursor.moveToFirst();
        Monster monster = cursorToMonster(cursor);
        cursor.close();

        return monster;
    }

    public Monster cursorToMonster(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
        int idName = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
        int idStatOne = cursor.getColumnIndex(DatabaseHelper.COLUMN_STATONE);
        int idStatTwo = cursor.getColumnIndex(DatabaseHelper.COLUMN_STATTWO);
        int idStatThree = cursor.getColumnIndex(DatabaseHelper.COLUMN_STATTHREE);

        String name = cursor.getString(idName);
        int[] stats = {cursor.getInt(idStatOne), cursor.getInt(idStatTwo), cursor.getInt(idStatThree)};
        long id = cursor.getLong(idIndex);

        Monster monster = new Monster(((int) id), name, stats);

        return monster;
    }

    public List<Monster> getAllMonsters() {

        List<Monster> monsterList = new ArrayList<>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);

        cursor.moveToFirst();
        Monster monster;

        while (!cursor.isAfterLast()) {
            monster = cursorToMonster(cursor);
            monsterList.add(monster);
            /*
            Log.d(LOG_TAG, "ID" + monster.getName() + ", Str" + monster.getStats()[0]
                                                    + ", Agi" + monster.getStats()[1]
                                                    + ", Hp"  + monster.getStats()[2]);
            */
            Log.d(LOG_TAG, "ID" + monster.getId() + "Inhalt:" + monster.toString());
            cursor.moveToNext();
        }

        cursor.close();

        return monsterList;
    }
}