package com.yxm.spring5.test;

import com.yxm.spring5.service.UserService;
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
    //通过注解创建bean
    @Test
    public void test() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        //2.获取对象
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.test();
    }

}
