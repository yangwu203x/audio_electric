package com.audio.electric.domain;

import java.io.Serializable;

public class SingerSongKey implements Serializable {
    private Integer songId;

    private Integer singerId;

    private static final long serialVersionUID = 1L;

    public SingerSongKey(Integer songId, Integer singerId) {
        this.songId = songId;
        this.singerId = singerId;
    }

    public SingerSongKey() {
        super();
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
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
        SingerSongKey other = (SingerSongKey) that;
        return (this.getSongId() == null ? other.getSongId() == null : this.getSongId().equals(other.getSongId()))
            && (this.getSingerId() == null ? other.getSingerId() == null : this.getSingerId().equals(other.getSingerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSongId() == null) ? 0 : getSongId().hashCode());
        result = prime * result + ((getSingerId() == null) ? 0 : getSingerId().hashCode());
        return result;
    }
}