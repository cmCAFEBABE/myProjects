/**
 * @(#)Test.java, 2020-12-06.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package lambda;

import com.google.common.collect.Lists;
import validation.Pojo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class Test {

    @org.junit.Test
    public void test(){
        Pojo pojo = new Pojo("1", "2");
        Pojo pojo1 = Optional.ofNullable(pojo)
                .orElse(new Pojo("2", "3"));
        System.out.println(pojo1);

         pojo1 = Optional.ofNullable(pojo)
                .orElse(new Pojo("2", "3"));
        System.out.println(pojo1);

        Pojo pojo2 = null;
        Pojo pojo3 = Optional.ofNullable(pojo2)
                .orElse(new Pojo("2", "3"));
        System.out.println(pojo3);
    }

    @org.junit.Test
    public void test1(){
        List<Integer> list = Lists.newArrayList(1,2,2,3);
        List<Integer> listA = Lists.newArrayList();
        list.stream()
                .filter(o->{
                    boolean b = o != 1;
                    listA.add(o);
                    listA.add(-1);
                    return b;
                })
                .filter(o->{
                    boolean b = o != 3;
                    listA.add(o);
                    listA.add(9999);
                 return b;
                })
                .collect(Collectors.toList());
        System.out.println(listA);
    }




}
