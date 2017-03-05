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

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.calendar);
        int numberOfColumns = 8;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, WeekCalendarUtils.getCurrentWeekFields());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("ASD", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }

    @Override
    public String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }
}
