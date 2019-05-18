package com.example.dreamsdiary.MainActivityFragments;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.Layout;
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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
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

        return view;
    }

    private void getChartData() {
        List<String> CountForMonth = App.getInstance().getDatabase().notesDao().getCountNotesForMonth();
        List<AxisValue> axisNotes = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            axisNotes.add(new AxisValue(i));
        }
        List<AxisValue> axisDays = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
//        calendar.add(5, -30);
        calendar.set(5, 0);
        int[] counts = new int[calendar.getActualMaximum(5)];
        String a = new String();
        int test = calendar.getActualMaximum(5);
        String[] spl = new String[CountForMonth.size()];
        for (int i = 0; i < calendar.getActualMaximum(5)-1; i++) {
            for (int c = CountForMonth.size()-1; c >= 0; c--) {
                a = CountForMonth.get(c);
                spl = a.split("=");
                int d = Integer.parseInt(String.valueOf(a.charAt(8)) + String.valueOf(a.charAt(9)));
                int m = Integer.parseInt(String.valueOf(a.charAt(5)) + String.valueOf(a.charAt(6)));
                if (d-1 == calendar.get(5) & m-1 == calendar.get(2)) {
                    counts[i] = Integer.parseInt(spl[1]);
                    break;
                }
                else {
                    if (i == calendar.getActualMaximum(5)) {
                        break;
                    }
                    counts[i] = 0;
                    continue;
                }
            }
            calendar.add(5, 1);
            axisDays.add(new AxisValue(calendar.get(5)+1));
        }
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < 1; ++i) {
            List<PointValue> values = new ArrayList<>();
            for (int j = 0; j < counts.length; ++j) {
                values.add(new PointValue(j, counts[j]));
            }
            Line line = new Line(values);
            line.setColor(ChartUtils.COLOR_BLUE);
            line.setCubic(true);
            line.setFilled(true);
            line.setHasLabels(true);
            line.setHasLines(true);
            line.setHasPoints(false);
            lines.add(line);
        }
        lineData = new LineChartData(lines);

        Axis axisX = new Axis().setHasLines(true);
        Axis axisY = new Axis().setHasLines(true);
        axisX.setName(getString(R.string.axisDays)).setValues(axisDays);
        axisY.setName(getString(R.string.axisNotes)).setValues(axisNotes).setAutoGenerated(false).setInside(false);
        lineData.setAxisXBottom(axisX);
        lineData.setAxisYLeft(axisY);
        lineData.setBaseValue(Float.NEGATIVE_INFINITY);
        lineChart.setLineChartData(lineData);
        lineChart.setZoomEnabled(true);
        lineChart.setZoomLevel(4, 4, 4);
        lineChart.setMaxZoom(5);
        lineChart.setZoomType(ZoomType.HORIZONTAL);

        //pieChart setup
        List<SliceValue> pieValues = new ArrayList<>();
        //set count All
        pieValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countAll(), ChartUtils.COLOR_BLUE));
        //set count Licuid
        pieValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countLicuid(), ChartUtils.COLOR_VIOLET));


        pieData = new PieChartData(pieValues);
        pieData.setHasLabels(true);
        pieData.setHasLabelsOnlyForSelected(false);
        pieData.setHasLabelsOutside(false);
        pieData.setHasCenterCircle(false);
        pieChart.setPieChartData(pieData);
        pieChart.setChartRotationEnabled(false);
    }
}
