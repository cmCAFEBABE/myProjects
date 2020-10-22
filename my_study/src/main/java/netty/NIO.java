/**
 * @(#)NIO.java, 2020-10-22.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package netty;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class NIO {


    /**
     * 写文件
     * 流程：
     * buffer->channel->file
     */
    @Test
    public void test0() {

        try (FileOutputStream fileOutputStream = new FileOutputStream("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt0.txt")) {

            String str = "测试NIO:buffer->channel->file";
            FileChannel channel = fileOutputStream.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(512);
            //1.内容写入buffer
            allocate.put(str.getBytes());
            allocate.flip();
            //2.buffer 写入channel
            channel.write(allocate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件
     * 流程：
     * file->channel->buffer->显示
     */
    @Test
    public void test1() {
        File file = new File("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt0.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
            channel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 把一个文件1复制到文件2(byteBuffer 一次使用)
     * <p>
     * 流程:
     * file1->channel1->buffer->channel2->file2
     */
    @Test
    public void test() {
        File file = new File("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt0.txt");
        File fileCopy = new File("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt00.txt");
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(fileCopy)
        ) {
            FileChannel channel1 = fileInputStream.getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate((int) file.length());

            //把channel1 里面的内容读到buffer中
            channel1.read(buffer);
            buffer.flip();
            //吧buffer 里面内容写入channel1
            channel2.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 把一个文件1复制到文件2(byteBuffer 循环使用)
     * <p>
     * 流程:
     * file1->channel1->buffer->channel2->file2
     */
    @Test
    public void test2() {
        File file = new File("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt0.txt");
        File fileCopy = new File("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt00.txt");
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(fileCopy)
        ) {
            FileChannel channel1 = fileInputStream.getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(8);

            //把channel1 里面的内容读到buffer中

            while ((channel1.read(buffer)) != -1) {
                //buffer put->reade
                buffer.flip();
                channel2.write(buffer);
                //恢复成初始状态
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 把一个文件1复制到文件2(channel1->channel2)
     * <p>
     * 流程:中间buffer过程封装起来
     * file1->channel1(->buffer->)channel2->file2
     */
    @Test
    public void test3(){
        File file = new File("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt1.txt");
        File fileCopy = new File("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt11.txt");
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(fileCopy)
        ) {
            FileChannel channel1 = fileInputStream.getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();
            channel2.transferFrom(channel1,0,channel1.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}