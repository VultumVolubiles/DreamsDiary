package com.example.dreamsdiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dreamsdiary.entities.Notes;

public class debugActivity extends AppCompatActivity {
    private DiaryDatabase db;
    private Notes notes;
    private debugFuntions debug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        db = App.getInstance().getDatabase();
        debug = new debugFuntions();
    }

    public void onClickDeleteAllNotes(View view) {
        debug.deleteAllNotes(db);
    }

    public void onClickFillNotes(View view) {
        debug.fillNotes(db);
    }
}
