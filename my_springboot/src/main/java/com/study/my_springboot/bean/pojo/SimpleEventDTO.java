/**
 * @(#)SimpleEventDTO.java, 2020-12-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Data
@AllArgsConstructor
public class SimpleEventDTO  implements Serializable {
    private String Key;
    private String value;
}