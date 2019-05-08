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
import com.example.dreamsdiary.databinding.FragmentNewNoteResourcesBinding;

public class FragmentResources extends Fragment {
    View view;
    FragmentNewNoteResourcesBinding resourcesBinding;
    String res;

    public FragmentResources () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_new_note_resources, container, false);
        resourcesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note_resources, container, false);
        view = resourcesBinding.getRoot();
        res = "Resources";
        resourcesBinding.setResources(res);
        return view;
    }

}
