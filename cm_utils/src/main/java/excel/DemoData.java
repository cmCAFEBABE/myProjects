package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class DemoData {
    @ExcelProperty("skuId")
    private String string;
    @ExcelProperty("date")
    private String date;
    @ExcelProperty("doubleData")
    private Double doubleData;
}