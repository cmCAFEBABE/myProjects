/**
 * @(#)AccountController.java, 2020-07-25.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.controller;

import com.study.my_springboot.aspects.UserBehavior;
import com.study.my_springboot.common.enums.PayWayEnm;
import com.study.my_springboot.entity.Account;
import com.study.my_springboot.service.AccountSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountSerice accountSerice;

    @RequestMapping("/getAll")
    public List<Account> getAccoutAllList() {
        return accountSerice.getAllAccountList();
    }

    @RequestMapping("/transferMoney")
//    @UserBehavior(behavior = "test")
    public List<Account> transferMoney() {
        accountSerice.transferMoney("tom", "jack", 1000d);
        return accountSerice.getAllAccountList();
    }


    @PostMapping("/testAspect")
    @UserBehavior(behavior = "testAspect")
    public List<Account> transferMoney(@RequestBody Account account) {
        accountSerice.transferMoney("tom", "jack", 1000d);
        return accountSerice.getAllAccountList();
    }
    @GetMapping("/pay")
    public String payWay(PayWayEnm payWay){
        return accountSerice.pay(payWay);
    }
    @GetMapping("/cancel")
    public String cancel(PayWayEnm payWay){
        return accountSerice.cancel(payWay);
    }
}