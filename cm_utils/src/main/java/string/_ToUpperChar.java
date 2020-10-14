/**
 * @(#)_ToUpperChar.java, 2020-07-27.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package string;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Streams;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class _ToUpperChar {







    @Test
    public void test1() {
        String _string = "supplier_id,\n" +
                "storehouse_id,\n" +
                "storehouse_name,\n" +
                "goods_right,\n" +
                "kpi_total_score,\n" +
                "outstore_pack_error_rate,\n" +
                "outstore_pack_error_rate_score,\n" +
                "outstore_pack_error_weight,\n" +
                "outstore_pack_intime_rate,\n" +
                "outstore_pack_intime_rate_score,\n" +
                "outstore_pack_intime_weight,\n" +
                "outstore_lack_rate,\n" +
                "outstore_lack_rate_score,\n" +
                "outstore_lack_weight,\n" +
                "inventory_error_rate,\n" +
                "inventory_error_rate_score,\n" +
                "inventory_error_weight,\n" +
                "consignee_intime_rate,\n" +
                "consignee_intime_rate_score,\n" +
                "consignee_intime_weight,\n" +
                "express_intime_rate,\n" +
                "express_intime_rate_score,\n" +
                "express_intime_weight,\n" +
                "express_complain_rate,\n" +
                "express_complain_rate_score,\n" +
                "express_complain_weight,\n" +
                "outstore_intime_fulldose_rate,\n" +
                "outstore_intime_fulldose_rate_score,\n" +
                "outstore_intime_fulldose_weight,\n" +
                "kf_outtime_rate,\n" +
                "kf_outtime_rate_score,\n" +
                "kf_outtime_weight,\n" +
                "kf_1_flow_rate,\n" +
                "kf_1_flow_rate_score,\n" +
                "kf_1_flow_weight,\n" +
                "return_qc_intime_rate,\n" +
                "return_qc_intime_rate_score,\n" +
                "return_qc_intime_weight,\n" +
                "stat_begin_dt,\n" +
                "stat_end_dt,\n" +
                "stat_perio,";
        String[] split = _string.split(",");
        ArrayList<String> list = Lists.newArrayList(split);
        list.forEach(o -> {
            char[] chars = o.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '_') {
                    chars[i + 1] = Character.toUpperCase(chars[i + 1]);
                }
            }
            String transferString = String.valueOf(chars);
            String replaceString = transferString.replaceAll("_", "");
            String results = "private String " + replaceString;
            System.out.println(replaceString);
        });
    }

    @Test
    public void test2() {
        System.out.println(StringMapper.map);
        List<String> filedList = Lists.newArrayList();
        String _string =
                        "supplier_id\tstring\t供应商id\n" +
                                "item_id\tbigint\t商品id\n" +
                                "sku_id\tbigint\tskuid\n" +
                                "purchase_uid\tstring\t采购uid\n" +
                                "purchase_name\tstring\t采购姓名\n" +
                                "planner_uid\tstring\t计划uid\n" +
                                "planner_name\tstring\t计划姓名\n" +
                                "qc_uid\tstring\tsqe uid\n" +
                                "qc_name\tstring\tsqe 姓名\n" +
                                "manager_uid\tstring\t商品开发uid\n" +
                                "manager_name\tstring\t商品开发姓名";
        String[] split = _string.split("\n");
        ArrayList<String> list = Lists.newArrayList(split);
        list.forEach(o -> {
            String[] rowString = o.split("\t");

            String sub1 = "/**\n" +
                    " *" + rowString[2] +
                    " \n*/\n";
            String sub2 = "private " + StringMapper.map.get(rowString[1].toLowerCase())+" ";
            String sub3 = _StringTransfer(rowString[0]);
            filedList.add(sub3);

            String result = sub1+sub2+sub3+";";
            System.out.println(result);
        });

        System.out.println("----------------");
        filedList.stream().forEach(System.out::println);
    }

    private String _StringTransfer(String o){
        char[] chars = o.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                chars[i + 1] = Character.toUpperCase(chars[i + 1]);
            }
        }
        String transferString = String.valueOf(chars);
        return transferString.replaceAll("_", "");
    }


    @Test
    public void mockData1(){
        String objectName = "data";
        String filed = "    /**\n" +
                "     * 工单标题\n" +
                "     */\n" +
                "    private String workOrderName;\n" +
                "\n" +
                "    /**\n" +
                "     * 工单Id\n" +
                "     */\n" +
                "    private String workOrderId;\n" +
                "\n" +
                "    /**\n" +
                "     * 工单完结日期\n" +
                "     */\n" +
                "    private Long workOrderEndTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 指标类型\n" +
                "     */\n" +
                "    private String indicatorType;\n" +
                "\n" +
                "    /**\n" +
                "     * 关联仓库名称\n" +
                "     */\n" +
                "    private String relatedWarehouseName;\n" +
                "\n" +
                "    /**\n" +
                "     * 订单号\n" +
                "     */\n" +
                "    private String orderNo;\n" +
                "\n" +
                "    /**\n" +
                "     * 商品名称\n" +
                "     */\n" +
                "    private String itemName;\n" +
                "\n" +
                "    /**\n" +
                "     * skuId\n" +
                "     */\n" +
                "    private String skuId;\n";

        String[] split = filed.split("\n");
        List<String> fieldList = Arrays.stream(split).filter(o->o.contains("private")).map(o->o.trim()).collect(Collectors.toList());
//        fieldList.stream().forEach(System.out::println);
        List<String> collect = fieldList.stream().map(o -> {
            String[] s = o.split(" ");
            String subFiled = s[s.length - 1];
            char[] chars = subFiled.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            String result = objectName + ".set" + String.valueOf(chars).replaceAll(";","") + "();";
            return result;
        }).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

    }

    @Test
    public void mockData(){
        String objectName = "fillData";
        String field = "supplierId\n" +
                "storehouseId\n" +
                "storehouseName\n" +
                "goodsRight\n" +
                "kpiTotalScore\n" +
                "outstorePackErrorRate\n" +
                "outstorePackErrorRateScore\n" +
                "outstorePackErrorWeight\n" +
                "outstorePackIntimeRate\n" +
                "outstorePackIntimeRateScore\n" +
                "outstorePackIntimeWeight\n" +
                "outstoreLackRate\n" +
                "outstoreLackRateScore\n" +
                "outstoreLackWeight\n" +
                "inventoryErrorRate\n" +
                "inventoryErrorRateScore\n" +
                "inventoryErrorWeight\n" +
                "consigneeIntimeRate\n" +
                "consigneeIntimeRateScore\n" +
                "consigneeIntimeWeight\n" +
                "expressIntimeRate\n" +
                "expressIntimeRateScore\n" +
                "expressIntimeWeight\n" +
                "expressComplainRate\n" +
                "expressComplainRateScore\n" +
                "expressComplainWeight\n" +
                "outstoreIntimeFulldoseRate\n" +
                "outstoreIntimeFulldoseRateScore\n" +
                "outstoreIntimeFulldoseWeight\n" +
                "kfOuttimeRate\n" +
                "kfOuttimeRateScore\n" +
                "kfOuttimeWeight\n" +
                "kf1FlowRate\n" +
                "kf1FlowRateScore\n" +
                "kf1FlowWeight\n" +
                "returnQcIntimeRate\n" +
                "returnQcIntimeRateScore\n" +
                "returnQcIntimeWeight\n" +
                "statBeginDt\n" +
                "statEndDt\n" +
                "statPeriod";
        String[] split = field.split("\n");
        Arrays.stream(split).forEach(o->{
            char[] chars = o.toCharArray();
            chars[0]=Character.toUpperCase(chars[0]);
            String result = objectName+".set"+String.valueOf(chars)+"();";
            System.out.println(result);
        });
    }



}