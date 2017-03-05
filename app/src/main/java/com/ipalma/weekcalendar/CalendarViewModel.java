package com.ipalma.weekcalendar;


import android.databinding.ObservableArrayMap;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarViewModel {

    public ObservableArrayMap<String, String> daysHeader = new ObservableArrayMap<>();

    private CalendarView view;
    private Calendar currentWeek;

    public CalendarViewModel(CalendarView view) {
        this.view = view;
        init();
    }

    private void init() {
        initCalendar();
        setCalendarHeader();
    }

    private void initCalendar() {
        currentWeek = Calendar.getInstance();
        currentWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    }

    public void showNextWeek() {
        currentWeek.add(Calendar.DAY_OF_MONTH, 7);
        setCalendarHeader();
    }

    public void showPreviousWeek() {
        currentWeek.add(Calendar.DAY_OF_MONTH, -7);
        setCalendarHeader();
    }

    private void setCalendarHeader() {
        Calendar week = (Calendar) currentWeek.clone();
        String[] days = view.getStringArray(R.array.days_array);
        SimpleDateFormat sdf = new SimpleDateFormat("d/M", Locale.getDefault());

        for (int i = 1; i <= 7; i++) {
            daysHeader.put("day" + i, String.format(days[i-1], sdf.format(week.getTime())));
            week.add(Calendar.DAY_OF_WEEK, 1);
        }
    }
}
