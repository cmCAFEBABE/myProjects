/**
 * @(#)B.java, 2021-03-20.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.bean.pojo;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class B {
    public B() {
        System.out.println("--B 实例化完成");
    }

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
        System.out.println("--B 属性填充完成");
    }
}