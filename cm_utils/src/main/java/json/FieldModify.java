/**
 * @(#)FieldModify.java, 2019/5/20.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.mail.yanxuan.supplier.api.remote.domain.ao.sharedata;

/**
 * @author 雷玉超(leiyuchao @ corp.netease.com)
 * @data 2019/05/20
 */
public class FieldModify {
    private String fieldName;

    private Integer preState;

    private Integer nowState;

    private Object preValue;

    private Object curValue;

    private String desc;

    public Integer getPreState() {
        return preState;
    }

    public void setPreState(Integer preState) {
        this.preState = preState;
    }

    public Integer getNowState() {
        return nowState;
    }

    public void setNowState(Integer nowState) {
        this.nowState = nowState;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getPreValue() {
        return preValue;
    }

    public void setPreValue(Object preValue) {
        this.preValue = preValue;
    }

    public Object getCurValue() {
        return curValue;
    }

    public void setCurValue(Object curValue) {
        this.curValue = curValue;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
