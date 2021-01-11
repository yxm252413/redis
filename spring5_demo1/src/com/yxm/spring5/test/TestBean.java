package com.yxm.spring5.test;

import com.yxm.spring5.Book2;
import com.yxm.spring5.bean.Emp;
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
}