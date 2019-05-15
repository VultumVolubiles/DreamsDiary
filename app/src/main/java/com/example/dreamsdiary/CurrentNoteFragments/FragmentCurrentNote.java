package com.example.dreamsdiary.CurrentNoteFragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dreamsdiary.App;
import com.example.dreamsdiary.R;
import com.example.dreamsdiary.databinding.FragmentCurrentNoteNoteBinding;
import com.example.dreamsdiary.entities.Notes;

public class FragmentCurrentNote extends Fragment {
    View view;
    ImageView fav;
    ImageView lic;
    Notes note = new Notes();
    FragmentCurrentNoteNoteBinding fragmentCurrentNoteNoteBinding;
    public static FragmentCurrentNote newInstance(int id) {
        FragmentCurrentNote fragmentCurrentNote = new FragmentCurrentNote();

        Bundle args = new Bundle();
        args.putInt("id", id);
        fragmentCurrentNote.setArguments(args);

        return fragmentCurrentNote;
    }
    public FragmentCurrentNote() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentCurrentNoteNoteBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_note_note, container, false);
        view = fragmentCurrentNoteNoteBinding.getRoot();
        note = App.getInstance().getDatabase().notesDao().getById(getArguments().getInt("id"));
        lic = view.findViewById(R.id.imageButtonLicuid);
        fav = view.findViewById(R.id.imageButtonFavorite);
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
        fragmentCurrentNoteNoteBinding.setNote(note);
        return view;
    }
}
