package com.freeclassroom;

import lombok.Data;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-23 - 9:48
 */
@Data
public class ClassRoom {
    /**
     * ID
     */
    private Integer id;
    /**
     * 所属教学楼名称
     */
    private String buildingName;

    /**
     * 教室名称 TA101
     */
    private String roomName;

    /**
     * 星期
     */
    private String week;

    /**
     * 节次
     */
    private Integer session;

    /**
     *  上课周
     */
    private List<Integer> schoolWeek;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 班级
     */
    private String className;
}
