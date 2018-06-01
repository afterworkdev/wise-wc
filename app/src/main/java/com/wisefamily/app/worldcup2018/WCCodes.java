package com.wisefamily.app.worldcup2018;

import android.graphics.drawable.Drawable;

import lombok.Getter;

/**
 * Created by wisepjh on 2018. 5. 28..
 */

public class WCCodes {

    public enum Country {
        RUS("RUSSIA",        "러시아",         R.drawable.rus),
        KSA("Saudi Arabia",  "사우디아라비아",     R.drawable.ksa),
        EGY("Egypt",         "이집트",         R.drawable.egy),
        URU("Uruguay",       "우르과이", R.drawable.uru),
        POR("Portugal",      "포르투칼", R.drawable.por),
        ESP("Spain",         "스페인", R.drawable.esp),
        MAR("Morocco",       "모로코", R.drawable.mar),
        IRN("IR Iran",       "이란", R.drawable.irn),
        FRA("France",        "프랑스", R.drawable.fra),
        AUS("Australia",     "오스트레일리아", R.drawable.aus),
        PER("Peru",          "페루", R.drawable.per),
        DEN("Denmark",       "덴마크", R.drawable.den),
        ARG("Argentina",     "아르헨티나", R.drawable.arg),
        ISL("Iceland",       "아이슬란드", R.drawable.isl),
        CRO("Croatia",       "크로아티아", R.drawable.cro),
        NGA("Nigeria",       "나이지리아", R.drawable.nga),
        BRA("Brazil",        "브라질", R.drawable.bra),
        SUI("Switzerland",   "스위스", R.drawable.sui),
        CRC("Costa Rica",    "코스타리카", R.drawable.crc),
        SRB("Serbia",        "세르비아", R.drawable.srb),
        GER("Germany",       "독일", R.drawable.ger),
        MEX("Mexico",        "멕시코", R.drawable.mex),
        SWE("Sweden",        "스웨덴", R.drawable.swe),
        KOR("South Korea",   "대한민국", R.drawable.kor),
//      KOR("Korea Republic","대한민국", R.drawable.kor),
        BEL("Belgium",       "벨기에", R.drawable.bel),
        PAN("Panama",        "파나마", R.drawable.pan),
        TUN("Tunisia",       "튀니지", R.drawable.tun),
        ENG("England",       "잉글랜드", R.drawable.eng),
        POL("Poland",        "폴란드", R.drawable.pol),
        SEN("Senegal",       "세네갈", R.drawable.sen),
        COL("Colombia",      "콜롬비아", R.drawable.col),
        JPN("Japan",         "일본", R.drawable.jpn)
        ;

        @Getter
        private String en;
        @Getter
        private String ko;
        @Getter
        private int flag;

        Country(String en, String ko, int flag) {//, Group group) {
            this.en = en;
            this.ko = ko;
            this.flag = flag;
        }
    }

    public enum Entry16 {
        C1, D2, A1, B2, B1, A2, D1, C2, E1, F2, G1, H2, F1, E2, H1, G2,
    }

}
