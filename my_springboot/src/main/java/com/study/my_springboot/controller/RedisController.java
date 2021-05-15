/**
 * @(#)RedisController.java, 2021-03-27.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private String goods = "goods";

    @Value("${spring.redis.port}")
    private Integer serverPort;

    @GetMapping("/addGoods")
    public Integer addGoods() {
        Integer append = stringRedisTemplate.opsForValue().append(goods, "1000");
        return append;
    }


    @GetMapping("/bugGoods")
    public String bugGoods() {
        String result = stringRedisTemplate.opsForValue().get(goods);
        Integer goodsNum = result == null ? 0 : Integer.parseInt(result);
        if(goodsNum>0){
            goodsNum--;
            stringRedisTemplate.opsForValue().set(goods,goodsNum.toString());
            return "成功买到商品,当前还剩"+goodsNum+"件,port = "+serverPort;
        }else {
            return "失败买到商品,当前还剩"+goodsNum+"件,port = "+serverPort;
        }
    }
}