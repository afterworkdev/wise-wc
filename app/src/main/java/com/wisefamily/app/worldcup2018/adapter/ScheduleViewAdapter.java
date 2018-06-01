package com.wisefamily.app.worldcup2018.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisefamily.app.worldcup2018.R;
import com.wisefamily.app.worldcup2018.data.WCData;
import com.wisefamily.app.worldcup2018.holder.ScheduleViewHolder;
import com.wisefamily.app.worldcup2018.model.MatchSchedule;
import com.wisefamily.app.worldcup2018.utils.DateUtils;

import java.util.List;
import java.util.Locale;

import lombok.Data;

@Data
public class ScheduleViewAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {

    private List<MatchSchedule> schedules;
    private boolean favorite = true;

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_item_layout, parent, false);
        return new ScheduleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
        MatchSchedule schedule = this.schedules.get(position);

        if (favorite)
            holder.getIvBookmark().setVisibility(View.VISIBLE);
        else
            holder.getIvBookmark().setVisibility(View.GONE);

        holder.getIvFlagTeamA().setImageResource(schedule.getTeamA().getFlag());
        holder.getTvTitleTeamA().setText(schedule.getTeamA().getEn());
        if (schedule.getResult() != null) {
            holder.getTvScoreA().setText(schedule.getResult().getScoreA());
        }

        holder.getIvFlagTeamB().setImageResource(schedule.getTeamB().getFlag());
        holder.getTvTitleTeamB().setText(schedule.getTeamB().getEn());
        if (schedule.getResult() != null) {
            holder.getTvScoreB().setText(schedule.getResult().getScoreB());
        }

        Locale locale = WCData.getInstance().getLocale();
        String startDate = DateUtils.getFormattedDateStr(schedule.getStartTimeUtc(), locale);
        holder.getTvSchedule().setText(startDate);

    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public void setTodaysMatches(List<MatchSchedule> schedules) {
        this.schedules = schedules;
        this.favorite = false;
    }

}
