/**
 * @(#)SupplyingItemExportDataTypeAO.java, 2020-09-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package reflect;

import java.io.Serializable;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class SupplyingItemExportDataTypeVO implements Serializable {
    private static final long serialVersionUID = -6969147878704257877L;
    private boolean isContainCurrentItemStatus;
    private boolean isContainPhysicsCategory;
    private boolean isContainGoodComment;
    private boolean isContainBadComment;
    //退货率
    private boolean isContainRollBackItemRate;
    //质检通过率
    private boolean isContainQCRate;
    private boolean isContainTotalSaleStock;
    private boolean isContainInWayStock;
    private boolean isContainStockDayNum;

    private boolean isContainAvgSaleQtyQuanzhanNogift30d;
    private boolean isContainYesterdaySaleNum;

    //邮箱
    private String email;

    public boolean isContainCurrentItemStatus() {
        return isContainCurrentItemStatus;
    }

    public void setContainCurrentItemStatus(boolean containCurrentItemStatus) {
        isContainCurrentItemStatus = containCurrentItemStatus;
    }

    public boolean isContainPhysicsCategory() {
        return isContainPhysicsCategory;
    }

    public void setContainPhysicsCategory(boolean containPhysicsCategory) {
        isContainPhysicsCategory = containPhysicsCategory;
    }

    public boolean isContainGoodComment() {
        return isContainGoodComment;
    }

    public void setContainGoodComment(boolean containGoodComment) {
        isContainGoodComment = containGoodComment;
    }

    public boolean isContainBadComment() {
        return isContainBadComment;
    }

    public void setContainBadComment(boolean containBadComment) {
        isContainBadComment = containBadComment;
    }

    public boolean isContainRollBackItemRate() {
        return isContainRollBackItemRate;
    }

    public void setContainRollBackItemRate(boolean containRollBackItemRate) {
        isContainRollBackItemRate = containRollBackItemRate;
    }

    public boolean isContainQCRate() {
        return isContainQCRate;
    }

    public void setContainQCRate(boolean containQCRate) {
        isContainQCRate = containQCRate;
    }

    public boolean isContainTotalSaleStock() {
        return isContainTotalSaleStock;
    }

    public void setContainTotalSaleStock(boolean containTotalSaleStock) {
        isContainTotalSaleStock = containTotalSaleStock;
    }

    public boolean isContainInWayStock() {
        return isContainInWayStock;
    }

    public void setContainInWayStock(boolean containInWayStock) {
        isContainInWayStock = containInWayStock;
    }

    public boolean isContainStockDayNum() {
        return isContainStockDayNum;
    }

    public void setContainStockDayNum(boolean containStockDayNum) {
        isContainStockDayNum = containStockDayNum;
    }

    public boolean isContainAvgSaleQtyQuanzhanNogift30d() {
        return isContainAvgSaleQtyQuanzhanNogift30d;
    }

    public void setContainAvgSaleQtyQuanzhanNogift30d(boolean containAvgSaleQtyQuanzhanNogift30d) {
        isContainAvgSaleQtyQuanzhanNogift30d = containAvgSaleQtyQuanzhanNogift30d;
    }

    public boolean isContainYesterdaySaleNum() {
        return isContainYesterdaySaleNum;
    }

    public void setContainYesterdaySaleNum(boolean containYesterdaySaleNum) {
        isContainYesterdaySaleNum = containYesterdaySaleNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}