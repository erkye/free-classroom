package com.freeroom.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 李发展
 * @date 2020-8-25 - 20:52
 * 教学周计算工具类
 */
public class SchoolTimeUtil {

    /**
     * 学期开始时间 1598803200000L 2020年8月31
     * 1598198400000L 2020年8月24 星期一 测试使用
     */
    public static final Date startTime = new Date(1598803200000L);


    /**
     * 计算教学周
     * @param date
     * @return
     */
    public static int getSchoolWeek(Date date){
        int schoolWeek = -1;
        if(date.after(startTime)){
          schoolWeek = (int) ((date.getTime() - startTime.getTime()) / (1000 * 60 * 60 * 24 * 7)) + 1;
        }
        return schoolWeek;
    }

    /**
     * 获取日期对应的星期名称 如 周一
     * @param date
     * @return
     */
    public static String getWeekString(Date date){
        String[] weeks = new String[]{"周日","周一","周二","周三","周四","周五","周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(w < 0) {
            w=0;
        }
        return weeks[w];

    }


}
