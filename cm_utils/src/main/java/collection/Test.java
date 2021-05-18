/**
 * @(#)Test.java, 2020-11-24.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package collection;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class Test {
    @org.junit.Test
    public void test2(){
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        for (String str:list){
            if("2".equals(str)){
                list.remove(str);
            }
        }
        System.out.println(list);
    }

    @org.junit.Test
    public void test(){
        Map<Integer,Integer> map = Maps.newHashMap();
        map.put(null,1);
        System.out.println(JSON.toJSONString(map));
    }

    @org.junit.Test
    public void test3(){
        TreeSet<String> set = new TreeSet<>();
        HashSet<String> set2 = new HashSet<>();
        LinkedHashSet<String> set3 = new LinkedHashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(String.valueOf(i));
            set2.add(String.valueOf(i));
            set3.add(String.valueOf(i));
        }
        System.out.println(set);
        System.out.println(set2);
        System.out.println(set3);
    }
    @org.junit.Test
    public void test4(){
        boolean flag = new Object()==null;
        boolean flag2 =  null==new Object();
        System.out.println(flag);
        System.out.println(flag2);
    }
}