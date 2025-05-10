package com.catalog.system.service.design.patterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
/**
 * 动态代理模式
 *
 * @author zjd
 * @date 2025-05-09
 */
public class ProxyInvocationHandler implements InvocationHandler {
    Object target;
    public void setTarget(Object target) {
        this.target = target;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this );
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long endTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.printf(String.format("%s方法执行耗时：%%d毫秒%%n", method.getName()), endTime - startTime);
        return result;
    }
 
}