package com.example.dreamsdiary;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dreamsdiary.CurrentNoteFragments.FragmentCurrentNote;
import com.example.dreamsdiary.CurrentNoteFragments.FragmentResources;
import com.example.dreamsdiary.entities.Notes;

public class CurrentNoteActivity extends AppCompatActivity {

    private Notes note;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NoteViewPagerAdapter adapter;
    private int id;
    final int REQUEST_CODE_NOTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_note);
        FragmentCurrentNote fragmentNote = new FragmentCurrentNote();
        Bundle arguments = getIntent().getExtras();
        if (arguments!=null) {
            id = (int) arguments.getSerializable("id");
            fragmentNote.setArguments(arguments);
            note = App.getInstance().getDatabase().notesDao().getById(id);
        }
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new NoteViewPagerAdapter(getSupportFragmentManager());
        //adding fragments
        adapter.AddFragment(fragmentNote, "Note");
        adapter.AddFragment(new FragmentResources(), "Resources");
        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onClickCancel (View view)
    {
        finish();
    }

    public void onClickEdit (View view) {
        Intent intent = new Intent(this, NewNoteActivity.class);
        intent.putExtra("id", id);
        startActivityForResult(intent, REQUEST_CODE_NOTE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK) {
//            note = App.getInstance().getDatabase().notesDao().getById(data.getIntExtra("id", id));
//            FragmentCurrentNote fn = new FragmentCurrentNote();
//            fn.setCurrentNote(note);
//            adapter.ReplaceFragment(0, fn);
        }
        else {
//            note = App.getInstance().getDatabase().notesDao().getById(data.getIntExtra("id", id));
//            FragmentCurrentNote fn = new FragmentCurrentNote();
//            fn.setCurrentNote(note);
//            adapter.ReplaceFragment(0, fn);
        }
    }
}
