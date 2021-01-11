package com.yxm.spring5.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Classname userservice
 * @Description TODO
 * @Date 2021/1/11
 * @Created by yxm
 */
@Controller
//@Repository
//@Service
//@Component(value = "userService")//等价于<bean id="userService" class=""></bean>;value可以不写，默认是首字母小写的驼峰命名
public class UserService {
    public void test() {
        System.out.println("....................add");
    }
}
