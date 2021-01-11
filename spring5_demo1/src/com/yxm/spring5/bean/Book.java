package com.yxm.spring5.bean;

import java.util.List;

/**
 * @Classname Book
 * @Description TODO
 * @Date 2021/1/11
 * @Created by yxm
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test() {
        System.out.println(list);
    }
}
