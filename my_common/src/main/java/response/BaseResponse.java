/**
 * @(#)BaseResponse.java, 2020-10-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package response;


import enums.StatusCode;
import lombok.Data;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Data
public class BaseResponse<T> {
    private Integer code;
    private String msg;
    private T data;
    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}