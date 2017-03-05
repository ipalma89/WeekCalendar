package com.ipalma.weekcalendar;


import com.ipalma.weekcalendar.databinding.CalendarHeaderBinding;

import java.util.Calendar;

public class CalendarViewModel {

    private CalendarView view;
    private int currentWeek;

    public CalendarViewModel(CalendarView view) {
        this.view = view;
        init();
    }

    private void init() {

    }

    public void showNextWeek() {
        currentWeek += 7;
        Calendar nextWeek = Calendar.getInstance();
        nextWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        nextWeek.add(Calendar.DAY_OF_MONTH, currentWeek);
//        weekView.goToDate(nextWeek);
    }

    public void showPreviousWeek() {
        currentWeek -= 7;
        Calendar previousWeek = Calendar.getInstance();
        previousWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        previousWeek.add(Calendar.DAY_OF_MONTH, currentWeek);
//        weekView.goToDate(previousWeek);
    }

    public void setCalendarHeader(CalendarHeaderBinding calendarHeader) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
    }
}
