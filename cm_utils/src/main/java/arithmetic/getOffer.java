package arithmetic; /**
 * @(#)arithmetic.java, 2021-03-08.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.junit.Test;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class getOffer {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * in: 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
     * out: true
     */
    @Test
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        int x = array.length - 1;
        int y = 0;
        while (true) {
            if (x < 0 || y >= array[0].length) {
                return false;
            }
            int value = array[x][y];
            if (value == target) {
                return true;
            } else if (value < target) {
                y++;
            } else {
                x--;
            }
        }
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * "We Are Happy"
     * "We%20Are%20Happy"
     */
    @Test
    public String replaceSpace (String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

}