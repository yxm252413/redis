package com.yxm.spring5;

/**
 * @Classname Book2
 * @Description TODO
 * @Date 2021/1/10
 * @Created by yxm
 */
public class Book2 {
    private String bname;

    //设置null
    private String bautor;

    public Book2 setBname(String bname) {
        this.bname = bname;
        return this;
    }

    public Book2 setBautor(String bautor) {
        this.bautor = bautor;
        return this;
    }

    public void testDemo() {
        System.out.println(bname + "::" + bautor);
    }
}
