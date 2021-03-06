package com.boz.bean;

import java.util.ArrayList;
import java.util.List;

public class CixingExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public CixingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
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

        public Criteria andZiIsNull() {
            addCriterion("zi is null");
            return (Criteria) this;
        }

        public Criteria andZiIsNotNull() {
            addCriterion("zi is not null");
            return (Criteria) this;
        }

        public Criteria andZiEqualTo(String value) {
            addCriterion("zi =", value, "zi");
            return (Criteria) this;
        }

        public Criteria andZiNotEqualTo(String value) {
            addCriterion("zi <>", value, "zi");
            return (Criteria) this;
        }

        public Criteria andZiGreaterThan(String value) {
            addCriterion("zi >", value, "zi");
            return (Criteria) this;
        }

        public Criteria andZiGreaterThanOrEqualTo(String value) {
            addCriterion("zi >=", value, "zi");
            return (Criteria) this;
        }

        public Criteria andZiLessThan(String value) {
            addCriterion("zi <", value, "zi");
            return (Criteria) this;
        }

        public Criteria andZiLessThanOrEqualTo(String value) {
            addCriterion("zi <=", value, "zi");
            return (Criteria) this;
        }

        public Criteria andZiLike(String value) {
            addCriterion("zi like", value, "zi");
            return (Criteria) this;
        }

        public Criteria andZiNotLike(String value) {
            addCriterion("zi not like", value, "zi");
            return (Criteria) this;
        }

        public Criteria andZiIn(List<String> values) {
            addCriterion("zi in", values, "zi");
            return (Criteria) this;
        }

        public Criteria andZiNotIn(List<String> values) {
            addCriterion("zi not in", values, "zi");
            return (Criteria) this;
        }

        public Criteria andZiBetween(String value1, String value2) {
            addCriterion("zi between", value1, value2, "zi");
            return (Criteria) this;
        }

        public Criteria andZiNotBetween(String value1, String value2) {
            addCriterion("zi not between", value1, value2, "zi");
            return (Criteria) this;
        }

        public Criteria andZiPinyinIsNull() {
            addCriterion("zi_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andZiPinyinIsNotNull() {
            addCriterion("zi_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andZiPinyinEqualTo(String value) {
            addCriterion("zi_pinyin =", value, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinNotEqualTo(String value) {
            addCriterion("zi_pinyin <>", value, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinGreaterThan(String value) {
            addCriterion("zi_pinyin >", value, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("zi_pinyin >=", value, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinLessThan(String value) {
            addCriterion("zi_pinyin <", value, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinLessThanOrEqualTo(String value) {
            addCriterion("zi_pinyin <=", value, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinLike(String value) {
            addCriterion("zi_pinyin like", value, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinNotLike(String value) {
            addCriterion("zi_pinyin not like", value, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinIn(List<String> values) {
            addCriterion("zi_pinyin in", values, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinNotIn(List<String> values) {
            addCriterion("zi_pinyin not in", values, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinBetween(String value1, String value2) {
            addCriterion("zi_pinyin between", value1, value2, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPinyinNotBetween(String value1, String value2) {
            addCriterion("zi_pinyin not between", value1, value2, "ziPinyin");
            return (Criteria) this;
        }

        public Criteria andZiPyIsNull() {
            addCriterion("zi_py is null");
            return (Criteria) this;
        }

        public Criteria andZiPyIsNotNull() {
            addCriterion("zi_py is not null");
            return (Criteria) this;
        }

        public Criteria andZiPyEqualTo(String value) {
            addCriterion("zi_py =", value, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyNotEqualTo(String value) {
            addCriterion("zi_py <>", value, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyGreaterThan(String value) {
            addCriterion("zi_py >", value, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyGreaterThanOrEqualTo(String value) {
            addCriterion("zi_py >=", value, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyLessThan(String value) {
            addCriterion("zi_py <", value, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyLessThanOrEqualTo(String value) {
            addCriterion("zi_py <=", value, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyLike(String value) {
            addCriterion("zi_py like", value, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyNotLike(String value) {
            addCriterion("zi_py not like", value, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyIn(List<String> values) {
            addCriterion("zi_py in", values, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyNotIn(List<String> values) {
            addCriterion("zi_py not in", values, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyBetween(String value1, String value2) {
            addCriterion("zi_py between", value1, value2, "ziPy");
            return (Criteria) this;
        }

        public Criteria andZiPyNotBetween(String value1, String value2) {
            addCriterion("zi_py not between", value1, value2, "ziPy");
            return (Criteria) this;
        }

        public Criteria andPyIsNull() {
            addCriterion("py is null");
            return (Criteria) this;
        }

        public Criteria andPyIsNotNull() {
            addCriterion("py is not null");
            return (Criteria) this;
        }

        public Criteria andPyEqualTo(String value) {
            addCriterion("py =", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyNotEqualTo(String value) {
            addCriterion("py <>", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyGreaterThan(String value) {
            addCriterion("py >", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyGreaterThanOrEqualTo(String value) {
            addCriterion("py >=", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyLessThan(String value) {
            addCriterion("py <", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyLessThanOrEqualTo(String value) {
            addCriterion("py <=", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyLike(String value) {
            addCriterion("py like", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyNotLike(String value) {
            addCriterion("py not like", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyIn(List<String> values) {
            addCriterion("py in", values, "py");
            return (Criteria) this;
        }

        public Criteria andPyNotIn(List<String> values) {
            addCriterion("py not in", values, "py");
            return (Criteria) this;
        }

        public Criteria andPyBetween(String value1, String value2) {
            addCriterion("py between", value1, value2, "py");
            return (Criteria) this;
        }

        public Criteria andPyNotBetween(String value1, String value2) {
            addCriterion("py not between", value1, value2, "py");
            return (Criteria) this;
        }

        public Criteria andCizuIsNull() {
            addCriterion("cizu is null");
            return (Criteria) this;
        }

        public Criteria andCizuIsNotNull() {
            addCriterion("cizu is not null");
            return (Criteria) this;
        }

        public Criteria andCizuEqualTo(String value) {
            addCriterion("cizu =", value, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuNotEqualTo(String value) {
            addCriterion("cizu <>", value, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuGreaterThan(String value) {
            addCriterion("cizu >", value, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuGreaterThanOrEqualTo(String value) {
            addCriterion("cizu >=", value, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuLessThan(String value) {
            addCriterion("cizu <", value, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuLessThanOrEqualTo(String value) {
            addCriterion("cizu <=", value, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuLike(String value) {
            addCriterion("cizu like", value, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuNotLike(String value) {
            addCriterion("cizu not like", value, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuIn(List<String> values) {
            addCriterion("cizu in", values, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuNotIn(List<String> values) {
            addCriterion("cizu not in", values, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuBetween(String value1, String value2) {
            addCriterion("cizu between", value1, value2, "cizu");
            return (Criteria) this;
        }

        public Criteria andCizuNotBetween(String value1, String value2) {
            addCriterion("cizu not between", value1, value2, "cizu");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated do_not_delete_during_merge Fri Mar 08 13:29:48 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yw_lib_cixing
     *
     * @mbg.generated Fri Mar 08 13:29:48 CST 2019
     */
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