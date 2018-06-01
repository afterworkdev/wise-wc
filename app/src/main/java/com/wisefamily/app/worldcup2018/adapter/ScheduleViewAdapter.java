package com.wisefamily.app.worldcup2018.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisefamily.app.worldcup2018.R;
import com.wisefamily.app.worldcup2018.data.WCData;
import com.wisefamily.app.worldcup2018.holder.ScheduleViewHolder;
import com.wisefamily.app.worldcup2018.model.GroupInfo;
import com.wisefamily.app.worldcup2018.model.Groups;
import com.wisefamily.app.worldcup2018.model.MatchResult;
import com.wisefamily.app.worldcup2018.model.MatchSchedule;
import com.wisefamily.app.worldcup2018.utils.DateUtils;

import java.util.List;
import java.util.Locale;

import lombok.Data;

@Data
public class ScheduleViewAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {

//    private GroupInfo groupInfo;
    private List<MatchSchedule> schedule;

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_item_layout, parent, false);
        return new ScheduleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
//        holder.setButton(Integer.toString(position+1));
//        toggleButton(holder.getLottoBtn(), false);

        MatchSchedule schedule = this.schedule.get(position);
//        MatchResult result = groupInfo.getResult().get(position);

        holder.getIvflagTeamA().setImageResource(schedule.getTeamA().getFlag());
        holder.getTvTitleTeamA().setText(schedule.getTeamA().getEn());
        holder.getTvScoreA().setText(schedule.getResult().getScoreA());

        holder.getIvflagTeamB().setImageResource(schedule.getTeamB().getFlag());
        holder.getTvTitleTeamB().setText(schedule.getTeamB().getEn());
        holder.getTvScoreB().setText(schedule.getResult().getScoreB());

        Locale locale = WCData.getInstance().getLocale();
        String startDate = DateUtils.getFormattedDateStr(schedule.getStartTimeUtc(), locale);
        holder.getTvSchedule().setText(startDate);
    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }
}
