package com.lanjy.designpatten.proxyjdk;

import java.lang.reflect.Proxy;

/**
 * @author：lanjy
 * @date：2020/4/28
 * @description：生产代理对象的工厂
 */
public class MyProxyFactory {

    public static Object getProxy(Object target) {
        MyInvocationHandle handle = new MyInvocationHandle();

        handle.setTarget(target);

        Object proxy = Proxy.newProxyInstance(
                        target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(),
                        handle
        );
        return proxy;
    }

}
