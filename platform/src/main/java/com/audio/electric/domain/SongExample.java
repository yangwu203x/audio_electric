package com.audio.electric.domain;

import java.util.ArrayList;
import java.util.List;

public class SongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SongExample() {
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

        public Criteria andMrsIdIsNull() {
            addCriterion("mrs_id is null");
            return (Criteria) this;
        }

        public Criteria andMrsIdIsNotNull() {
            addCriterion("mrs_id is not null");
            return (Criteria) this;
        }

        public Criteria andMrsIdEqualTo(String value) {
            addCriterion("mrs_id =", value, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdNotEqualTo(String value) {
            addCriterion("mrs_id <>", value, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdGreaterThan(String value) {
            addCriterion("mrs_id >", value, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdGreaterThanOrEqualTo(String value) {
            addCriterion("mrs_id >=", value, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdLessThan(String value) {
            addCriterion("mrs_id <", value, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdLessThanOrEqualTo(String value) {
            addCriterion("mrs_id <=", value, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdLike(String value) {
            addCriterion("mrs_id like", value, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdNotLike(String value) {
            addCriterion("mrs_id not like", value, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdIn(List<String> values) {
            addCriterion("mrs_id in", values, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdNotIn(List<String> values) {
            addCriterion("mrs_id not in", values, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdBetween(String value1, String value2) {
            addCriterion("mrs_id between", value1, value2, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMrsIdNotBetween(String value1, String value2) {
            addCriterion("mrs_id not between", value1, value2, "mrsId");
            return (Criteria) this;
        }

        public Criteria andMidiIdIsNull() {
            addCriterion("midi_id is null");
            return (Criteria) this;
        }

        public Criteria andMidiIdIsNotNull() {
            addCriterion("midi_id is not null");
            return (Criteria) this;
        }

        public Criteria andMidiIdEqualTo(String value) {
            addCriterion("midi_id =", value, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdNotEqualTo(String value) {
            addCriterion("midi_id <>", value, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdGreaterThan(String value) {
            addCriterion("midi_id >", value, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdGreaterThanOrEqualTo(String value) {
            addCriterion("midi_id >=", value, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdLessThan(String value) {
            addCriterion("midi_id <", value, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdLessThanOrEqualTo(String value) {
            addCriterion("midi_id <=", value, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdLike(String value) {
            addCriterion("midi_id like", value, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdNotLike(String value) {
            addCriterion("midi_id not like", value, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdIn(List<String> values) {
            addCriterion("midi_id in", values, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdNotIn(List<String> values) {
            addCriterion("midi_id not in", values, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdBetween(String value1, String value2) {
            addCriterion("midi_id between", value1, value2, "midiId");
            return (Criteria) this;
        }

        public Criteria andMidiIdNotBetween(String value1, String value2) {
            addCriterion("midi_id not between", value1, value2, "midiId");
            return (Criteria) this;
        }

        public Criteria andVodIdIsNull() {
            addCriterion("vod_id is null");
            return (Criteria) this;
        }

        public Criteria andVodIdIsNotNull() {
            addCriterion("vod_id is not null");
            return (Criteria) this;
        }

        public Criteria andVodIdEqualTo(String value) {
            addCriterion("vod_id =", value, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdNotEqualTo(String value) {
            addCriterion("vod_id <>", value, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdGreaterThan(String value) {
            addCriterion("vod_id >", value, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdGreaterThanOrEqualTo(String value) {
            addCriterion("vod_id >=", value, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdLessThan(String value) {
            addCriterion("vod_id <", value, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdLessThanOrEqualTo(String value) {
            addCriterion("vod_id <=", value, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdLike(String value) {
            addCriterion("vod_id like", value, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdNotLike(String value) {
            addCriterion("vod_id not like", value, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdIn(List<String> values) {
            addCriterion("vod_id in", values, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdNotIn(List<String> values) {
            addCriterion("vod_id not in", values, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdBetween(String value1, String value2) {
            addCriterion("vod_id between", value1, value2, "vodId");
            return (Criteria) this;
        }

        public Criteria andVodIdNotBetween(String value1, String value2) {
            addCriterion("vod_id not between", value1, value2, "vodId");
            return (Criteria) this;
        }

        public Criteria andSongNameIsNull() {
            addCriterion("song_name is null");
            return (Criteria) this;
        }

        public Criteria andSongNameIsNotNull() {
            addCriterion("song_name is not null");
            return (Criteria) this;
        }

        public Criteria andSongNameEqualTo(String value) {
            addCriterion("song_name =", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotEqualTo(String value) {
            addCriterion("song_name <>", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameGreaterThan(String value) {
            addCriterion("song_name >", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameGreaterThanOrEqualTo(String value) {
            addCriterion("song_name >=", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLessThan(String value) {
            addCriterion("song_name <", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLessThanOrEqualTo(String value) {
            addCriterion("song_name <=", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLike(String value) {
            addCriterion("song_name like", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotLike(String value) {
            addCriterion("song_name not like", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameIn(List<String> values) {
            addCriterion("song_name in", values, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotIn(List<String> values) {
            addCriterion("song_name not in", values, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameBetween(String value1, String value2) {
            addCriterion("song_name between", value1, value2, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotBetween(String value1, String value2) {
            addCriterion("song_name not between", value1, value2, "songName");
            return (Criteria) this;
        }

        public Criteria andFileFormatIsNull() {
            addCriterion("file_format is null");
            return (Criteria) this;
        }

        public Criteria andFileFormatIsNotNull() {
            addCriterion("file_format is not null");
            return (Criteria) this;
        }

        public Criteria andFileFormatEqualTo(String value) {
            addCriterion("file_format =", value, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatNotEqualTo(String value) {
            addCriterion("file_format <>", value, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatGreaterThan(String value) {
            addCriterion("file_format >", value, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatGreaterThanOrEqualTo(String value) {
            addCriterion("file_format >=", value, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatLessThan(String value) {
            addCriterion("file_format <", value, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatLessThanOrEqualTo(String value) {
            addCriterion("file_format <=", value, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatLike(String value) {
            addCriterion("file_format like", value, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatNotLike(String value) {
            addCriterion("file_format not like", value, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatIn(List<String> values) {
            addCriterion("file_format in", values, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatNotIn(List<String> values) {
            addCriterion("file_format not in", values, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatBetween(String value1, String value2) {
            addCriterion("file_format between", value1, value2, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andFileFormatNotBetween(String value1, String value2) {
            addCriterion("file_format not between", value1, value2, "fileFormat");
            return (Criteria) this;
        }

        public Criteria andSpellIsNull() {
            addCriterion("spell is null");
            return (Criteria) this;
        }

        public Criteria andSpellIsNotNull() {
            addCriterion("spell is not null");
            return (Criteria) this;
        }

        public Criteria andSpellEqualTo(String value) {
            addCriterion("spell =", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellNotEqualTo(String value) {
            addCriterion("spell <>", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellGreaterThan(String value) {
            addCriterion("spell >", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellGreaterThanOrEqualTo(String value) {
            addCriterion("spell >=", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellLessThan(String value) {
            addCriterion("spell <", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellLessThanOrEqualTo(String value) {
            addCriterion("spell <=", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellLike(String value) {
            addCriterion("spell like", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellNotLike(String value) {
            addCriterion("spell not like", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellIn(List<String> values) {
            addCriterion("spell in", values, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellNotIn(List<String> values) {
            addCriterion("spell not in", values, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellBetween(String value1, String value2) {
            addCriterion("spell between", value1, value2, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellNotBetween(String value1, String value2) {
            addCriterion("spell not between", value1, value2, "spell");
            return (Criteria) this;
        }

        public Criteria andLangIdIsNull() {
            addCriterion("lang_id is null");
            return (Criteria) this;
        }

        public Criteria andLangIdIsNotNull() {
            addCriterion("lang_id is not null");
            return (Criteria) this;
        }

        public Criteria andLangIdEqualTo(String value) {
            addCriterion("lang_id =", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdNotEqualTo(String value) {
            addCriterion("lang_id <>", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdGreaterThan(String value) {
            addCriterion("lang_id >", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdGreaterThanOrEqualTo(String value) {
            addCriterion("lang_id >=", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdLessThan(String value) {
            addCriterion("lang_id <", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdLessThanOrEqualTo(String value) {
            addCriterion("lang_id <=", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdLike(String value) {
            addCriterion("lang_id like", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdNotLike(String value) {
            addCriterion("lang_id not like", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdIn(List<String> values) {
            addCriterion("lang_id in", values, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdNotIn(List<String> values) {
            addCriterion("lang_id not in", values, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdBetween(String value1, String value2) {
            addCriterion("lang_id between", value1, value2, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdNotBetween(String value1, String value2) {
            addCriterion("lang_id not between", value1, value2, "langId");
            return (Criteria) this;
        }

        public Criteria andNewSongIsNull() {
            addCriterion("new_song is null");
            return (Criteria) this;
        }

        public Criteria andNewSongIsNotNull() {
            addCriterion("new_song is not null");
            return (Criteria) this;
        }

        public Criteria andNewSongEqualTo(String value) {
            addCriterion("new_song =", value, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongNotEqualTo(String value) {
            addCriterion("new_song <>", value, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongGreaterThan(String value) {
            addCriterion("new_song >", value, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongGreaterThanOrEqualTo(String value) {
            addCriterion("new_song >=", value, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongLessThan(String value) {
            addCriterion("new_song <", value, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongLessThanOrEqualTo(String value) {
            addCriterion("new_song <=", value, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongLike(String value) {
            addCriterion("new_song like", value, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongNotLike(String value) {
            addCriterion("new_song not like", value, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongIn(List<String> values) {
            addCriterion("new_song in", values, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongNotIn(List<String> values) {
            addCriterion("new_song not in", values, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongBetween(String value1, String value2) {
            addCriterion("new_song between", value1, value2, "newSong");
            return (Criteria) this;
        }

        public Criteria andNewSongNotBetween(String value1, String value2) {
            addCriterion("new_song not between", value1, value2, "newSong");
            return (Criteria) this;
        }

        public Criteria andHotSongIsNull() {
            addCriterion("hot_song is null");
            return (Criteria) this;
        }

        public Criteria andHotSongIsNotNull() {
            addCriterion("hot_song is not null");
            return (Criteria) this;
        }

        public Criteria andHotSongEqualTo(String value) {
            addCriterion("hot_song =", value, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongNotEqualTo(String value) {
            addCriterion("hot_song <>", value, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongGreaterThan(String value) {
            addCriterion("hot_song >", value, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongGreaterThanOrEqualTo(String value) {
            addCriterion("hot_song >=", value, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongLessThan(String value) {
            addCriterion("hot_song <", value, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongLessThanOrEqualTo(String value) {
            addCriterion("hot_song <=", value, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongLike(String value) {
            addCriterion("hot_song like", value, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongNotLike(String value) {
            addCriterion("hot_song not like", value, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongIn(List<String> values) {
            addCriterion("hot_song in", values, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongNotIn(List<String> values) {
            addCriterion("hot_song not in", values, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongBetween(String value1, String value2) {
            addCriterion("hot_song between", value1, value2, "hotSong");
            return (Criteria) this;
        }

        public Criteria andHotSongNotBetween(String value1, String value2) {
            addCriterion("hot_song not between", value1, value2, "hotSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongIsNull() {
            addCriterion("classic_song is null");
            return (Criteria) this;
        }

        public Criteria andClassicSongIsNotNull() {
            addCriterion("classic_song is not null");
            return (Criteria) this;
        }

        public Criteria andClassicSongEqualTo(String value) {
            addCriterion("classic_song =", value, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongNotEqualTo(String value) {
            addCriterion("classic_song <>", value, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongGreaterThan(String value) {
            addCriterion("classic_song >", value, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongGreaterThanOrEqualTo(String value) {
            addCriterion("classic_song >=", value, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongLessThan(String value) {
            addCriterion("classic_song <", value, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongLessThanOrEqualTo(String value) {
            addCriterion("classic_song <=", value, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongLike(String value) {
            addCriterion("classic_song like", value, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongNotLike(String value) {
            addCriterion("classic_song not like", value, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongIn(List<String> values) {
            addCriterion("classic_song in", values, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongNotIn(List<String> values) {
            addCriterion("classic_song not in", values, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongBetween(String value1, String value2) {
            addCriterion("classic_song between", value1, value2, "classicSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongNotBetween(String value1, String value2) {
            addCriterion("classic_song not between", value1, value2, "classicSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongIsNull() {
            addCriterion("theme_song is null");
            return (Criteria) this;
        }

        public Criteria andThemeSongIsNotNull() {
            addCriterion("theme_song is not null");
            return (Criteria) this;
        }

        public Criteria andThemeSongEqualTo(String value) {
            addCriterion("theme_song =", value, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongNotEqualTo(String value) {
            addCriterion("theme_song <>", value, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongGreaterThan(String value) {
            addCriterion("theme_song >", value, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongGreaterThanOrEqualTo(String value) {
            addCriterion("theme_song >=", value, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongLessThan(String value) {
            addCriterion("theme_song <", value, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongLessThanOrEqualTo(String value) {
            addCriterion("theme_song <=", value, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongLike(String value) {
            addCriterion("theme_song like", value, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongNotLike(String value) {
            addCriterion("theme_song not like", value, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongIn(List<String> values) {
            addCriterion("theme_song in", values, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongNotIn(List<String> values) {
            addCriterion("theme_song not in", values, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongBetween(String value1, String value2) {
            addCriterion("theme_song between", value1, value2, "themeSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongNotBetween(String value1, String value2) {
            addCriterion("theme_song not between", value1, value2, "themeSong");
            return (Criteria) this;
        }

        public Criteria andTvProgramIsNull() {
            addCriterion("tv_program is null");
            return (Criteria) this;
        }

        public Criteria andTvProgramIsNotNull() {
            addCriterion("tv_program is not null");
            return (Criteria) this;
        }

        public Criteria andTvProgramEqualTo(String value) {
            addCriterion("tv_program =", value, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramNotEqualTo(String value) {
            addCriterion("tv_program <>", value, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramGreaterThan(String value) {
            addCriterion("tv_program >", value, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramGreaterThanOrEqualTo(String value) {
            addCriterion("tv_program >=", value, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramLessThan(String value) {
            addCriterion("tv_program <", value, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramLessThanOrEqualTo(String value) {
            addCriterion("tv_program <=", value, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramLike(String value) {
            addCriterion("tv_program like", value, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramNotLike(String value) {
            addCriterion("tv_program not like", value, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramIn(List<String> values) {
            addCriterion("tv_program in", values, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramNotIn(List<String> values) {
            addCriterion("tv_program not in", values, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramBetween(String value1, String value2) {
            addCriterion("tv_program between", value1, value2, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andTvProgramNotBetween(String value1, String value2) {
            addCriterion("tv_program not between", value1, value2, "tvProgram");
            return (Criteria) this;
        }

        public Criteria andSceneIsNull() {
            addCriterion("scene is null");
            return (Criteria) this;
        }

        public Criteria andSceneIsNotNull() {
            addCriterion("scene is not null");
            return (Criteria) this;
        }

        public Criteria andSceneEqualTo(String value) {
            addCriterion("scene =", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotEqualTo(String value) {
            addCriterion("scene <>", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThan(String value) {
            addCriterion("scene >", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThanOrEqualTo(String value) {
            addCriterion("scene >=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThan(String value) {
            addCriterion("scene <", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThanOrEqualTo(String value) {
            addCriterion("scene <=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLike(String value) {
            addCriterion("scene like", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotLike(String value) {
            addCriterion("scene not like", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneIn(List<String> values) {
            addCriterion("scene in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotIn(List<String> values) {
            addCriterion("scene not in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneBetween(String value1, String value2) {
            addCriterion("scene between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotBetween(String value1, String value2) {
            addCriterion("scene not between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andSongYearsIsNull() {
            addCriterion("song_years is null");
            return (Criteria) this;
        }

        public Criteria andSongYearsIsNotNull() {
            addCriterion("song_years is not null");
            return (Criteria) this;
        }

        public Criteria andSongYearsEqualTo(String value) {
            addCriterion("song_years =", value, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsNotEqualTo(String value) {
            addCriterion("song_years <>", value, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsGreaterThan(String value) {
            addCriterion("song_years >", value, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsGreaterThanOrEqualTo(String value) {
            addCriterion("song_years >=", value, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsLessThan(String value) {
            addCriterion("song_years <", value, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsLessThanOrEqualTo(String value) {
            addCriterion("song_years <=", value, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsLike(String value) {
            addCriterion("song_years like", value, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsNotLike(String value) {
            addCriterion("song_years not like", value, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsIn(List<String> values) {
            addCriterion("song_years in", values, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsNotIn(List<String> values) {
            addCriterion("song_years not in", values, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsBetween(String value1, String value2) {
            addCriterion("song_years between", value1, value2, "songYears");
            return (Criteria) this;
        }

        public Criteria andSongYearsNotBetween(String value1, String value2) {
            addCriterion("song_years not between", value1, value2, "songYears");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedIsNull() {
            addCriterion("enter_selected is null");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedIsNotNull() {
            addCriterion("enter_selected is not null");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedEqualTo(String value) {
            addCriterion("enter_selected =", value, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedNotEqualTo(String value) {
            addCriterion("enter_selected <>", value, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedGreaterThan(String value) {
            addCriterion("enter_selected >", value, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedGreaterThanOrEqualTo(String value) {
            addCriterion("enter_selected >=", value, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedLessThan(String value) {
            addCriterion("enter_selected <", value, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedLessThanOrEqualTo(String value) {
            addCriterion("enter_selected <=", value, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedLike(String value) {
            addCriterion("enter_selected like", value, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedNotLike(String value) {
            addCriterion("enter_selected not like", value, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedIn(List<String> values) {
            addCriterion("enter_selected in", values, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedNotIn(List<String> values) {
            addCriterion("enter_selected not in", values, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedBetween(String value1, String value2) {
            addCriterion("enter_selected between", value1, value2, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedNotBetween(String value1, String value2) {
            addCriterion("enter_selected not between", value1, value2, "enterSelected");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(String value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(String value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(String value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(String value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLike(String value) {
            addCriterion("update_date like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotLike(String value) {
            addCriterion("update_date not like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<String> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<String> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(String value1, String value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(String value1, String value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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

        public Criteria andSongZsIsNull() {
            addCriterion("song_zs is null");
            return (Criteria) this;
        }

        public Criteria andSongZsIsNotNull() {
            addCriterion("song_zs is not null");
            return (Criteria) this;
        }

        public Criteria andSongZsEqualTo(Integer value) {
            addCriterion("song_zs =", value, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsNotEqualTo(Integer value) {
            addCriterion("song_zs <>", value, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsGreaterThan(Integer value) {
            addCriterion("song_zs >", value, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsGreaterThanOrEqualTo(Integer value) {
            addCriterion("song_zs >=", value, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsLessThan(Integer value) {
            addCriterion("song_zs <", value, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsLessThanOrEqualTo(Integer value) {
            addCriterion("song_zs <=", value, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsIn(List<Integer> values) {
            addCriterion("song_zs in", values, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsNotIn(List<Integer> values) {
            addCriterion("song_zs not in", values, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsBetween(Integer value1, Integer value2) {
            addCriterion("song_zs between", value1, value2, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongZsNotBetween(Integer value1, Integer value2) {
            addCriterion("song_zs not between", value1, value2, "songZs");
            return (Criteria) this;
        }

        public Criteria andSongNoIsNull() {
            addCriterion("song_no is null");
            return (Criteria) this;
        }

        public Criteria andSongNoIsNotNull() {
            addCriterion("song_no is not null");
            return (Criteria) this;
        }

        public Criteria andSongNoEqualTo(String value) {
            addCriterion("song_no =", value, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoNotEqualTo(String value) {
            addCriterion("song_no <>", value, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoGreaterThan(String value) {
            addCriterion("song_no >", value, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoGreaterThanOrEqualTo(String value) {
            addCriterion("song_no >=", value, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoLessThan(String value) {
            addCriterion("song_no <", value, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoLessThanOrEqualTo(String value) {
            addCriterion("song_no <=", value, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoLike(String value) {
            addCriterion("song_no like", value, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoNotLike(String value) {
            addCriterion("song_no not like", value, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoIn(List<String> values) {
            addCriterion("song_no in", values, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoNotIn(List<String> values) {
            addCriterion("song_no not in", values, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoBetween(String value1, String value2) {
            addCriterion("song_no between", value1, value2, "songNo");
            return (Criteria) this;
        }

        public Criteria andSongNoNotBetween(String value1, String value2) {
            addCriterion("song_no not between", value1, value2, "songNo");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSingerIdIsNull() {
            addCriterion("singer_id is null");
            return (Criteria) this;
        }

        public Criteria andSingerIdIsNotNull() {
            addCriterion("singer_id is not null");
            return (Criteria) this;
        }

        public Criteria andSingerIdEqualTo(String value) {
            addCriterion("singer_id =", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotEqualTo(String value) {
            addCriterion("singer_id <>", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdGreaterThan(String value) {
            addCriterion("singer_id >", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdGreaterThanOrEqualTo(String value) {
            addCriterion("singer_id >=", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdLessThan(String value) {
            addCriterion("singer_id <", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdLessThanOrEqualTo(String value) {
            addCriterion("singer_id <=", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdLike(String value) {
            addCriterion("singer_id like", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotLike(String value) {
            addCriterion("singer_id not like", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdIn(List<String> values) {
            addCriterion("singer_id in", values, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotIn(List<String> values) {
            addCriterion("singer_id not in", values, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdBetween(String value1, String value2) {
            addCriterion("singer_id between", value1, value2, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotBetween(String value1, String value2) {
            addCriterion("singer_id not between", value1, value2, "singerId");
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

        public Criteria andTvProgramEnterIsNull() {
            addCriterion("tv_program_enter is null");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterIsNotNull() {
            addCriterion("tv_program_enter is not null");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterEqualTo(String value) {
            addCriterion("tv_program_enter =", value, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterNotEqualTo(String value) {
            addCriterion("tv_program_enter <>", value, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterGreaterThan(String value) {
            addCriterion("tv_program_enter >", value, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterGreaterThanOrEqualTo(String value) {
            addCriterion("tv_program_enter >=", value, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterLessThan(String value) {
            addCriterion("tv_program_enter <", value, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterLessThanOrEqualTo(String value) {
            addCriterion("tv_program_enter <=", value, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterLike(String value) {
            addCriterion("tv_program_enter like", value, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterNotLike(String value) {
            addCriterion("tv_program_enter not like", value, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterIn(List<String> values) {
            addCriterion("tv_program_enter in", values, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterNotIn(List<String> values) {
            addCriterion("tv_program_enter not in", values, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterBetween(String value1, String value2) {
            addCriterion("tv_program_enter between", value1, value2, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterNotBetween(String value1, String value2) {
            addCriterion("tv_program_enter not between", value1, value2, "tvProgramEnter");
            return (Criteria) this;
        }

        public Criteria andMrsIdLikeInsensitive(String value) {
            addCriterion("upper(mrs_id) like", value.toUpperCase(), "mrsId");
            return (Criteria) this;
        }

        public Criteria andMidiIdLikeInsensitive(String value) {
            addCriterion("upper(midi_id) like", value.toUpperCase(), "midiId");
            return (Criteria) this;
        }

        public Criteria andVodIdLikeInsensitive(String value) {
            addCriterion("upper(vod_id) like", value.toUpperCase(), "vodId");
            return (Criteria) this;
        }

        public Criteria andSongNameLikeInsensitive(String value) {
            addCriterion("upper(song_name) like", value.toUpperCase(), "songName");
            return (Criteria) this;
        }

        public Criteria andFileFormatLikeInsensitive(String value) {
            addCriterion("upper(file_format) like", value.toUpperCase(), "fileFormat");
            return (Criteria) this;
        }

        public Criteria andSpellLikeInsensitive(String value) {
            addCriterion("upper(spell) like", value.toUpperCase(), "spell");
            return (Criteria) this;
        }

        public Criteria andLangIdLikeInsensitive(String value) {
            addCriterion("upper(lang_id) like", value.toUpperCase(), "langId");
            return (Criteria) this;
        }

        public Criteria andNewSongLikeInsensitive(String value) {
            addCriterion("upper(new_song) like", value.toUpperCase(), "newSong");
            return (Criteria) this;
        }

        public Criteria andHotSongLikeInsensitive(String value) {
            addCriterion("upper(hot_song) like", value.toUpperCase(), "hotSong");
            return (Criteria) this;
        }

        public Criteria andClassicSongLikeInsensitive(String value) {
            addCriterion("upper(classic_song) like", value.toUpperCase(), "classicSong");
            return (Criteria) this;
        }

        public Criteria andThemeSongLikeInsensitive(String value) {
            addCriterion("upper(theme_song) like", value.toUpperCase(), "themeSong");
            return (Criteria) this;
        }

        public Criteria andTvProgramLikeInsensitive(String value) {
            addCriterion("upper(tv_program) like", value.toUpperCase(), "tvProgram");
            return (Criteria) this;
        }

        public Criteria andSceneLikeInsensitive(String value) {
            addCriterion("upper(scene) like", value.toUpperCase(), "scene");
            return (Criteria) this;
        }

        public Criteria andSongYearsLikeInsensitive(String value) {
            addCriterion("upper(song_years) like", value.toUpperCase(), "songYears");
            return (Criteria) this;
        }

        public Criteria andEnterSelectedLikeInsensitive(String value) {
            addCriterion("upper(enter_selected) like", value.toUpperCase(), "enterSelected");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLikeInsensitive(String value) {
            addCriterion("upper(update_date) like", value.toUpperCase(), "updateDate");
            return (Criteria) this;
        }

        public Criteria andHeaderPathLikeInsensitive(String value) {
            addCriterion("upper(header_path) like", value.toUpperCase(), "headerPath");
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

        public Criteria andSongNoLikeInsensitive(String value) {
            addCriterion("upper(song_no) like", value.toUpperCase(), "songNo");
            return (Criteria) this;
        }

        public Criteria andSingerIdLikeInsensitive(String value) {
            addCriterion("upper(singer_id) like", value.toUpperCase(), "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerNameLikeInsensitive(String value) {
            addCriterion("upper(singer_name) like", value.toUpperCase(), "singerName");
            return (Criteria) this;
        }

        public Criteria andTvProgramEnterLikeInsensitive(String value) {
            addCriterion("upper(tv_program_enter) like", value.toUpperCase(), "tvProgramEnter");
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