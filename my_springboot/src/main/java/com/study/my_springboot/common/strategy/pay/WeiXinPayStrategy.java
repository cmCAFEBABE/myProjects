/**
 * @(#)WeiXinPayStrategy.java, 2020-09-13.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.common.strategy.pay;

import com.study.my_springboot.common.enums.PayWayEnm;
import com.study.my_springboot.common.factory.PayWayStrategyFactory;
import org.springframework.stereotype.Component;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Component
public class WeiXinPayStrategy extends PayStrategy {
    @Override
    public String pay(){
        return "使用微信支付成功";
    }
    @Override
    public String cancel(){
        return "使用微信支付成功";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PayWayStrategyFactory.register(PayWayEnm.WEIXIN,this);
    }
}