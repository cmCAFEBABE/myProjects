/**
 * @(#)StringTest.java, 2020-08-10.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package string;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import excel.DownloadDTO;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class StringTest implements Serializable {

    @Test
    public void test(){
        String str = "email=\"123\",Test=\"2\",i=3,test1=null";
        String[] split = str.split(",");
        String email = StringUtils.EMPTY;

        for (int i = 0; i < split.length; i++) {
            if(split[i]!=null&&split[i].contains("email")){
                email = split[i];
                break;
            }
        }
        String s = email.replaceAll("email=", "").replaceAll("\"", "");
        System.out.println(s);

    }


    @Test
    public void test2(){
        DownloadDTO downloadDTO = new DownloadDTO();
        downloadDTO.setCategory("1231");
        switchAspectJudge(1,"213123",downloadDTO,5,null,null);
    }




    @Test
    public void test3(){
        ArrayList<Object> objects = Lists.newArrayList(new Object());
        System.out.println(objects.size());
        System.out.println(test33());
        System.out.println(JSON.toJSONString(objects));
    }
    public String test33(){
        return "123";
    }
    @Test
    public void test4(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("123");
        stringBuffer.setLength(0);
        stringBuffer.append("456");
        System.out.println(stringBuffer);
    }
    public void switchAspectJudge(Object... object){
        System.out.println(JSON.toJSONString(object));
    }


    @Test
    public void test5(){
        String str = "123"+null+"456";
        System.out.println(str);
    }


    @Test
    public void test6(){
        String str = "123123123123";
        System.out.println(str.replace("1","一"));

    }

    @Test
    public void test7(){
        String str = "email:yze@1.com}";
        System.out.println(str.substring(0,6));
    }
    @Test
    public void test8(){
        String str= "1";
        System.out.println(str==null);
        System.out.println(null==str);
    }
    @Test
    public void test9(){
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 40000; i++) {
            list.add(i);
        }
        Lists.partition(list,500);

        List<List<Integer>> partition = Lists.partition(list, 500);
        Set<Long> failedSkuIds = Sets.newHashSet();
        for (int i = 0; i < partition.size(); i++) {
            List<Integer> subQuoteWarehouseTransferAOS = partition.get(i);
            System.out.println(subQuoteWarehouseTransferAOS);
        }
    }
}