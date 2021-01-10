package com.yxm.spring5.test;

import com.yxm.spring5.Book;
import com.yxm.spring5.Book1;
import com.yxm.spring5.Book2;
import com.yxm.spring5.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Classname TestString5
 * @Description TODO
 * @Date 2021/1/10
 * @Created by yxm
 */

public class TestString5 {
    @Test
    public void testAdd() {

        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
//        BeanFactory applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\project\\redis\\spring5_demo1\\src\\bean1.xml");
        //2.获取对象
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void testSetter() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取对象
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void testSetter1() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取对象
        Book book = applicationContext.getBean("bookk", Book.class);
        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void testConstructor() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取对象
        Book1 book = applicationContext.getBean("book1", Book1.class);
        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void testBook2() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取对象
        Book2 book = applicationContext.getBean("book2", Book2.class);
        System.out.println(book);
        book.testDemo();
    }
}
