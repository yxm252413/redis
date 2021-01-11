package com.yxm.spring5.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Classname BeanPost
 * @Description 后置处理器
 * @Date 2021/1/11
 * @Created by yxm
 */
public class BeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("把bean实例传递给bean后置处理器postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("把bean实例传递给bean后置处理器方法postProcessAfterInitialization");
        return bean;
    }
}
