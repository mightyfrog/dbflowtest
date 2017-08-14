package org.mightyfrog.dbflowtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Food food = new Food();
        food.name = "honey";
        food.save();
        Ant a1 = new Ant();
        a1.name = "ant 1";
        a1.age = 1;
        a1.food = food;
        Ant a2 = new Ant();
        a2.name = "ant 2";
        a2.age = 2;
        a2.food = food;
        Queen queen = new Queen();
        queen.name = "queen";
        queen.ants = new ArrayList<>(2);
        a1.queen = queen;
        a2.queen = queen;
        queen.ants.add(a1);
        queen.ants.add(a2);
        queen.save();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Queen> queenList = SQLite.select()
                        .from(Queen.class)
                        .queryList();
                for (Queen queen : queenList) {
                    android.util.Log.e("mf", "Queen=" + queen);
                    for (Ant a : queen.ants) {
                        android.util.Log.e("mf", "Ant=" + a);
                    }
                }
                android.util.Log.e("mf", "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                List<Ant> antList = SQLite.select()
                        .from(Ant.class)
                        .queryList();
                for (Ant ant : antList) {
                    ant.load();
                    ant.queen.load();
                    ant.food.load();
                    android.util.Log.e("mf", "Ant=" + ant);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify ant parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
