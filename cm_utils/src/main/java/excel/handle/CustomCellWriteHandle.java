/**
 * @(#)CustomCellWriteHandle.java, 2020-08-17.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package excel.handle;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import excel.style.CellStyleUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.StringUtil;

import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class CustomCellWriteHandle implements CellWriteHandler {
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

//        log.info("第{}行每{}列！" , cell.getRowIndex(), cell.getColumnIndex());
        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
        CellStyle cellStyle = CellStyleUtil.cellStyle(workbook);
        //根据校验结果设置单元格文字颜色
            //设置单元格背景色
//            cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());

        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cell.setCellStyle(cellStyle);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        CellType cellTypeEnum = cell.getCellTypeEnum();

        if (cellTypeEnum.equals(CellType.BLANK)){
            cell.setCellValue("-");
        }

    }
}