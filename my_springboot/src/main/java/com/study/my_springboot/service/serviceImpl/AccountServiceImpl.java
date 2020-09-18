/**
 * @(#)AccountServiceImpl.java, 2020-07-25.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.service.serviceImpl;

import com.study.my_springboot.Aspects.MethodTimeCount;
import com.study.my_springboot.common.enums.PayWayEnm;
import com.study.my_springboot.common.factory.PayWayStrategyFactory;
import com.study.my_springboot.common.strategy.pay.PayStrategy;
import com.study.my_springboot.entity.Account;
import com.study.my_springboot.mapper.AccountMapper;
import com.study.my_springboot.service.AccountSerice;
import javafx.application.Application;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountServiceImpl implements AccountSerice {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Account> getAllAccountList() {
        return accountMapper.getAllAccountList();
    }

    @Override
//    @MethodTimeCount
    public void transferMoney(String inName, String outName, Double money) {
//        Object o = AopContext.currentProxy();
        accountMapper.deleteMoney(outName,money);
//        int i= 1/0;
        accountMapper.addMoney(inName,money);
    }

    @Override
    public String pay(PayWayEnm payWay) {
        PayStrategy payStrategy = PayWayStrategyFactory.getPayStrategy(payWay);
        return payStrategy.pay();
    }

    @Override
    public String cancel(PayWayEnm payWay) {
        PayStrategy payStrategy = PayWayStrategyFactory.getPayStrategy(payWay);
        return payStrategy.cancel();
    }
}