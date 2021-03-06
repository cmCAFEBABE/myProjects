/**
 * @(#)ConfigBean.java, 2020-09-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.configBean;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;
import java.io.Serializable;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Component
public class ConfigBean {
    @Value("${myqueue}")
    private String myQueue;


    @Value("${myTopic}")
    private String myTopic;

    @Value("${spring.activemq.user}")
    private String userName;
    @Value("${spring.activemq.password}")
    private String password;
    @Value("${spring.activemq.broker-url}")
    private String brokerURL ;


    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(myTopic);
    }



    /**
     * 处理topic消息
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(){
        DefaultJmsListenerContainerFactory factory = getListenerFactory();
        factory.setPubSubDomain(true);
        return factory;
    }

    /**
     * 处理queue消息
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory(){
        DefaultJmsListenerContainerFactory factory = getListenerFactory();
        factory.setPubSubDomain(false);
        return factory;

    }
    private DefaultJmsListenerContainerFactory getListenerFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(userName, password, brokerURL);
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate (LettuceConnectionFactory connectionFactory){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}