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

            if (x[i].equals("")) {
                continue;
            }

            if (Long.valueOf(x[i]) <= 0) {
                System.out.println(0);
                return;
            }
            xList.add(Long.valueOf(x[i]));
        }
        for (int i = 0; i < y.length; i++) {
            if (y[i].equals("")) {
                continue;
            }
            if (Long.valueOf(y[i]) <= 0) {
                System.out.println(0);
                return;
            }
            yList.add(Long.valueOf(y[i]));
        }

        if (xList.size() != yList.size()) {
            System.out.println(0);
            return;
        }

        Long max = 0L;
        for (int j = 0; j < xList.size(); j++) {
            Long len = 0L;
            for (int i = j; i < xList.size(); i++) {
                len += xList.get(i);
                max = Math.max(len * getMin(yList, j, i + 1), max);
            }
        }
        System.out.println(max);
    }

    @Test
    public void test() {
        List<Long> list = Lists.newArrayList(1L, 2L);

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            list.add(scanner.nextLong());
//        }

        List<String> listStr = list.stream().map(o -> {
            return Long.toBinaryString(o);
        }).collect(Collectors.toList());
        System.out.println(listStr);
        String subStr = "";
        for (int i = 0; i < listStr.size(); i++) {
            if (listStr.get(i).length() > 2) {
                subStr = listStr.get(i).substring(listStr.get(i).length() - 2);
                listStr.set(i, listStr.get(i).substring(0, listStr.get(i).length() - 2));
            }
            if (i + 1 < listStr.size()) {
                listStr.set(i, subStr + listStr.get(i));
            }

        }
        listStr.set(0, subStr + listStr.get(0));


        List<Long> collect = listStr.stream().map(o -> {
            return Long.valueOf(o, 2);
        }).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            if (i != listStr.size() - 1) {
                System.out.println(collect.get(i) + " ");
            } else {
                System.out.println(collect.get(i));
            }
        }
    }


    @Test
    public void test2() {
        Scanner scanner = new Scanner(System.in);
//        String str = "[1,1,1,1,2,1,1],[5,2,5,4,5,1,6]";
        String str = scanner.nextLine();

        String[] split = str.split("]");

        String[] x = split[0].replaceAll("\\[", "").split(",");
        String[] y = split[1].replaceAll("\\[", "").split(",");


        List<Long> xList = new ArrayList<>();
        List<Long> yList = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {

            if (x[i].equals("")) {
                continue;
            }

            if (Long.valueOf(x[i]) <= 0) {
                System.out.println(0);
                return;
            }
            xList.add(Long.valueOf(x[i]));
        }
        for (int i = 0; i < y.length; i++) {
            if (y[i].equals("")) {
                continue;
            }
            if (Long.valueOf(y[i]) <= 0) {
                System.out.println(0);
                return;
            }
            yList.add(Long.valueOf(y[i]));
        }

        if (xList.size() != yList.size()) {
            System.out.println(0);
            return;
        }

        Long max = 0L;
        for (int j = 0; j < xList.size(); j++) {
            Long len = 0L;
            for (int i = j; i < xList.size(); i++) {
                len += xList.get(i);
                max = Math.max(len * getMin(yList, j, i + 1), max);
            }
        }
        System.out.println(max);

    }

    private static Long getMin(List<Long> yList, Integer index1, Integer index2) {
        Long aLong = yList.subList(index1, index2).stream().min(Comparator.comparingLong(Long::longValue)).get();
        return aLong;
    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {
        DataShareSkuPermEnum enums = TOTAL_SALE_STOCK;
        ArrayList<DataShareSkuPermEnum> dataShareSkuPermEnums = Lists.newArrayList(DataShareSkuPermEnum.values());
        System.out.println(JSON.toJSONString(dataShareSkuPermEnums));
        System.out.println(TOTAL_SALE_STOCK.toString());
    }


    @Test
    public void longestPalindrome() {
        String s = "vvgogaewginhopuxzwyryobjjpieyhwfopiowxmyylvcgsnhfcnogpqpukzmnpewavoutbloyrrhatimmxfqmcwgfebuoqbbgvubbkjfvxivjfijlpvtsnhagzfptahhyojwzamayoiegkenycnkxzkambimhdykdcxyyfjnvztzypmfczdhhnkmfuvgkhzbwmjznykkagqdrueohgcmeidjqsvfugcioeduohprjtfdmtzosnhoiganffarokxjifzzxhixdzycwfheqqegduzwtiacmdhqfmxhazcxsqyrvrihfqzjxvawdeandnwgjlquvzadruiqmcsgibglhicsvzqknztqpkiihdoisxipkourentfvrltieihiktgzswtgcmmlfrjifqinhrbplbsgswqlbjkyxjwoshsvxlhlpgzwbmxzwaemtowcxwourjwmmwjruowxcwotmeawzxmbwzgplhlxvshsowjxykjblqwsgsblpbrhniqfijrflmmcgtwszgtkihieitlrvftneruokpixsiodhiikpqtznkqzvscihlgbigscmqiurdazvuqljgwndnaedwavxjzqfhirvryqsxczahxmfqhdmcaitwzudgeqqehfwcyzdxihxzzfijxkoraffnagiohnsoztmdftjrphoudeoicgufvsqjdiemcghoeurdqgakkynzjmwbzhkgvufmknhhdzcfmpyztzvnjfyyxcdkydhmibmakzxkncynekgeioyamazwjoyhhatpfzgahnstvpljifjvixvfjkbbuvgbbqoubefgwcmqfxmmitahrryolbtuovawepnmzkupqpgoncfhnsgcvlyymxwoipofwhyeipjjboyrywzxupohnigweagogvv";
        System.out.println(s.substring(1, 2));
        if (s == null || s.length() == 0) {
            return;
        }
//        SortedSet<String> sortedSet = new TreeSet<>(Comparator.comparingInt(String::length).reversed());
        Set<String> sortedSet = new HashSet<>();
        sortedSet.add("");
        for (int i = 0; i < s.length(); i++) {
            //长度为1 必是回文串
            if (i == 0) {
                sortedSet.add(s.substring(0, 1));
            } else {
                for (int j = 0; j < i; j++) {
                    String str = s.substring(j + 1, i);
                    //如果包含就说明是回文串
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (sortedSet.contains(str) && b) {
                        String substring = s.substring(j, i + 1);
                        sortedSet.add(substring);
                        break;
                    }
                }
                sortedSet.add(s.substring(i, i + 1));
            }

        }
        System.out.println(sortedSet.stream().max(Comparator.comparingLong(String::length)).orElse(null));
    }


    @Test
    public void longestPalindrome2() {
        String s = "vvgogaewginhopuxzwyryobjjpieyhwfopiowxmyylvcgsnhfcnogpqpukzmnpewavoutbloyrrhatimmxfqmcwgfebuoqbbgvubbkjfvxivjfijlpvtsnhagzfptahhyojwzamayoiegkenycnkxzkambimhdykdcxyyfjnvztzypmfczdhhnkmfuvgkhzbwmjznykkagqdrueohgcmeidjqsvfugcioeduohprjtfdmtzosnhoiganffarokxjifzzxhixdzycwfheqqegduzwtiacmdhqfmxhazcxsqyrvrihfqzjxvawdeandnwgjlquvzadruiqmcsgibglhicsvzqknztqpkiihdoisxipkourentfvrltieihiktgzswtgcmmlfrjifqinhrbplbsgswqlbjkyxjwoshsvxlhlpgzwbmxzwaemtowcxwourjwmmwjruowxcwotmeawzxmbwzgplhlxvshsowjxykjblqwsgsblpbrhniqfijrflmmcgtwszgtkihieitlrvftneruokpixsiodhiikpqtznkqzvscihlgbigscmqiurdazvuqljgwndnaedwavxjzqfhirvryqsxczahxmfqhdmcaitwzudgeqqehfwcyzdxihxzzfijxkoraffnagiohnsoztmdftjrphoudeoicgufvsqjdiemcghoeurdqgakkynzjmwbzhkgvufmknhhdzcfmpyztzvnjfyyxcdkydhmibmakzxkncynekgeioyamazwjoyhhatpfzgahnstvpljifjvixvfjkbbuvgbbqoubefgwcmqfxmmitahrryolbtuovawepnmzkupqpgoncfhnsgcvlyymxwoipofwhyeipjjboyrywzxupohnigweagogvv";
        System.out.println(s.substring(1, 2));
        if (s == null || s.length() == 0) {
            return;
        }
        int x = 0;
        int y = 0;
        int maxLeng = 0;
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            //长度为1 必是回文串
            if (i == 0) {
                dp[0][1] = true;
                x = 0;
                y = 1;
                maxLeng = 1;
            } else {
                for (int j = 0; j < i; j++) {
                    //如果包含就说明是回文串
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (dp[j+1][i] && b) {
                        dp[j][i+1] = true;
                        if(i+1-j+1>maxLeng){
                            x = j;
                            y = i+1;
                        }
                        break;
                    }
                }
                dp[i][i+1]=true;
                if(2>maxLeng){
                    x = i;
                    y = i+1;
                }
            }

        }
        System.out.println(s.substring(x,y));
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        String maxSubStr = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && (j - i + 1) > maxSubStr.length()) {
                        maxSubStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return maxSubStr;
    }
}