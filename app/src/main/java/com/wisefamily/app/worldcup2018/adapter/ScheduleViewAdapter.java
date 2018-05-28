package com.wisefamily.app.worldcup2018.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisefamily.app.worldcup2018.R;
import com.wisefamily.app.worldcup2018.holder.ScheduleViewHolder;

public class ScheduleViewAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {


    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_item_layout, parent, false);
        return new ScheduleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
//        holder.setButton(Integer.toString(position+1));
//        toggleButton(holder.getLottoBtn(), false);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
