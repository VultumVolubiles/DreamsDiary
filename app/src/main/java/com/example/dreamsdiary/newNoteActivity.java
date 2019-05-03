package com.example.dreamsdiary;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dreamsdiary.databinding.ActivityNewNoteBinding;
import com.example.dreamsdiary.entities.Notes;

import java.util.Date;

public class newNoteActivity extends AppCompatActivity {

    private ActivityNewNoteBinding activityNewNoteBinding;
    private Notes note = new Notes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_new_note);
        activityNewNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_note);
        activityNewNoteBinding.setNote(note);
    }

    public void onSaveClick (View view) {
        DiaryDatabase db = App.getInstance().getDatabase();
        note.color="#DCD3D3";
        note.date= new Date().toString();
        note.favorite = 1;
        note.licuid = 1;
        db.notesDao().insert(note);

    }
}
