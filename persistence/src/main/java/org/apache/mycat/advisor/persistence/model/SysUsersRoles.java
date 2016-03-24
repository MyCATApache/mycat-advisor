package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "sys_users_roles")
public class SysUsersRoles {
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long roleId;
    private Long tabId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = false, insertable = true, updatable = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "tab_id", nullable = true, insertable = true, updatable = true)
    public Long getTabId() {
        return tabId;
    }

    public void setTabId(Long tabId) {
        this.tabId = tabId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUsersRoles that = (SysUsersRoles) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (tabId != null ? !tabId.equals(that.tabId) : that.tabId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (tabId != null ? tabId.hashCode() : 0);
        return result;
    }
}
