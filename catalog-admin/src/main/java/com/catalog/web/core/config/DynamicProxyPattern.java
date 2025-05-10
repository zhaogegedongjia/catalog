package com.catalog.web.core.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 动态代理模式
 *
 * @author zjd
 * @date 2025-05-09
 */
@Aspect
@Component
public class DynamicProxyPattern {
 
    @Around("execution(* com.catalog.web.controller.tool..*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        // 继续执行原方法
        Object result = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.printf(String.format("%s方法执行耗时：%%d毫秒%%n", pjp.getSignature()), elapsedTime);
        return result;
    }
}