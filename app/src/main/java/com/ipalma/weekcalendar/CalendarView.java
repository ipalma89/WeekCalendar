package com.ipalma.weekcalendar;


import android.support.annotation.StringRes;

public interface CalendarView {

    String getString(@StringRes int stringRes, Object... args);

    String[] getStringArray(int resId);

    void onItemClick(int id);
}
