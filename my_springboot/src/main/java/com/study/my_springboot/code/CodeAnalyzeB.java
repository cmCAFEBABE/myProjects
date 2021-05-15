/**
 * @(#)codeAnalyzeB.java, 2020-12-20.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Component
public class CodeAnalyzeB {
    @Autowired
    CodeAnalyzeA codeAnalyzeA;
}