package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
@Alias("Role")
public class Role implements Serializable {
    private Integer id;

    private String roleName;

    private String createDate;

    private String description;

    private Integer roleAdd;

    private Integer roleDel;

    private Integer roleUpdate;

    private Integer roleCheck;

    private Integer roleExport;

    private static final long serialVersionUID = 1L;

    public Role(Integer id, String roleName, String createDate, String description, Integer roleAdd, Integer roleDel, Integer roleUpdate, Integer roleCheck, Integer roleExport) {
        this.id = id;
        this.roleName = roleName;
        this.createDate = createDate;
        this.description = description;
        this.roleAdd = roleAdd;
        this.roleDel = roleDel;
        this.roleUpdate = roleUpdate;
        this.roleCheck = roleCheck;
        this.roleExport = roleExport;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getRoleAdd() {
        return roleAdd;
    }

    public void setRoleAdd(Integer roleAdd) {
        this.roleAdd = roleAdd;
    }

    public Integer getRoleDel() {
        return roleDel;
    }

    public void setRoleDel(Integer roleDel) {
        this.roleDel = roleDel;
    }

    public Integer getRoleUpdate() {
        return roleUpdate;
    }

    public void setRoleUpdate(Integer roleUpdate) {
        this.roleUpdate = roleUpdate;
    }

    public Integer getRoleCheck() {
        return roleCheck;
    }

    public void setRoleCheck(Integer roleCheck) {
        this.roleCheck = roleCheck;
    }

    public Integer getRoleExport() {
        return roleExport;
    }

    public void setRoleExport(Integer roleExport) {
        this.roleExport = roleExport;
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
        Role other = (Role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRoleAdd() == null ? other.getRoleAdd() == null : this.getRoleAdd().equals(other.getRoleAdd()))
            && (this.getRoleDel() == null ? other.getRoleDel() == null : this.getRoleDel().equals(other.getRoleDel()))
            && (this.getRoleUpdate() == null ? other.getRoleUpdate() == null : this.getRoleUpdate().equals(other.getRoleUpdate()))
            && (this.getRoleCheck() == null ? other.getRoleCheck() == null : this.getRoleCheck().equals(other.getRoleCheck()))
            && (this.getRoleExport() == null ? other.getRoleExport() == null : this.getRoleExport().equals(other.getRoleExport()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRoleAdd() == null) ? 0 : getRoleAdd().hashCode());
        result = prime * result + ((getRoleDel() == null) ? 0 : getRoleDel().hashCode());
        result = prime * result + ((getRoleUpdate() == null) ? 0 : getRoleUpdate().hashCode());
        result = prime * result + ((getRoleCheck() == null) ? 0 : getRoleCheck().hashCode());
        result = prime * result + ((getRoleExport() == null) ? 0 : getRoleExport().hashCode());
        return result;
    }
}