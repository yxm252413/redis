package com.yxm.spring5.factoryBean;

import com.yxm.spring5.bean.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Classname MyBean
 * @Description TODO
 * @Date 2021/1/11
 * @Created by yxm
 */
public class MyBean implements FactoryBean {
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
