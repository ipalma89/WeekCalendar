package com.ipalma.weekcalendar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by ivan on 3/4/17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<CalendarItemViewHolder> {

    public List<CalendarItem> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    private CalendarView clickListener;

    public MyRecyclerViewAdapter(Context context, List<CalendarItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public CalendarItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.calendar_item, parent, false);
        CalendarItemViewHolder viewHolder = new CalendarItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CalendarItemViewHolder holder, int position) {
        CalendarItem item = mData.get(position);
        holder.bind(item, clickListener);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setClickListener(CalendarView itemClickListener) {
        clickListener = itemClickListener;
    }
}
