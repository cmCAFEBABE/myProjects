package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DownloadDTO {
    private String category;
    private String fruit;
    private String color;
    private Date produceDate;
}