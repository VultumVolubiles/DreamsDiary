package com.example.dreamsdiary.MainActivityFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dreamsdiary.App;
import com.example.dreamsdiary.DiaryDatabase;
import com.example.dreamsdiary.R;
import com.example.dreamsdiary.entities.Notes;
import com.example.dreamsdiary.notesAdapter;

import java.util.List;

public class FragmentDiary extends Fragment {
    View view;
    notesAdapter adapter;
    Notes notes;
    DiaryDatabase db;

    public FragmentDiary() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_diary, container, false);
        db = App.getInstance().getDatabase();
        List<Notes> listNotes = db.notesDao().getAll();
        if (listNotes.size() > 0){
            for(Notes note : listNotes){
                notes = note;
                break;
            }
        }
        else {
            notes = new Notes();
            notes.title = "";
            notes.body = "Database don't have a notes.";
        }
        //Setup notes recyclerView
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter = new notesAdapter(listNotes);
        rv.setAdapter(adapter);

        return view;
    }
}
