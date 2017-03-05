package com.ipalma.weekcalendar;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ipalma.weekcalendar.databinding.ActivityCalendarBinding;

public class CalendarActivity extends AppCompatActivity implements CalendarView, MyRecyclerViewAdapter.ItemClickListener {

    private ActivityCalendarBinding binding;
    private CalendarViewModel viewModel;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calendar);
        viewModel = new CalendarViewModel(this);
        binding.setViewModel(viewModel);
        viewModel.setCalendarHeader(binding.calendarHeader);

        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42",
                "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42",
                "43", "44", "45", "46", "47", "48"};

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.calendar);
        int numberOfColumns = 8;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("ASD", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }
}
