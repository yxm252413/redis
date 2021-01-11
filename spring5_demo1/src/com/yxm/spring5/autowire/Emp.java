package com.yxm.spring5.autowire;

/**
 * @Classname Emp
 * @Description TODO
 * @Date 2021/1/11
 * @Created by yxm
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void test() {
        System.out.println(dept);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}
