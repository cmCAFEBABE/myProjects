package com.study.my_springboot.test;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class DemoData {
    /**
     * skuId
     */
    @ExcelProperty(value = "skuId")
    private Long skuId;
    /**
     * 老仓库Id
     */
    @ExcelProperty(value = "warehouseCode")
    private String warehouseCode;
}