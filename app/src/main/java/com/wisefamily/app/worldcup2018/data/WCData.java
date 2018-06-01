package com.wisefamily.app.worldcup2018.data;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import com.wisefamily.app.worldcup2018.model.GroupInfo;
import com.wisefamily.app.worldcup2018.model.Groups;
import com.wisefamily.app.worldcup2018.model.MatchSchedule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by wisepjh on 2018. 5. 28..
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WCData {

    private static WCData instance = null;
    public static WCData getInstance() {
        if (instance == null) {
            instance = new WCData();
        }
        return instance;
    }

    private Locale currentLocale;

    private Groups groups;

    private List<MatchSchedule> schedules;


    public Locale getLocale() {
        if (currentLocale == null)
            return new Locale("ru","RU");
        else
            return currentLocale;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void setRemoteGroups(Groups remote) {
        groups = remote;
        schedules = new ArrayList<>();

        schedules.addAll(remote.getGroupA().getSchedule());
        schedules.addAll(remote.getGroupB().getSchedule());
        schedules.addAll(remote.getGroupC().getSchedule());
        schedules.addAll(remote.getGroupD().getSchedule());
        schedules.addAll(remote.getGroupE().getSchedule());
        schedules.addAll(remote.getGroupF().getSchedule());
        schedules.addAll(remote.getGroupG().getSchedule());
        schedules.addAll(remote.getGroupH().getSchedule());

        schedules.sort(new Comparator<MatchSchedule>() {
            @Override
            public int compare(MatchSchedule o1, MatchSchedule o2) {
                if (o1.getStartTimeUtc() > o2.getStartTimeUtc()) {
                    return 1;
                }
                else if (o1.getStartTimeUtc() < o2.getStartTimeUtc()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public List<MatchSchedule> getMatchSchedulesAfterNow(int count) {
//        long currentTs = new Date().getTime();
        long currentTs = 1515942000000L;
        List<MatchSchedule> afterSchedules = new ArrayList<>();

        for(MatchSchedule match : schedules) {
            if (match.getStartTimeUtc() >= currentTs) {
                afterSchedules.add(match);
            }

            if (afterSchedules.size() >= count) {
                return afterSchedules;
            }
        }
        return afterSchedules;
    }

}
