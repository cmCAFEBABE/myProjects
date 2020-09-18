/**
 * @(#)CellStyleUtil.java, 2020-08-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package excel.style;

import org.apache.poi.ss.usermodel.*;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class CellStyleUtil {
    /**
     *  通用样式
     * @param workbook
     * @return
     */
    public static CellStyle cellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        //居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

}