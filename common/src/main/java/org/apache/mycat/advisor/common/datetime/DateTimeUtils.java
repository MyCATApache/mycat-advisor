/*
        Copyright  DR.YangLong

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.apache.mycat.advisor.common.datetime;


import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * functional describe:日期及时间工具，日期时间计算及日期时间格式化
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0 2015/5/13 9:24
 */
public class DateTimeUtils {
    /**
     * 时间单位
     */
    public static final int YEAR_UNIT = 0;
    public static final int MONTH_UNIT = 1;
    public static final int DAY_UNIT = 2;
    public static final int HOURE_UNIT = 3;
    public static final int MINUTE_UNIT = 4;

    private DateTimeUtils() {
    }

    public static Date getFirstDayOfWeek(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.minusDays(dateTime.getDayOfWeek() - 1).toDate();
    }

    public static Date getLastDayOfWeek(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(7 - dateTime.getDayOfWeek()).toDate();
    }

    /**
     * 获取时间间隔
     *
     * @return
     */
    public static Period getTimePeriod(Date startTime, Date endTime, PeriodType periodType) {
        if (periodType == null) periodType = PeriodType.minutes();
        DateTime dateTimeStart = new DateTime(startTime);
        DateTime dateTimeEnd = new DateTime(endTime);
        Period p = new Period(dateTimeStart, dateTimeEnd, periodType);
        return p;
    }

    /**
     * 获取间隔年数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getPeriodYears(Date startTime, Date endTime) {
        return getTimePeriod(startTime, endTime, PeriodType.years()).getYears();
    }

    /**
     * 获取间隔天数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getPeriodDays(Date startTime, Date endTime) {
        return getTimePeriod(startTime, endTime, PeriodType.days()).getDays();
    }

    /**
     * 获取间隔小时数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getPeriodHours(Date startTime, Date endTime) {
        return getTimePeriod(startTime, endTime, PeriodType.hours()).getHours();
    }

    /**
     * 获取间隔秒数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getPeriodSeconds(Date startTime, Date endTime) {
        return getTimePeriod(startTime, endTime, PeriodType.seconds()).getSeconds();
    }

    /**
     * 获取间隔分钟数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getPeriodMinutes(Date startTime, Date endTime) {
        return getTimePeriod(startTime, endTime, PeriodType.minutes()).getMinutes();
    }

    /**
     * 获取间隔月数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getPeriodMonths(Date startTime, Date endTime) {
        return getTimePeriod(startTime, endTime, PeriodType.months()).getMonths();
    }

    /**
     * 获取毫秒数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getPeriodMillis(Date startTime, Date endTime) {
        Duration duration = new Duration(new DateTime(startTime), new DateTime(endTime));
        return duration.getMillis();
    }

    /**
     * 日期前移
     *
     * @param date     当前日期
     * @param before   前移数量
     * @param timeUnit 单位,<code>0,1,2,3,4</code>
     * @return 前移后的日期
     */
    public static Date getBeforeDate(Date date, final int before, final int timeUnit) {
        DateTime dateTime = new DateTime(date);
        Date result;
        switch (timeUnit) {
            case YEAR_UNIT:
                result = dateTime.minusYears(before).toDate();
                break;
            case MONTH_UNIT:
                result = dateTime.minusMonths(before).toDate();
                break;
            case DAY_UNIT:
                result = dateTime.minusDays(before).toDate();
                break;
            case HOURE_UNIT:
                result = dateTime.minusHours(before).toDate();
                break;
            case MINUTE_UNIT:
                result = dateTime.minusMinutes(before).toDate();
                break;
            default:
                result = date;
        }
        return result;
    }

    /**
     * 日期后移
     *
     * @param date     当前日期
     * @param after    后移数量
     * @param timeUnit 单位
     * @return 前移后的日期
     */
    public static Date getAfterDate(Date date, final int after, final int timeUnit) {
        DateTime dateTime = new DateTime(date);
        Date result;
        switch (timeUnit) {
            case YEAR_UNIT:
                result = dateTime.plusYears(after).toDate();
                break;
            case MONTH_UNIT:
                result = dateTime.plusMonths(after).toDate();
                break;
            case DAY_UNIT:
                result = dateTime.plusDays(after).toDate();
                break;
            case HOURE_UNIT:
                result = dateTime.plusHours(after).toDate();
                break;
            case MINUTE_UNIT:
                result = dateTime.plusMinutes(after).toDate();
                break;
            default:
                result = date;
        }
        return result;
    }

    /**
     * 得到今天的日期。只关心天，时分秒全部清零。
     *
     * @return
     */
    public static Date getToday() {
        return formatDate(new Date());
    }

