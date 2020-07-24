/**
 * Outsider.com.cn.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.example.lxk.uils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.springframework.util.StringUtils;

import com.example.lxk.enums.ResultEnum;
import com.example.lxk.exception.ServiceException;

/**
 * @author outsider
 * @version Id: DateUtil.java, v 0.1 2019/9/29 21:44 outsider Exp $$
 */
public class DateUtil {
    private DateUtil() {
        throw new IllegalAccessError("DateUtil class");
    }

    /**
     * 日期格式(yyyyMMdd).
     * 参照({@link SimpleDateFormat}).
     */
    public static final String DATE_PATTERN             = "yyyyMMdd";

    public static final String DATE_PATTERN2            = "yyyy-MM-dd";

    public static final String DATE_PATTERN3            = "yyyy-MM";

    /**
     * 日期时间格式(yyyyMMddHHmmss).
     * 参照({@link SimpleDateFormat}).
     */
    public static final String DATE_TIME_PATTERN        = "yyyyMMddHHmmss";
    public static final String MILLI_SECOND             = "yyyyMMddHHmmssSSS";

    public static final String DATE_TIME_PATTERN2       = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TIME_PATTERN_FORMAT = "yyyy年MM月dd日HH时mm分ss秒";

    public static final String DATE_TIME_PATTERN3       = "yyyy-MM-dd HH:mm";

    public static final String DATE_TIME_PATTERN4       = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间格式(HHmmss).
     * 参照({@link SimpleDateFormat}).
     */
    public static final String TIME_PATTERN             = "HHmmss";

    public static final String TIME_PATTERN_HHMM        = "HHmm";

    /**
     * 按指定的格式({@link SimpleDateFormat})格式化时间.
     *
     * @param millis  时间毫秒数.
     * @param pattern 格式
     * @return 格式化后的时间
     */
    public static String format(long millis, String pattern) {
        return format(new Date(millis), pattern);
    }

