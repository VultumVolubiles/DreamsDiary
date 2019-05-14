package com.example.dreamsdiary.CurrentNoteFragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.dreamsdiary.R;
import com.example.dreamsdiary.databinding.FragmentCurrentNoteResourcesBinding;

public class FragmentResources extends Fragment {
    View view;
    FragmentCurrentNoteResourcesBinding resourcesBinding;
    String res;

    public FragmentResources () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        resourcesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_note_resources, container, false);
        view = resourcesBinding.getRoot();
        res = "Resources";
        resourcesBinding.setResources(res);
        return view;
    }

}
