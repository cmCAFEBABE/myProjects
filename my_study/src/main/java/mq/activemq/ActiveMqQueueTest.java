/**
 * @(#)ActiveMqTest.java, 2020-09-15.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.ScheduledMessage;
import org.junit.Test;

import javax.jms.*;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ActiveMqQueueTest {

    private final String ACTIVEMQ_URL = "nio://124.70.151.153:61618";
    private final String ACTIVEMQ_QUEUE = "queue01";

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
        Queue queue = session.createQueue(ACTIVEMQ_QUEUE);
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = session.createTextMessage(ACTIVEMQ_QUEUE + "current index = " + i);
            producer.send(textMessage);
        }
        producer.close();
        session.close();
        connection.close();
        System.out.println("发送成功");

    }

    /**
     * 延时 周期 发布
     * @throws JMSException
     */
    @Test
    public void produce2() throws JMSException {
        //1.创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.获得连接,启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3.创建会话
        //参数1 事务  2签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地（队列还是topic）
        Queue queue = session.createQueue(ACTIVEMQ_QUEUE);
        MessageProducer producer = session.createProducer(queue);

        long delay = 3*1000;
        long period = 3*1000;
        int repeat = 5;

        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = session.createTextMessage(ACTIVEMQ_QUEUE + "current index = " + i);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY,delay);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD,period);
            textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT,repeat);
            producer.send(textMessage);
        }
        producer.close();
        session.close();
        connection.close();
        System.out.println("发送成功");

    }

    /**
     * 阻塞普通消费
     * @throws JMSException
     */
    @Test
    public void consumer() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        //配置消费失败 重试策略
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setMaximumRedeliveries(3);
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);


        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(ACTIVEMQ_QUEUE);
        MessageConsumer consumer = session.createConsumer(queue);
        for (int i = 0; i < 9999; i++) {
            TextMessage receive = (TextMessage) consumer.receive();
            if(receive!=null){
                System.out.println("接收到的消息:"+i+receive.getText());
            }
        }
        //事务打开后一定要记得提交
        //session.commit();
        consumer.close();
        session.close();
        connection.close();
    }


    /**
     * 定时普通消费
     * @throws JMSException
     */
    @Test
    public void inTimeConsumer() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(ACTIVEMQ_QUEUE);
        MessageConsumer consumer = session.createConsumer(queue);
        for (int i = 0; i < 10; i++) {
            TextMessage receive = (TextMessage) consumer.receive(2000L);
            if(receive!=null){
                System.out.println("接收到的消息:"+receive.getText());
            }
        }
        consumer.close();
        session.close();
        connection.close();
    }

    /**
     * 监听消费
     * @throws JMSException
     */
    @Test
    public void listenConsumer() throws Exception {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(ACTIVEMQ_QUEUE);
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(o -> onMessage(o));
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}