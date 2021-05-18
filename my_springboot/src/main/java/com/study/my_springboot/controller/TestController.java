/**
 * @(#)testController.java, 2020-07-25.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.study.my_springboot.aspects.MethodTimeCount;
import com.study.my_springboot.bean.pojo.TestException;
import com.study.my_springboot.event.PublishEventHelper;
import com.study.my_springboot.service.TestExceptionService;
import com.study.my_springboot.test.DemoData;
import com.study.my_springboot.test.DemoDataListener;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    PublishEventHelper publishEventHelper;


    @Autowired
    TestExceptionService exceptionService;

    @Autowired
    Environment environment;

    @RequestMapping("/helloworld")
//    @UserBehavior(behavior = "test")
    @MethodTimeCount
    public String helloworld() {
        return "helloworld";
    }

    @RequestMapping("/only/for/liyunian")
    public String onlyForliyunian() {
        return "小胖子,陈先生爱你哦！";
    }


    @RequestMapping("/getPath")
    public String getPath(HttpServletRequest request) {
        System.out.println(request.getServletPath());
        return request.getServletPath();
    }

    @GetMapping("/testEvent")
    public void testEvent(){
        publishEventHelper.testPushEvent();
    }

    @GetMapping("/testEvent2")
    public void testEvent2(){
        publishEventHelper.testPushEvent2();
    }

    @GetMapping("/testException")
    public void testException(){
        exceptionService.throwException();
        System.out.println("异步不影响主流程");
    }

    @GetMapping("/throwAsyncException")
    public void throwAsyncException(){
        exceptionService.throwAsyncException();
        System.out.println("异步不影响主流程");
    }

    @GetMapping("/testCollectionParams")
    public void testCollectionParams(@RequestParam Set<String> sets){
        sets.forEach(System.out::println);
    }

    @GetMapping("/testCollectionParams2")
    public void testCollectionParams2(Set<String> sets){
        sets.forEach(System.out::println);
    }

    @PostMapping("/quoteMultiToOneWarehouse")
    public void testController(@RequestParam(value="filename") MultipartFile file){
        try {
            ArrayList<DemoData> objects = Lists.newArrayList();
            EasyExcel.read(file.getInputStream(), DemoData.class, new DemoDataListener(objects)).sheet().doRead();
            System.out.println("111");
            System.out.println(JSON.toJSON(objects));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @GetMapping("/testEnv")
    public void testEnv(){
        System.out.println(JSON.toJSONString(environment.getActiveProfiles()));
        System.out.println("-----------------");
        System.out.println(JSON.toJSONString(environment));
        System.out.println("-----------------");
        System.out.println(environment.getProperty("myTopic"));
        System.out.println("-----------------");
        System.out.println(environment.getProperty("testNull","必须要有值"));
    }


    @GetMapping("/testExceptionHandle")
    public void testExceptionHandle(){
        System.out.println("123");
        throw new TestException("test");
    }
    @ExceptionHandler(TestException.class)
    public ResponseEntity handleException(TestException e){
        System.out.println(e.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("test","123");
        return new ResponseEntity(httpHeaders,HttpStatus.RESET_CONTENT);
    }
}