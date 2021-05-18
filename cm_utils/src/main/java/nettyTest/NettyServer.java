/**
 * @(#)NettyServer.java, 2021-03-11.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package nettyTest;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class NettyServer {
    public static void main(String[] args) {
        //创建 BossGroup 和 WorkerGroup
//说明
//1. 创建两个线程组 bossGroup 和 workerGroup
//2. bossGroup 只是处理连接请求 , 真正的和客户端业务处理，会交给 workerGroup 完成 //3. 两个都是无限循环
//4. bossGroup 和 workerGroup 含有的子线程(NioEventLoop)的个数
// 默认实际cpu核数*2
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
    }
}