    /**
     * 根据月份取得日历的第一个星期天
     *
     * @param month 当前月份字符
     * @return
     */
    public static Date getMonthFristWeekSunday(String month) {
        Calendar c = Calendar.getInstance();
        c.setTime(parse(month, "yyyy-MM"));
        c.set(Calendar.DATE, 1);
        int dayNum = c.get(Calendar.DAY_OF_WEEK);
        c.add(Calendar.DATE, 1 - dayNum);
        return c.getTime();
    }

    /**
     * 取得这个月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, 1);
        c.roll(Calendar.DATE, -1);

        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    /**
     * 根据月份取得日历的最后一个星期六
     *
     * @param month 当前月份字符
     * @return
     */
    public static Date getMonthLastWeekSaturday(String month) {
        Calendar c = Calendar.getInstance();
        Date lastDay = getLastDayOfMonth(parse(month, "yyyy-MM"));
        c.setTime(lastDay);
        int dayNum = c.get(Calendar.DAY_OF_WEEK);
        if (dayNum != 7) {
            c.add(Calendar.DATE, 7 - dayNum);
        }
        return c.getTime();
    }

    /**
     * 获取今年的第一天
     *
     * @return
     */
    public static Date getCurrentYearFirst() {
        Calendar today = Calendar.getInstance();
        int yearPlus = Calendar.getInstance().get(Calendar.YEAR);
        today.set(yearPlus, 1, 1);
        return new Date(today.getTimeInMillis());
    }

    /**
     * 获取今年的最后一天
     *
     * @return
     */
    public static Date getCurrentYearLast() {
        Calendar today = Calendar.getInstance();
        int yearPlus = Calendar.getInstance().get(Calendar.YEAR);
        today.set(yearPlus, 12, 31);
        return new Date(today.getTimeInMillis());
    }

    /**
     * 比较指定毫秒数和当前系统毫秒数之前的间隔，返回间隔秒数
     *
     * @param startMilliSecond 指定的毫秒数
     * @return 返回两个毫秒数之间的间隔秒数
     */
    public static long compareToSecond(long startMilliSecond) {
        if (startMilliSecond > 0) {
            // 系统当前毫秒数
            long currentMilli = System.currentTimeMillis();
            long startSecond = startMilliSecond / 1000;
            long endSecond = currentMilli / 1000;

            return endSecond - startSecond;
        }

        return -1;
    }

    /**
     * 获取问候语
     * @return
     */
    public static String getGreetings() {
        Date curTime = new Date();
        int hour = curTime.getHours();
        String greetings = "你好";
        if (hour >= 0 && hour < 6) {
            greetings = "凌晨好";
        }
        else if (hour >= 6 && hour < 8) {
            greetings = "早晨好";
        }
        else if (hour >= 8 && hour < 11) {
            greetings = "上午好";
        }
        else if (hour >= 11 && hour < 14) {
            greetings = "中午好";
        }
        else if (hour >= 14 && hour < 18) {
            greetings = "下午好";
        }
        else if (hour >= 18 && hour < 22) {
            greetings = "晚上好";
        }
        else if (hour >= 22 && hour < 24) {
            greetings = "午夜好";
        }
        return greetings;
    }

    /**
     * 将日期时间清零
     *
     * @param date 日期
     * @return
     */
    public static Date formatDate(Date date) {
        return parse(format(date), "yyyy-MM-dd");
    }

    /**
     * 对给定的日期以"yyyy-MM-dd"格式化
     *
     * @param date 日期
     * @return
     */
    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    /**
     * 对给定的日期以"yyyy年MM月dd日 hh:mm"格式化
     *
     * @param date 日期
     * @return
     */
    public static String formatChinese(Date date) {
        if (date == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return df.format(date);
    }

    /**
     * 对给定的日期以模式串pattern格式化
     *
     * @param date 日期
     * @param pattern 格式化模式
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    /**
     * 对给定的日期字符串以"yyyy-MM-dd HH:mm"格式解析
     *
     * @param dateString
     * @return
     */
    public static Date parse(String dateString) {
        return parse(dateString, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 对给定的日期字符串以pattern格式解析
     *
     * @param dateString
     * @param pattern
     * @return
     */
    public static Date parse(String dateString, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = df.parse(dateString);
        }
        catch (Throwable t) {
            date = null;
        }
        return date;
    }

    /**
     * 获取当前时间的UTC时间值
     * @return
     */
    public static long getTimeOfUTC(){
        Calendar calendar=Calendar.getInstance();
        //时区偏移量
        int zoneOffset=calendar.get(Calendar.ZONE_OFFSET);
        //夏令时差
        int dstOffset=calendar.get(Calendar.DST_OFFSET);
        //减去偏移量之和
        calendar.add(Calendar.MILLISECOND,-(zoneOffset+dstOffset));
        //获取UTC时间
        long utcTime=calendar.getTimeInMillis();
        return utcTime;
    }

}
