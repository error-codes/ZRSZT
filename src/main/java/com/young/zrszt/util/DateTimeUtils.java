package com.young.zrszt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 17:06
 */
public class DateTimeUtils {

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_PATTERN);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static Date getCurrentDateTime() {
        return new Date();
    }

    public static String getCurrentDateTimeStr() {
        return getCurrentDateTime().toString();
    }

    public static LocalDateTime getCurDateAfterNumberChronoUnit(Long number, ChronoUnit chronoUnit) {
        return LocalDateTime.now().plus(number, chronoUnit);
    }

    public static LocalDate stringToLocalDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public static LocalDateTime stringToLocalDateTime(String date) {
        return LocalDateTime.parse(date, DATE_TIME_FORMATTER);
    }

    /**
     * 字符串转日期
     */
    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat(DATE_PATTERN).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 日期转字符串
     */
    public static String localDateToString(LocalDate date) {
        return DATE_FORMATTER.format(date);
    }

    /**
     * 日期时间转字符串
     */
    public static String localDateTimeToString(LocalDateTime date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return DATE_TIME_FORMATTER.format(date);
    }


    public static String dateToString(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return date.toString();
    }
    
    public static Date LocalDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public static Date LocalDateToDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


    public static LocalDate dateToLocalDate(Date date) {
        return LocalDateTime.ofInstant(new Date(date.getTime()).toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    public static Date dateToLocalDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
