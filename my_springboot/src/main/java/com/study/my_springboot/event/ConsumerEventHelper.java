/**
 * @(#)ConsumerEventHelper.java, 2020-12-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.event;

import com.study.my_springboot.bean.pojo.SimpleEventDTO;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Component
public class ConsumerEventHelper{


    @EventListener(condition = "#simpleEventDTO.key == 'key1'")
    public String testListenEvent(SimpleEventDTO simpleEventDTO){
        System.out.println(simpleEventDTO);
        return simpleEventDTO.toString();
    }

    @EventListener(condition = "#simpleEventDTO.key == 'key2'")
    public String testListenEvent2(SimpleEventDTO simpleEventDTO){
        System.out.println(simpleEventDTO);
        return simpleEventDTO.toString();
    }
}