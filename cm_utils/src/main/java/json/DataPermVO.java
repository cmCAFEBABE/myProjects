
package json;

import java.io.Serializable;

/**
 * @author 雷玉超(leiyuchao @ corp.netease.com)
 * @data 2019/05/10
 */
public class DataPermVO implements Serializable {
    private static final long serialVersionUID = 2040540541420993877L;

    //用户id
    private String userId;

    //数据模型名称
    private String modelName;

    //权限配置维度 spu
    private String dimensionKey;

    //权限配置维度2 sku
    private String dimensionKey2;

    //权限配置维度说明
    private String dimensionKeysDesc;

    //权限行过滤条件
    private String rowCondition;

    //权限列字段列表
    private String columnFields;

    private Long createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDimensionKey() {
        return dimensionKey;
    }

    public void setDimensionKey(String dimensionKey) {
        this.dimensionKey = dimensionKey;
    }

    public String getRowCondition() {
        return rowCondition;
    }

    public void setRowCondition(String rowCondition) {
        this.rowCondition = rowCondition;
    }

    public String getColumnFields() {
        return columnFields;
    }

    public void setColumnFields(String columnFields) {
        this.columnFields = columnFields;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getDimensionKey2() {
        return dimensionKey2;
    }

    public void setDimensionKey2(String dimensionKey2) {
        this.dimensionKey2 = dimensionKey2;
    }

    public String getDimensionKeysDesc() {
        return dimensionKeysDesc;
    }

    public void setDimensionKeysDesc(String dimensionKeysDesc) {
        this.dimensionKeysDesc = dimensionKeysDesc;
    }
}
