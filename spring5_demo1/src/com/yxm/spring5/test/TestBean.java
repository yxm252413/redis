package com.yxm.spring5.test;

import com.yxm.spring5.Book2;
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
    @Test
    public void test() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        //2.获取对象
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
