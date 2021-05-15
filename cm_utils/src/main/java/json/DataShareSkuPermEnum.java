/**
 * @(#)SkuPermEnum.java, 2020-09-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package json;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public enum DataShareSkuPermEnum {



    SKU_TOTAL_SALE_STOCK("总销售库存"),
    SKU_STOCK_TRANSFER_DAYS("库转天数"),
    SKU_SALE_DATA("销量数据"),
    SKU_GOOD_EVALUATE_RATE("好评率"),
    SKU_BAD_EVALUATE_RATE("差评率"),
    SKU_BACK_GOODS_RATE("退货率"),
    SKU_QC_PASS_RATE("质检通过率"),
    SKU_OVER_DUE_RATE("逾期率"),
    SKU_PURCHASE_PLAN("采购计划"),
    SKU_PURCHASE_PLAN_TIME_RANGE("采购计划时间范围"),
    SKU_ARRIVAL_GOODS_PLAN("到货计划");

    private final String desc;

    public static DataShareSkuPermEnum getEnumByName(String str){
        for (DataShareSkuPermEnum e: DataShareSkuPermEnum.values()) {
            if(str.equals(e.toString())){
                return e;
            }
        }
        return null;
    }
    DataShareSkuPermEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
