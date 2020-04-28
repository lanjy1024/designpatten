package com.lanjy.designpatten.proxyjdk;

/**
 * @author：lanjy
 * @date：2020/4/28
 * @description：
 * 动态代理的主要特点就是能够在程序运行时JVM才为被代理对象生成代理对象。
 * 常说的动态代理也叫做JDK代理也是一种接口代理，
 * JDK中生成代理对象的代理类就是Proxy，
 * 所在包是java.lang.reflect
 */
public class ProxyDemo {

    public static void main(String[] args) {
        IDog dog = new GunDog();
        //通过工厂获取代理类
        IDog proxy =(IDog) MyProxyFactory.getProxy(dog);
        proxy.run();
        System.out.println("================");
        IDog singleDog = new SingleDog();
        IDog singleDogProxy = (IDog) MyProxyFactory.getProxy(singleDog);
        singleDogProxy.run();
    }

}
