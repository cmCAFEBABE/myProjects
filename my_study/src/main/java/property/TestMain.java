/**
 * @(#)Test.java, 2020-08-13.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package property;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class TestMain {

    @Test
    public void test(){
        long time1 = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++) {
            String[] property = {"str0","str1","str2","str3","str4","str5","str6","str7","str8","str9","str10","str11","str12","str13","str14","str15","str16","str17","str18","str19","str20","str21","str22","str23","str24","str25","str26","str27","str28","str29"};
            String[] name={"str0","str1","str2","str3","str4","str5","str6","str7","str8","str9","str10","str11","str12","str13","str14","str15","str16","str17","str18","str19","str20","str21","str22","str23","str24","str25","str26","str27","str28","str29"};
            Map<String,String> map=new HashMap<>();
            for (int i = 0; i < property.length; i++) {
                map.put(name[i],property[i]);
            }
            PropertyObject propertyObject = JSONObject.parseObject(JSON.toJSONString(map), PropertyObject.class);
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        time1 = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++) {
            PropertyObject propertyObject = new PropertyObject();
            propertyObject.setStr0("1");
            propertyObject.setStr1("1");
            propertyObject.setStr2("1");
            propertyObject.setStr3("1");
            propertyObject.setStr4("1");
            propertyObject.setStr5("1");
            propertyObject.setStr6("1");
            propertyObject.setStr7("1");
            propertyObject.setStr8("1");
            propertyObject.setStr9("1");
            propertyObject.setStr10("1");
            propertyObject.setStr11("1");
            propertyObject.setStr12("1");
            propertyObject.setStr13("1");
            propertyObject.setStr14("1");
            propertyObject.setStr15("1");
            propertyObject.setStr16("1");
            propertyObject.setStr17("1");
            propertyObject.setStr18("1");
            propertyObject.setStr19("1");
            propertyObject.setStr20("1");
            propertyObject.setStr21("1");
            propertyObject.setStr22("1");
            propertyObject.setStr23("1");
            propertyObject.setStr24("1");
            propertyObject.setStr25("1");
            propertyObject.setStr26("1");
            propertyObject.setStr27("1");
            propertyObject.setStr28("1");
            propertyObject.setStr29("1");
        }
        time2 = System.currentTimeMillis();
        System.out.println(time2-time1);

    }

    @Test
    public void test2(){
        for (int i = 0; i < 30; i++) {
//            System.out.print("\"str"+i+"\",");


            System.out.println("propertyObject.setStr"+i+"(\"1\");");
        }
    }
}