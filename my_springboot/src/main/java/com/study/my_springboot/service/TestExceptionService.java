/**
 * @(#)ExceptionException.java, 2020-12-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Service
public class TestExceptionService {

    public void throwException(){
        throw new RuntimeException("这里是运行时异常");
    }

    @Async
    public void throwAsyncException(){
        throw new RuntimeException("这里是运行时异常");
    }
}