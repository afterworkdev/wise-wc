package com.wisefamily.app.worldcup2018.model;

import java.util.List;

import com.wisefamily.app.worldcup2018.WCCodes;

import lombok.Data;

/**
 * Created by wisepjh on 2018. 5. 28..
 */
@Data
public class GroupInfo {
    private List<WCCodes.Country> teams;
    private List<MatchSchedule> schedule;
    private List<MatchResult> result;
}
