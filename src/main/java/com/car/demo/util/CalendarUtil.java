package com.car.demo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarUtil {//解决获取某月的第一天和最后一天
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    public static String getFisrtDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        // 格式化日期
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    public static void main(String[] args) {
        String firstDay = getFisrtDayOfMonth(2014, 2);
        System.out.println("获取指定月的第一天：" + firstDay);
        String lastDay = getLastDayOfMonth(2014, 2);
        System.out.println("获取指定月的最后一天：" + lastDay);

    }
}
