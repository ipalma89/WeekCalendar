package com.ipalma.weekcalendar;


import android.annotation.SuppressLint;

import java.text.ParseException;
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
                calendarFields.add(new CalendarItem(i, sdf.format(hour.getTime())));
                hour.add(Calendar.MINUTE, 30);
            } else {
                calendarFields.add(new CalendarItem(i));
            }
        }

        return calendarFields;
    }

    @SuppressLint("SimpleDateFormat")
    public static int getPositionInAdapter(String startTime) {
        Calendar quotaTime = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            quotaTime.setTime(sdf.parse(startTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int day = quotaTime.get(Calendar.DAY_OF_WEEK);
        int hour = quotaTime.get(Calendar.HOUR_OF_DAY);
        int minutes = quotaTime.get(Calendar.MINUTE);

        int pos = hour * 16;
        pos += minutes == 30 ? 8 : 0;
        pos += day == 1 ? 7 : day - 1;

        return pos;
    }
}
