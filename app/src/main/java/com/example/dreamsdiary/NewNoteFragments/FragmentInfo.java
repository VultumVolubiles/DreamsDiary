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
import com.example.dreamsdiary.databinding.FragmentNewNoteInfoBinding;

import java.util.Date;

public class FragmentInfo extends Fragment {
    View view;
    FragmentNewNoteInfoBinding infoBinding;
    int favorite;
    int licuid;
    Date date;

    public FragmentInfo () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        infoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note_info, container, false);
        view = infoBinding.getRoot();
        favorite = 0;
        infoBinding.setFavorite(favorite);
        licuid = 0;
        infoBinding.setLicuid(licuid);
        date = new Date();
        infoBinding.setDate(date);
        return view;
    }
}
