/**
 * @(#)MethodTimeCountAspect.java, 2020-09-14.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Aspect
@Component
public class MethodTimeCountAspect {
    @Pointcut("@annotation(com.study.my_springboot.Aspects.MethodTimeCount)")
    public void pointCut() {}


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object resultObject = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName+"costTime:"+(endTime-startTime)+"ms");
        return resultObject;

    }
}