/**
 * @(#)ThreadLocalTest.java, 2020-09-14.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package multhread;

import org.junit.Test;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ThreadLocalTest {
    @Test
    public void test(){
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("123");
        threadLocal.set("1234");

        ThreadLocal threadLocal2 = new ThreadLocal();
        threadLocal2.set("456");
        threadLocal2.set("4567");
        Thread thread = Thread.currentThread();
        System.out.println("123");
    }
}