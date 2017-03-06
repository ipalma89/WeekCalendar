package com.ipalma.weekcalendar;

import android.databinding.ObservableField;

public class CalendarItem {

    public ObservableField<String> event = new ObservableField<>("");

    public CalendarItem(String event) {
        this.event.set(event);
    }
}
