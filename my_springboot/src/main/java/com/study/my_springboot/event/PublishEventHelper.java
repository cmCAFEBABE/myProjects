/**
 * @(#)PublishEventHelper.java, 2020-12-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.event;

import com.study.my_springboot.bean.pojo.SimpleEventDTO;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Component
public class PublishEventHelper extends ApplicationObjectSupport {

    public void testPushEvent() {
        getApplicationContext().publishEvent(new SimpleEventDTO("key1", "value1"));
    }

    public void testPushEvent2() {
        getApplicationContext().publishEvent(new SimpleEventDTO("key2", "value2"));
    }
}