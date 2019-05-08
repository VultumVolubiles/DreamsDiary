package com.example.dreamsdiary;

import android.content.Intent;
//import android.databinding.DataBindingUtil;
//import com.example.dreamsdiary.databinding.ActivityMainBinding;
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

//    private ActivityMainBinding activityMainBinding;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigationView;
    private FragmentTransaction fragmentTransaction;

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

//        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void addNoteOnClick (View view) {
        Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
        startActivity(intent);
    }


}
