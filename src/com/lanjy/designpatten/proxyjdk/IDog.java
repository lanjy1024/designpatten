package com.lanjy.designpatten.proxyjdk;

/**
 * @author：lanjy
 * @date：2020/4/28
 * @description：目标类接口
 * 动态代理的主要特点就是能够在程序运行时JVM才为"被代理对象"生成"代理对象"。
 * 常说的动态代理也叫做JDK代理也是一种接口代理，
 * JDK中生成代理对象的代理类就是Proxy，所在包是java.lang.reflect
 */
public interface IDog {
    void run();
}
