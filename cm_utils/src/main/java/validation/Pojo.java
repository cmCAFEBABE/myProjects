package validation; /**
 * @(#)pojo.java, 2020-11-23.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


import lombok.Data;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Data
public class Pojo {
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;

    public Pojo(String string1, String string2) {
        System.out.println(1);
        this.string1 = string1;
        this.string2 = string2;
    }

}