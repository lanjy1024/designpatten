package com.lanjy.designpatten.proxystatic;

/**
 * @author：lanjy
 * @date：2020/4/28
 * @description：
 * 步骤 2
 * 创建实现接口的实体类
 * 真实对象____目标对象
 *
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("RealImage Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("RealImage Loading " + fileName);
    }
}
