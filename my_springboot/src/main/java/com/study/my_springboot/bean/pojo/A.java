/**
 * @(#)a.java, 2021-03-20.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.bean.pojo;

import com.alibaba.fastjson.JSON;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class A {
    public A() {
        System.out.println("--A 实例化完成");
    }

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
        System.out.println("--A 属性填充完成");
    }
}