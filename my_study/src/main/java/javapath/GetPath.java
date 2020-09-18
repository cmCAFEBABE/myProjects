/**
 * @(#)GetPath.java, 2020-07-28.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package javapath;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */

/**
 * 方式1，使用绝对路径的方式加载；
 * 方式2，使用相对路径当前类所在的classpath（类路径）的根路径(classes目录)加载资源文件；
 * 方式3，使用相对路径—相对于当前字节码文件所在的位置加载资源文件；@author 陈敏(chenmin5 @ corp.netease.com)
 */
public class GetPath {
    /**
     * 使用绝对路径
     */
    @Test
    public void test() {
        String path = "/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/test.filestream";
        try(InputStream inputStream = new FileInputStream(path) ){
            printInputStream(inputStream);
        }catch (Exception e){
            System.out.println("exception");
        }
    }

    /**
     *使用相对路径：classpath(类路径)的根目录（classes目录）加载资源文件
     *
     * 1：使用当前类获取 test2
     * 2：使用当前线程的类加载器获取 test3
     */
    @Test
    public void test2() throws Exception{
        ClassLoader classLoader = GetPath.class.getClassLoader();
        System.out.println();
        InputStream resourceAsStream = classLoader.getResourceAsStream("test/test.file");
        printInputStream(resourceAsStream);
    }
    @Test
    public void test3() throws Exception{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("test/test.file");
        printInputStream(resourceAsStream);
    }

    private void printInputStream(InputStream inputStream) throws Exception{
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.toString());
    }

    /**
     * 字节码所在的位置的相对路径
     */
    @Test
    public void test4() throws Exception{
        InputStream resourceAsStream = GetPath.class.getResourceAsStream("../test/test.filestream");
        printInputStream(resourceAsStream);
    }
    /**
     * 使用classPath ERROR
     */
    @Test
    public void test5() {
        String path = "classpath:test/test.filestream";
        try(InputStream inputStream = new FileInputStream(path) ){
            printInputStream(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 各种路径
     */
    @Test
    public void test6() {
        System.out.println(this.getClass().getResource(""));
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getClassLoader().getResource(""));
        System.out.println(this.getClass().getClassLoader().getResource("/"));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemClassLoader().getResource("").getPath());
    }
    /**
     *Spring ClassPathResource
     */
    @Test
    public void test7() throws Exception{
        ClassPathResource classPathResource = new ClassPathResource("test/test.file");
        System.out.println(classPathResource.getClassLoader().getResource(""));
        File file = classPathResource.getFile();
        InputStream inputStream = new FileInputStream(file);
        printInputStream(inputStream);
    }


}