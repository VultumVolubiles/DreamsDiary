package com.example.dreamsdiary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.dreamsdiary.entities.Notes;

public class DebugActivity extends AppCompatActivity {
    private DiaryDatabase db;
    private Notes notes;
    private debugFuntions debug;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        Intent intent;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_diary:
                    intent = new Intent(DebugActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_statistic:
                    intent = new Intent(DebugActivity.this, StatisticActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_settings:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        db = App.getInstance().getDatabase();
        debug = new debugFuntions();
    }

    public void onClickDeleteAllNotes(View view) {
        debug.deleteAllNotes(db);
    }

    public void onClickFillNotes(View view) {
        debug.fillNotes(db);
    }

    public void onClicAddFavoriteNote(View view) {
        debug.addFavoriteNote(db);
    }

    public void onClickAddLicuidNote(View view) {
        debug.addLicuidNote(db);
    }

    public void onClickAddLFNote(View view) {
        debug.addLFNote(db);
    }

    public void onClickOpenTabs(View view) {
//        Intent intent = new Intent(DebugActivity.this, nNoteActivity.class);
//        startActivity(intent);
    }
}
