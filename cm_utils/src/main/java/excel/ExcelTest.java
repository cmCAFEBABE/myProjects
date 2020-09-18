/**
 * @(#)ExcelTest2.java, 2020-07-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.merge.OnceAbsoluteMergeStrategy;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ExcelTest {
    String fileSource = "document/excel/";
    @Test
    public void commonWriteTest() {
        String fileName = fileSource+"生成excel" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, DownloadDTO.class).sheet("sheet名称")
                .doWrite(getFruitData());
    }
    // 模拟从数据库读取需要下载的列表信息
    private List<DownloadDTO> getFruitData() {
        List<DownloadDTO> returnList = new ArrayList<>();
        DownloadDTO d1 = new DownloadDTO();
        d1.setCategory("水果");
        d1.setFruit("苹果");
        d1.setColor("红色");
        d1.setProduceDate(new Date());

        DownloadDTO d2 = new DownloadDTO();
        BeanUtils.copyProperties(d1, d2);
        d2.setColor("绿色");

        DownloadDTO d3 = new DownloadDTO();
        BeanUtils.copyProperties(d1, d3);
        d2.setColor("白色");

        DownloadDTO t1 = new DownloadDTO();
        t1.setCategory("水果");
        t1.setFruit("香蕉");
        t1.setColor("黄色");
        t1.setProduceDate(new Date());

        DownloadDTO t2 = new DownloadDTO();
        BeanUtils.copyProperties(t1, t2);
        t2.setColor("青色");

        returnList.add(d1);
        returnList.add(d2);
        returnList.add(d3);
        returnList.add(t1);
        returnList.add(t2);
        return returnList;
    }

    /**
     * 合并单元格
     */
    @Test
    public void loopMergeStrategyTest() {
        // 将第一列的数据每隔两行进行合并
        String fileName = fileSource+"合并单元格" + System.currentTimeMillis() + ".xlsx";
        LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 0);
        EasyExcel.write(fileName, DownloadDTO.class).registerWriteHandler(loopMergeStrategy)
                .sheet("sheet名称").doWrite(getFruitData());
    }



    /**
     * 指定坐标范围，对多个固定区间进行合并
     */
    @Test
    public void onceMergeStrategyTest() {
        String fileName = fileSource+"多个固定区间进行合并" + System.currentTimeMillis() + ".xlsx";
        OnceAbsoluteMergeStrategy onceAbsoluteMergeStrategy = new OnceAbsoluteMergeStrategy(1, 3, 1, 1);
        OnceAbsoluteMergeStrategy onceAbsoluteMergeStrategy2 = new OnceAbsoluteMergeStrategy(4, 5, 1, 1);
        EasyExcel.write(fileName, DownloadDTO.class)
                .registerWriteHandler(onceAbsoluteMergeStrategy)
                .registerWriteHandler(onceAbsoluteMergeStrategy2)
                .sheet("sheet名称").doWrite(getFruitData());
    }

    /**
     * 自定义合并策略
     */
    @Test
    public void myMergeStrategyTest() {
        String fileName = fileSource+"自定义合并策略" + System.currentTimeMillis() + ".xlsx";
        MyMergeStrategy myMergeStrategy = new MyMergeStrategy(getFruitData(), getGroupData());
        EasyExcel.write(fileName, DownloadDTO.class).registerWriteHandler(myMergeStrategy)
                .sheet("sheet名称").doWrite(getFruitData());
    }

    private  List<Integer> getGroupData(){
        return Lists.newArrayList(2,3);
    }

}