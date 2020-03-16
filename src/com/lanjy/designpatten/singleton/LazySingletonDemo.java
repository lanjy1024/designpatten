package com.lanjy.designpatten.singleton;

/**
 * 懒汉式单例，所谓懒汉式就是类在初始化的时候不去创建实例，
 * 而在调用方法获取实例对象的时候才去判断时候已经实例化，
 * 如未实例化再去创建实例对象。
 *
 * 这在多线程情况下会有个安全隐患，可能会创建多个不同的实例对象。
 *
 * 使用双重检测+同步锁去控制避免线程安全。
 *
 * 指令重排问题，new对象的操作在字节码层面大概分为3个步骤：
 * 1）分配空间
 * 2）初始化
 * 3）引用赋值
 * 指令重排后步骤2和步骤3可能会有调换；
 *
 * 如果线程1分配空间，然后进行引用赋值，还没有初始化的时候
 * 线程2进来发现instance != null；则有可能会发生空指针异常；
 *
 * 针对指令重排问题，可以通过加关键字volatile来修饰，可以防止指令重排。
 *
 *
 */
public class LazySingletonDemo {
    public static void main(String[] args) {
        //在单线程环境下只会生成一个实例
        /*LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance1 == instance2);*/
        //在多线程环境下会产生多个single对象，打印的单例对象的地址不同，说明不是同一个对象

        new Thread( ()->{
            System.out.println(LazySingleton.getInstance());
        }).start();
        new Thread( ()->{
            System.out.println(LazySingleton.getInstance());
        }).start();

        //针对多线程情况下单例模式失效的问题,可以使用双重检查来创建实例
        new Thread( ()->{
            System.out.println(LazySingletonDoubleCheck.getInstance());
        }).start();
        new Thread( ()->{
            System.out.println(LazySingletonDoubleCheck.getInstance());
        }).start();

    }

}


//懒汉式单例
class LazySingleton{
    //私有化构造函数，不允许外部创建实例
    private LazySingleton() {
    }
    //自身创建实例对象并私有化
    private static LazySingleton instance;

    //给外部提供一个公共的获取实例类的方法
    //用延迟加载方式实现了懒汉式单例，但在多线程环境下会产生多个single对象
    public static LazySingleton getInstance(){
        if (instance == null){
            //模拟网络延迟问题,让线程休眠
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }
}



//懒汉式单例+双重检查
class LazySingletonDoubleCheck{
    //私有化构造函数，不允许外部创建实例
    private LazySingletonDoubleCheck() {
    }
    //自身创建实例对象并私有化
    private static LazySingletonDoubleCheck instance;

    //双重检查，如果对象还没实例化，则加同步锁，同步锁里面在加一层判断
    //避免多线程环境下会产生多个single对象的问题
    public static LazySingletonDoubleCheck getInstance(){
        if (instance == null){
            //模拟网络延迟问题,让线程休眠
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             synchronized (LazySingletonDoubleCheck.class){
                 if (instance == null){
                     instance = new LazySingletonDoubleCheck();
                 }
             }
        }
        return instance;
    }



}



//懒汉式单例+双重检查
class LazySingletonDoubleCheckAndVolatile {
    //私有化构造函数，不允许外部创建实例
    private LazySingletonDoubleCheckAndVolatile() {
    }

    //自身创建实例对象并私有化
    private volatile static LazySingletonDoubleCheckAndVolatile instance;

    //双重检查，如果对象还没实例化，则加同步锁，同步锁里面在加一层判断
    //避免多线程环境下会产生多个single对象的问题
    public static LazySingletonDoubleCheckAndVolatile getInstance() {
        if (instance == null) {
            //模拟网络延迟问题,让线程休眠
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LazySingletonDoubleCheckAndVolatile.class) {
                if (instance == null) {
                    instance = new LazySingletonDoubleCheckAndVolatile();
                }
            }
        }
        return instance;
    }
}




