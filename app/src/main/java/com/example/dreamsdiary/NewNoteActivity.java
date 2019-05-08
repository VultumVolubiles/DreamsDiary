package com.example.dreamsdiary;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import com.example.dreamsdiary.NewNoteFragments.FragmentInfo;
import com.example.dreamsdiary.NewNoteFragments.FragmentNote;
import com.example.dreamsdiary.NewNoteFragments.FragmentResources;
import com.example.dreamsdiary.entities.Notes;


public class NewNoteActivity extends AppCompatActivity {

    private Notes note;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NewNoteViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        note = new Notes();
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new NewNoteViewPagerAdapter(getSupportFragmentManager());
        //adding fragments
        adapter.AddFragment(new FragmentNote(), "Note");
        adapter.AddFragment(new FragmentInfo(), "Info");
        adapter.AddFragment(new FragmentResources(), "Resources");
        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

//        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year,
//                                            int month, int dayOfMonth) {
//                int mYear = year;
//                int mMonth = month;
//                int mDay = dayOfMonth;
//                String selectedDate = new StringBuilder().append(mMonth + 1)
//                        .append("-").append(mDay).append("-").append(mYear)
//                        .append(" ").toString();
//                note.date = selectedDate;
//            }
//        });

    }

    public void onSaveClick (View view) {
//        TextView tView = findViewById(R.id.editTitle);
        Notes newNote;
        note.title = "j";
        String body;
        String date;
        String color = "#33CCB366";
        int favorite;
        int licuid;

        newNote = new Notes();
//        newNote = new Notes(title,body,date,color,favorite,licuid);
        DiaryDatabase db = App.getInstance().getDatabase();
        db.notesDao().insert(newNote);
    }
}
