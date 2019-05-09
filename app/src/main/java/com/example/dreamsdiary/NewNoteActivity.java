package com.example.dreamsdiary;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        adapter.AddFragment(new FragmentResources(), "Resources");
        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onClickSave(View view) {
        TextView v = findViewById(R.id.editDate);
        note.date = v.getText().toString();
        v = findViewById(R.id.editTitle);
        note.title = v.getText().toString();
        v = findViewById(R.id.editBody);
        note.body = v.getText().toString();
        DiaryDatabase db = App.getInstance().getDatabase();
        db.notesDao().insert(note);
        finish();
    }

    public void onClickCancel (View view) {
        finish();
    }

    public void onClickFavorite (View view) {
        if (note.favorite == 0) {
            note.favorite += 1;
            ImageView fav = findViewById(R.id.imageButtonFavorite);
            fav.setImageResource(R.drawable.ic_favorite_enabled);
        }
        else {
            note.favorite -=1;
            ImageView fav = findViewById(R.id.imageButtonFavorite);
            fav.setImageResource(R.drawable.ic_favorite);
        }
    }
    public void onClickLicuid (View view) {
        if (note.licuid == 0) {
            note.licuid += 1;
            ImageView lic = findViewById(R.id.imageButtonLicuid);
            lic.setImageResource(R.drawable.ic_licuid_enabled);
        }
        else {
            note.licuid -=1;
            ImageView lic = findViewById(R.id.imageButtonLicuid);
            lic.setImageResource(R.drawable.ic_licuid);
        }
    }
    public void onClickTheme1 (View view) {
        note.color = "#F75B50";
    }
    public void onClickTheme2(View view) {
        note.color = "#4D944A";
    }
}
