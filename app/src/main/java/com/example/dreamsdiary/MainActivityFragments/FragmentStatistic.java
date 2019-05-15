package com.example.dreamsdiary.MainActivityFragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dreamsdiary.App;
import com.example.dreamsdiary.DiaryDatabase;
import com.example.dreamsdiary.R;
import com.example.dreamsdiary.databinding.FragmentStatisticBinding;

public class FragmentStatistic extends Fragment {

    DiaryDatabase db;
    String all;
    String fav;
    String lic;
    FragmentStatisticBinding fragmentStatisticBinding;
    View view;

    public FragmentStatistic() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentStatisticBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_statistic, container, false);
        view = fragmentStatisticBinding.getRoot();
        db = App.getInstance().getDatabase();
        all = String.valueOf(db.notesDao().countAll());
        fragmentStatisticBinding.setAll(all);
        fav = String.valueOf(db.notesDao().countFavorite());
        fragmentStatisticBinding.setFav(fav);
        lic = String.valueOf(db.notesDao().countLicuid());
        fragmentStatisticBinding.setLic(lic);
        return view;
    }
}
