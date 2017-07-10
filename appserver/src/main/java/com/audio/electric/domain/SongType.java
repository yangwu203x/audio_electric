package com.audio.electric.domain;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/23 0023 18:19
 */
public class SongType {
    private String typeName;
    private String description;
    private List<Integer> songIds;

    public SongType() {
    }

    public SongType(String typeName, String description, List<Integer> songIds) {
        this.typeName = typeName;
        this.description = description;
        this.songIds = songIds;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<Integer> songIds) {
        this.songIds = songIds;
    }
}
