package com.example.dreamsdiary;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dreamsdiary.NewNoteViewPager.FragmentInfo;
import com.example.dreamsdiary.NewNoteViewPager.FragmentNote;
import com.example.dreamsdiary.NewNoteViewPager.FragmentResources;
import com.example.dreamsdiary.NewNoteViewPager.NewNoteViewPagerAdapter;
import com.example.dreamsdiary.databinding.ActivityNewNoteBinding;
import com.example.dreamsdiary.entities.Notes;


public class NewNoteActivity extends AppCompatActivity {

//    private ActivityNewNoteBinding activityNewNoteBinding;
    private Notes note;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NewNoteViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        note = new Notes();
//        activityNewNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_note);
//        activityNewNoteBinding.setNote(note);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new NewNoteViewPagerAdapter(getSupportFragmentManager());
        //adding fragments
        adapter.AddFragment(new FragmentInfo(), "Info");
        adapter.AddFragment(new FragmentNote(), "Note");
        adapter.AddFragment(new FragmentResources(), "Resources");
        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onSaveClick (View view) {
        Notes newNote;
        String title;
        String body;
        String date;
        String color = "#33CCB366";
        int favorite;
        int licuid;

//        adapter.getItem(0).getView().

        newNote = new Notes();
//        newNote = new Notes(title,body,date,color,favorite,licuid);
        DiaryDatabase db = App.getInstance().getDatabase();
        db.notesDao().insert(newNote);
    }
}
