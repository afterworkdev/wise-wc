package com.wisefamily.app.worldcup2018.model;

import lombok.Data;
import com.wisefamily.app.worldcup2018.WCCodes;

/**
 * Created by wisepjh on 2018. 5. 28..
 */
@Data
public class MatchResult {
    private WCCodes.Country team;
    private int grade;
    private int wins;
    private int draw;
    private int lost;
    private int gf; // 득점
    private int ga; // 실점
    private int pts;
}
