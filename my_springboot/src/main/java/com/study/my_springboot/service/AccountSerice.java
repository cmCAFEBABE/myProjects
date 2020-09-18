/**
 * @(#)AccountSerice.java, 2020-07-25.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.service;

import com.study.my_springboot.common.enums.PayWayEnm;
import com.study.my_springboot.entity.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public interface AccountSerice {
    List<Account> getAllAccountList();

    @Transactional
    void transferMoney(String inName, String outName, Double money);

    String pay(PayWayEnm payWay);

    String cancel(PayWayEnm payWay);
}