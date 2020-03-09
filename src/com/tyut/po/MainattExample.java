package com.tyut.po;

import java.util.ArrayList;
import java.util.List;

public class MainattExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MainattExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNull() {
            addCriterion("dep_id is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("dep_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(Integer value) {
            addCriterion("dep_id =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(Integer value) {
            addCriterion("dep_id <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(Integer value) {
            addCriterion("dep_id >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dep_id >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(Integer value) {
            addCriterion("dep_id <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(Integer value) {
            addCriterion("dep_id <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<Integer> values) {
            addCriterion("dep_id in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<Integer> values) {
            addCriterion("dep_id not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(Integer value1, Integer value2) {
            addCriterion("dep_id between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dep_id not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdIsNull() {
            addCriterion("am_date1_id is null");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdIsNotNull() {
            addCriterion("am_date1_id is not null");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdEqualTo(Integer value) {
            addCriterion("am_date1_id =", value, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdNotEqualTo(Integer value) {
            addCriterion("am_date1_id <>", value, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdGreaterThan(Integer value) {
            addCriterion("am_date1_id >", value, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("am_date1_id >=", value, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdLessThan(Integer value) {
            addCriterion("am_date1_id <", value, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdLessThanOrEqualTo(Integer value) {
            addCriterion("am_date1_id <=", value, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdIn(List<Integer> values) {
            addCriterion("am_date1_id in", values, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdNotIn(List<Integer> values) {
            addCriterion("am_date1_id not in", values, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdBetween(Integer value1, Integer value2) {
            addCriterion("am_date1_id between", value1, value2, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate1IdNotBetween(Integer value1, Integer value2) {
            addCriterion("am_date1_id not between", value1, value2, "amDate1Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdIsNull() {
            addCriterion("am_date2_id is null");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdIsNotNull() {
            addCriterion("am_date2_id is not null");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdEqualTo(Integer value) {
            addCriterion("am_date2_id =", value, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdNotEqualTo(Integer value) {
            addCriterion("am_date2_id <>", value, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdGreaterThan(Integer value) {
            addCriterion("am_date2_id >", value, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("am_date2_id >=", value, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdLessThan(Integer value) {
            addCriterion("am_date2_id <", value, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdLessThanOrEqualTo(Integer value) {
            addCriterion("am_date2_id <=", value, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdIn(List<Integer> values) {
            addCriterion("am_date2_id in", values, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdNotIn(List<Integer> values) {
            addCriterion("am_date2_id not in", values, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdBetween(Integer value1, Integer value2) {
            addCriterion("am_date2_id between", value1, value2, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmDate2IdNotBetween(Integer value1, Integer value2) {
            addCriterion("am_date2_id not between", value1, value2, "amDate2Id");
            return (Criteria) this;
        }

        public Criteria andAmStateIsNull() {
            addCriterion("am_state is null");
            return (Criteria) this;
        }

        public Criteria andAmStateIsNotNull() {
            addCriterion("am_state is not null");
            return (Criteria) this;
        }

        public Criteria andAmStateEqualTo(Integer value) {
            addCriterion("am_state =", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateNotEqualTo(Integer value) {
            addCriterion("am_state <>", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateGreaterThan(Integer value) {
            addCriterion("am_state >", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("am_state >=", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateLessThan(Integer value) {
            addCriterion("am_state <", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateLessThanOrEqualTo(Integer value) {
            addCriterion("am_state <=", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateIn(List<Integer> values) {
            addCriterion("am_state in", values, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateNotIn(List<Integer> values) {
            addCriterion("am_state not in", values, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateBetween(Integer value1, Integer value2) {
            addCriterion("am_state between", value1, value2, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateNotBetween(Integer value1, Integer value2) {
            addCriterion("am_state not between", value1, value2, "amState");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdIsNull() {
            addCriterion("pm_date1_id is null");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdIsNotNull() {
            addCriterion("pm_date1_id is not null");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdEqualTo(Integer value) {
            addCriterion("pm_date1_id =", value, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdNotEqualTo(Integer value) {
            addCriterion("pm_date1_id <>", value, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdGreaterThan(Integer value) {
            addCriterion("pm_date1_id >", value, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pm_date1_id >=", value, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdLessThan(Integer value) {
            addCriterion("pm_date1_id <", value, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdLessThanOrEqualTo(Integer value) {
            addCriterion("pm_date1_id <=", value, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdIn(List<Integer> values) {
            addCriterion("pm_date1_id in", values, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdNotIn(List<Integer> values) {
            addCriterion("pm_date1_id not in", values, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdBetween(Integer value1, Integer value2) {
            addCriterion("pm_date1_id between", value1, value2, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate1IdNotBetween(Integer value1, Integer value2) {
            addCriterion("pm_date1_id not between", value1, value2, "pmDate1Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdIsNull() {
            addCriterion("pm_date2_id is null");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdIsNotNull() {
            addCriterion("pm_date2_id is not null");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdEqualTo(Integer value) {
            addCriterion("pm_date2_id =", value, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdNotEqualTo(Integer value) {
            addCriterion("pm_date2_id <>", value, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdGreaterThan(Integer value) {
            addCriterion("pm_date2_id >", value, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pm_date2_id >=", value, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdLessThan(Integer value) {
            addCriterion("pm_date2_id <", value, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdLessThanOrEqualTo(Integer value) {
            addCriterion("pm_date2_id <=", value, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdIn(List<Integer> values) {
            addCriterion("pm_date2_id in", values, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdNotIn(List<Integer> values) {
            addCriterion("pm_date2_id not in", values, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdBetween(Integer value1, Integer value2) {
            addCriterion("pm_date2_id between", value1, value2, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmDate2IdNotBetween(Integer value1, Integer value2) {
            addCriterion("pm_date2_id not between", value1, value2, "pmDate2Id");
            return (Criteria) this;
        }

        public Criteria andPmStateIsNull() {
            addCriterion("pm_state is null");
            return (Criteria) this;
        }

        public Criteria andPmStateIsNotNull() {
            addCriterion("pm_state is not null");
            return (Criteria) this;
        }

        public Criteria andPmStateEqualTo(Integer value) {
            addCriterion("pm_state =", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateNotEqualTo(Integer value) {
            addCriterion("pm_state <>", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateGreaterThan(Integer value) {
            addCriterion("pm_state >", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pm_state >=", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateLessThan(Integer value) {
            addCriterion("pm_state <", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateLessThanOrEqualTo(Integer value) {
            addCriterion("pm_state <=", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateIn(List<Integer> values) {
            addCriterion("pm_state in", values, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateNotIn(List<Integer> values) {
            addCriterion("pm_state not in", values, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateBetween(Integer value1, Integer value2) {
            addCriterion("pm_state between", value1, value2, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pm_state not between", value1, value2, "pmState");
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