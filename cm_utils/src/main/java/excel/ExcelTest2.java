/**
 * @(#)ExcelTest2.java, 2020-07-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.google.common.collect.Lists;
import excel.handle.CustomCellWriteHandle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ExcelTest2 {
    private String path = ClassLoader.getSystemClassLoader().getResource("document/excel/").getPath();

    /**
     * 横向的填充
     *
     * @since 2.1.1
     */
    @Test
    public void horizontalFill() {
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // {} 代表普通变量 {.} 代表是list的变量
        String templateFileName =
                path + "model/horizontal.xlsx";

        String fileName = path + "horizontalFill" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
        excelWriter.fill(data(), fillConfig, writeSheet);
        excelWriter.fill(data(), fillConfig, writeSheet);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2019年10月9日13:28:28");
        excelWriter.fill(map, writeSheet);

        // 别忘记关闭流
        excelWriter.finish();
    }

    private List<FillData> data() {
        List<FillData> list = new ArrayList<FillData>();
        for (int i = 0; i < 10; i++) {
            FillData fillData = new FillData();
            list.add(fillData);
            fillData.setName("张三");
            fillData.setNumber(5.2);
        }
        return list;
    }


    /**
     * 横向填充-数据共享详情页
     */
    @Test
    public void horizontalFill2() {
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // {} 代表普通变量 {.} 代表是list的变量
        System.out.println(path);
        String templateFileName =
                path + "model/model.xlsx";

        String fileName = path + "horizontalFill" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        ExcelWriter excelWriter = EasyExcel.write(fileName).registerWriteHandler(new CustomCellWriteHandle()).withTemplate(templateFileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
        excelWriter.fill(data2(), fillConfig, writeSheet);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rate", "0.1");
        excelWriter.fill(map, writeSheet);

        // 别忘记关闭流
        excelWriter.finish();
    }

    private List<ExternalWarehouseIndicator> data2() {
        List<ExternalWarehouseIndicator> list = new ArrayList<ExternalWarehouseIndicator>();
        for (int i = 0; i < 10; i++) {
            ExternalWarehouseIndicator fillData = new ExternalWarehouseIndicator();
            list.add(fillData);
            fillData.setSupplierId("YX00" + i);
            fillData.setStorehouseId("YXid" + i);
            fillData.setStorehouseName("YXname" + i);
            fillData.setGoodsRight(0);
            fillData.setKpiTotalScore(12d);
            fillData.setOutstorePackErrorRate(null);
            fillData.setOutstorePackErrorRateScore(87L);
            fillData.setOutstorePackErrorWeight(0.1);
            fillData.setOutstorePackIntimeRate(12d);
            fillData.setOutstorePackIntimeRateScore(87L);
            fillData.setOutstorePackIntimeWeight(0.1);
            fillData.setOutstoreLackRate(0.5);
            fillData.setOutstoreLackRateScore(88L);
            fillData.setOutstoreLackWeight(0.5);
            fillData.setInventoryErrorRate(0.3);
            fillData.setInventoryErrorRateScore(93L);
            fillData.setInventoryErrorWeight(0.4);
            fillData.setConsigneeIntimeRate(0.5);
            fillData.setConsigneeIntimeRateScore(97L);
            fillData.setConsigneeIntimeWeight(0.5);
            fillData.setExpressIntimeRate(0.5);
            fillData.setExpressIntimeRateScore(86L);
            fillData.setExpressIntimeWeight(0.3);
            fillData.setExpressComplainRate(0.3);
            fillData.setExpressComplainRateScore(98L);
            fillData.setExpressComplainWeight(0.2);
            fillData.setOutstoreIntimeFulldoseRate(0.4);
            fillData.setOutstoreIntimeFulldoseRateScore(99L);
            fillData.setOutstoreIntimeFulldoseWeight(0.1);
            fillData.setKfOuttimeRate(0.7);
            fillData.setKfOuttimeRateScore(90L);
            fillData.setKfOuttimeWeight(0.2);
            fillData.setKf1FlowRate(0.4);
            fillData.setKf1FlowRateScore(66L);
            fillData.setKf1FlowWeight(0.6);
            fillData.setReturnQcIntimeRate(0.6);
            fillData.setReturnQcIntimeRateScore(99L);
            fillData.setReturnQcIntimeWeight(0.3);
            fillData.setStatBeginDt(99999L);
            fillData.setStatEndDt(9999999999L);
            fillData.setStatPeriod(1);
            fillData.setTimeRange("这里是时间");


        }
        return list;
    }

    /**
     * 竖向填充 最基本excel
     */
    @Test
    public void common() {
        String fileName = path + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExternalWarehousePackageErrorRateDetail.class)
                .registerWriteHandler(new CustomCellWriteHandle())
                .sheet("模板")
                .doWrite(getData2());
    }

    private List<ExternalWarehousePackageErrorRateDetail> getData2() {
        List<ExternalWarehousePackageErrorRateDetail> result = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            ExternalWarehousePackageErrorRateDetail data = new ExternalWarehousePackageErrorRateDetail();
            result.add(data);
            data.setWorkOrderName(null);
            data.setWorkOrderId(null);
            data.setWorkOrderEndTime(System.currentTimeMillis());
            data.setIndicatorType("123123");
            data.setRelatedWarehouseName("13123123123123");
            data.setOrderNo("asdfasdf");
            data.setItemName("asdfasdfasd");
            data.setSkuId("asdasdf");
            data.setRate(0.15678);
        }

        return result;
    }

    /**
     * 竖向填充 多Sheet
     */
    @Test
    public void muiSheet() {
        // 方法3 如果写到不同的sheet 不同的对象
        String fileName = path + "muiSheet" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName).build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            WriteSheet writeSheet = EasyExcel.writerSheet(0, "模板" + 1).head(FillData.class).build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<FillData> data = data();
            excelWriter.write(data, writeSheet);

            writeSheet = EasyExcel.writerSheet(1, "模板" + 2).head(ExternalWarehousePackageErrorRateDetail.class).build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<ExternalWarehousePackageErrorRateDetail> data2 = getData2();
            excelWriter.write(data2, writeSheet);

        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }


    @Test
    public void testGetMulSheetExcel(){
        String fileName = path + "muiSheet" + System.currentTimeMillis() + ".xlsx";
        List<MulSheetVo> mulSheetVos = Lists.newArrayList();
        MulSheetVo mulSheetVo = new MulSheetVo();
        mulSheetVos.add(mulSheetVo);
        mulSheetVo.setSheetName("test1");
        mulSheetVo.setClazz(FillData.class);
        mulSheetVo.setData(data());

        MulSheetVo mulSheetVo2 = new MulSheetVo();
        mulSheetVos.add(mulSheetVo2);
        mulSheetVo2.setSheetName("test22222222");
        mulSheetVo2.setClazz(ExternalWarehousePackageErrorRateDetail.class);
        mulSheetVo2.setData(getData2());

        getMulSheetExcel(fileName,mulSheetVos);
    }
    /**
     * 多sheet生成 封装方法
     * @param fileName
     * @param mulSheetVo
     */
    private void getMulSheetExcel(String fileName, List<MulSheetVo> mulSheetVo) {
        ExcelWriter excelWriter = null;
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName).build();
            for (int i = 0; i < mulSheetVo.size(); i++) {
                WriteSheet writeSheet = EasyExcel.writerSheet(i,mulSheetVo.get(i).getSheetName()).head(mulSheetVo.get(i).getClazz()).build();
                excelWriter.write(mulSheetVo.get(i).getData(), writeSheet);
            }

        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }



}