/**
 * @(#)SkuPermEnum.java, 2020-09-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package test.enums;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public enum DataShareSkuPermEnum {
    TOTAL_SALE_STOCK("总销售库存"),
    STOCK_TRANSFER_DAYS("库转天数"),
    SALE_DATA("销售数据"),
    GOOD_EVALUATE_RATE("好评率"),
    BAD_EVALUATE_RATE("差评率"),
    BACK_GOODS_RATE("退货率"),
    QC_PASS_RATE("质检通过率"),
    OVER_DUE_RATE("逾期率"),
    PURCHASE_PLAN("采购计划"),
    PURCHASE_PLAN_TIME_RANGE("采购计划时间范围"),
    ARRIVAL_GOODS_PLAN("到货计划");

    private final String desc;

    DataShareSkuPermEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
