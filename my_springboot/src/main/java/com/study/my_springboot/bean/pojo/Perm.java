package com.study.my_springboot.bean.pojo;

public class Perm {
    private Long id;

    private String userid;

    private String modelname;

    private String dimensionkey1;

    private String rowcondition;

    private String columnfields;

    private Long createtime;

    private Long updatetime;

    private String dimensionkey0;

    private String dimensionkeysdesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getDimensionkey1() {
        return dimensionkey1;
    }

    public void setDimensionkey1(String dimensionkey1) {
        this.dimensionkey1 = dimensionkey1 == null ? null : dimensionkey1.trim();
    }

    public String getRowcondition() {
        return rowcondition;
    }

    public void setRowcondition(String rowcondition) {
        this.rowcondition = rowcondition == null ? null : rowcondition.trim();
    }

    public String getColumnfields() {
        return columnfields;
    }

    public void setColumnfields(String columnfields) {
        this.columnfields = columnfields == null ? null : columnfields.trim();
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public String getDimensionkey0() {
        return dimensionkey0;
    }

    public void setDimensionkey0(String dimensionkey0) {
        this.dimensionkey0 = dimensionkey0 == null ? null : dimensionkey0.trim();
    }

    public String getDimensionkeysdesc() {
        return dimensionkeysdesc;
    }

    public void setDimensionkeysdesc(String dimensionkeysdesc) {
        this.dimensionkeysdesc = dimensionkeysdesc == null ? null : dimensionkeysdesc.trim();
    }
}