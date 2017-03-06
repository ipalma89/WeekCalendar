package com.ipalma.weekcalendar;

import android.databinding.ObservableField;

public class CalendarItem {

    private CalendarView clickListener;
    private int id;
    public ObservableField<String> text = new ObservableField<>("");
    public ObservableField<Integer> color = new ObservableField<>(0);
    public ObservableField<Boolean> isFirstRow = new ObservableField<>(false);

    public CalendarItem(int id) {
        this.id = id;
    }

    public CalendarItem(int id, String hour) {
        this.id = id;
        text.set(hour);
        isFirstRow.set(true);
    }

    public void setItemClickListener(CalendarView listener) {
        clickListener = listener;
    }

    public void onItemClick() {
        clickListener.onItemClick(id);
    }
}
