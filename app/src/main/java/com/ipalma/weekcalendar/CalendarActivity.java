package com.ipalma.weekcalendar;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ipalma.weekcalendar.databinding.ActivityCalendarBinding;

public class CalendarActivity extends AppCompatActivity implements CalendarView {

    private ActivityCalendarBinding binding;
    private CalendarViewModel viewModel;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calendar);

        binding.calendarRecyclerView.setLayoutManager(new GridLayoutManager(this, 8));
        adapter = new MyRecyclerViewAdapter(this, WeekCalendarUtils.getCurrentWeekFields());
        adapter.setClickListener(this);
        binding.calendarRecyclerView.setAdapter(adapter);

        viewModel = new CalendarViewModel(this);
        binding.setViewModel(viewModel);
    }

    @Override
    public void onItemClick() {
//        Log.i("ASD", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }

    @Override
    public String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }
}
