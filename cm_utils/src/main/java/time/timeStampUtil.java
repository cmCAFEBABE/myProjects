/**
 * @(#)timeStampUtil.java, 2020-07-28.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

}