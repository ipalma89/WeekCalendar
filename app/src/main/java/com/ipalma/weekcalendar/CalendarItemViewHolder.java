package com.ipalma.weekcalendar;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ipalma.weekcalendar.databinding.CalendarItemBinding;


public class CalendarItemViewHolder extends RecyclerView.ViewHolder {

    private CalendarItemBinding binding;

    public CalendarItemViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(Object item, CalendarView clickListener) {
        binding.setVariable(BR.calendarItem, item);
        binding.executePendingBindings();
        binding.getCalendarItem().setItemClickListener(clickListener);
    }
}
