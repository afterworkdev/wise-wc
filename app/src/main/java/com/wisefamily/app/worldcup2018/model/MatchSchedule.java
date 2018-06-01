package com.wisefamily.app.worldcup2018.model;

import com.wisefamily.app.worldcup2018.WCCodes;

import lombok.Data;

/**
 * Created by wisepjh on 2018. 5. 28..
 */
@Data
public class MatchSchedule {
    private WCCodes.Country teamA;
    private WCCodes.Entry16 roundA;

    private WCCodes.Country teamB;
    private WCCodes.Entry16 roundB;

    private long startTimeUtc;
    private GameResult result;
}
