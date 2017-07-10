package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
@Alias("EnumValue")
public class EnumValue implements Serializable {
    private Integer id;

    private String name;

    private Integer enumTypeId;

    private String ename;

    private static final long serialVersionUID = 1L;

    public EnumValue(Integer id, String name, Integer enumTypeId) {
        this.id = id;
        this.name = name;
        this.enumTypeId = enumTypeId;
    }

    public EnumValue() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEnumTypeId() {
        return enumTypeId;
    }

    public void setEnumTypeId(Integer enumTypeId) {
        this.enumTypeId = enumTypeId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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
        EnumValue other = (EnumValue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getEnumTypeId() == null ? other.getEnumTypeId() == null : this.getEnumTypeId().equals(other.getEnumTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEnumTypeId() == null) ? 0 : getEnumTypeId().hashCode());
        return result;
    }
}