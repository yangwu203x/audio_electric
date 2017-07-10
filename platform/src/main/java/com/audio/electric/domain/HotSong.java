package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
@Alias("HotSong")
public class HotSong implements Serializable {
    private Integer id;

    private Integer songId;

    private Integer rank;

    private Song song;

    private static final long serialVersionUID = 1L;

    public HotSong(Integer songId, Integer rank) {
        this.songId = songId;
        this.rank = rank;
    }

    public HotSong(Integer id, Integer songId, Integer rank) {
        this.id = id;
        this.songId = songId;
        this.rank = rank;
    }

    public HotSong() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
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
        HotSong other = (HotSong) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSongId() == null ? other.getSongId() == null : this.getSongId().equals(other.getSongId()))
            && (this.getRank() == null ? other.getRank() == null : this.getRank().equals(other.getRank()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSongId() == null) ? 0 : getSongId().hashCode());
        result = prime * result + ((getRank() == null) ? 0 : getRank().hashCode());
        return result;
    }
}