package com.example.dreamsdiary.CurrentNoteFragments;

import android.databinding.DataBindingUtil;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dreamsdiary.App;
import com.example.dreamsdiary.NoteTheme;
import com.example.dreamsdiary.R;
import com.example.dreamsdiary.databinding.FragmentCurrentNoteNoteBinding;
import com.example.dreamsdiary.entities.Notes;

public class FragmentCurrentNote extends Fragment {
    View view;
    NoteTheme nTheme;
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
        nTheme = new NoteTheme(note.color, note.favorite, note.licuid);
        TextView body = view.findViewById(R.id.currentNoteBody);
        body.setMovementMethod(new ScrollingMovementMethod());
        ImageView but = view.findViewById(R.id.imageButtonFavorite);
        but.setImageResource(nTheme.iconFavorite);
        but = view.findViewById(R.id.imageButtonLicuid);
        but.setImageResource(nTheme.iconLicuid);
        fragmentCurrentNoteNoteBinding.setNote(note);
        fragmentCurrentNoteNoteBinding.setNTheme(nTheme);
        return view;
    }
}
