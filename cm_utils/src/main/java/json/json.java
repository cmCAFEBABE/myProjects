package json; /**
 * @(#)json.java, 2020-11-04.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static json.DataShareSkuPermEnum.*;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class json {

    @Test
    public void test(){
        String content = "{\"modify\":[{\"fieldName\":\"sale\"},{\"curValue\":30,\"fieldName\":\"orderPlan\",\"preValue\":60}],\"insert\":[\"stock\",\"returnRate\",\"deliveryPlan\"]}";
        Map<String, String> contentMap = JSON.parseObject(content, Map.class);
        contentMap.entrySet().stream().forEach(entry->{
            System.out.println(entry.getKey());
            if("modify".equals(entry.getKey())){
                List<FieldModify> list = JSON.parseObject(JSON.toJSONString(entry.getValue()), List.class);
                System.out.println(list);
            }else {
                List<String> list = JSON.parseObject(JSON.toJSONString(entry.getValue()), List.class);
                System.out.println(list);
            }
        });
    }

    @Test
    public void test2(){

        String content = "[{\"columnFields\":\"{\\\"SKU_TOTAL_SALE_STOCK\\\":\\\"false\\\",\\\"SKU_ARRIVAL_GOODS_PLAN\\\":\\\"false\\\",\\\"SKU_BACK_GOODS_RATE\\\":\\\"false\\\",\\\"SKU_BAD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_OVER_DUE_RATE\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN_TIME_RANGE\\\":\\\"false\\\",\\\"SKU_GOOD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_SALE_DATA\\\":\\\"false\\\",\\\"SKU_QC_PASS_RATE\\\":\\\"false\\\",\\\"SKU_STOCK_TRANSFER_DAYS\\\":\\\"false\\\"}\",\"createTime\":1604582459317,\"dimensionKey\":\"3512002\",\"dimensionKey2\":\"3745012\",\"dimensionKeysDesc\":\"SKU维度\",\"modelName\":\"SupplierSkuAuth\",\"rowCondition\":\"\",\"userId\":\"YX0011\"},{\"columnFields\":\"{\\\"SKU_TOTAL_SALE_STOCK\\\":\\\"false\\\",\\\"SKU_ARRIVAL_GOODS_PLAN\\\":\\\"false\\\",\\\"SKU_BACK_GOODS_RATE\\\":\\\"false\\\",\\\"SKU_BAD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_OVER_DUE_RATE\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN_TIME_RANGE\\\":\\\"false\\\",\\\"SKU_GOOD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_SALE_DATA\\\":\\\"false\\\",\\\"SKU_QC_PASS_RATE\\\":\\\"false\\\",\\\"SKU_STOCK_TRANSFER_DAYS\\\":\\\"false\\\"}\",\"createTime\":1604582459469,\"dimensionKey\":\"3512002\",\"dimensionKey2\":\"3745016\",\"dimensionKeysDesc\":\"SKU维度\",\"modelName\":\"SupplierSkuAuth\",\"rowCondition\":\"\",\"userId\":\"YX0011\"},{\"columnFields\":\"{\\\"SKU_TOTAL_SALE_STOCK\\\":\\\"false\\\",\\\"SKU_ARRIVAL_GOODS_PLAN\\\":\\\"false\\\",\\\"SKU_BACK_GOODS_RATE\\\":\\\"false\\\",\\\"SKU_BAD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_OVER_DUE_RATE\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN_TIME_RANGE\\\":\\\"false\\\",\\\"SKU_GOOD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_SALE_DATA\\\":\\\"false\\\",\\\"SKU_QC_PASS_RATE\\\":\\\"false\\\",\\\"SKU_STOCK_TRANSFER_DAYS\\\":\\\"false\\\"}\",\"createTime\":1604582459443,\"dimensionKey\":\"3512002\",\"dimensionKey2\":\"3745015\",\"dimensionKeysDesc\":\"SKU维度\",\"modelName\":\"SupplierSkuAuth\",\"rowCondition\":\"\",\"userId\":\"YX0011\"},{\"columnFields\":\"{\\\"SKU_TOTAL_SALE_STOCK\\\":\\\"false\\\",\\\"SKU_ARRIVAL_GOODS_PLAN\\\":\\\"false\\\",\\\"SKU_BACK_GOODS_RATE\\\":\\\"false\\\",\\\"SKU_BAD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_OVER_DUE_RATE\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN_TIME_RANGE\\\":\\\"false\\\",\\\"SKU_GOOD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_SALE_DATA\\\":\\\"false\\\",\\\"SKU_QC_PASS_RATE\\\":\\\"false\\\",\\\"SKU_STOCK_TRANSFER_DAYS\\\":\\\"false\\\"}\",\"createTime\":1604582459368,\"dimensionKey\":\"3512002\",\"dimensionKey2\":\"3745009\",\"dimensionKeysDesc\":\"SKU维度\",\"modelName\":\"SupplierSkuAuth\",\"rowCondition\":\"\",\"userId\":\"YX0011\"},{\"columnFields\":\"{\\\"SKU_TOTAL_SALE_STOCK\\\":\\\"true\\\",\\\"SKU_ARRIVAL_GOODS_PLAN\\\":\\\"false\\\",\\\"SKU_BACK_GOODS_RATE\\\":\\\"false\\\",\\\"SKU_BAD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_OVER_DUE_RATE\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN_TIME_RANGE\\\":\\\"false\\\",\\\"SKU_GOOD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_SALE_DATA\\\":\\\"false\\\",\\\"SKU_QC_PASS_RATE\\\":\\\"false\\\",\\\"SKU_STOCK_TRANSFER_DAYS\\\":\\\"false\\\"}\",\"createTime\":1604582459292,\"dimensionKey\":\"3512002\",\"dimensionKey2\":\"3745011\",\"dimensionKeysDesc\":\"SKU维度\",\"modelName\":\"SupplierSkuAuth\",\"rowCondition\":\"\",\"userId\":\"YX0011\"},{\"columnFields\":\"{\\\"SKU_TOTAL_SALE_STOCK\\\":\\\"false\\\",\\\"SKU_ARRIVAL_GOODS_PLAN\\\":\\\"false\\\",\\\"SKU_BACK_GOODS_RATE\\\":\\\"false\\\",\\\"SKU_BAD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_OVER_DUE_RATE\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN_TIME_RANGE\\\":\\\"false\\\",\\\"SKU_GOOD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_SALE_DATA\\\":\\\"false\\\",\\\"SKU_QC_PASS_RATE\\\":\\\"false\\\",\\\"SKU_STOCK_TRANSFER_DAYS\\\":\\\"false\\\"}\",\"createTime\":1604582459418,\"dimensionKey\":\"3512002\",\"dimensionKey2\":\"3745014\",\"dimensionKeysDesc\":\"SKU维度\",\"modelName\":\"SupplierSkuAuth\",\"rowCondition\":\"\",\"userId\":\"YX0011\"},{\"columnFields\":\"{\\\"SKU_TOTAL_SALE_STOCK\\\":\\\"false\\\",\\\"SKU_ARRIVAL_GOODS_PLAN\\\":\\\"false\\\",\\\"SKU_BACK_GOODS_RATE\\\":\\\"false\\\",\\\"SKU_BAD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_OVER_DUE_RATE\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN_TIME_RANGE\\\":\\\"false\\\",\\\"SKU_GOOD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_SALE_DATA\\\":\\\"false\\\",\\\"SKU_QC_PASS_RATE\\\":\\\"false\\\",\\\"SKU_STOCK_TRANSFER_DAYS\\\":\\\"false\\\"}\",\"createTime\":1604582459342,\"dimensionKey\":\"3512002\",\"dimensionKey2\":\"3745010\",\"dimensionKeysDesc\":\"SKU维度\",\"modelName\":\"SupplierSkuAuth\",\"rowCondition\":\"\",\"userId\":\"YX0011\"},{\"columnFields\":\"{\\\"SKU_TOTAL_SALE_STOCK\\\":\\\"true\\\",\\\"SKU_ARRIVAL_GOODS_PLAN\\\":\\\"false\\\",\\\"SKU_BACK_GOODS_RATE\\\":\\\"false\\\",\\\"SKU_BAD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_OVER_DUE_RATE\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN\\\":\\\"false\\\",\\\"SKU_PURCHASE_PLAN_TIME_RANGE\\\":\\\"false\\\",\\\"SKU_GOOD_EVALUATE_RATE\\\":\\\"false\\\",\\\"SKU_SALE_DATA\\\":\\\"false\\\",\\\"SKU_QC_PASS_RATE\\\":\\\"false\\\",\\\"SKU_STOCK_TRANSFER_DAYS\\\":\\\"false\\\"}\",\"createTime\":1604582459393,\"dimensionKey\":\"3512002\",\"dimensionKey2\":\"3745013\",\"dimensionKeysDesc\":\"SKU维度\",\"modelName\":\"SupplierSkuAuth\",\"rowCondition\":\"\",\"userId\":\"YX0011\"}]";
        List<String> skuPerm1 = JSON.parseObject(content,List.class);
        List<DataPermVO> skuPermList = skuPerm1.stream().map(o->JSON.parseObject(JSON.toJSONString(o),DataPermVO.class)).collect(Collectors.toList());
        skuPermList.stream().forEach(skuPerm->{
            Map<String, String> map = JSON.parseObject(skuPerm.getColumnFields(), Map.class);
            Set<String> subSkuPermSet = map.entrySet().stream().filter(entry-> !"false".equals(entry.getValue())).map(o->o.getKey()).collect(Collectors.toSet());
            System.out.println(subSkuPermSet);
        });

    }


    @Test
    public void test3(){
        String content = "{\"SKU_BACK_GOODS_RATE\":true,\"SKU_GOOD_EVALUATE_RATE\":true}";
        Map<String, String> map = JSON.parseObject(content, Map.class);
        System.out.println(map.containsKey("SKU_BACK_GOODS_RATE")&&"true".equals(JSON.toJSONString(map.get("SKU_BACK_GOODS_RATE"))));
    }


    @Test
    public void test4(){
        List list = Lists.newArrayList(1,2,3,4);
        System.out.println(list);
    }

    @Test
    public void test5(){
        Map<String, List<String>> notShowMap = new HashMap<>();
        Map<String, List<String>> showMap = new HashMap<>();
        Map<String, List<FieldModify>> modifyMap = new HashMap<>();
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("insert", showMap.get("1"));
        contentMap.put("insert", null);
        contentMap.put("delete", notShowMap.get("1"));
        contentMap.put("modify", modifyMap.get("1"));
        System.out.println("{}".equals(JSON.toJSONString(contentMap)));
    }

    @Test
    public void test6(){

        String content = "[\"isContainGoodComment\",\"isContainBadComment\",\"isContainQCRate\",\"isContainTotalSaleStock\",\"isContainAvgSaleQtyQuanzhanNogift30d\",\"isContainYesterdaySaleNum\"]";

        Set<String> set = JSON.parseObject(content,Set.class);

        Set<String> set1 = excludeColumnFiledNames2ExcelFiledName(set);
        System.out.println(set1);


    }


    private Set<String> excludeColumnFiledNames2ExcelFiledName(Set<String> excludeColumnFiledNames){
        if(CollectionUtils.isEmpty(excludeColumnFiledNames)){
            return Sets.newHashSet();
        }
        Set<String> results = excludeColumnFiledNames.stream().map(o -> {
            switch (o) {
                case "isContainCurrentItemStatus": {
                    return "itemMainStatus";
                }
                case "isContainPhysicsCategory": {
                    return "phyCategory";
                }
                case "isContainGoodComment": {
                    return "goodCommentRateTd";
                }
                case "isContainBadComment": {
                    return "badCommentRateTd";
                }
                case "isContainRollBackItemRate": {
                    return "t30ReturnSkuSucRateTd";
                }
                case "isContainQCRate": {
                    return "qcPassRateTd";
                }
                case "isContainTotalSaleStock": {
                    return "virtualQty1d";
                }
                case "isContainInWayStock": {
                    return "shipQty";
                }
                case "isContainStockDayNum": {
                    return "virtualTurnoverRate30d";
                }
                case "isContainAvgSaleQtyQuanzhanNogift30d": {
                    return "avgSaleQtyQuanzhanNogift30d";
                }
                case "isContainYesterdaySaleNum": {
                    return "yesterdaySaleQty1d";
                }
                default: {
                    return o;
                }
            }
        }).collect(Collectors.toSet());
        return results;
    }



    @Test
    public void test8(){


        String str = "{\"virtualQty\":true,\"avgSaleQty30d\":true,\"saleQty\":true}";

        System.out.println(oldColumnFieldMap2New(str));
    }

    private String oldColumnFieldMap2New(String columnField) {
        Map<String, String> columnFieldMap = JSON.parseObject(columnField, Map.class);
        Map<String, String> columnFieldMapNew = Maps.newHashMap();
        columnFieldMap.entrySet().stream().forEach(entry -> {
            //avgSaleQty30d 和 saleQty 两者必现 ，只存一个
            if (entry.getKey().equals("avgSaleQty30d")) {
                return;
            }
            String newKey = supplierItemPermEnum2NewPermEnum(entry.getKey());

            String value = "true".equals(JSON.toJSONString(entry.getValue())) ? "true" : entry.getValue();
            columnFieldMapNew.put(newKey, value);
        });
        String result = JSON.toJSONString(columnFieldMapNew);

        return result;
    }


    private String supplierItemPermEnum2NewPermEnum(String value) {
        String result = StringUtils.EMPTY;
        switch (value) {
            //实物库存在某次优化后去掉了 不考虑该情况
            case "inventoryQty": {
                result = "inventoryQty";
                break;
            }
            case "virtualQty": {
                result = SKU_TOTAL_SALE_STOCK.toString();
                break;
            }
            case "avgSaleQty30d": {
                result = SKU_SALE_DATA.toString();
                break;
            }
            case "saleQty": {
                result = SKU_SALE_DATA.toString();
                break;
            }
            case "goodCmtRate90d": {
                result = SKU_GOOD_EVALUATE_RATE.toString();
                break;
            }
            case "rfdAmtRate90d": {
                result = SKU_BACK_GOODS_RATE.toString();
                break;
            }
            case "suggestOrders": {
                result = SKU_PURCHASE_PLAN.toString();
                break;
            }
            case "shipQty": {
                result = SKU_ARRIVAL_GOODS_PLAN.toString();
                break;
            }
        }
        return result;
    }

    @Test
    public void test9(){
        List<TestJSON> list = Lists.newArrayList();
        for (int i = 0; i < 2000000; i++) {
            list.add(new TestJSON());
        }
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test10() throws Exception{
        List<TestJSON> list = Lists.newArrayList();
        for (int i = 0; i < 2000000; i++) {
            list.add(new TestJSON());
        }
        System.out.println(new ObjectMapper().writeValueAsString(list));
    }
    @Test
    public void test11() throws Exception{
        List<TestJSON> list = Lists.newArrayList();
        for (int i = 0; i < 2000000; i++) {
            list.add(new TestJSON());
        }
        System.out.println(new Gson().toJson(list));
    }

}