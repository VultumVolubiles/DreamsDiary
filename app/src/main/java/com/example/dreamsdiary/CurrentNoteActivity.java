package com.example.dreamsdiary;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dreamsdiary.CurrentNoteFragments.FragmentNote;
import com.example.dreamsdiary.CurrentNoteFragments.FragmentResources;
import com.example.dreamsdiary.entities.Notes;

public class CurrentNoteActivity extends AppCompatActivity {


    private Notes note;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NewNoteViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_note);
        Bundle arguments = getIntent().getExtras();
        if (arguments!=null) {
            note = (Notes) arguments.getSerializable(Notes.class.getSimpleName());
        }
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new NewNoteViewPagerAdapter(getSupportFragmentManager());
        //adding fragments
        FragmentNote fragmentNote = new FragmentNote();
        fragmentNote.setNote(note);
        adapter.AddFragment(fragmentNote, "Note");
        adapter.AddFragment(new FragmentResources(), "Resources");
        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onClickCancel (View view) {
        finish();
    }
    public void onClickEdit (View view) {
        Intent intent = new Intent(this, NewNoteActivity.class);
        intent.putExtra(Notes.class.getSimpleName(), note);
        startActivity(intent);
    }
}
