package com.tyut.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendanceExample() {
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

        public Criteria andAmRecordIsNull() {
            addCriterion("am_record is null");
            return (Criteria) this;
        }

        public Criteria andAmRecordIsNotNull() {
            addCriterion("am_record is not null");
            return (Criteria) this;
        }

        public Criteria andAmRecordEqualTo(Date value) {
            addCriterion("am_record =", value, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordNotEqualTo(Date value) {
            addCriterion("am_record <>", value, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordGreaterThan(Date value) {
            addCriterion("am_record >", value, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordGreaterThanOrEqualTo(Date value) {
            addCriterion("am_record >=", value, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordLessThan(Date value) {
            addCriterion("am_record <", value, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordLessThanOrEqualTo(Date value) {
            addCriterion("am_record <=", value, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordIn(List<Date> values) {
            addCriterion("am_record in", values, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordNotIn(List<Date> values) {
            addCriterion("am_record not in", values, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordBetween(Date value1, Date value2) {
            addCriterion("am_record between", value1, value2, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecordNotBetween(Date value1, Date value2) {
            addCriterion("am_record not between", value1, value2, "amRecord");
            return (Criteria) this;
        }

        public Criteria andAmRecord2IsNull() {
            addCriterion("am_record2 is null");
            return (Criteria) this;
        }

        public Criteria andAmRecord2IsNotNull() {
            addCriterion("am_record2 is not null");
            return (Criteria) this;
        }

        public Criteria andAmRecord2EqualTo(Date value) {
            addCriterion("am_record2 =", value, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2NotEqualTo(Date value) {
            addCriterion("am_record2 <>", value, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2GreaterThan(Date value) {
            addCriterion("am_record2 >", value, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2GreaterThanOrEqualTo(Date value) {
            addCriterion("am_record2 >=", value, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2LessThan(Date value) {
            addCriterion("am_record2 <", value, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2LessThanOrEqualTo(Date value) {
            addCriterion("am_record2 <=", value, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2In(List<Date> values) {
            addCriterion("am_record2 in", values, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2NotIn(List<Date> values) {
            addCriterion("am_record2 not in", values, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2Between(Date value1, Date value2) {
            addCriterion("am_record2 between", value1, value2, "amRecord2");
            return (Criteria) this;
        }

        public Criteria andAmRecord2NotBetween(Date value1, Date value2) {
            addCriterion("am_record2 not between", value1, value2, "amRecord2");
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

        public Criteria andAmStateEqualTo(String value) {
            addCriterion("am_state =", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateNotEqualTo(String value) {
            addCriterion("am_state <>", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateGreaterThan(String value) {
            addCriterion("am_state >", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateGreaterThanOrEqualTo(String value) {
            addCriterion("am_state >=", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateLessThan(String value) {
            addCriterion("am_state <", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateLessThanOrEqualTo(String value) {
            addCriterion("am_state <=", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateLike(String value) {
            addCriterion("am_state like", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateNotLike(String value) {
            addCriterion("am_state not like", value, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateIn(List<String> values) {
            addCriterion("am_state in", values, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateNotIn(List<String> values) {
            addCriterion("am_state not in", values, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateBetween(String value1, String value2) {
            addCriterion("am_state between", value1, value2, "amState");
            return (Criteria) this;
        }

        public Criteria andAmStateNotBetween(String value1, String value2) {
            addCriterion("am_state not between", value1, value2, "amState");
            return (Criteria) this;
        }

        public Criteria andPmRecordIsNull() {
            addCriterion("pm_record is null");
            return (Criteria) this;
        }

        public Criteria andPmRecordIsNotNull() {
            addCriterion("pm_record is not null");
            return (Criteria) this;
        }

        public Criteria andPmRecordEqualTo(Date value) {
            addCriterion("pm_record =", value, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordNotEqualTo(Date value) {
            addCriterion("pm_record <>", value, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordGreaterThan(Date value) {
            addCriterion("pm_record >", value, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordGreaterThanOrEqualTo(Date value) {
            addCriterion("pm_record >=", value, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordLessThan(Date value) {
            addCriterion("pm_record <", value, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordLessThanOrEqualTo(Date value) {
            addCriterion("pm_record <=", value, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordIn(List<Date> values) {
            addCriterion("pm_record in", values, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordNotIn(List<Date> values) {
            addCriterion("pm_record not in", values, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordBetween(Date value1, Date value2) {
            addCriterion("pm_record between", value1, value2, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecordNotBetween(Date value1, Date value2) {
            addCriterion("pm_record not between", value1, value2, "pmRecord");
            return (Criteria) this;
        }

        public Criteria andPmRecord2IsNull() {
            addCriterion("pm_record2 is null");
            return (Criteria) this;
        }

        public Criteria andPmRecord2IsNotNull() {
            addCriterion("pm_record2 is not null");
            return (Criteria) this;
        }

        public Criteria andPmRecord2EqualTo(Date value) {
            addCriterion("pm_record2 =", value, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2NotEqualTo(Date value) {
            addCriterion("pm_record2 <>", value, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2GreaterThan(Date value) {
            addCriterion("pm_record2 >", value, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2GreaterThanOrEqualTo(Date value) {
            addCriterion("pm_record2 >=", value, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2LessThan(Date value) {
            addCriterion("pm_record2 <", value, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2LessThanOrEqualTo(Date value) {
            addCriterion("pm_record2 <=", value, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2In(List<Date> values) {
            addCriterion("pm_record2 in", values, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2NotIn(List<Date> values) {
            addCriterion("pm_record2 not in", values, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2Between(Date value1, Date value2) {
            addCriterion("pm_record2 between", value1, value2, "pmRecord2");
            return (Criteria) this;
        }

        public Criteria andPmRecord2NotBetween(Date value1, Date value2) {
            addCriterion("pm_record2 not between", value1, value2, "pmRecord2");
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

        public Criteria andPmStateEqualTo(String value) {
            addCriterion("pm_state =", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateNotEqualTo(String value) {
            addCriterion("pm_state <>", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateGreaterThan(String value) {
            addCriterion("pm_state >", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateGreaterThanOrEqualTo(String value) {
            addCriterion("pm_state >=", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateLessThan(String value) {
            addCriterion("pm_state <", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateLessThanOrEqualTo(String value) {
            addCriterion("pm_state <=", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateLike(String value) {
            addCriterion("pm_state like", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateNotLike(String value) {
            addCriterion("pm_state not like", value, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateIn(List<String> values) {
            addCriterion("pm_state in", values, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateNotIn(List<String> values) {
            addCriterion("pm_state not in", values, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateBetween(String value1, String value2) {
            addCriterion("pm_state between", value1, value2, "pmState");
            return (Criteria) this;
        }

        public Criteria andPmStateNotBetween(String value1, String value2) {
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