    /**
     * 按指定的格式({@link SimpleDateFormat})格式化时间.
     *
     * @param date    时间
     * @param pattern 格式
     * @return 格式化后的时间
     */
    public static String format(Date date, String pattern) {
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * 按默认的格式(yyyyMMdd)格式化日期.
     *
     * @param date 时间
     * @return 格式化后的日期
     */
    public static String formartDate(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String formartDate2(Date date) {
        return format(date, DATE_PATTERN2);
    }

    public static String formartDate3(Date date) {
        return format(date, DATE_TIME_PATTERN_FORMAT);
    }

    /**
     * 按默认的格式(HHmmss)格式化时间.
     *
     * @param date 时间
     * @return 格式化后的时间
     */
    public static String formartTime(Date date) {
        return format(date, TIME_PATTERN);
    }

    /**
     * 按默认的格式(yyyyMMddHHmmss)格式化日期时间.
     *
     * @param date 时间
     * @return 格式化后的日期时间.
     */
    public static String formartDateTime(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    public static String formartDateTime2(Date date) {
        return format(date, DATE_TIME_PATTERN2);
    }

    /**
     * Date格式化
     *
     * @param date 时间
     * @return 格式化后的日期时间.
     */
    public static Date formatDate(Date date, String datePattern) {
        if (date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        if (datePattern == null || datePattern.trim().equals("")) {
            datePattern = DATE_TIME_PATTERN2;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        String dateStr = sdf.format(date);
        Date mydate = null;
        try {
            mydate = sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new ServiceException(ResultEnum.STRING_TO_DATE_FAIL);
        }
        return mydate;
    }

    /**
     * 按指定的格式({@link SimpleDateFormat})格式化当前时间.
     *
     * @param pattern 格式
     * @return 格式化后的当前时间
     */
    public static String formatCurrent(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 按默认的格式(yyyyMMdd)格式化当前日期.
     *
     * @return 格式化后的当前日期
     */
    public static String formartCurrentDate() {
        return format(new Date(), DATE_PATTERN);
    }

    /**
     * 按默认的格式(HHmmss)格式化当前时间.
     *
     * @return 格式化后的当前时间.
     */
    public static String formartCurrentTime() {
        return format(new Date(), TIME_PATTERN);
    }

    /**
     * 按默认的格式(yyyyMMddHHmmss)格式化当前日期时间.
     *
     * @return 格式化后的当前日期时间.
     */
    public static String formartCurrentDateTime() {
        return format(new Date(), DATE_TIME_PATTERN);
    }

    /**
     * 获得今天凌晨0点0分对应的时间.
     *
     * @return 今天凌晨0点0分对应的时间.
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得指定时间当天凌晨0点0分对应的时间.
     *
     * @param date 指定的时间.
     * @return 指定时间当天凌晨0点0分对应的时间.
     */
    public static Date getTheDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 比较开始日期和结束日期.
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 如果start和end均为<code>null</code>或他们代表的日期相同,返回0;
     * 如果end为<code>null</code>,返回大于0的数字;
     * 如果start为<code>null</code>,则start假设为当前日期和end比较,
     * start代表日期在end代表的日期前,则返回小于0的数字,
     * start代表日期在end代表的日期后,则返回大于0的数字.
     */
    public static int compareDate(Date start, Date end) {
        Date sdate = start;
        if (start == null && end == null) {
            return 0;
        } else if (end == null) {
            return 1;
        } else if (sdate == null) {
            sdate = new Date();
        }
        sdate = getTheDate(sdate);
        Date send = getTheDate(end);
        return sdate.compareTo(send);
    }

    /**
     * 返回指定时间点 <code>amount</code> 年后(前)的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date   源时间,不能为<code>null</code>.
     * @param amount 年数,正数为加,负数为减.
     * @return 增加(减少)指定年数后的日期对象.
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * 返回指定时间点 <code>amount</code> 月后(前)的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date   源时间,不能为<code>null</code>.
     * @param amount 月数,正数为加,负数为减.
     * @return 增加(减少)指定月数后的日期对象.
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 返回指定时间点 <code>amount</code> 星期后(前)的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date   源时间,不能为<code>null</code>.
     * @param amount 星期数,正数为加,负数为减.
     * @return 增加(减少)指定星期数后的日期对象.
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    /**
     * 返回指定时间点 <code>amount</code> 天后(前)的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date   源时间,不能为<code>null</code>.
     * @param amount 天数,正数为加,负数为减.
     * @return 增加(减少)指定天数后的日期对象.
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 返回指定时间点 <code>amount</code> 小时后(前)的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date   源时间,不能为<code>null</code>.
     * @param amount 小时数,正数为加,负数为减.
     * @return 增加(减少)指定小时数后的日期对象.
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 返回指定时间点 <code>amount</code> 分钟后(前)的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date   源时间,不能为<code>null</code>.
     * @param amount 分钟数,正数为加,负数为减.
     * @return 增加(减少)指定分钟数后的日期对象.
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 返回指定时间点 <code>amount</code> 秒后(前)的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date   源时间,不能为<code>null</code>.
     * @param amount 秒数,正数为加,负数为减.
     * @return 增加(减少)指定秒数后的日期对象.
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    /**
     * 返回指定时间点 <code>amount</code> 豪秒后(前)的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date   源时间,不能为<code>null</code>.
     * @param amount 豪秒数,正数为加,负数为减.
     * @return 增加(减少)指定豪秒数后的日期对象.
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    /**
     * 返回指定时间点增加(减少)一段时间后的时间. 返回新对象,源日期对象(<code>date</code>)不变.
     *
     * @param date          源时间,不能为<code>null</code>.
     * @param calendarField 增加(减少)的日历项.
     * @param amount        数量,正数为加,负数为减.
     * @return 日历项增加(减少)指定数目后的日期对象.
     */
    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("日期对象不允许为null!");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    /**
     * String To Date
     * @param dateStr 字符串时间
     * @param pattern 时间格式
     * @return        返回结果
     */
    public static Date toDate(String dateStr, String pattern) {
        Date date;
        if (StringUtils.isEmpty(dateStr)) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        if (pattern.trim() == null) {
            pattern = DATE_TIME_PATTERN2;
        }
        try {
            DateFormat dd = new SimpleDateFormat(pattern);
            date = dd.parse(dateStr);
        } catch (ParseException e) {
            throw new ServiceException(ResultEnum.STRING_TO_DATE_FAIL);
        }
        return date;
    }

    /**
     * String To Date
     * @param dateStr 字符串时间
     * @param pattern 时间格式
     * @return        返回结果
     */
    public static Date stringToDate(String dateStr, String pattern) {
        Date date;
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        if (pattern.trim() == null) {
            pattern = DATE_TIME_PATTERN2;
        }
        try {
            DateFormat dd = new SimpleDateFormat(pattern);
            date = dd.parse(dateStr);
        } catch (ParseException e) {
            throw new ServiceException(ResultEnum.STRING_TO_DATE_FAIL);
        }
        return date;
    }

    /**
     * @return 当前时间毫秒数.
     */
    public static long getSysNanoTime() {
        return System.nanoTime();
    }

    /**
     * @return 当前时间毫秒数字符串.
     */
    public static String getSysNanoTimeStr() {
        return String.valueOf(System.nanoTime());
    }

    /**
     * @return 当前时间毫秒数字符串后六位.
     */
    public static String getSysNanoTimeLastSix() {
        String time = getSysNanoTimeStr();
        return time.substring(time.length() - 6, time.length());
    }

    /**
     * @param stime 开始时间
     * @param etime 结束时间
     * @param time  需要进行判断的时间
     * @return 如果    stime大于等于time小于等于etime返回true 否则返回false
     */
    public static boolean betweenAnd(String stime, String etime,
                                     String time) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date sTime = dateFormat.parse(stime);
        Date eTime = dateFormat.parse(etime);
        Date temptime = dateFormat.parse(time);
        int a = sTime.compareTo(temptime);
        int b = eTime.compareTo(temptime);
        boolean flag = false;
        if (a <= 0 && b >= 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 时间比大小
     */
    public static int timeCompare(String t1, String t2) {
        int firstTime = Integer.parseInt(t1);
        int secondTime = Integer.parseInt(t2);
        if (firstTime < secondTime) {
            return 1;
        } else if (firstTime == secondTime) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 时间中间加":"
     */
    public static String stringToTime(String timeNum) {
        String newTime = null;
        if (timeNum != null) {
            String newTime1 = timeNum.substring(0, 2);
            String newTime2 = timeNum.substring(2, 4);
            newTime = newTime1 + ":" + newTime2;
        }
        return newTime;
    }

    /**
     * 获取指定时间当月第一天的00:00:00
     *
     * @param date 指定时间
     * @return 返回结果
     */
    public static Date getFirstDayOfMonth(Date date, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中当月第一天
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN2);
        String firstDayOfMonth = sdf.format(cal.getTime()) + " 00:00:00";
        Date firstDateOfMonth = toDate(firstDayOfMonth, pattern);
        return firstDateOfMonth;
    }

    /**
     * 获取指定时间当月最后一天的23:59:59
     *
     * @param date 指定时间
     * @return 返回结果
     */
    public static Date getLastDayOfMonth(Date date, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN2);
        String lastDayOfMonth = sdf.format(cal.getTime()) + " 23:59:59";
        Date lastDateOfMonth = toDate(lastDayOfMonth, pattern);
        return lastDateOfMonth;
    }

}