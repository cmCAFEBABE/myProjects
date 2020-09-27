/**
 * @(#)UserBehaviorAspect.java, 2020-08-06.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.aspects;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Aspect
@Component
public class UserBehaviorAspect {

    @Pointcut("@annotation(com.study.my_springboot.aspects.UserBehavior)")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        System.out.println("我在方法执行前执行");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("我在方法执行后执行");
    }

    @AfterReturning("pointCut()")
    public void afterReturn() {
        System.out.println("我在方法执行后执行，如果方法有异常则不执行");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("我在方法执行前一刻执行");
        Object resultObject = joinPoint.proceed();
        UserBehavior declaredAnnotation = getDeclaredAnnotation(joinPoint);
        System.out.println(declaredAnnotation.behavior());
        System.out.println("我在方法执行后一刻执行,环绕通知可查看连接点的方法和参数，可进行操作验证");
        return  resultObject ;
    }



    /**
     * 获取方法中声明的注解
     *
     * @param joinPoint
     * @return
     * @throws NoSuchMethodException
     */
    public UserBehavior getDeclaredAnnotation(ProceedingJoinPoint joinPoint) throws NoSuchMethodException,ClassNotFoundException {
        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
////            System.out.println("参数="+ JSON.toJSONString(arg)+" ");
//        }
//        String[] fieldsName = getFieldsName(joinPoint);
//        Arrays.stream(fieldsName).forEach(System.out::println);
/*        for (int i = 0; i < args.length; i++) {
            System.out.println(fieldsName[i]+":"+JSON.toJSONString(args[i]));
        }*/
        System.out.println(getArgs(joinPoint));
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        System.out.println("方法名"+methodName);

        // 反射获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        // 拿到方法对应的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        // 根据类、方法、参数类型（重载）获取到方法的具体信息
        Method objMethod = targetClass.getMethod(methodName, parameterTypes);
        System.out.println(objMethod);
        // 拿到方法定义的注解信息
        UserBehavior annotation = objMethod.getDeclaredAnnotation(UserBehavior.class);
        // 返回
        return annotation;
    }

    /**
     * 获取方法参数
     * @param pjp
     * @return
     */
    public static String getArgs(ProceedingJoinPoint pjp){
        if (pjp == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] parameterNames = ((MethodSignature) pjp.getSignature()).getParameterNames();
        Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        // todo zhangenli: 部分环境下参数名为null，会影响到测试。先跳过。
        if (null == parameterNames) {
            return "";
        }
        for (int i = 0; i < parameterNames.length; i++) {
            Class type = parameterTypes[i];
            if (ServletRequest.class.isAssignableFrom(type) || ServletResponse.class.isAssignableFrom(type)) {
                continue;
            }
            if (sb.length() != 0) {
                sb.append(",");
            }
            Object arg = pjp.getArgs()[i];
            sb.append(parameterNames[i] + "=" + JSON.toJSONString(arg));

        }
        return sb.toString();
    }


    //返回方法的参数名
    private static String[] getFieldsName(JoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException {
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Class<?>[] classes = new Class[args.length];
        for (int k = 0; k < args.length; k++) {
            if (args[k]!=null&&(!args[k].getClass().isPrimitive())) {
                //获取的是封装类型而不是基础类型
                String result = args[k].getClass().getName();
                Class s = map.get(result);
                classes[k] = s == null ? args[k].getClass() : s;
            }
        }
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        //获取指定的方法，第二个参数可以不传，但是为了防止有重载的现象，还是需要传入参数的类型
        Method method = Class.forName(classType).getMethod(methodName, classes);
        String[] parameterNames = pnd.getParameterNames(method);
        return parameterNames;
    }
    private static HashMap<String, Class> map = new HashMap<String, Class>() {
        {
            put("java.lang.Integer", int.class);
            put("java.lang.Double", double.class);
            put("java.lang.Float", float.class);
            put("java.lang.Long", long.class);
            put("java.lang.Short", short.class);
            put("java.lang.Boolean", boolean.class);
            put("java.lang.Char", char.class);
        }
    };
}