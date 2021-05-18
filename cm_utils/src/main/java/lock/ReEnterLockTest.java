/**
 * @(#)ReEnterLockTest.java, 2021-03-11.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package lock;


import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ReEnterLockTest {
    Object o = new Object();

    @Test
    public void test() {
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + "times:" + i);
                }
            }
        }).start();
    }

    @Test
    public void test1() {
        test2();
    }

    public synchronized void test2() {
        System.out.println(2);
        test3();
    }

    public synchronized void test3() {
        System.out.println(3);
        test4();
    }

    public synchronized void test4() {
        System.out.println(4);
    }


    @Test
    public void test5() {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                int times = 5;
                for (int i = 0; i < times; i++) {
                    lock.lock();
                    System.out.println(i);
                    lock.unlock();
                }
            } finally {
//                lock.unlock();
            }
        }).start();
        System.out.println("-----------");
        new Thread(() -> {
            lock.lock();
            try {
                int times = 5;
                for (int i = 0; i < times; i++) {
                    lock.lock();
                    System.out.println("beta2   " + i);
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }).start();


    }

    @Test
    public void test6() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println(1);
            try {
                try {
                    System.out.println("开始阻塞");
                    condition.await();
                    System.out.println("done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            lock.lock();
            System.out.println(2);
            try{
                System.out.println("开始通知");
                condition.signal();
            }finally {
                lock.unlock();
            }
        }).start();
    }
}