/**
 * @(#)TransactionTest.java, 2020-07-25.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.mystudy.test.transaction;

import com.study.my_springboot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class TransactionTest {
    @Autowired
    AccountMapper accountMapper;

//    @Test
//    public void getAllAcountList(){
//        System.out.println(accountMapper.getAllAccountList());
//    }
}