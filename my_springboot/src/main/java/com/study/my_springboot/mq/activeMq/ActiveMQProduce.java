/**
 * @(#)ActiveMQProduce.java, 2020-09-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.mq.activeMq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.UUID;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Component
@EnableJms
public class ActiveMQProduce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void produceQueueMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"boot-queue:"+ UUID.randomUUID().toString());
    }

    /**
     * 间隔3秒定投
     * 直接开启主启动类 即可间隔调用该方法
     */
    @Scheduled(fixedDelay = 3000)
    public void produceQueueMsgSchedule(){
        jmsMessagingTemplate.convertAndSend(queue,"********Queue******* boot-queue-scheduled:"+ UUID.randomUUID().toString());
        System.out.println("********Queue******* boot-queue-scheduled:send OK");
    }
    @Scheduled(fixedDelay = 3000)
    public void produceTopicSchedule(){
        jmsMessagingTemplate.convertAndSend(topic,"********Topic******* boot-topic-scheduled:"+ UUID.randomUUID().toString());
        System.out.println("********Topic******* boot-topic-scheduled:send OK");
    }

}