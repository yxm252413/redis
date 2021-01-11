package com.yxm.spring5.bean;

/**
 * @Classname Course
 * @Description 课程类
 * @Date 2021/1/11
 * @Created by yxm
 */
public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
