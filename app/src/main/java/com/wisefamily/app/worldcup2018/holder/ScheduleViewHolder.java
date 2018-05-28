package com.wisefamily.app.worldcup2018.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.wisefamily.app.worldcup2018.R;

@Data
@EqualsAndHashCode(callSuper = false)
public class ScheduleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.bookmark)
    ImageView ivbookmark;

    @BindView(R.id.teamA) LinearLayout layoutTeamA;
    @BindView(R.id.teamA_flag) ImageView ivflagTeamA;
    @BindView(R.id.teamA_title) TextView tvTitleTeamA;

    @BindView(R.id.midArea) LinearLayout middleArea;
    @BindView(R.id.scoreArea) LinearLayout scoreArea;
    @BindView(R.id.scoreA) TextView tvScoreA;
    @BindView(R.id.vs) TextView tvVs;
    @BindView(R.id.scoreB) TextView tvScoreB;

    @BindView(R.id.teamB) LinearLayout layoutTeamB;
    @BindView(R.id.teamB_flag) ImageView ivflagTeamB;
    @BindView(R.id.teamB_title) TextView tvTitleTeamB;

    public ScheduleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

//    public void setButton(String value) {
//        this.lottoBtn.setTag(value);
//        this.lottoBtn.setText(value);
//    }
//
//    public String getTag() {
//        return this.lottoBtn.getTag().toString();
//    }
//
//    public String getText() {
//        return this.lottoBtn.getText().toString();
//    }
}
