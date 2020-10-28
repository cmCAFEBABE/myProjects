package enums; /**
 * @(#)StatusCode.java, 2020-10-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public enum StatusCode {
    /**
     *
     */
    SUCCESS(400,"成功"),
    FAIL(500,"失败"),
    INVALID_PARAMS(501,"非法的参数!"),
    NOTLOGIN(502,"用户没登录"),
    ;

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}