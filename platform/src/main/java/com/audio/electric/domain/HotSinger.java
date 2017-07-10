package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
@Alias("HotSinger")
public class HotSinger implements Serializable {
    private Integer id;

    private Integer singerId;

    private Integer rank;

    private Singer singer;

    private static final long serialVersionUID = 1L;

    public HotSinger(Integer id, Integer singerId, Integer rank) {
        this.id = id;
        this.singerId = singerId;
        this.rank = rank;
    }

    public HotSinger(Integer singerId, Integer rank) {
        this.singerId = singerId;
        this.rank = rank;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public HotSinger() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HotSinger other = (HotSinger) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSingerId() == null ? other.getSingerId() == null : this.getSingerId().equals(other.getSingerId()))
            && (this.getRank() == null ? other.getRank() == null : this.getRank().equals(other.getRank()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSingerId() == null) ? 0 : getSingerId().hashCode());
        result = prime * result + ((getRank() == null) ? 0 : getRank().hashCode());
        return result;
    }
}