package com.car.demo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {//解决获取某月的第一天和最后一天
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Date getLastDayOfMonth(int year, int month) {
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
        return cal.getTime();//sdf.format()
    }

    public static Date getFisrtDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);

        return cal.getTime();//sdf.format()
    }

    public static Date getFirstDayofThisMonth() {
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return c.getTime();//sdf.format()
    }

    public static Date getLastDayofThisMonth() {
        //获取当前月最后一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();//sdf.format()
    }

//    public static void main(String[] args) {
//        Date firstDay = getFisrtDayOfMonth(2014, 2);
//        System.out.println("获取指定月的第一天：" + sdf.format(firstDay));
//        Date lastDay = getLastDayOfMonth(2014, 2);
//        System.out.println("获取指定月的最后一天：" + sdf.format(lastDay));
//        System.out.println("当月第一天："+sdf.format(getFirstDayofThisMonth()));
//        System.out.println("当月最后一天："+sdf.format(getLastDayofThisMonth()));
//    }
}
