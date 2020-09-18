/**
 * @(#)PayStrategy.java, 2020-09-13.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.common.strategy.pay;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public abstract class PayStrategy implements InitializingBean {
    public String pay(){
        throw new UnsupportedOperationException();
    }
    public String cancel(){
        throw new UnsupportedOperationException();
    }
}