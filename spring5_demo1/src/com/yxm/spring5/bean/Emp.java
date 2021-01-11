package com.yxm.spring5.bean;

/**
 * @Classname Emp
 * @Description 员工类
 * @Date 2021/1/11
 * @Created by yxm
 */
public class Emp {
    private String ename;
    private String gender;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    //员工属于某个部门，使用对象形式表示
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void add() {
        System.out.println(ename + "::" + gender + "::" + dept);
    }
}
