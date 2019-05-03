package com.example.dreamsdiary;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.dreamsdiary.databinding.ActivityMainBinding;
import com.example.dreamsdiary.entities.Notes;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ActivityMainBinding activityMainBinding;
    private DiaryDatabase db;
    private Notes notes;
    private int count;

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
        notes = new Notes();
        count = 0;
        notes.body = "text of note";
        notes.title = "first note";
        notes.date = "03/05/2019";
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        db = App.getInstance().getDatabase();
        activityMainBinding.setNotes(notes);
//        System.out.println(db.notesDao().countAll());
//        count = db.notesDao().countAll();
//        activityMainBinding.setCount(String.valueOf(count));

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

    public void addNoteOnClick (View view) {
        Intent intent = new Intent(MainActivity.this, newNoteActivity.class);
        startActivity(intent);
    }

}