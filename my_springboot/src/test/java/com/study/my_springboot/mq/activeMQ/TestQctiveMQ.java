/**
 * @(#)TestQctiveMQ.java, 2020-09-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.mq.activeMQ;

import com.study.my_springboot.MySpringbootApplication;
import com.study.my_springboot.mq.activeMq.ActiveMQProduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@SpringBootTest(classes = MySpringbootApplication.class)
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestQctiveMQ {
    @Autowired
    private ActiveMQProduce activeMQProduce;

    @Test
    public void testActiveMQProduce() throws Exception{
        activeMQProduce.produceQueueMsg();
    }
}