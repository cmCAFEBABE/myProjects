/**
 * @(#)ActiveMQConsumer.java, 2020-09-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.mq.activeMq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
//@Component
public class ActiveMQConsumer {

    /**
     * 服务起来后 会自动监听
     * @param textMessage
     * @throws Exception
     */
    @JmsListener(destination = "${myqueue}",containerFactory="queueListenerFactory")
    public void receiveQueueMsg(TextMessage textMessage) throws Exception{
        System.out.println("*****Queue******消费者收到消息:"+textMessage.getText());
    }

    @JmsListener(destination = "${myTopic}",containerFactory="topicListenerFactory")
    public void receiveTopicMsg1(TextMessage textMessage) throws Exception{
        System.out.println("*****Topic******消费者1 收到消息:"+textMessage.getText());
    }

    @JmsListener(destination = "${myTopic}",containerFactory="topicListenerFactory")
    public void receiveTopicMsg2(TextMessage textMessage) throws Exception{
        System.out.println("*****Topic******消费者2 收到消息:"+textMessage.getText());
    }

    @JmsListener(destination = "${myTopic}",containerFactory="topicListenerFactory")
    public void receiveTopicMsg3(TextMessage textMessage) throws Exception{
        System.out.println("*****Topic******消费者3 收到消息:"+textMessage.getText());
    }
}