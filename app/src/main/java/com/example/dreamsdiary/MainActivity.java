package com.example.dreamsdiary;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.dreamsdiary.databinding.ActivityMainBinding;
import com.example.dreamsdiary.entities.Notes;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private DiaryDatabase db;
    private Notes notes;
    private RecyclerView.Adapter adapter;
    private int count;
    private ActivityMainBinding activityMainBinding;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        Intent intent;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_diary:

                    return true;
                case R.id.navigation_statistic:
                    intent = new Intent(MainActivity.this, StatisticActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_settings:
                    intent = new Intent(MainActivity.this, DebugActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = App.getInstance().getDatabase();
        List<Notes> listNotes = db.notesDao().getAll();
        if (listNotes.size() > 0){
            for(Notes note : listNotes){
                notes = note;
                break;
            }
        }
        else {
            notes = new Notes();
            notes.title = "";
            notes.body = "Database don't have a notes.";
        }
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setNotes(notes);
        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new notesAdapter(listNotes);
        rv.setAdapter(adapter);
//        notes = new Notes();
        count = 0;


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void addNoteOnClick (View view) {
        Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
        startActivity(intent);
    }


}
