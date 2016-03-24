package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "sys_roles")
public class SysRoles {
    @Id
    @Column(name = "ROLE_ID", nullable = false, insertable = true, updatable = true)
    private Long roleId;
    private String roleName;
    private String roleDesc;
    private Integer enable;
    private Integer issys;
    private Long moduleId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = true, insertable = true, updatable = true, length = 50)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "ROLE_DESC", nullable = true, insertable = true, updatable = true, length = 50)
    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Basic
    @Column(name = "ENABLE", nullable = true, insertable = true, updatable = true)
    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Basic
    @Column(name = "ISSYS", nullable = true, insertable = true, updatable = true)
    public Integer getIssys() {
        return issys;
    }

    public void setIssys(Integer issys) {
        this.issys = issys;
    }

    @Basic
    @Column(name = "MODULE_ID", nullable = true, insertable = true, updatable = true)
    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoles sysRoles = (SysRoles) o;

        if (roleId != null ? !roleId.equals(sysRoles.roleId) : sysRoles.roleId != null) return false;
        if (roleName != null ? !roleName.equals(sysRoles.roleName) : sysRoles.roleName != null) return false;
        if (roleDesc != null ? !roleDesc.equals(sysRoles.roleDesc) : sysRoles.roleDesc != null) return false;
        if (enable != null ? !enable.equals(sysRoles.enable) : sysRoles.enable != null) return false;
        if (issys != null ? !issys.equals(sysRoles.issys) : sysRoles.issys != null) return false;
        if (moduleId != null ? !moduleId.equals(sysRoles.moduleId) : sysRoles.moduleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleDesc != null ? roleDesc.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (issys != null ? issys.hashCode() : 0);
        result = 31 * result + (moduleId != null ? moduleId.hashCode() : 0);
        return result;
    }
}
