/**
 * @(#)ValidationTestPojo.java, 2020-12-01.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.bean.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Data
public class ValidationTestPojo {
    @NotNull(message = "这里是自定义Message")
    private Integer intValue;
    @NotEmpty
    private String string;
    @Email
    private String email;
}