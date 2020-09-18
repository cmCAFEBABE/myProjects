/**
 * @(#)collectionUtil.java, 2020-07-29.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package collection;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 求集合的交集、并集、差集
 *
 * 注意：对象类型使用集合方法操作之前 一定要重写equals方法和hashcose方法
 */
public class CollectionUtil {
    private static Set<Integer> set1;
    private static Set<Integer> set2;

    private static Set<User> set3;
    private static Set<User> set4;

    private static List<Integer> list1;
    private static List<Integer> list2;

    private static List<User> list3;
    private static List<User> list4;

    static {
        //基本类型
        set1 = Sets.newHashSet(1,2,3,4);
        set2 = Sets.newHashSet(1,3,5,6,7);
        set3 = Sets.newHashSet();
        set4 = Sets.newHashSet();

        list1 = Lists.newArrayList(1,2,3,4,5);
        list2 = Lists.newArrayList(2,4,5,7,8,9,10);
        list3 = Lists.newArrayList();
        list4 = Lists.newArrayList();

        //对象类型
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        set3.add(user2);
        set3.add(user);

        set4.add(user3);
        set4.add(user4);
        user.setName("test");
        user.setYear(12);

        BeanUtils.copyProperties(user,user2);
        BeanUtils.copyProperties(user,user3);
        BeanUtils.copyProperties(user,user4);
        user3.setName("qwe");


    }
    /**
     * set交集
     */
    @Test
    public void setRetain(){
        //set求交集
        set1.retainAll(set2);
        System.out.println(set1);

        //对象类型
        set3.retainAll(set4);
        System.out.println(JSON.toJSONString(set3));

        //lambda求交集
        Set<Integer> retainResult = set1.stream().filter(o ->
            set2.contains(o)
        ).collect(Collectors.toSet());
        System.out.println(retainResult);
    }
    /**
     * list交集
     */
    @Test
    public void listRetain(){
        //list求交集
        list1.retainAll(list2);
        System.out.println(list1);
        //lambda求交集
        Set<Integer> retainResult = list1.stream().filter(o ->
                list2.contains(o)
        ).collect(Collectors.toSet());
        System.out.println(retainResult);
    }
    /**
     *set并集
     */
    @Test
    public void setUnion(){
        set1.addAll(set2);
        System.out.println(set2);
    }
    /**
     *list并集
     */
    @Test
    public void listUnion(){
        //list 直接addAll会有重复case
//        list1.addAll(list2);
//        System.out.println(list1);
        //list 先removeAll 去掉与list2重复的 再addAll
        list1.removeAll(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }
    /**
     * set集
     */
    @Test
    public void setRemove(){
        set1.removeAll(set2);
        System.out.println(set1);
    }
    /**
     * list差集
     */
    @Test
    public void listRemove(){
        list1.removeAll(list2);
        System.out.println(list1);
    }

    @Test
    public void list2Map(){
        List<User> list = Lists.newArrayList();
        Map<String,List<User>> map = Maps.newHashMap();
        for (User user:list){
            if(map.containsKey(user.getName())){
                //替换元数据
                //保持元数据
                map.get(user.getName()).add(user);
            }
            else {
                map.put(user.getName(),Lists.newArrayList(user));
            }
        }
    }



    @Test
    public void list2MapByLambda(){
        List<User> list = Lists.newArrayList();


        boolean b = list.stream().anyMatch(o -> {
            return "chenmin".equals(o.getName());
        });

        boolean is = list.stream().allMatch(o -> {
            return "chenmin".equals(o.getName());
        });



        List<String> collect = list.stream().map(User::getName).collect(Collectors.toList());

        //key EnglishName
        Map<String, User> collect1 = list.stream().collect(Collectors.toMap(User::getName, o -> o, (o1, o2) -> o1));

        List<User> list2 = Lists.newArrayList();
        Map<String, List<User>> map = list2.stream().collect(Collectors.groupingBy(User::getName));







    }

}