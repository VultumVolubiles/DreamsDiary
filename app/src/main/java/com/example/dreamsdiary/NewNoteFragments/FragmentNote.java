package com.example.dreamsdiary.NewNoteFragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dreamsdiary.R;
import com.example.dreamsdiary.databinding.FragmentNewNoteNoteBinding;

public class FragmentNote extends Fragment {
    View view;

    String title;
    String body;

    FragmentNewNoteNoteBinding noteBinding;
    public FragmentNote () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_new_note_note, container, false);
        noteBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note_note, container, false);
        view = noteBinding.getRoot();
        noteBinding.setTitle(title);
        noteBinding.setBody(body);
        return view;

    }

}
