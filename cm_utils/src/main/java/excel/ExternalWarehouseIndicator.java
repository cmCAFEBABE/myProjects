/**
 * @(#)ExternalWarehouseIndicator.java, 2020-07-23.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package excel;

import java.io.Serializable;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ExternalWarehouseIndicator implements Serializable {

    private static final long serialVersionUID = -5404181896228624147L;
    /**
     *供应商id
     */
    private String supplierId;
    /**
     *仓库id
     */
    private String storehouseId;
    /**
     *仓库名
     */
    private String storehouseName;
    /**
     *仓库货权归属（0：严选；1：供应商）
     */
    private Integer goodsRight;
    /**
     *履约总评分
     */
    private Double kpiTotalScore;
    /**
     *打包错误率
     */
    private Double outstorePackErrorRate;
    /**
     *打包错误率得分
     */
    private Long outstorePackErrorRateScore;
    /**
     *打包错误率得分权重
     */
    private Double outstorePackErrorWeight;
    /**
     *打包及时率
     */
    private Double outstorePackIntimeRate;
    /**
     *打包及时率得分
     */
    private Long outstorePackIntimeRateScore;
    /**
     *打包及时率得分权重
     */
    private Double outstorePackIntimeWeight;
    /**
     *订单缺货率
     */
    private Double outstoreLackRate;
    /**
     *订单缺货率得分
     */
    private Long outstoreLackRateScore;
    /**
     *订单缺货率得分权重
     */
    private Double outstoreLackWeight;
    /**
     *库存容错率
     */
    private Double inventoryErrorRate;
    /**
     *库存容错率得分
     */
    private Long inventoryErrorRateScore;
    /**
     *库存容错率得分权重
     */
    private Double inventoryErrorWeight;
    /**
     *揽收及时率
     */
    private Double consigneeIntimeRate;
    /**
     *揽收及时率得分
     */
    private Long consigneeIntimeRateScore;
    /**
     *揽收及时率得分权重
     */
    private Double consigneeIntimeWeight;
    /**
     *配送及时率
     */
    private Double expressIntimeRate;
    /**
     *配送及时率得分
     */
    private Long expressIntimeRateScore;
    /**
     *配送及时率得分权重
     */
    private Double expressIntimeWeight;
    /**
     *配送客诉率
     */
    private Double expressComplainRate;
    /**
     *配送客诉率得分
     */
    private Long expressComplainRateScore;
    /**
     *配送客诉率得分权重
     */
    private Double expressComplainWeight;
    /**
     *订单及时足量满足率
     */
    private Double outstoreIntimeFulldoseRate;
    /**
     *订单及时足量满足率得分
     */
    private Long outstoreIntimeFulldoseRateScore;

    /**
     *订单及时足量满足率得分权重
     */
    private Double outstoreIntimeFulldoseWeight;
    /**
     *工单24hr超时率
     */
    private Double kfOuttimeRate;
    /**
     *工单24hr超时率得分
     */
    private Long kfOuttimeRateScore;
    /**
     *工单24hr超时率得分权重
     */
    private Double kfOuttimeWeight;
    /**
     *工单一次流转完成率
     */
    private Double kf1FlowRate;
    /**
     *工单一次流转完成率得分
     */
    private Long kf1FlowRateScore;
    /**
     *工单一次流转完成率得分权重
     */
    private Double kf1FlowWeight;
    /**
     *质检确认平均处理率
     */
    private Double returnQcIntimeRate;
    /**
     *质检确认平均处理率得分
     */
    private Long returnQcIntimeRateScore;
    /**
     *质检确认平均处理率得分权重
     */
    private Double returnQcIntimeWeight;
    /**
     *评级统计开始时间（时间戳，毫秒）
     */
    private Long statBeginDt;
    /**
     *评级统计结束时间（时间戳，毫秒）
     */
    private Long statEndDt;

    /**
     * 时间范围
     */
    private String timeRange;

    /**
     *评级周期（0：日度；1：周度；2：月度；3：季度；4：年度）
     */
    private Integer statPeriod;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(String storehouseId) {
        this.storehouseId = storehouseId;
    }

    public String getStorehouseName() {
        return storehouseName;
    }

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName;
    }

    public Integer getGoodsRight() {
        return goodsRight;
    }

    public void setGoodsRight(Integer goodsRight) {
        this.goodsRight = goodsRight;
    }

    public Double getKpiTotalScore() {
        return kpiTotalScore;
    }

    public void setKpiTotalScore(Double kpiTotalScore) {
        this.kpiTotalScore = kpiTotalScore;
    }

    public Double getOutstorePackErrorRate() {
        return outstorePackErrorRate;
    }

    public void setOutstorePackErrorRate(Double outstorePackErrorRate) {
        this.outstorePackErrorRate = outstorePackErrorRate;
    }

    public Long getOutstorePackErrorRateScore() {
        return outstorePackErrorRateScore;
    }

    public void setOutstorePackErrorRateScore(Long outstorePackErrorRateScore) {
        this.outstorePackErrorRateScore = outstorePackErrorRateScore;
    }

    public Double getOutstorePackErrorWeight() {
        return outstorePackErrorWeight;
    }

    public void setOutstorePackErrorWeight(Double outstorePackErrorWeight) {
        this.outstorePackErrorWeight = outstorePackErrorWeight;
    }

    public Double getOutstorePackIntimeRate() {
        return outstorePackIntimeRate;
    }

    public void setOutstorePackIntimeRate(Double outstorePackIntimeRate) {
        this.outstorePackIntimeRate = outstorePackIntimeRate;
    }

    public Long getOutstorePackIntimeRateScore() {
        return outstorePackIntimeRateScore;
    }

    public void setOutstorePackIntimeRateScore(Long outstorePackIntimeRateScore) {
        this.outstorePackIntimeRateScore = outstorePackIntimeRateScore;
    }

    public Double getOutstorePackIntimeWeight() {
        return outstorePackIntimeWeight;
    }

    public void setOutstorePackIntimeWeight(Double outstorePackIntimeWeight) {
        this.outstorePackIntimeWeight = outstorePackIntimeWeight;
    }

    public Double getOutstoreLackRate() {
        return outstoreLackRate;
    }

    public void setOutstoreLackRate(Double outstoreLackRate) {
        this.outstoreLackRate = outstoreLackRate;
    }

    public Long getOutstoreLackRateScore() {
        return outstoreLackRateScore;
    }

    public void setOutstoreLackRateScore(Long outstoreLackRateScore) {
        this.outstoreLackRateScore = outstoreLackRateScore;
    }

    public Double getOutstoreLackWeight() {
        return outstoreLackWeight;
    }

    public void setOutstoreLackWeight(Double outstoreLackWeight) {
        this.outstoreLackWeight = outstoreLackWeight;
    }

    public Double getInventoryErrorRate() {
        return inventoryErrorRate;
    }

    public void setInventoryErrorRate(Double inventoryErrorRate) {
        this.inventoryErrorRate = inventoryErrorRate;
    }

    public Long getInventoryErrorRateScore() {
        return inventoryErrorRateScore;
    }

    public void setInventoryErrorRateScore(Long inventoryErrorRateScore) {
        this.inventoryErrorRateScore = inventoryErrorRateScore;
    }

    public Double getInventoryErrorWeight() {
        return inventoryErrorWeight;
    }

    public void setInventoryErrorWeight(Double inventoryErrorWeight) {
        this.inventoryErrorWeight = inventoryErrorWeight;
    }

    public Double getConsigneeIntimeRate() {
        return consigneeIntimeRate;
    }

    public void setConsigneeIntimeRate(Double consigneeIntimeRate) {
        this.consigneeIntimeRate = consigneeIntimeRate;
    }

    public Long getConsigneeIntimeRateScore() {
        return consigneeIntimeRateScore;
    }

    public void setConsigneeIntimeRateScore(Long consigneeIntimeRateScore) {
        this.consigneeIntimeRateScore = consigneeIntimeRateScore;
    }

    public Double getConsigneeIntimeWeight() {
        return consigneeIntimeWeight;
    }

    public void setConsigneeIntimeWeight(Double consigneeIntimeWeight) {
        this.consigneeIntimeWeight = consigneeIntimeWeight;
    }

    public Double getExpressIntimeRate() {
        return expressIntimeRate;
    }

    public void setExpressIntimeRate(Double expressIntimeRate) {
        this.expressIntimeRate = expressIntimeRate;
    }

    public Long getExpressIntimeRateScore() {
        return expressIntimeRateScore;
    }

    public void setExpressIntimeRateScore(Long expressIntimeRateScore) {
        this.expressIntimeRateScore = expressIntimeRateScore;
    }

    public Double getExpressIntimeWeight() {
        return expressIntimeWeight;
    }

    public void setExpressIntimeWeight(Double expressIntimeWeight) {
        this.expressIntimeWeight = expressIntimeWeight;
    }

    public Double getExpressComplainRate() {
        return expressComplainRate;
    }

    public void setExpressComplainRate(Double expressComplainRate) {
        this.expressComplainRate = expressComplainRate;
    }

    public Long getExpressComplainRateScore() {
        return expressComplainRateScore;
    }

    public void setExpressComplainRateScore(Long expressComplainRateScore) {
        this.expressComplainRateScore = expressComplainRateScore;
    }

    public Double getExpressComplainWeight() {
        return expressComplainWeight;
    }

    public void setExpressComplainWeight(Double expressComplainWeight) {
        this.expressComplainWeight = expressComplainWeight;
    }

    public Double getOutstoreIntimeFulldoseRate() {
        return outstoreIntimeFulldoseRate;
    }

    public void setOutstoreIntimeFulldoseRate(Double outstoreIntimeFulldoseRate) {
        this.outstoreIntimeFulldoseRate = outstoreIntimeFulldoseRate;
    }

    public Long getOutstoreIntimeFulldoseRateScore() {
        return outstoreIntimeFulldoseRateScore;
    }

    public void setOutstoreIntimeFulldoseRateScore(Long outstoreIntimeFulldoseRateScore) {
        this.outstoreIntimeFulldoseRateScore = outstoreIntimeFulldoseRateScore;
    }



    public Double getKfOuttimeRate() {
        return kfOuttimeRate;
    }

    public void setKfOuttimeRate(Double kfOuttimeRate) {
        this.kfOuttimeRate = kfOuttimeRate;
    }

    public Long getKfOuttimeRateScore() {
        return kfOuttimeRateScore;
    }

    public void setKfOuttimeRateScore(Long kfOuttimeRateScore) {
        this.kfOuttimeRateScore = kfOuttimeRateScore;
    }

    public Double getKfOuttimeWeight() {
        return kfOuttimeWeight;
    }

    public void setKfOuttimeWeight(Double kfOuttimeWeight) {
        this.kfOuttimeWeight = kfOuttimeWeight;
    }

    public Double getKf1FlowRate() {
        return kf1FlowRate;
    }

    public void setKf1FlowRate(Double kf1FlowRate) {
        this.kf1FlowRate = kf1FlowRate;
    }

    public Long getKf1FlowRateScore() {
        return kf1FlowRateScore;
    }

    public void setKf1FlowRateScore(Long kf1FlowRateScore) {
        this.kf1FlowRateScore = kf1FlowRateScore;
    }

    public Double getKf1FlowWeight() {
        return kf1FlowWeight;
    }

    public void setKf1FlowWeight(Double kf1FlowWeight) {
        this.kf1FlowWeight = kf1FlowWeight;
    }

    public Double getReturnQcIntimeRate() {
        return returnQcIntimeRate;
    }

    public void setReturnQcIntimeRate(Double returnQcIntimeRate) {
        this.returnQcIntimeRate = returnQcIntimeRate;
    }

    public Long getReturnQcIntimeRateScore() {
        return returnQcIntimeRateScore;
    }

    public void setReturnQcIntimeRateScore(Long returnQcIntimeRateScore) {
        this.returnQcIntimeRateScore = returnQcIntimeRateScore;
    }

    public Double getReturnQcIntimeWeight() {
        return returnQcIntimeWeight;
    }

    public void setReturnQcIntimeWeight(Double returnQcIntimeWeight) {
        this.returnQcIntimeWeight = returnQcIntimeWeight;
    }

    public Long getStatBeginDt() {
        return statBeginDt;
    }

    public void setStatBeginDt(Long statBeginDt) {
        this.statBeginDt = statBeginDt;
    }

    public Long getStatEndDt() {
        return statEndDt;
    }

    public void setStatEndDt(Long statEndDt) {
        this.statEndDt = statEndDt;
    }

    public Integer getStatPeriod() {
        return statPeriod;
    }

    public void setStatPeriod(Integer statPeriod) {
        this.statPeriod = statPeriod;
    }
    public Double getOutstoreIntimeFulldoseWeight() {
        return outstoreIntimeFulldoseWeight;
    }

    public void setOutstoreIntimeFulldoseWeight(Double outstoreIntimeFulldoseWeight) {
        this.outstoreIntimeFulldoseWeight = outstoreIntimeFulldoseWeight;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }
}