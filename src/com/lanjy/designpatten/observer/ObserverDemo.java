package com.lanjy.designpatten.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：主题（一） ==> 订阅者（多）
 */
public class ObserverDemo {
    public static void main(String[] args) {
        WechatServer wechatServer = new WechatServer();
        wechatServer.attact(new WechatUserLan());
        wechatServer.attact(new WechatUserTimi());

        wechatServer.sentInfomation("微信公众号12306发布一条推送");
    }

}

/**
 * 订阅者接口
 * update方法在得到主题的通知是更新自己
 */
interface Observer{
    void update(Object o);
}
//微信用户wechatUserLan
class WechatUserLan implements Observer{
    @Override
    public void update(Object o) {
        read(o);
    }
    private void read(Object o){
        System.out.println("微信用户WechatUserLan,接收到信息："+o.toString());
    }
}

//微信用户WechatUserTimi
class WechatUserTimi implements Observer{
    @Override
    public void update(Object o) {
        read(o);
    }
    private void read(Object o){
        System.out.println("微信用户WechatUserTimi,接收到信息："+o.toString());
    }
}
/**
 * 定义一个主题，也就是一个抽象的被观察者
 * 它把所有对观察者对象的引用保存在一个集合中，
 * 每个主题都可以有任意数量的观察者。
 * 抽象主题提供一个接口，可以增加和删除观察者角色。
 * 一般用一个抽象类或接口来实现。
 */
interface Subject {
    /**
     * 添加观察者
     * @param observer
     */
    void attact(Observer observer);
    /**
     * 移除观察者
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知所有观察者
     */
    void notifyObserver(Object o);
}

/**
 * 模拟一个微信公众号服务
 */
class WechatServer implements Subject {
    //定义一个容器，用来存储订阅者的引用对象
    private List<Observer> list = new ArrayList<Observer>();;

    @Override
    public void attact(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver(Object message) {
        for(Observer observer : list){
            observer.update(message);
        }
    }
    //公众号推送一条信息
    public void sentInfomation(String message) {
        System.out.println("微信服务更新消息： " + message);
        notifyObserver(message);
    }
}