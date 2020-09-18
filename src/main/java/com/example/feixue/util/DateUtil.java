package com.example.feixue.util;

import java.util.Calendar;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：时间工具类
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/5/30 12:49
 */
public class DateUtil {
    public static String getAgent(String date1){
        int year1 = Integer.valueOf(date1.substring(0,4));
        Calendar date2 = Calendar.getInstance();
        int month2 = date2.get(Calendar.MONTH) + 1;
        int year2 = date2.get(Calendar.YEAR);
        int month1 = Integer.valueOf(date1.substring(5,7));
        int age = 0;
        if (year1 < year2) {
            if (month1 < month2) {
                age = year2 - year1;
            } else if (month1 == month2) {
                int date1Date = Integer.valueOf(date1.substring(8, 10));
                int date2Date = date2.get(Calendar.DATE);
                if (date2Date <= date1Date) {
                    age = year2 - year1;
                } else {
                    age = year2 - year1 - 1;
                }
            } else {
                age = year2 - year1 - 1;
            }
        }
        return String.valueOf(age);
    }
}
