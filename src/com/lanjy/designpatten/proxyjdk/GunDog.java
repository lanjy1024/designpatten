package com.lanjy.designpatten.proxyjdk;

/**
 * @author：lanjy
 * @date：2020/4/28
 * @description：//目标类
 */
public class GunDog implements IDog{
    @Override
    public void run() {
        System.out.println("猎狗在跑");
    }
}
