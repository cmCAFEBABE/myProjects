/**
 * @(#)Test.java, 2021-04-12.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package pattern;

import com.alibaba.excel.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class Test {
    @org.junit.Test
    public void test(){
        String str = "YXPE21040011(签署合同7天内)即将失效,请延长生效日期(供应商:YX2999)";
        String pattern = "\\(供应商:(.*)\\)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @org.junit.Test
    public void test2(){
        String title = "YXPE21040011(签署合同7天内)即将失效,请延长生效日期(供应商:YX2999)";
        String patStr = "\\(供应商:(.*)\\)";

        Pattern pattern = Pattern.compile(patStr);

        Matcher matcher = pattern.matcher(title);

        if(matcher.find())
        {
            System.out.println(matcher.group(1));
        }
    }
}