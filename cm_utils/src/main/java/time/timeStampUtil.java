/**
 * @(#)timeStampUtil.java, 2020-07-28.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package time;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.JANUARY;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class timeStampUtil {

    private String timeFormat = "yyyy-MM-dd HH:00:00";
    private String timeFormat2 = "yyyy年MM月dd日";
    private final String accurateChineseFormat = "yyyy年MM月dd日HH时mm分ss秒";
    /**
     * 时间戳转换到年月日
     */
    @Test
    public void timeStampToDate(){
        String format = new SimpleDateFormat(timeFormat2).format(System.currentTimeMillis());
        System.out.println(format);
    }


    /**
     * 时间戳转换到年月日
     */
    @Test
    public void timeStampToDate2(){
        String format = new SimpleDateFormat(accurateChineseFormat).format(System.currentTimeMillis());
        System.out.println(format);
    }


    @Test
    public void testTimeStampRange2Data(){
        System.out.println(timeStampRange2Data(4153891016d));
        System.out.println(timeStampRange2Data(1368170729.8333));
    }

    /**
     * 时间戳间隔 换算成 秒
     */
    public Double timeStampRange2Data(Double val){
        return Math.floor(val/(24*3600*1000));
    }


    @Test
    public void date2TimeStamp (){
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
    }

    @Test
    public void test_getCron(){

        String cron=getCron(System.currentTimeMillis());
        System.out.println(cron);
    }

    /**
     * 时间戳转换得到corn表达式
     */
    public static String getCron(Long timeStamp){
        Date date = new Date(timeStamp);
        String dateFormat="ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }
    public static String formatDateByPattern(Date date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    @Test
    public void test(){
        String result2 = new SimpleDateFormat("MM-dd").format(System.currentTimeMillis());
        System.out.println(result2);
    }
    @Test
    public void test2(){
        Date now = new Date();
        long beginOfYear = DateUtil.beginOfYear(now).toTimestamp().getTime();
        long endOfYear = DateUtil.endOfYear(now).toTimestamp().getTime();
        System.out.println(beginOfYear);
        System.out.println(endOfYear);
    }
    @Test
    public void test3() throws InterruptedException {
//        Date date = new Date("2018-01-01");
//        long time = date.getTime();
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.set(Integer.valueOf("2018"),0,1,0,0,0);
        Long time = calendar.getTimeInMillis();
        System.out.println(time);
        Thread.sleep(200);
        Calendar calendar2 = Calendar.getInstance();// 获取当前日期
        calendar2.set(Integer.valueOf("2018"),0,1,0,0,0);
        Long time2 = calendar.getTimeInMillis();
        System.out.println(time2);
    }

    @Test
    public void test5() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = df.parse("2018-12-29");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.CHINA);
        cal.setTime(date);
        //!!!!!!getWeekYear() 不是取当前年份！！！
        System.out.println(cal.getWeekYear());
        cal.set(cal.getWeekYear(),JANUARY,1);
        long timestamp = cal.getTimeInMillis();
        System.out.println(timestamp);
    }

    @Test
    public void test6() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        java.util.Date date = df.parse("2018-02-31");
        System.out.println(date.getTime());
    }

    @Test
    public void test4(){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        long currentZoneTime = calendar.getTimeInMillis();
        calendar.add(Calendar.DATE, 7);
        //获取7天后零点的时间戳
        long weekAfterTime = calendar.getTimeInMillis();
        System.out.println(weekAfterTime);
    }


}