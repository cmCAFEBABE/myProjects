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
import excel.DownloadDTO;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class StringTest {
    @Test
    public void test(){
        String str = "email=\"123\",test=\"2\",i=3,test1=null";
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
        System.out.println(JSON.toJSONString(objects));
    }

    public void switchAspectJudge(Object... object){
        System.out.println(JSON.toJSONString(object));
    }

}