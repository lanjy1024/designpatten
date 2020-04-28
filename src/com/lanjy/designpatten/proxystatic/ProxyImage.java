package com.lanjy.designpatten.proxystatic;

/**
 * @author：lanjy
 * @date：2020/4/28
 * @description：
 * 代理对象
 * 代理类需要有真实对象的控制权 (引用)
 *
 * 静态代理总结:
 * 优点：可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 缺点:
 * 因为代理对象需要与目标对象实现一样的接口,
 * 所以会有很多代理类,类太多.
 * 同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * 而动态代理方式可以解决上面的问题
 */
public class ProxyImage implements Image{
    //目标对象RealImage:被增强的对象
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("=========before=========display");
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
        System.out.println("=========after=========display");
    }
}
