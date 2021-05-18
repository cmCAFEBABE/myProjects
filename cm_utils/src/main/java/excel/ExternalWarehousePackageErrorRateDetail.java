/**
 * @(#)ExterWarehousePackageErrorRateDetail.java, 2020-07-23.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import excel.conver.StringConver;

import java.io.Serializable;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ExternalWarehousePackageErrorRateDetail implements Serializable {

    private static final long serialVersionUID = 4912704725271566790L;
    /**
     * 工单标题
     */
    @ExcelProperty(value = "工单标题",converter = StringConver.class)
    private String workOrderName;


    /**
     * 工单标题
     */
    @ExcelProperty(value = "testIsContain")
    private String isContainGoodComment;

    /**
     * 工单Id
     */
    @ExcelProperty(value = "工单Id",converter = StringConver.class)
    private String workOrderId;

    /**
     * 工单完结日期
     */
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty("工单完结日期")
    private Long workOrderEndTime;

    /**
     * 指标类型
     */
    @ExcelProperty("指标类型")
    private String indicatorType;

    /**
     * 关联仓库名称
     */
    @ExcelProperty("关联仓库名称")
    private String relatedWarehouseName;

    /**
     * 订单号
     */
    @ExcelProperty("订单号")
    private String orderNo;

    /**
     * 商品名称
     */
    @ExcelProperty("商品名称")
    private String itemName;

    /**
     * skuId
     */
    @ExcelProperty("skuId")
    private String skuId;

    @NumberFormat("#.##%")
    @ExcelProperty("rate")
    private Double rate;


    public String getWorkOrderName() {
        return workOrderName;
    }

    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderEndTime() {
        return workOrderEndTime;
    }

    public void setWorkOrderEndTime(Long workOrderEndTime) {
        this.workOrderEndTime = workOrderEndTime;
    }

    public String getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(String indicatorType) {
        this.indicatorType = indicatorType;
    }

    public String getRelatedWarehouseName() {
        return relatedWarehouseName;
    }

    public void setRelatedWarehouseName(String relatedWarehouseName) {
        this.relatedWarehouseName = relatedWarehouseName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getIsContainGoodComment() {
        return isContainGoodComment;
    }

    public void setIsContainGoodComment(String isContainGoodComment) {
        this.isContainGoodComment = isContainGoodComment;
    }
}