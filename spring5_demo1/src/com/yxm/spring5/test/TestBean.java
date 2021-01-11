package com.yxm.spring5.test;

import com.yxm.spring5.Book2;
import com.yxm.spring5.bean.*;
import com.yxm.spring5.factoryBean.MyBean;
import com.yxm.spring5.server.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname TestBean
 * @Description TODO
 * @Date 2021/1/11
 * @Created by yxm
 */
public class TestBean {
    //注入属性-bean
    @Test
    public void test() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        //2.获取对象
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

    //注入属性-内部bean
    @Test
    public void test1() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean4.xml");
        //2.获取对象
        Emp emp = applicationContext.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.add();
    }

    //注入属性-集合属性注入array,list,map,set
    @Test
    public void test3() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("StuBean.xml");
        //2.获取对象
        Stu stu = applicationContext.getBean("stu", Stu.class);
        System.out.println(stu);
        stu.test();
    }

    //注入属性-集合属性注入array,list,map,set
    @Test
    public void test4() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Book.xml");
        //2.获取对象
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book);
        book.test();
    }

    //工厂bean
    @Test
    public void test5() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("MyBean.xml");
        //2.获取对象
        Course myBean = applicationContext.getBean("myBean", Course.class);
        System.out.println(myBean);
    }

    //验证默认情况下bean是单实例
    @Test
    public void test6() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Book.xml");
        //2.获取对象
        Book book = applicationContext.getBean("book", Book.class);
        Book book1 = applicationContext.getBean("book", Book.class);
//        地址一样，说明是单实例
        System.out.println(book);//com.yxm.spring5.bean.Book@5d11346
        System.out.println(book1);//com.yxm.spring5.bean.Book@5d11346
        book.test();
    }

    //验证默认情况下bean是单实例
    /*<bean id="book" class="com.yxm.spring5.bean.Book" scope="prototype">
        <property name="list" ref="bookList"></property>
    </bean>*/
    @Test
    public void test7() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Book.xml");
        //2.获取对象
        Book book = applicationContext.getBean("book", Book.class);
        Book book1 = applicationContext.getBean("book", Book.class);
        System.out.println(book);//com.yxm.spring5.bean.Book@5d11346a
        System.out.println(book1);//com.yxm.spring5.bean.Book@7a36aefa
        book.test();
    }

    @Test
    public void test8() {
        //加载配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Orders.xml");
        //2.获取对象
        Orders orders = applicationContext.getBean("orders", Orders.class);
        System.out.println("4.bean可以使用了（获取对象）");
        System.out.println(orders);

        //手动销毁
        applicationContext.close();
    }
}
