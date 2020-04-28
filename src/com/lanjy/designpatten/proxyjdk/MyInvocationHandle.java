package com.lanjy.designpatten.proxyjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author：lanjy
 * @date：2020/4/28
 * @description：代理对象
 * 不需要实现接口
 */
public class MyInvocationHandle implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtils.method1();
        method.invoke(target, args);
        DogUtils.method2();
        return null;
    }
}
