package com.study.my_springboot.bean.pojo;

import java.util.ArrayList;
import java.util.List;

public class PermExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andModelnameIsNull() {
            addCriterion("modelName is null");
            return (Criteria) this;
        }

        public Criteria andModelnameIsNotNull() {
            addCriterion("modelName is not null");
            return (Criteria) this;
        }

        public Criteria andModelnameEqualTo(String value) {
            addCriterion("modelName =", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotEqualTo(String value) {
            addCriterion("modelName <>", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameGreaterThan(String value) {
            addCriterion("modelName >", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameGreaterThanOrEqualTo(String value) {
            addCriterion("modelName >=", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLessThan(String value) {
            addCriterion("modelName <", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLessThanOrEqualTo(String value) {
            addCriterion("modelName <=", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLike(String value) {
            addCriterion("modelName like", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotLike(String value) {
            addCriterion("modelName not like", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameIn(List<String> values) {
            addCriterion("modelName in", values, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotIn(List<String> values) {
            addCriterion("modelName not in", values, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameBetween(String value1, String value2) {
            addCriterion("modelName between", value1, value2, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotBetween(String value1, String value2) {
            addCriterion("modelName not between", value1, value2, "modelname");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1IsNull() {
            addCriterion("dimensionKey_1 is null");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1IsNotNull() {
            addCriterion("dimensionKey_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1EqualTo(String value) {
            addCriterion("dimensionKey_1 =", value, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1NotEqualTo(String value) {
            addCriterion("dimensionKey_1 <>", value, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1GreaterThan(String value) {
            addCriterion("dimensionKey_1 >", value, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1GreaterThanOrEqualTo(String value) {
            addCriterion("dimensionKey_1 >=", value, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1LessThan(String value) {
            addCriterion("dimensionKey_1 <", value, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1LessThanOrEqualTo(String value) {
            addCriterion("dimensionKey_1 <=", value, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1Like(String value) {
            addCriterion("dimensionKey_1 like", value, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1NotLike(String value) {
            addCriterion("dimensionKey_1 not like", value, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1In(List<String> values) {
            addCriterion("dimensionKey_1 in", values, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1NotIn(List<String> values) {
            addCriterion("dimensionKey_1 not in", values, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1Between(String value1, String value2) {
            addCriterion("dimensionKey_1 between", value1, value2, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andDimensionkey1NotBetween(String value1, String value2) {
            addCriterion("dimensionKey_1 not between", value1, value2, "dimensionkey1");
            return (Criteria) this;
        }

        public Criteria andRowconditionIsNull() {
            addCriterion("rowCondition is null");
            return (Criteria) this;
        }

        public Criteria andRowconditionIsNotNull() {
            addCriterion("rowCondition is not null");
            return (Criteria) this;
        }

        public Criteria andRowconditionEqualTo(String value) {
            addCriterion("rowCondition =", value, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionNotEqualTo(String value) {
            addCriterion("rowCondition <>", value, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionGreaterThan(String value) {
            addCriterion("rowCondition >", value, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionGreaterThanOrEqualTo(String value) {
            addCriterion("rowCondition >=", value, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionLessThan(String value) {
            addCriterion("rowCondition <", value, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionLessThanOrEqualTo(String value) {
            addCriterion("rowCondition <=", value, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionLike(String value) {
            addCriterion("rowCondition like", value, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionNotLike(String value) {
            addCriterion("rowCondition not like", value, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionIn(List<String> values) {
            addCriterion("rowCondition in", values, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionNotIn(List<String> values) {
            addCriterion("rowCondition not in", values, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionBetween(String value1, String value2) {
            addCriterion("rowCondition between", value1, value2, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andRowconditionNotBetween(String value1, String value2) {
            addCriterion("rowCondition not between", value1, value2, "rowcondition");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsIsNull() {
            addCriterion("columnFields is null");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsIsNotNull() {
            addCriterion("columnFields is not null");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsEqualTo(String value) {
            addCriterion("columnFields =", value, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsNotEqualTo(String value) {
            addCriterion("columnFields <>", value, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsGreaterThan(String value) {
            addCriterion("columnFields >", value, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsGreaterThanOrEqualTo(String value) {
            addCriterion("columnFields >=", value, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsLessThan(String value) {
            addCriterion("columnFields <", value, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsLessThanOrEqualTo(String value) {
            addCriterion("columnFields <=", value, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsLike(String value) {
            addCriterion("columnFields like", value, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsNotLike(String value) {
            addCriterion("columnFields not like", value, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsIn(List<String> values) {
            addCriterion("columnFields in", values, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsNotIn(List<String> values) {
            addCriterion("columnFields not in", values, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsBetween(String value1, String value2) {
            addCriterion("columnFields between", value1, value2, "columnfields");
            return (Criteria) this;
        }

        public Criteria andColumnfieldsNotBetween(String value1, String value2) {
            addCriterion("columnFields not between", value1, value2, "columnfields");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Long value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Long value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Long value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Long value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Long value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Long> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Long> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Long value1, Long value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Long value1, Long value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Long value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Long value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Long value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Long value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Long value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Long> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Long> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Long value1, Long value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Long value1, Long value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0IsNull() {
            addCriterion("dimensionKey_0 is null");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0IsNotNull() {
            addCriterion("dimensionKey_0 is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0EqualTo(String value) {
            addCriterion("dimensionKey_0 =", value, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0NotEqualTo(String value) {
            addCriterion("dimensionKey_0 <>", value, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0GreaterThan(String value) {
            addCriterion("dimensionKey_0 >", value, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0GreaterThanOrEqualTo(String value) {
            addCriterion("dimensionKey_0 >=", value, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0LessThan(String value) {
            addCriterion("dimensionKey_0 <", value, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0LessThanOrEqualTo(String value) {
            addCriterion("dimensionKey_0 <=", value, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0Like(String value) {
            addCriterion("dimensionKey_0 like", value, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0NotLike(String value) {
            addCriterion("dimensionKey_0 not like", value, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0In(List<String> values) {
            addCriterion("dimensionKey_0 in", values, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0NotIn(List<String> values) {
            addCriterion("dimensionKey_0 not in", values, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0Between(String value1, String value2) {
            addCriterion("dimensionKey_0 between", value1, value2, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkey0NotBetween(String value1, String value2) {
            addCriterion("dimensionKey_0 not between", value1, value2, "dimensionkey0");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescIsNull() {
            addCriterion("dimensionKeysDesc is null");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescIsNotNull() {
            addCriterion("dimensionKeysDesc is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescEqualTo(String value) {
            addCriterion("dimensionKeysDesc =", value, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescNotEqualTo(String value) {
            addCriterion("dimensionKeysDesc <>", value, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescGreaterThan(String value) {
            addCriterion("dimensionKeysDesc >", value, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescGreaterThanOrEqualTo(String value) {
            addCriterion("dimensionKeysDesc >=", value, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescLessThan(String value) {
            addCriterion("dimensionKeysDesc <", value, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescLessThanOrEqualTo(String value) {
            addCriterion("dimensionKeysDesc <=", value, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescLike(String value) {
            addCriterion("dimensionKeysDesc like", value, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescNotLike(String value) {
            addCriterion("dimensionKeysDesc not like", value, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescIn(List<String> values) {
            addCriterion("dimensionKeysDesc in", values, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescNotIn(List<String> values) {
            addCriterion("dimensionKeysDesc not in", values, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescBetween(String value1, String value2) {
            addCriterion("dimensionKeysDesc between", value1, value2, "dimensionkeysdesc");
            return (Criteria) this;
        }

        public Criteria andDimensionkeysdescNotBetween(String value1, String value2) {
            addCriterion("dimensionKeysDesc not between", value1, value2, "dimensionkeysdesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}