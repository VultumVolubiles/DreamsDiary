package com.example.dreamsdiary.MainActivityFragments;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dreamsdiary.App;
import com.example.dreamsdiary.DiaryDatabase;
import com.example.dreamsdiary.NewNoteFragments.LinearGraphicValues;
import com.example.dreamsdiary.R;
import com.example.dreamsdiary.databinding.FragmentStatisticBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

public class FragmentStatistic extends Fragment {

    private LineChartView lineChart;
    private PieChartView pieChart;
    private LineChartData lineData;
    private PieChartData pieData;

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
        lineChart = view.findViewById(R.id.linearGraphic);
        pieChart = view.findViewById(R.id.pieChartView);
        getChartData();
        //add scrolling
//        ConstraintLayout statistic = view.findViewById(R.id.statisticContainer);
//        statistic.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }

    private void getChartData() {
        List<String> test = App.getInstance().getDatabase().notesDao().getCountNotesForMonth();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < 1; ++i) {
//            int[] counts = App.getInstance().getDatabase().notesDao().getCountNotesForMonth();
            List<PointValue> values = new ArrayList<>();
//            for (int j = 0; j < counts.length; ++j) {
//                values.add(new PointValue(j, counts[j]));
//            }
            Line line = new Line(values);
            line.setColor(ChartUtils.COLOR_BLUE);
            line.setCubic(true);
            line.setFilled(true);
            line.setHasLabels(true);
            line.setHasLines(true);
            line.setHasPoints(true);
            lines.add(line);
        }
        lineData = new LineChartData(lines);
        Axis axisX = new Axis();
        Axis axisY = new Axis().setHasLines(true);
        axisX.setName("Days");
        axisY.setName("Notes");
        lineData.setAxisXBottom(axisX);
        lineData.setAxisYLeft(axisY);
        lineData.setBaseValue(Float.NEGATIVE_INFINITY);
        lineChart.setLineChartData(lineData);

        //pieChart setup
        List<SliceValue> pieValues = new ArrayList<>();
        //set count All
        pieValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countAll(), ChartUtils.COLOR_BLUE));
        //set count Licuid
        pieValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countLicuid(), ChartUtils.COLOR_VIOLET));


        pieData = new PieChartData(pieValues);
        pieData.setHasLabels(true);
        pieData.setHasLabelsOnlyForSelected(false);
        pieData.setHasLabelsOutside(true);
        pieData.setHasCenterCircle(false);
        pieChart.setPieChartData(pieData);
    }

    public void onClickStatisticFavorite(View view) {
        List<SliceValue> newValues = new ArrayList<>();
        //set count All
        newValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countAll(), ChartUtils.COLOR_BLUE));
        //set count Favorite
        newValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countLicuid(), ChartUtils.COLOR_ORANGE));
        pieData.setValues(newValues);
    }
    public void onClickStatisticLicuid (View view) {
        List<SliceValue> newValues = new ArrayList<>();
        //set count All
        newValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countAll(), ChartUtils.COLOR_BLUE));
        //set count Licuid
        newValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countLicuid(), ChartUtils.COLOR_VIOLET));
        pieData.setValues(newValues);
    }
}
