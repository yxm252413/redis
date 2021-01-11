package com.yxm.spring5.server;

import com.yxm.spring5.dao.UserDao;
import com.yxm.spring5.dao.impl.UserDaoImpl;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/1/11
 * @Created by yxm
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("...................UserService  add");
        userDao.update();
    }
}
