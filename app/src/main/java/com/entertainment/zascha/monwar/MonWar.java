package com.entertainment.zascha.monwar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MonWar extends AppCompatActivity {

    private static final String LOG_TAG = MonWar.class.getSimpleName();

    private DatabaseHandler dataField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_war);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Monster testMonster = new Monster(1, "pikachu", new int[] {1,2,3} );
        Log.d(LOG_TAG,"" + testMonster.toString());

        dataField = new DatabaseHandler(this);

        Log.d(LOG_TAG,"Öffne DB");
        dataField.open();

        Monster monster = dataField.createDatabaseHandler("Pichaku", new int[]{1,2,2});
        Log.d(LOG_TAG, "New Monster:");
        Log.d(LOG_TAG, "ID:" + monster.getId() + "Inhalt:" + monster.toString());

        Log.d(LOG_TAG, "Complete List of Monsters");
        showAllListEntries();

        Log.d(LOG_TAG,"Schließe DB");
        dataField.close();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mon_war, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAllListEntries(){
        List<Monster> monsterList = dataField.getAllMonsters();

        ArrayAdapter<Monster> monsterArrayAdapter = new ArrayAdapter<>( this,
                android.R.layout.simple_list_item_multiple_choice,monsterList);

        ListView monsterListView = (ListView) findViewById(R.id.listview_monster);
        monsterListView.setAdapter(monsterArrayAdapter);
    }
}
