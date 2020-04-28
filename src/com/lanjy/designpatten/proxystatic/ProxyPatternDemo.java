package com.lanjy.designpatten.proxystatic;

/**
 * @author：lanjy
 * @date：2020/4/28
 * @description：
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("====");
        // 图像不需要从磁盘加载
        image.display();
        System.out.println("====");
        Image realImage = new RealImage("test_10mb.jpg");
        realImage.display();
    }
}
