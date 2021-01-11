package com.yxm.spring5.bean;

/**
 * @Classname Orders
 * @Description 演示bean生命周期
 * @Date 2021/1/11
 * @Created by yxm
 */
public class Orders {
    public Orders() {
        System.out.println("1.通过构造器创建bean实例（无参构造）");
    }

    private String oname;

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("2.为bean的属性设置值和对其他的bean引用（调用set方法）");
    }
    public void initMethod() {
        System.out.println("3.调用bean的初始化方法（需要进行配置初始化方法）");
    }
    public void destoryMethod() {
        System.out.println("5.当容器关闭的时候，调用bean的销毁方法（需要进行配置销毁的方法）");
    }
}
