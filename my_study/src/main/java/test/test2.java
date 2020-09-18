/**
 * @(#)test2.java, 2020-08-29.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numString = scanner.nextLine();
        String[] split = numString.replaceAll("\\[","").replaceAll("]","").replaceAll("\"","").split(",");
//        Arrays.stream(split).forEach(System.out::println);
        List<Long> x = new ArrayList<>();
        List<Long> y = new ArrayList<>();
        for (int i = 0; i < split.length; i+=2) {
            x.add(Long.valueOf(split[i]));
            y.add(Long.valueOf(split[i+1]));
        }
        Long avgx = x.stream().mapToLong(Long::longValue).sum()/x.size();
        Long avgy = x.stream().mapToLong(Long::longValue).sum()/y.size();

        int index = -1;
        long d = -1;
        for (int i = 0; i < x.size(); i++) {
            if( Math.abs(x.get(i)-avgx)*Math.abs(y.get(i)-avgy)>d){
                index = i;
                d = Math.abs(x.get(i)-avgx)*Math.abs(y.get(i)-avgy);
            }
        }
        System.out.println(index+1);

    }


    @Test
    public void test(){
        int num = 100;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append("一");
        }
        System.out.println(stringBuilder);
    }

    @Test
    public void test2(){
        Integer  i = 0;
        System.out.println(i.equals(0));
    }

    @Test
    public void test3(){
        System.out.println(Integer.MAX_VALUE);
    }

}