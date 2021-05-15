/**
 * @(#)QuoteTendencyChartVO.java, 2021-03-08.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.mail.yanxuan.supplier.ms.core.domain.po.quote;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Data
@Builder
public class QuoteTendencyChartVO {

    private String supplierId;

    private Long itemId;
    /**
     * itemId关联的所有skuId 正序排列
     */
    private List<Long> skuIds;

    /**
     * 画图数据
     */
    private Map<QuoteVersionVO,List<QuoteTendencyChartSegmentVO>> data;

}