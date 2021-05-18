/**
 * @(#)testJson.java, 2021-03-08.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package pojo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class TestJson {
    @Test
    public void test(){
        QuoteTendencyChartSegmentVO segment1 = QuoteTendencyChartSegmentVO.builder().build();
        QuoteTendencyChartSegmentVO segment2 = QuoteTendencyChartSegmentVO.builder().build();
        ArrayList<QuoteTendencyChartSegmentVO> dataValueList = Lists.newArrayList(segment1, segment2);
        QuoteVersionVO versionVO = QuoteVersionVO.builder().flowId(1).quoteTime(1L).skuId(1L).build();
        HashMap<QuoteVersionVO, List<QuoteTendencyChartSegmentVO>> data = Maps.newHashMap();
        data.put(versionVO,dataValueList);
        QuoteTendencyChartVO build = QuoteTendencyChartVO.builder().data(data).build();
        System.out.println(JSON.toJSON(build));
    }
}