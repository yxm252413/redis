package com.yxm.spring5.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname Stu
 * @Description TODO
 * @Date 2021/1/11
 * @Created by yxm
 */
public class Stu {
    private String[] course;
    private List<String> list;

    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }

    //一个学生学习多门课程
    private List<Course> listCourse;
    private Map<String, String> map;
    private Set<String> set;

    public void setCourse(String[] course) {
        this.course = course;
    }

    public Stu setList(List<String> list) {
        this.list = list;
        return this;
    }

    public Stu setMap(Map<String, String> map) {
        this.map = map;
        return this;
    }

    public Stu setSet(Set<String> set) {
        this.set = set;
        return this;
    }

    public void test() {
        System.out.println(Arrays.toString(course));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(listCourse);
    }
}
