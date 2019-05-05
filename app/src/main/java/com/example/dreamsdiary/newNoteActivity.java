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
    private Notes note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        note = new Notes();
        activityNewNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_note);
        activityNewNoteBinding.setNote(note);
//        activityNewNoteBinding.setCount(0);
    }

    public void onSaveClick (View view) {
        DiaryDatabase db = App.getInstance().getDatabase();
//        note.color="#DCD3D3";
//        note.date= "03/05/2019";
//        note.favorite = 1;
//        note.licuid = 1;
        db.notesDao().insert(note);
//        int i = db.notesDao().countAll();
//        activityNewNoteBinding.setCount(i);
    }
}
