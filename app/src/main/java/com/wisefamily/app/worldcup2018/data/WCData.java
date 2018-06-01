package com.wisefamily.app.worldcup2018.data;

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

    public Locale getLocale() {
        if (currentLocale == null)
            return new Locale("ru","RU");
        else
            return currentLocale;
    }

}
