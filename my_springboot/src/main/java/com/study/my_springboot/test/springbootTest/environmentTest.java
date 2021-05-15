/**
 * @(#)environmentTest.java, 2021-03-21.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.test.springbootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class environmentTest {
    @Autowired
    Environment environment;

    @Test
    public void testEnvConfig(){
        System.out.println(environment.getActiveProfiles());
        System.out.println("test OK");
        System.out.println("---------------------");
        System.out.println(environment.getProperty("myTopic"));
    }
}