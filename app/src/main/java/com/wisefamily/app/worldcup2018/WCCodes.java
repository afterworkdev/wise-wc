package com.wisefamily.app.worldcup2018;

import lombok.Getter;

/**
 * Created by wisepjh on 2018. 5. 28..
 */

public class WCCodes {

    public enum Country {
        RUS("RUSSIA",        "러시아"),
        KSA("Saudi Arabia",  "사우디아라비아"),
        EGY("Egypt",         "이집트"),
        URU("Uruguay",       "우르과이"),
        POR("Portugal",      "포르투칼"),
        ESP("Spain",         "스페인"),
        MAR("Morocco",       "모로코"),
        IRN("IR Iran",       "이란"),
        FRA("France",        "프랑스"),
        AUS("Australia",     "오스트레일리아"),
        PER("Peru",          "페루"),
        DEN("Denmark",       "덴마크"),
        ARG("Argentina",     "아르헨티나"),
        ISL("Iceland",       "아이슬란드"),
        CRO("Croatia",       "크로아티아"),
        NGA("Nigeria",       "나이지리아"),
        BRA("Brazil",        "브라질"),
        SUI("Switzerland",   "스위스"),
        CRC("Costa Rica",    "코스타리카"),
        SRB("Serbia",        "세르비아"),
        GER("Germany",       "독일"),
        MEX("Mexico",        "멕시코"),
        SWE("Sweden",        "스웨덴"),
        KOR("Korea Republic","대한민국"),
        BEL("Belgium",       "벨기에"),
        PAN("Panama",        "파나마"),
        TUN("Tunisia",       "튀니지"),
        ENG("England",       "잉글랜드"),
        POL("Poland",        "폴란드"),
        SEN("Senegal",       "세네갈"),
        COL("Colombia",      "콜롬비아"),
        JPN("Japan",         "일본")
        ;

        @Getter
        private String en;
        @Getter
        private String ko;

        Country(String en, String ko) {//, Group group) {
            this.en = en;
            this.ko = ko;
        }
    }

    public enum Entry16 {
        C1, D2, A1, B2, B1, A2, D1, C2, E1, F2, G1, H2, F1, E2, H1, G2,
    }

}
