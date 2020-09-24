/**
 * @(#)test.java, 2020-08-26.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;
import test.enums.DataShareSkuPermEnum;

import java.util.*;
import java.util.stream.Collectors;

import static test.enums.DataShareSkuPermEnum.TOTAL_SALE_STOCK;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class test {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String str = "[1,1,1,1,2,1,1],[5,2,5,4,5,1,6]";
        String str = scanner.nextLine();

        String[] split = str.split("]");

        String[] x = split[0].replaceAll("\\[", "").split(",");
        String[] y = split[1].replaceAll("\\[", "").split(",");


        List<Long> xList = new ArrayList<>();
        List<Long> yList = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {

            if(x[i].equals("")){
                continue;
            }

            if (Long.valueOf(x[i])<=0){
                System.out.println(0);
                return ;
            }
            xList.add(Long.valueOf(x[i]));
        }
        for (int i = 0; i < y.length; i++) {
            if(y[i].equals("")){
                continue;
            }
            if (Long.valueOf(y[i])<=0){
                System.out.println(0);
                return ;
            }
            yList.add(Long.valueOf(y[i]));
        }

        if (xList.size()!=yList.size()){
            System.out.println(0);
            return;
        }

        Long max = 0L;
        for (int j = 0; j < xList.size(); j++) {
            Long len = 0L;
            for (int i = j; i < xList.size(); i++) {
                len+=xList.get(i);
                max = Math.max(len*getMin(yList,j,i+1),max);
            }
        }
        System.out.println(max);
    }
    @Test
    public void test(){
        List<Long> list = Lists.newArrayList(1L,2L);

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            list.add(scanner.nextLong());
//        }

        List<String> listStr = list.stream().map(o->{
            return Long.toBinaryString(o);
        }).collect(Collectors.toList());
        System.out.println(listStr);
        String subStr = "";
        for (int i = 0; i < listStr.size(); i++) {
            if (listStr.get(i).length()>2){
                subStr = listStr.get(i).substring(listStr.get(i).length()-2);
                listStr.set(i,listStr.get(i).substring(0,listStr.get(i).length()-2));
            }
            if (i+1<listStr.size()){
                listStr.set(i,subStr+listStr.get(i));
            }

        }
        listStr.set(0,subStr+listStr.get(0));


        List<Long> collect = listStr.stream().map(o -> {
            return Long.valueOf(o, 2);
        }).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            if (i!=listStr.size()-1){
                System.out.println(collect.get(i)+" ");
            }else {
                System.out.println(collect.get(i));
            }
        }
    }


    @Test
    public void test2(){
        Scanner scanner = new Scanner(System.in);
//        String str = "[1,1,1,1,2,1,1],[5,2,5,4,5,1,6]";
        String str = scanner.nextLine();

        String[] split = str.split("]");

        String[] x = split[0].replaceAll("\\[", "").split(",");
        String[] y = split[1].replaceAll("\\[", "").split(",");


        List<Long> xList = new ArrayList<>();
        List<Long> yList = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {

            if(x[i].equals("")){
                continue;
            }

            if (Long.valueOf(x[i])<=0){
                System.out.println(0);
                return ;
            }
            xList.add(Long.valueOf(x[i]));
        }
        for (int i = 0; i < y.length; i++) {
            if(y[i].equals("")){
                continue;
            }
            if (Long.valueOf(y[i])<=0){
                System.out.println(0);
                return ;
            }
            yList.add(Long.valueOf(y[i]));
        }

        if (xList.size()!=yList.size()){
            System.out.println(0);
            return;
        }

        Long max = 0L;
        for (int j = 0; j < xList.size(); j++) {
            Long len = 0L;
            for (int i = j; i < xList.size(); i++) {
                len+=xList.get(i);
                max = Math.max(len*getMin(yList,j,i+1),max);
            }
        }
        System.out.println(max);

    }

    private static Long  getMin(List<Long> yList,Integer index1,Integer index2){
        Long aLong = yList.subList(index1, index2).stream().min(Comparator.comparingLong(Long::longValue)).get();
        return aLong;
    }

    @Test
    public void test3(){

    }

    @Test
    public void test4(){
        DataShareSkuPermEnum enums= TOTAL_SALE_STOCK;
        ArrayList<DataShareSkuPermEnum> dataShareSkuPermEnums = Lists.newArrayList(DataShareSkuPermEnum.values());
        System.out.println(JSON.toJSONString(dataShareSkuPermEnums));
        System.out.println(TOTAL_SALE_STOCK.toString());
    }

}