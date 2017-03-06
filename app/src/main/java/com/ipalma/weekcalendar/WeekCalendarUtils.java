package com.ipalma.weekcalendar;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class WeekCalendarUtils {

    public static List<CalendarItem> getCurrentWeekFields() {
        List<CalendarItem> calendarFields = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Calendar hour = Calendar.getInstance();
        hour.set(Calendar.HOUR_OF_DAY, 0);
        hour.set(Calendar.MINUTE, 0);

        for (int i = 0; i < 384; i++) {
            if (i % 8 == 0) {
                if (i % 16 == 0) {
                    calendarFields.add(new CalendarItem(sdf.format(hour.getTime())));
                    hour.add(Calendar.MINUTE, 60);
                } else {
                    calendarFields.add(new CalendarItem(""));
                }
            } else {
                calendarFields.add(new CalendarItem("Ev-" + i));
            }
        }

        return calendarFields;
    }
}
