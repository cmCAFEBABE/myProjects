/**
 * @(#)TodoTaskTypeViewTypeMap.java, 2020-11-26.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class TodoTaskTypeViewTypeMap {
    private String type;
    private String  showRule;

    public static void main(String[] args) {
        String json = "[1,2,3]";

        List<String> l = JSON.parseObject(json, new TypeReference<List<String>>(){});

        System.out.println(l);

        for (String s : l) {
            System.out.println(s);
        }
    }
}