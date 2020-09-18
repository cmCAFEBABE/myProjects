/**
 * @(#)PayWayEnm.java, 2020-09-13.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.common.enums;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public enum PayWayEnm {
    ZHIFUBAO("支付宝"),
    WEIXIN("微信");
    private String name;

    PayWayEnm(String name) {
        this.name = name;
    }
}