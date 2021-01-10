package com.yxm.spring5;

/**
 * @Classname Book
 * @Description TODO
 * @Date 2021/1/10
 * @Created by yxm
 */
public class Book1 {
    private String bname;

    private String bautor;

    public Book1(String bname, String bautor) {
        this.bname = bname;
        this.bautor = bautor;
    }

    public void testDemo() {
        System.out.println(bname + "::" + bautor);
    }
}