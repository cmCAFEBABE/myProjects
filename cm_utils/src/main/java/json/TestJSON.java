/**
 * @(#)TestJSON.java, 2020-12-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package json;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Data
public class TestJSON {
    private String str = "1111111";


    private static String itemTypeTransfer(String skuSpecValueInfo) {
        if (StringUtils.isEmpty(skuSpecValueInfo)) {
            return StringUtils.EMPTY;
        }
        try {
            Map<String, String> columnFieldMap = JSON.parseObject(skuSpecValueInfo, Map.class);
            String result = columnFieldMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.joining(","));
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return StringUtils.EMPTY;
    }


    public static void main(String[] args) {
        String str = "{\"颜色\":\"深茶褐（床单款）\",\"尺寸\":\"King Size\"}";
        System.out.println(itemTypeTransfer(str));
    }

}