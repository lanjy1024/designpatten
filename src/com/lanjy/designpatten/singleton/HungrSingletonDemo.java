package com.lanjy.designpatten.singleton;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * 饿汉式单例模式，所谓饿汉式，本质是借助jvm类加载机制保证实例的唯一。
 * 就是在类加载的时候直接去创建实例化对象；
 * 实现方式可以有多种多样，只要确保在加载的时候创建好实例化对象便可；
 */
public class HungrSingletonDemo {
    public static void main(String[] args) {
        HungrSingleton instance1 = HungrSingleton.getInstance();
        HungrSingleton instance2 = HungrSingleton.getInstance();
        System.out.println(instance1 == instance2);
    }



}

//1、静态成员变量实现饿汉式单例模式
class HungrSingleton{
    //私有化构造函数
    private HungrSingleton() {
    }
    //私有化实例
    private static HungrSingleton instance = new HungrSingleton();
    public static HungrSingleton getInstance(){
        return instance;
    }

}

//2、静态内部类实现饿汉式单例模式
class InnerClassHungrSingleton{
    //私有化构造函数
    private InnerClassHungrSingleton() {
    }
    //私有化静态内部类,静态内部类也是懒加载的
    // 只有在调用getInstance方法并且返回的时候才会初始化
    //这个过程也是借助jvm类加载机制来保证唯一的
    private static class InnerClassHoider{
        //私有化实例
        private static InnerClassHungrSingleton instance = new InnerClassHungrSingleton();
    }

    public static InnerClassHungrSingleton getInstance(){
        return InnerClassHoider.instance;
    }
}

//3、static静态代码块实现饿汉式单例模式
class StaticBlockSingleton {

    // 私有构造
    private StaticBlockSingleton() {}

    private static StaticBlockSingleton instance = null;

    // 静态代码块
    static{
        instance = new StaticBlockSingleton();
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}


//4、内部枚举类实现饿汉式单例模式

class SingletonFactory {

    // 私有化内部枚举类
    private enum EnmuSingleton{
        Singleton;
        private Singleton singleton;

        //枚举类的构造方法在类加载是被实例化
        private EnmuSingleton(){
            singleton = new Singleton();
        }
        public Singleton getInstance(){
            return singleton;
        }
    }
    public static Singleton getInstance() {
        return EnmuSingleton.Singleton.getInstance();
    }
}
class Singleton{
    public Singleton(){}
}