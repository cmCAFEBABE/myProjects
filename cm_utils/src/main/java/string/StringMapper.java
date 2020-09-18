/**
 * @(#)stringMapper.java, 2020-07-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package string;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class StringMapper {
    public static Map<String, String> map = Maps.newHashMap();
    static {
        map.put("string","String");
        map.put("int","Integer");
        map.put("double","Double");
        map.put("bigint","Long");
    }
}