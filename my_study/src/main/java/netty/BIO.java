/**
 * @(#)BIO.java, 2020-10-21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package netty;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class BIO {
    public static void main(String[] args) throws Exception {
        //1.创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //2.创建ServiceSocket 监听6666 端口号
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while (true) {
            //开始监听
            Socket acceptSocket = serverSocket.accept();
            executorService.submit(() -> {
                runSocket(acceptSocket);
            });
        }

    }

    private static void runSocket(Socket socket) {
        System.out.println("当前线程Id:" + Thread.currentThread().getId() + "当前线程Name:" + Thread.currentThread().getName());
        try (InputStream inputStream = socket.getInputStream()) {
            byte[] bytes = new byte[1024];
            int read = 0;
            while ((read = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("socket处理结束");

    }
}