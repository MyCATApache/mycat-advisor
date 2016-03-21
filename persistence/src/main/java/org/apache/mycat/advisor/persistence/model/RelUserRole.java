package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class RelUserRole {
    private Long id;

    private Long userId;

    private Long roleIe;

    private Date insertTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleIe() {
        return roleIe;
    }

    public void setRoleIe(Long roleIe) {
        this.roleIe = roleIe;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}