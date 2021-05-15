/**
 * @(#)circularDependency.java, 2021-03-20.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.test.circularDependency;

import com.study.my_springboot.bean.pojo.A;
import com.study.my_springboot.bean.pojo.B;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class circularDependency {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = context.getBean("a", A.class);
        B b = context.getBean("b", B.class);
    }
}