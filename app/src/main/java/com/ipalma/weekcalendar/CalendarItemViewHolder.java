package com.ipalma.weekcalendar;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class CalendarItemViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public CalendarItemViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(Object item) {
        binding.setVariable(BR.calendarItem, item);
        binding.executePendingBindings();
    }
}
