package com.wisefamily.app.worldcup2018.utils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wisepjh on 2018. 5. 28..
 */
public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMEZONE_UTC = "UTC";
    public static final String TIMEZONE_SEOUL = "Asia/Seoul";

//    public static String getFormattedDateStr(LocalDateTime localDateTime) {
//        return getFormattedDateStr(localDateTime, DEFAULT_DATE_FORMAT);
//    }
//
//    public static String getFormattedDateStr(LocalDateTime localDateTime, String format) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
//        return localDateTime.format(dateTimeFormatter);
//    }

    public static String getFormattedDateStr(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.KOREAN);
        return sdf.format(new Date(timestamp));
    }

    public static String getFormattedDateStr(long timestamp, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT, locale);
        return sdf.format(new Date(timestamp));
    }

    public static LocalDateTime getLocalDateTimeFromStr(String formattedDateStr) {
        return LocalDateTime.parse(formattedDateStr, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    public static LocalDateTime getLocalDateTimeFromStr(String formattedDateStr, String datePattern) {
        return LocalDateTime.parse(formattedDateStr, DateTimeFormatter.ofPattern(datePattern));
    }

    public static LocalDateTime getTimePartFilledLocalDateTime(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 23, 59, 59);
    }

    public static LocalDateTime getTimePartZeroLocalDateTime(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 00, 00, 00);
    }

    public static String getCurrentTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    public static boolean isWeekend(LocalDateTime localDateTime) {
        return (localDateTime.getDayOfWeek() == DayOfWeek.SUNDAY || localDateTime.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    public static long getTimestampOnTimezone(LocalDateTime localDateTime) {
        return getTimestampOnTimezone(localDateTime, TIMEZONE_SEOUL);
    }

    public static long getTimestampOnTimezone(LocalDateTime localDateTime, String timezone) {
        return localDateTime.atZone(ZoneId.of(timezone)).toInstant().toEpochMilli();
    }

    public static LocalDateTime getLocalDateTimeFromEpochMilli(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.of(TIMEZONE_SEOUL)).toLocalDateTime();
    }
}
