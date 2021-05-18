/**
 * @(#)stream.java, 2020-08-10.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package file.stream;

import com.alibaba.excel.util.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class stream {
    @Test
    public void test(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/chenmin/IdeaProjects/myProjects/my_study/src/main/resources/test/txt1.txt"))) {
            String line = StringUtils.EMPTY;
            while ((line = bufferedReader.readLine())!=null) {
                String[] s = line.split(" ");
                Object result = initObject(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private test initObject(String[] o){
        //todo set
        test test = new test();
        return test;
    }
}

class test{
    private String s1;
    private String s2;

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }
}