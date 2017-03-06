package com.ipalma.weekcalendar;

import android.databinding.ObservableField;

public class CalendarItem {

    public ObservableField<String> text = new ObservableField<>("");
    public ObservableField<Integer> color = new ObservableField<>(0);
    public ObservableField<Boolean> isFirstRow = new ObservableField<>(false);

    public CalendarItem() {

    }

    public CalendarItem(String hour) {
        text.set(hour);
        isFirstRow.set(true);
    }
}
