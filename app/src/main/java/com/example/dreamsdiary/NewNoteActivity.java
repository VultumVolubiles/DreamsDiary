package com.example.dreamsdiary;

import android.content.Intent;
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
        private NoteViewPagerAdapter adapter;
        private boolean edit;
        private int id;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_note);
        Bundle arguments = getIntent().getExtras();
        if (arguments!=null) {
            id = (int) arguments.getSerializable("id");
            note = App.getInstance().getDatabase().notesDao().getById(id);
            this.edit = true;
        }
        else {
            note = new Notes();
            this.edit = false;
        }
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new NoteViewPagerAdapter(getSupportFragmentManager());
        //adding fragments
        FragmentNote fragmentNote = new FragmentNote();
        fragmentNote.setNote(note);
        adapter.AddFragment(fragmentNote, getString(R.string.tabNote));
        adapter.AddFragment(new FragmentResources(), getString(R.string.tabResources));
        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onClickSave(View view) {
        TextView v = findViewById(R.id.currentNoteDate);
        note.date = v.getText().toString();
        v = findViewById(R.id.currentNoteTitle);
        note.title = v.getText().toString();
        v = findViewById(R.id.currentNoteBody);
        note.body = v.getText().toString();
        DiaryDatabase db = App.getInstance().getDatabase();
        if (this.edit) {
            db.notesDao().update(note);
            Intent intent = new Intent();
            intent.putExtra("id", note.id);
            setResult(RESULT_OK, intent);
        }
        else {
        db.notesDao().insert(note);
        }
        finish();
    }

    public void onClickCancel (View view) {
        Intent intent = new Intent();
        intent.putExtra("id", note.id);
        setResult(RESULT_OK, intent);
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
