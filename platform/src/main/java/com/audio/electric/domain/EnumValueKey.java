package com.audio.electric.domain;

import java.io.Serializable;

public class EnumValueKey implements Serializable {
    private Integer value;

    private String title;

    private static final long serialVersionUID = 1L;

    public EnumValueKey(Integer value, String title) {
        this.value = value;
        this.title = title;
    }

    public EnumValueKey() {
        super();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
        EnumValueKey other = (EnumValueKey) that;
        return (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        return result;
    }
}