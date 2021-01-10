package com.yxm.spring5;

/**
 * @Classname Book
 * @Description TODO
 * @Date 2021/1/10
 * @Created by yxm
 */
public class Book {
    private String bname;

    private String bautor;

    public Book setBname(String bname) {
        this.bname = bname;
        return this;
    }

    public Book setBautor(String bautor) {
        this.bautor = bautor;
        return this;
    }

    public void testDemo() {
        System.out.println(bname + "::" + bautor);
    }
}