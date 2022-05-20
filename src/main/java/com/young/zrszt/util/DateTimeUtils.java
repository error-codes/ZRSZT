package com.young.zrszt.util;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 17:06
 */
public class DateTimeUtils {

    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static Date getCurrentDateTime() {
        return new Date();
    }

    public static String getCurrentDateTimeStr() {
        return getCurrentDateTime().toString();
    }
}
