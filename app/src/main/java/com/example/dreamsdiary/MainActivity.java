package com.example.dreamsdiary;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.dreamsdiary.App;
import com.example.dreamsdiary.databinding.ActivityMainBinding;
import com.example.dreamsdiary.entities.Notes;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private String noNotes;
    private ActivityMainBinding activityMainBinding;
    private DiaryDatabase db;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_diary:
                    mTextMessage.setText(R.string.title_diary);
                    return true;
                case R.id.navigation_statistic:
                    mTextMessage.setText(R.string.title_statistic);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.title_settings);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Notes notes = new Notes();
        notes.body = "text of note";
        notes.title = "first note";
        notes.date = "03/05/2019";
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        db = App.getInstance().getDatabase();
        activityMainBinding.setNotes(notes);

//        if (db.notesDao().countAll() == 0) {
//            noNotes = "You don't have notes";
//        }
//        else {
//            noNotes = "You have notes";
//        }

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void addNoteOnClic (View view) {
        Intent intent = new Intent(MainActivity.this, newNoteActivity.class);
        startActivity(intent);
    }

}