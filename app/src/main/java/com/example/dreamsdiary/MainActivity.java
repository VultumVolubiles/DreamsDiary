package com.example.dreamsdiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.dreamsdiary.MainActivityFragments.FragmentDebug;
import com.example.dreamsdiary.MainActivityFragments.FragmentDiary;
import com.example.dreamsdiary.MainActivityFragments.FragmentStatistic;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigationView;
    private FragmentTransaction fragmentTransaction;
    private debugFuntions debug = new debugFuntions();
    private DiaryDatabase db = App.getInstance().getDatabase();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_diary:
                    fragment = new FragmentDiary();
                    break;
                case R.id.navigation_statistic:
                    fragment = new FragmentStatistic();
                    break;
                case R.id.navigation_settings:
                    fragment = new FragmentDebug();
                    break;
            }
            fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new FragmentDiary();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(new FragmentStatistic(), "Statistic");
        fragmentTransaction.add(new FragmentDiary(), "Diary");
        fragmentTransaction.add(new FragmentDebug(), "Debug");
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void addNoteOnClick (View view) {
        Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
        startActivity(intent);
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
}
