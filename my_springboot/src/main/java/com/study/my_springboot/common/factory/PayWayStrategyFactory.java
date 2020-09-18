/**
 * @(#)PayWayStrategyFactory.java, 2020-09-13.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.common.factory;

import com.google.common.collect.Maps;
import com.study.my_springboot.common.enums.PayWayEnm;
import com.study.my_springboot.common.strategy.pay.PayStrategy;

import java.util.Map;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class PayWayStrategyFactory {
    public static final Map<PayWayEnm, PayStrategy> strategyMap = Maps.newHashMap();

    public static PayStrategy getPayStrategy(PayWayEnm payWayEnm){
        return strategyMap.get(payWayEnm);
    }
    public static void register(PayWayEnm payWayEnm,PayStrategy payStrategy){
        strategyMap.put(payWayEnm,payStrategy);
    }
}