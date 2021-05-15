/**
 * @(#)QuoteDrawAO.java, 2021-03-08.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package pojo;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */

import lombok.Builder;
import lombok.Data;

/**
 * 报价熔断后视图
 */
@Data
@Builder
public class QuoteTendencyChartSegmentVO {

    /**
     * 报价开始时间
     */
    private Long startTime;
    /**
     * 报价结束时间
     */
    private Long endTime;
    /**
     * 0:固定结算价 1:扣点比例
     */
    private Integer priceType;
    /**
     * 价格:priceType=0 则表示 固定结算价的值；priceType=1 则表示扣点比例
     */
    private Double price;

}