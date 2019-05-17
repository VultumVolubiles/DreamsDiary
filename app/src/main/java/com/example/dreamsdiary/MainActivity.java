package com.example.dreamsdiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dreamsdiary.MainActivityFragments.FragmentDebug;
import com.example.dreamsdiary.MainActivityFragments.FragmentDiary;
import com.example.dreamsdiary.MainActivityFragments.FragmentStatistic;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

public class MainActivity extends AppCompatActivity{

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigationView;
    private FragmentTransaction fragmentTransaction;
    private debugFuntions debug = new debugFuntions();
    private DiaryDatabase db = App.getInstance().getDatabase();
    private PieChartData pieData;
    private PieChartView pieChart;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_diary:
                    fragment = new FragmentDiary();
                    break;
                case R.id.navigation_statistic:
                    fragment = new FragmentStatistic();
                    break;
                case R.id.navigation_settings:
                    fragment = new FragmentDebug();
                    break;
            }
            fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new FragmentDiary();
        pieChart = findViewById(R.id.pieChartView);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(new FragmentStatistic(), getString(R.string.title_statistic));
        fragmentTransaction.add(new FragmentDiary(), getString(R.string.title_diary));
        fragmentTransaction.add(new FragmentDebug(), getString(R.string.title_settings));
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
        startActivity(intent);

    }

    public void onClickDeleteAllNotes(View view) {
        debug.deleteAllNotes(db);
    }

    public void onClickFillNotes(View view) {
        debug.fillNotes(db);
    }

    public void onClickAddFavoriteNote(View view) {
        debug.addFavoriteNote(db);
    }

    public void onClickAddLicuidNote(View view) {
        debug.addLicuidNote(db);
    }

    public void onClickAddLFNote(View view) {
        debug.addLFNote(db);
    }

    public void onClickStatisticFavorite(View view) {
        List<SliceValue> newValues = new ArrayList<>();
        newValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countAll()-App.getInstance().getDatabase().notesDao().countFavorite(), ChartUtils.COLOR_BLUE));
        newValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countFavorite(), ChartUtils.COLOR_ORANGE));
        TextView text = this.findViewById(R.id.textPieCount);
        text.setText(R.string.statisticFavoriteNotes);
        text = this.findViewById(R.id.statisticPieChartTitle);
        text.setText(R.string.statisticPieChartTitleF);
        ImageView image = this.findViewById(R.id.imagePieCount);
        image.setImageResource(R.color.colorIconEnabledF);
        image = this.findViewById(R.id.buttonStatisticF);
        image.setImageResource(R.drawable.ic_favorite_enabled);
        image = this.findViewById(R.id.buttonStatisticL);
        image.setImageResource(R.drawable.ic_licuid);
        pieData = new PieChartData(newValues);
        pieData.setHasLabels(true);
        pieData.setHasLabelsOnlyForSelected(false);
        pieData.setHasLabelsOutside(false);
        pieData.setHasCenterCircle(false);
        pieChart = this.findViewById(R.id.pieChartView);
        pieChart.setPieChartData(pieData);
    }
    public void onClickStatisticLicuid (View view) {
        List<SliceValue> newValues = new ArrayList<>();
        newValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countAll()-App.getInstance().getDatabase().notesDao().countLicuid(), ChartUtils.COLOR_BLUE));
        newValues.add(new SliceValue(App.getInstance().getDatabase().notesDao().countLicuid(), ChartUtils.COLOR_VIOLET));
        TextView text = this.findViewById(R.id.textPieCount);
        text.setText(R.string.statisticLicuidNotes);
        text = this.findViewById(R.id.statisticPieChartTitle);
        text.setText(R.string.statisticPieChartTitleL);
        ImageView image = this.findViewById(R.id.imagePieCount);
        image.setImageResource(R.color.colorIconEnabledL);
        image = this.findViewById(R.id.buttonStatisticL);
        image.setImageResource(R.drawable.ic_licuid_enabled);
        image = this.findViewById(R.id.buttonStatisticF);
        image.setImageResource(R.drawable.ic_favorite);
        pieData = new PieChartData(newValues);
        pieData = new PieChartData(newValues);
        pieData.setHasLabels(true);
        pieData.setHasLabelsOnlyForSelected(false);
        pieData.setHasLabelsOutside(false);
        pieData.setHasCenterCircle(false);
        pieChart = this.findViewById(R.id.pieChartView);
        pieChart.setPieChartData(pieData);
    }

    public void setLangRu (View view) {

    }

    public void setLangEn (View view) {
    }
}
