/**
 * @(#)testController.java, 2020-07-25.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.controller;

import com.study.my_springboot.Aspects.MethodTimeCount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@RestController
@RequestMapping("/test")
public class testController {
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


}