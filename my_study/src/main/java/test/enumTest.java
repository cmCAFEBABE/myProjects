/**
 * @(#)enumTest.java, 2020-10-13.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package test;

import org.junit.Test;
import test.enums.DataShareSupplierPermEnum;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class enumTest {

    @Test
    public void test1(){
        for (DataShareSupplierPermEnum e: DataShareSupplierPermEnum.values()) {
            System.out.println(e.toString());
        }
    }
}