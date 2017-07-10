package com.audio.electric.domain;

import java.util.ArrayList;
import java.util.List;

public class ApkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApkExample() {
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

        public Criteria andApkNameIsNull() {
            addCriterion("apk_name is null");
            return (Criteria) this;
        }

        public Criteria andApkNameIsNotNull() {
            addCriterion("apk_name is not null");
            return (Criteria) this;
        }

        public Criteria andApkNameEqualTo(String value) {
            addCriterion("apk_name =", value, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameNotEqualTo(String value) {
            addCriterion("apk_name <>", value, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameGreaterThan(String value) {
            addCriterion("apk_name >", value, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameGreaterThanOrEqualTo(String value) {
            addCriterion("apk_name >=", value, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameLessThan(String value) {
            addCriterion("apk_name <", value, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameLessThanOrEqualTo(String value) {
            addCriterion("apk_name <=", value, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameLike(String value) {
            addCriterion("apk_name like", value, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameNotLike(String value) {
            addCriterion("apk_name not like", value, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameIn(List<String> values) {
            addCriterion("apk_name in", values, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameNotIn(List<String> values) {
            addCriterion("apk_name not in", values, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameBetween(String value1, String value2) {
            addCriterion("apk_name between", value1, value2, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkNameNotBetween(String value1, String value2) {
            addCriterion("apk_name not between", value1, value2, "apkName");
            return (Criteria) this;
        }

        public Criteria andApkVersionIsNull() {
            addCriterion("apk_version is null");
            return (Criteria) this;
        }

        public Criteria andApkVersionIsNotNull() {
            addCriterion("apk_version is not null");
            return (Criteria) this;
        }

        public Criteria andApkVersionEqualTo(String value) {
            addCriterion("apk_version =", value, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionNotEqualTo(String value) {
            addCriterion("apk_version <>", value, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionGreaterThan(String value) {
            addCriterion("apk_version >", value, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionGreaterThanOrEqualTo(String value) {
            addCriterion("apk_version >=", value, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionLessThan(String value) {
            addCriterion("apk_version <", value, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionLessThanOrEqualTo(String value) {
            addCriterion("apk_version <=", value, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionLike(String value) {
            addCriterion("apk_version like", value, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionNotLike(String value) {
            addCriterion("apk_version not like", value, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionIn(List<String> values) {
            addCriterion("apk_version in", values, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionNotIn(List<String> values) {
            addCriterion("apk_version not in", values, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionBetween(String value1, String value2) {
            addCriterion("apk_version between", value1, value2, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkVersionNotBetween(String value1, String value2) {
            addCriterion("apk_version not between", value1, value2, "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkPathIsNull() {
            addCriterion("apk_path is null");
            return (Criteria) this;
        }

        public Criteria andApkPathIsNotNull() {
            addCriterion("apk_path is not null");
            return (Criteria) this;
        }

        public Criteria andApkPathEqualTo(String value) {
            addCriterion("apk_path =", value, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathNotEqualTo(String value) {
            addCriterion("apk_path <>", value, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathGreaterThan(String value) {
            addCriterion("apk_path >", value, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathGreaterThanOrEqualTo(String value) {
            addCriterion("apk_path >=", value, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathLessThan(String value) {
            addCriterion("apk_path <", value, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathLessThanOrEqualTo(String value) {
            addCriterion("apk_path <=", value, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathLike(String value) {
            addCriterion("apk_path like", value, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathNotLike(String value) {
            addCriterion("apk_path not like", value, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathIn(List<String> values) {
            addCriterion("apk_path in", values, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathNotIn(List<String> values) {
            addCriterion("apk_path not in", values, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathBetween(String value1, String value2) {
            addCriterion("apk_path between", value1, value2, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkPathNotBetween(String value1, String value2) {
            addCriterion("apk_path not between", value1, value2, "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathIsNull() {
            addCriterion("apk_down_path is null");
            return (Criteria) this;
        }

        public Criteria andApkDownPathIsNotNull() {
            addCriterion("apk_down_path is not null");
            return (Criteria) this;
        }

        public Criteria andApkDownPathEqualTo(String value) {
            addCriterion("apk_down_path =", value, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathNotEqualTo(String value) {
            addCriterion("apk_down_path <>", value, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathGreaterThan(String value) {
            addCriterion("apk_down_path >", value, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathGreaterThanOrEqualTo(String value) {
            addCriterion("apk_down_path >=", value, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathLessThan(String value) {
            addCriterion("apk_down_path <", value, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathLessThanOrEqualTo(String value) {
            addCriterion("apk_down_path <=", value, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathLike(String value) {
            addCriterion("apk_down_path like", value, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathNotLike(String value) {
            addCriterion("apk_down_path not like", value, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathIn(List<String> values) {
            addCriterion("apk_down_path in", values, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathNotIn(List<String> values) {
            addCriterion("apk_down_path not in", values, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathBetween(String value1, String value2) {
            addCriterion("apk_down_path between", value1, value2, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathNotBetween(String value1, String value2) {
            addCriterion("apk_down_path not between", value1, value2, "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andServerUrlIsNull() {
            addCriterion("server_url is null");
            return (Criteria) this;
        }

        public Criteria andServerUrlIsNotNull() {
            addCriterion("server_url is not null");
            return (Criteria) this;
        }

        public Criteria andServerUrlEqualTo(String value) {
            addCriterion("server_url =", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlNotEqualTo(String value) {
            addCriterion("server_url <>", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlGreaterThan(String value) {
            addCriterion("server_url >", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("server_url >=", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlLessThan(String value) {
            addCriterion("server_url <", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlLessThanOrEqualTo(String value) {
            addCriterion("server_url <=", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlLike(String value) {
            addCriterion("server_url like", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlNotLike(String value) {
            addCriterion("server_url not like", value, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlIn(List<String> values) {
            addCriterion("server_url in", values, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlNotIn(List<String> values) {
            addCriterion("server_url not in", values, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlBetween(String value1, String value2) {
            addCriterion("server_url between", value1, value2, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andServerUrlNotBetween(String value1, String value2) {
            addCriterion("server_url not between", value1, value2, "serverUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andApkNameLikeInsensitive(String value) {
            addCriterion("upper(apk_name) like", value.toUpperCase(), "apkName");
            return (Criteria) this;
        }

        public Criteria andApkVersionLikeInsensitive(String value) {
            addCriterion("upper(apk_version) like", value.toUpperCase(), "apkVersion");
            return (Criteria) this;
        }

        public Criteria andApkPathLikeInsensitive(String value) {
            addCriterion("upper(apk_path) like", value.toUpperCase(), "apkPath");
            return (Criteria) this;
        }

        public Criteria andApkDownPathLikeInsensitive(String value) {
            addCriterion("upper(apk_down_path) like", value.toUpperCase(), "apkDownPath");
            return (Criteria) this;
        }

        public Criteria andServerUrlLikeInsensitive(String value) {
            addCriterion("upper(server_url) like", value.toUpperCase(), "serverUrl");
            return (Criteria) this;
        }

        public Criteria andTypeLikeInsensitive(String value) {
            addCriterion("upper(type) like", value.toUpperCase(), "type");
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