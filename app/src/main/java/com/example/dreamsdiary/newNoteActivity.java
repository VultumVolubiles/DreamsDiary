package com.example.dreamsdiary;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import com.example.dreamsdiary.dao.NotesDao;
import com.example.dreamsdiary.databinding.ActivityNewNoteBinding;
import com.example.dreamsdiary.entities.Notes;


import java.util.Date;

public class newNoteActivity extends AppCompatActivity {

    private ActivityNewNoteBinding activityNewNoteBinding;
    private DiaryDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Notes note = new Notes();
        note.date = new Date().toString();
        note.color = "#FB3A3A";
        activityNewNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_note);
        activityNewNoteBinding.setNote(note);
        db = App.getInstance().getDatabase();
    }

    public void addNote(View view) {
        db.notesDao().insert(activityNewNoteBinding.getNote());
        this.activityNewNoteBinding.unbind();
    }
}
