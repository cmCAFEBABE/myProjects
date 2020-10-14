package test.enums;

public enum DataShareSupplierPermEnum {
    SUPPLIER_TOTAL_SALE_STOCK("总销售库存"),
    SUPPLIER_STOCK_TRANSFER_DAYS("库转天数"),
    SUPPLIER_SALE_DATA("销售数据"),
    SUPPLIER_GOOD_EVALUATE_RATE("好评率"),
    SUPPLIER_BAD_EVALUATE_RATE("差评率"),
    SUPPLIER_BACK_GOODS_RATE("退货率"),
    SUPPLIER_QC_PASS_RATE("质检通过率"),
    SUPPLIER_OVER_DUE_RATE("逾期率"),
    SUPPLIER_PURCHASE_PLAN("采购计划"),
    SUPPLIER_PURCHASE_PLAN_TIME_RANGE("采购计划时间范围"),
    SUPPLIER_ARRIVAL_GOODS_PLAN("到货计划"),
    SUPPLIER_COOPERATION_TIME("合作时间"),
    SUPPLIER_FIRST_GOODS_BUG_TIME("首个商品下单时间"),
    SUPPLIER_COOPERATION_TYPE("合作品类"),
    SUPPLIER_COOPERATION_GOODS_NUM("合作商品数量"),
    SUPPLIER_ACCUMULATED_PURCHASE_NUM("累计采购量"),
    SUPPLIER_ACCUMULATED_PURCHASE_MONEY("累计采购金额"),
    SUPPLIER_SINGING_PURCHASE_ORDER_NUM("签署中采购订单数"),
    SUPPLIER_QCING_PURCHASE_ORDER_NUM("签署中采购订单数"),
    SUPPLIER_WAITING_IN_STOCK_PURCHASE_ORDER_NUM("待入库采购订单数"),
    SUPPLIER_IN_STOCK_PURCHASE_ORDER_NUM("已库采购订单数"),
    SUPPLIER_OVER_DUE_PURCHASE_ORDER_DETAIL("逾期采购订单详情"),
    SUPPLIER_ANNUAL_PURCHASE_MONEY("年度商品采购金额（元）"),
    SUPPLIER_VALID_PURCHASE_NUM("有效采购量（件）"),
    SUPPLIER_ANNUAL_PURCHASE_NUM("年度采购订单数（单）"),
    SUPPLIER_MONTH_RATE("月度评级数据"),
    SUPPLIER_SEASON_RATE("季度评级数据"),
    SUPPLIER_CONTRACT_INFO("合同信息"),
    SUPPLIER_OFFER_MONEY("报价数据");

    private final String desc;

    DataShareSupplierPermEnum(String desc) {
        this.desc = desc;
    }


    public DataShareSupplierPermEnum getEnumByName(String str){
        for (DataShareSupplierPermEnum e: DataShareSupplierPermEnum.values()) {
            if(str.equals(e.toString())){
                return e;
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }
}