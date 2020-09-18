/**
 * @(#)test1.java, 2020-08-29.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package test;

import java.util.Scanner;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numString = scanner.nextLine();
        Long num  = Long.valueOf(numString.replaceAll("num=",""));
        char[] threeRadix = Long.toString(num,3).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < threeRadix.length; i++) {
            if(threeRadix[i]=='0'){
                threeRadix[i]= '@';
            }
            else if (threeRadix[i]=='1'){
                threeRadix[i]= '$';
            }
            else if (threeRadix[i]=='2'){
                threeRadix[i]='&';
            }
            stringBuilder.append(threeRadix[i]);
        }

        System.out.println(stringBuilder);


    }
}