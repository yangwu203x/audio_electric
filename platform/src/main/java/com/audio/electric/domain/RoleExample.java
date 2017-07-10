package com.audio.electric.domain;

import java.util.ArrayList;
import java.util.List;

public class RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleExample() {
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

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("create_date like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("create_date not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andRoleAddIsNull() {
            addCriterion("role_add is null");
            return (Criteria) this;
        }

        public Criteria andRoleAddIsNotNull() {
            addCriterion("role_add is not null");
            return (Criteria) this;
        }

        public Criteria andRoleAddEqualTo(Integer value) {
            addCriterion("role_add =", value, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddNotEqualTo(Integer value) {
            addCriterion("role_add <>", value, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddGreaterThan(Integer value) {
            addCriterion("role_add >", value, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_add >=", value, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddLessThan(Integer value) {
            addCriterion("role_add <", value, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddLessThanOrEqualTo(Integer value) {
            addCriterion("role_add <=", value, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddIn(List<Integer> values) {
            addCriterion("role_add in", values, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddNotIn(List<Integer> values) {
            addCriterion("role_add not in", values, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddBetween(Integer value1, Integer value2) {
            addCriterion("role_add between", value1, value2, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleAddNotBetween(Integer value1, Integer value2) {
            addCriterion("role_add not between", value1, value2, "roleAdd");
            return (Criteria) this;
        }

        public Criteria andRoleDelIsNull() {
            addCriterion("role_del is null");
            return (Criteria) this;
        }

        public Criteria andRoleDelIsNotNull() {
            addCriterion("role_del is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDelEqualTo(Integer value) {
            addCriterion("role_del =", value, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelNotEqualTo(Integer value) {
            addCriterion("role_del <>", value, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelGreaterThan(Integer value) {
            addCriterion("role_del >", value, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_del >=", value, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelLessThan(Integer value) {
            addCriterion("role_del <", value, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelLessThanOrEqualTo(Integer value) {
            addCriterion("role_del <=", value, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelIn(List<Integer> values) {
            addCriterion("role_del in", values, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelNotIn(List<Integer> values) {
            addCriterion("role_del not in", values, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelBetween(Integer value1, Integer value2) {
            addCriterion("role_del between", value1, value2, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleDelNotBetween(Integer value1, Integer value2) {
            addCriterion("role_del not between", value1, value2, "roleDel");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateIsNull() {
            addCriterion("role_update is null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateIsNotNull() {
            addCriterion("role_update is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateEqualTo(Integer value) {
            addCriterion("role_update =", value, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateNotEqualTo(Integer value) {
            addCriterion("role_update <>", value, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateGreaterThan(Integer value) {
            addCriterion("role_update >", value, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_update >=", value, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateLessThan(Integer value) {
            addCriterion("role_update <", value, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("role_update <=", value, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateIn(List<Integer> values) {
            addCriterion("role_update in", values, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateNotIn(List<Integer> values) {
            addCriterion("role_update not in", values, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateBetween(Integer value1, Integer value2) {
            addCriterion("role_update between", value1, value2, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("role_update not between", value1, value2, "roleUpdate");
            return (Criteria) this;
        }

        public Criteria andRoleCheckIsNull() {
            addCriterion("role_check is null");
            return (Criteria) this;
        }

        public Criteria andRoleCheckIsNotNull() {
            addCriterion("role_check is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCheckEqualTo(Integer value) {
            addCriterion("role_check =", value, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckNotEqualTo(Integer value) {
            addCriterion("role_check <>", value, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckGreaterThan(Integer value) {
            addCriterion("role_check >", value, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_check >=", value, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckLessThan(Integer value) {
            addCriterion("role_check <", value, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckLessThanOrEqualTo(Integer value) {
            addCriterion("role_check <=", value, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckIn(List<Integer> values) {
            addCriterion("role_check in", values, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckNotIn(List<Integer> values) {
            addCriterion("role_check not in", values, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckBetween(Integer value1, Integer value2) {
            addCriterion("role_check between", value1, value2, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("role_check not between", value1, value2, "roleCheck");
            return (Criteria) this;
        }

        public Criteria andRoleNameLikeInsensitive(String value) {
            addCriterion("upper(role_name) like", value.toUpperCase(), "roleName");
            return (Criteria) this;
        }

        public Criteria andCreateDateLikeInsensitive(String value) {
            addCriterion("upper(create_date) like", value.toUpperCase(), "createDate");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
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