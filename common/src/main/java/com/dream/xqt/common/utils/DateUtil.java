package com.dream.xqt.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xinxiaoyao
 * @date 2022/5/19 09:09
 */
public class DateUtil {
    private final static String DATE_PATTERN_SPLIT_WITH_SPOT = "yyyy.MM.dd";
    private final static String DATE_PATTERN_SPLIT_WITH_BAR = "yyyy-MM-dd";
    private final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static SimpleDateFormat dateFormatPattern = new SimpleDateFormat(DATE_PATTERN_SPLIT_WITH_BAR);

    public static SimpleDateFormat dateTimeFormatPattern = new SimpleDateFormat(DATE_FORMAT);

    public static Date getStartOfDay(Date day) {
        return getStartOfDay(day, Calendar.getInstance());
    }

    public static Date getEndOfDay(Date day) {
        return getEndOfDay(day, Calendar.getInstance());
    }

    private static Date getStartOfDay(Date day, Calendar cal) {
        if (day == null)
            day = new Date();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    private static Date getEndOfDay(Date day, Calendar cal) {
        if (day == null)
            day = new Date();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    /**
     * @see java.util.Date
     * @see String
     * 日期类型转换成字符串
     */
    public static String format(Date date, String pattern) {
        if (date != null && StringUtils.isNotEmpty(pattern)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        }
        return "";
    }

    public static String formatSpotDate(Date date) {
        if (date != null) {
            return format(date, DATE_PATTERN_SPLIT_WITH_SPOT);
        }
        return "";
    }

    public static String formatSpotDateTime(Date date) {
        if (date != null) {
            return format(date, DATE_FORMAT);
        }
        return "";
    }


    /**
     * 解析为 yyyy-MM-dd
     *
     * @param str
     * @return
     */
    public static Date parseISODate(String str) {
        if (StringUtils.isNotEmpty(str)) {
            try {
                return dateFormatPattern.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static Date parseISODateTime(String str) {
        if (StringUtils.isNotEmpty(str)) {
            try {
                return dateTimeFormatPattern.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
