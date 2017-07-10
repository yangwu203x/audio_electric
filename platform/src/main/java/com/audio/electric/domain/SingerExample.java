package com.audio.electric.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SingerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SingerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSingerNameIsNull() {
            addCriterion("singer_name is null");
            return (Criteria) this;
        }

        public Criteria andSingerNameIsNotNull() {
            addCriterion("singer_name is not null");
            return (Criteria) this;
        }

        public Criteria andSingerNameEqualTo(String value) {
            addCriterion("singer_name =", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameNotEqualTo(String value) {
            addCriterion("singer_name <>", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameGreaterThan(String value) {
            addCriterion("singer_name >", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameGreaterThanOrEqualTo(String value) {
            addCriterion("singer_name >=", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameLessThan(String value) {
            addCriterion("singer_name <", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameLessThanOrEqualTo(String value) {
            addCriterion("singer_name <=", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameLike(String value) {
            addCriterion("singer_name like", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameNotLike(String value) {
            addCriterion("singer_name not like", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameIn(List<String> values) {
            addCriterion("singer_name in", values, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameNotIn(List<String> values) {
            addCriterion("singer_name not in", values, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameBetween(String value1, String value2) {
            addCriterion("singer_name between", value1, value2, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameNotBetween(String value1, String value2) {
            addCriterion("singer_name not between", value1, value2, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerTypeIsNull() {
            addCriterion("singer_type is null");
            return (Criteria) this;
        }

        public Criteria andSingerTypeIsNotNull() {
            addCriterion("singer_type is not null");
            return (Criteria) this;
        }

        public Criteria andSingerTypeEqualTo(String value) {
            addCriterion("singer_type =", value, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeNotEqualTo(String value) {
            addCriterion("singer_type <>", value, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeGreaterThan(String value) {
            addCriterion("singer_type >", value, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("singer_type >=", value, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeLessThan(String value) {
            addCriterion("singer_type <", value, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeLessThanOrEqualTo(String value) {
            addCriterion("singer_type <=", value, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeLike(String value) {
            addCriterion("singer_type like", value, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeNotLike(String value) {
            addCriterion("singer_type not like", value, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeIn(List<String> values) {
            addCriterion("singer_type in", values, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeNotIn(List<String> values) {
            addCriterion("singer_type not in", values, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeBetween(String value1, String value2) {
            addCriterion("singer_type between", value1, value2, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerTypeNotBetween(String value1, String value2) {
            addCriterion("singer_type not between", value1, value2, "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinIsNull() {
            addCriterion("singer_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinIsNotNull() {
            addCriterion("singer_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinEqualTo(String value) {
            addCriterion("singer_pinyin =", value, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinNotEqualTo(String value) {
            addCriterion("singer_pinyin <>", value, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinGreaterThan(String value) {
            addCriterion("singer_pinyin >", value, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("singer_pinyin >=", value, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinLessThan(String value) {
            addCriterion("singer_pinyin <", value, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinLessThanOrEqualTo(String value) {
            addCriterion("singer_pinyin <=", value, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinLike(String value) {
            addCriterion("singer_pinyin like", value, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinNotLike(String value) {
            addCriterion("singer_pinyin not like", value, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinIn(List<String> values) {
            addCriterion("singer_pinyin in", values, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinNotIn(List<String> values) {
            addCriterion("singer_pinyin not in", values, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinBetween(String value1, String value2) {
            addCriterion("singer_pinyin between", value1, value2, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinNotBetween(String value1, String value2) {
            addCriterion("singer_pinyin not between", value1, value2, "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesIsNull() {
            addCriterion("singer_odertimes is null");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesIsNotNull() {
            addCriterion("singer_odertimes is not null");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesEqualTo(Integer value) {
            addCriterion("singer_odertimes =", value, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesNotEqualTo(Integer value) {
            addCriterion("singer_odertimes <>", value, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesGreaterThan(Integer value) {
            addCriterion("singer_odertimes >", value, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("singer_odertimes >=", value, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesLessThan(Integer value) {
            addCriterion("singer_odertimes <", value, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesLessThanOrEqualTo(Integer value) {
            addCriterion("singer_odertimes <=", value, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesIn(List<Integer> values) {
            addCriterion("singer_odertimes in", values, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesNotIn(List<Integer> values) {
            addCriterion("singer_odertimes not in", values, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesBetween(Integer value1, Integer value2) {
            addCriterion("singer_odertimes between", value1, value2, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andSingerOdertimesNotBetween(Integer value1, Integer value2) {
            addCriterion("singer_odertimes not between", value1, value2, "singerOdertimes");
            return (Criteria) this;
        }

        public Criteria andHeaderPathIsNull() {
            addCriterion("header_path is null");
            return (Criteria) this;
        }

        public Criteria andHeaderPathIsNotNull() {
            addCriterion("header_path is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderPathEqualTo(String value) {
            addCriterion("header_path =", value, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathNotEqualTo(String value) {
            addCriterion("header_path <>", value, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathGreaterThan(String value) {
            addCriterion("header_path >", value, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathGreaterThanOrEqualTo(String value) {
            addCriterion("header_path >=", value, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathLessThan(String value) {
            addCriterion("header_path <", value, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathLessThanOrEqualTo(String value) {
            addCriterion("header_path <=", value, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathLike(String value) {
            addCriterion("header_path like", value, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathNotLike(String value) {
            addCriterion("header_path not like", value, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathIn(List<String> values) {
            addCriterion("header_path in", values, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathNotIn(List<String> values) {
            addCriterion("header_path not in", values, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathBetween(String value1, String value2) {
            addCriterion("header_path between", value1, value2, "headerPath");
            return (Criteria) this;
        }

        public Criteria andHeaderPathNotBetween(String value1, String value2) {
            addCriterion("header_path not between", value1, value2, "headerPath");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSongCountIsNull() {
            addCriterion("song_count is null");
            return (Criteria) this;
        }

        public Criteria andSongCountIsNotNull() {
            addCriterion("song_count is not null");
            return (Criteria) this;
        }

        public Criteria andSongCountEqualTo(String value) {
            addCriterion("song_count =", value, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountNotEqualTo(String value) {
            addCriterion("song_count <>", value, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountGreaterThan(String value) {
            addCriterion("song_count >", value, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountGreaterThanOrEqualTo(String value) {
            addCriterion("song_count >=", value, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountLessThan(String value) {
            addCriterion("song_count <", value, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountLessThanOrEqualTo(String value) {
            addCriterion("song_count <=", value, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountLike(String value) {
            addCriterion("song_count like", value, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountNotLike(String value) {
            addCriterion("song_count not like", value, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountIn(List<String> values) {
            addCriterion("song_count in", values, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountNotIn(List<String> values) {
            addCriterion("song_count not in", values, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountBetween(String value1, String value2) {
            addCriterion("song_count between", value1, value2, "songCount");
            return (Criteria) this;
        }

        public Criteria andSongCountNotBetween(String value1, String value2) {
            addCriterion("song_count not between", value1, value2, "songCount");
            return (Criteria) this;
        }

        public Criteria andSingerNationIsNull() {
            addCriterion("singer_nation is null");
            return (Criteria) this;
        }

        public Criteria andSingerNationIsNotNull() {
            addCriterion("singer_nation is not null");
            return (Criteria) this;
        }

        public Criteria andSingerNationEqualTo(String value) {
            addCriterion("singer_nation =", value, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationNotEqualTo(String value) {
            addCriterion("singer_nation <>", value, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationGreaterThan(String value) {
            addCriterion("singer_nation >", value, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationGreaterThanOrEqualTo(String value) {
            addCriterion("singer_nation >=", value, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationLessThan(String value) {
            addCriterion("singer_nation <", value, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationLessThanOrEqualTo(String value) {
            addCriterion("singer_nation <=", value, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationLike(String value) {
            addCriterion("singer_nation like", value, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationNotLike(String value) {
            addCriterion("singer_nation not like", value, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationIn(List<String> values) {
            addCriterion("singer_nation in", values, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationNotIn(List<String> values) {
            addCriterion("singer_nation not in", values, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationBetween(String value1, String value2) {
            addCriterion("singer_nation between", value1, value2, "singerNation");
            return (Criteria) this;
        }

        public Criteria andSingerNationNotBetween(String value1, String value2) {
            addCriterion("singer_nation not between", value1, value2, "singerNation");
            return (Criteria) this;
        }

        public Criteria andPrefixPathIsNull() {
            addCriterion("prefix_path is null");
            return (Criteria) this;
        }

        public Criteria andPrefixPathIsNotNull() {
            addCriterion("prefix_path is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixPathEqualTo(String value) {
            addCriterion("prefix_path =", value, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathNotEqualTo(String value) {
            addCriterion("prefix_path <>", value, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathGreaterThan(String value) {
            addCriterion("prefix_path >", value, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathGreaterThanOrEqualTo(String value) {
            addCriterion("prefix_path >=", value, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathLessThan(String value) {
            addCriterion("prefix_path <", value, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathLessThanOrEqualTo(String value) {
            addCriterion("prefix_path <=", value, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathLike(String value) {
            addCriterion("prefix_path like", value, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathNotLike(String value) {
            addCriterion("prefix_path not like", value, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathIn(List<String> values) {
            addCriterion("prefix_path in", values, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathNotIn(List<String> values) {
            addCriterion("prefix_path not in", values, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathBetween(String value1, String value2) {
            addCriterion("prefix_path between", value1, value2, "prefixPath");
            return (Criteria) this;
        }

        public Criteria andPrefixPathNotBetween(String value1, String value2) {
            addCriterion("prefix_path not between", value1, value2, "prefixPath");
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

        public Criteria andSingerNoIsNull() {
            addCriterion("singer_no is null");
            return (Criteria) this;
        }

        public Criteria andSingerNoIsNotNull() {
            addCriterion("singer_no is not null");
            return (Criteria) this;
        }

        public Criteria andSingerNoEqualTo(String value) {
            addCriterion("singer_no =", value, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoNotEqualTo(String value) {
            addCriterion("singer_no <>", value, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoGreaterThan(String value) {
            addCriterion("singer_no >", value, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoGreaterThanOrEqualTo(String value) {
            addCriterion("singer_no >=", value, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoLessThan(String value) {
            addCriterion("singer_no <", value, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoLessThanOrEqualTo(String value) {
            addCriterion("singer_no <=", value, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoLike(String value) {
            addCriterion("singer_no like", value, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoNotLike(String value) {
            addCriterion("singer_no not like", value, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoIn(List<String> values) {
            addCriterion("singer_no in", values, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoNotIn(List<String> values) {
            addCriterion("singer_no not in", values, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoBetween(String value1, String value2) {
            addCriterion("singer_no between", value1, value2, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerNoNotBetween(String value1, String value2) {
            addCriterion("singer_no not between", value1, value2, "singerNo");
            return (Criteria) this;
        }

        public Criteria andSingerZsIsNull() {
            addCriterion("singer_zs is null");
            return (Criteria) this;
        }

        public Criteria andSingerZsIsNotNull() {
            addCriterion("singer_zs is not null");
            return (Criteria) this;
        }

        public Criteria andSingerZsEqualTo(Integer value) {
            addCriterion("singer_zs =", value, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsNotEqualTo(Integer value) {
            addCriterion("singer_zs <>", value, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsGreaterThan(Integer value) {
            addCriterion("singer_zs >", value, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsGreaterThanOrEqualTo(Integer value) {
            addCriterion("singer_zs >=", value, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsLessThan(Integer value) {
            addCriterion("singer_zs <", value, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsLessThanOrEqualTo(Integer value) {
            addCriterion("singer_zs <=", value, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsIn(List<Integer> values) {
            addCriterion("singer_zs in", values, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsNotIn(List<Integer> values) {
            addCriterion("singer_zs not in", values, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsBetween(Integer value1, Integer value2) {
            addCriterion("singer_zs between", value1, value2, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerZsNotBetween(Integer value1, Integer value2) {
            addCriterion("singer_zs not between", value1, value2, "singerZs");
            return (Criteria) this;
        }

        public Criteria andSingerVersionIsNull() {
            addCriterion("singer_version is null");
            return (Criteria) this;
        }

        public Criteria andSingerVersionIsNotNull() {
            addCriterion("singer_version is not null");
            return (Criteria) this;
        }

        public Criteria andSingerVersionEqualTo(Date value) {
            addCriterionForJDBCDate("singer_version =", value, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionNotEqualTo(Date value) {
            addCriterionForJDBCDate("singer_version <>", value, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionGreaterThan(Date value) {
            addCriterionForJDBCDate("singer_version >", value, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("singer_version >=", value, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionLessThan(Date value) {
            addCriterionForJDBCDate("singer_version <", value, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("singer_version <=", value, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionIn(List<Date> values) {
            addCriterionForJDBCDate("singer_version in", values, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionNotIn(List<Date> values) {
            addCriterionForJDBCDate("singer_version not in", values, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("singer_version between", value1, value2, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerVersionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("singer_version not between", value1, value2, "singerVersion");
            return (Criteria) this;
        }

        public Criteria andSingerNameLikeInsensitive(String value) {
            addCriterion("upper(singer_name) like", value.toUpperCase(), "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerTypeLikeInsensitive(String value) {
            addCriterion("upper(singer_type) like", value.toUpperCase(), "singerType");
            return (Criteria) this;
        }

        public Criteria andSingerPinyinLikeInsensitive(String value) {
            addCriterion("upper(singer_pinyin) like", value.toUpperCase(), "singerPinyin");
            return (Criteria) this;
        }

        public Criteria andHeaderPathLikeInsensitive(String value) {
            addCriterion("upper(header_path) like", value.toUpperCase(), "headerPath");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(status) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andSongCountLikeInsensitive(String value) {
            addCriterion("upper(song_count) like", value.toUpperCase(), "songCount");
            return (Criteria) this;
        }

        public Criteria andSingerNationLikeInsensitive(String value) {
            addCriterion("upper(singer_nation) like", value.toUpperCase(), "singerNation");
            return (Criteria) this;
        }

        public Criteria andPrefixPathLikeInsensitive(String value) {
            addCriterion("upper(prefix_path) like", value.toUpperCase(), "prefixPath");
            return (Criteria) this;
        }

        public Criteria andServerUrlLikeInsensitive(String value) {
            addCriterion("upper(server_url) like", value.toUpperCase(), "serverUrl");
            return (Criteria) this;
        }

        public Criteria andSingerNoLikeInsensitive(String value) {
            addCriterion("upper(singer_no) like", value.toUpperCase(), "singerNo");
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