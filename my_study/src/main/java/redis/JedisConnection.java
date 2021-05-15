/**
 * @(#)JedisConnection.java, 2020-09-10.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class JedisConnection {

    private static String host = "121.5.224.189";
    private static int port = 6379;
    private static String password = "19950808";
    private static Jedis jedis = null;

    static {
        jedis = new Jedis(host, port);
        jedis.auth(password);
    }

    @Test
    public void testApi() {
        jedis.set("static", "123");
    }
}