/**
 * @(#)AccountMapper.java, 2020-07-25.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.mapper;

import com.study.my_springboot.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Mapper
public interface AccountMapper {

    List<Account> getAllAccountList();

    int addMoney( @Param("inName")String inName, @Param("money")Double money);

    int deleteMoney(@Param("outName")String outName, @Param("money")Double money);
}