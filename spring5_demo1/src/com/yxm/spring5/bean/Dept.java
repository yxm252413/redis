package com.yxm.spring5.bean;

/**
 * @Classname Dept
 * @Description 部门类
 * @Date 2021/1/11
 * @Created by yxm
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
