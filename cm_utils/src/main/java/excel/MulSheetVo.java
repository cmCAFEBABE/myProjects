/**
 * @(#)mulSheetVo.java, 2020-07-30.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package excel;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class MulSheetVo {
    private String sheetName;
    private Class<?> clazz;
    private List<?> data;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}