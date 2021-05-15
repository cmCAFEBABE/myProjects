/**
 * @(#)QuoteVersionVO.java, 2021-03-08.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.mail.yanxuan.supplier.ms.core.domain.po.quote;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Data
@EqualsAndHashCode
public class QuoteVersionVO {
    /**
     * skuId
     */
    private Long skuId;
    /**
     * 报价发起时间
     */
    private Long quoteTime;
    /**
     * 报价关联工单
     */
    private Integer flowId;

}