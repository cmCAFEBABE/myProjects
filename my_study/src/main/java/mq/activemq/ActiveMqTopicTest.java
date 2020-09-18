/**
 * @(#)ActiveMqTopicTest.java, 2020-09-16.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ActiveMqTopicTest {

    private final String ACTIVEMQ_URL = "tcp://124.70.151.153:61616";
    private final String ACTIVEMQ_TOPIC = "activemqTopicTest";

    private static void onMessage(Message o) {
        if (o != null && o instanceof TextMessage) {
            try {
                System.out.println(((TextMessage) o).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void produce() throws JMSException {
        //1.创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.获得连接,启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3.创建会话
        //参数1 事务  2签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地（队列还是topic）
        Topic queue = session.createTopic(ACTIVEMQ_TOPIC);
        MessageProducer producer = session.createProducer(queue);
        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = session.createTextMessage(ACTIVEMQ_TOPIC + "current topic index = " + i);
            producer.send(textMessage);
        }
        producer.close();
        session.close();
        connection.close();
        System.out.println("发送成功");

    }


    /**
     * 监听消费1
     * @throws JMSException
     */
    @Test
    public void listenConsumer1() throws Exception {
        System.out.println("consumer : 1");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(ACTIVEMQ_TOPIC);
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(o -> onMessage(o));
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
    /**
     * 监听消费2
     * @throws JMSException
     */
    @Test
    public void listenConsumer2() throws Exception {
        System.out.println("consumer : 2");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(ACTIVEMQ_TOPIC);
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(o -> onMessage(o));
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}