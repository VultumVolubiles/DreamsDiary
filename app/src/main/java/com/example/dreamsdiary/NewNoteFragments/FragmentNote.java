package com.example.dreamsdiary.NewNoteFragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dreamsdiary.R;
import com.example.dreamsdiary.databinding.FragmentNewNoteNoteBinding;
import com.example.dreamsdiary.entities.Notes;

public class FragmentNote extends Fragment {
    View view;
    Notes note;

    FragmentNewNoteNoteBinding noteBinding;
    public FragmentNote () {

    }

    public void setNote(Notes note) {
        this.note = note;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        noteBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note_note, container, false);
        view = noteBinding.getRoot();
        ImageView lic;
        ImageView fav;
        try {
            if (note.licuid == 1) {
                lic = view.findViewById(R.id.imageButtonLicuid);
                lic.setImageResource(R.drawable.ic_licuid_enabled);
            }
            if (note.favorite == 1) {
                fav = view.findViewById(R.id.imageButtonFavorite);
                fav.setImageResource(R.drawable.ic_favorite_enabled);
            }
        } catch (NullPointerException exception) {
            note = new Notes();
        }
        noteBinding.setNote(note);
        return view;
    }


}
