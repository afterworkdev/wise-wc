package com.wisefamily.app.worldcup2018.model;

import java.util.List;

import lombok.Data;
import com.wisefamily.app.worldcup2018.WCCodes;

/**
 * Created by wisepjh on 2018. 5. 28..
 */

@Data
public class GameResult {
    /* {"score_a":"2", "score_b":"1", "win":"RU"} */
    private int scoreA;
    private int scoreB;
    private WCCodes.Country winner;
    private List<String> goalPlayer;
}
