package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "tab_user_login_info")
public class TabUserLoginInfo {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long userId;
    private Timestamp lastlogintime;
    private Timestamp logintime;
    private Timestamp logoutTime;
    private String lastmacaddr;
    private String macaddr;
    private String lastipaddr;
    private String ipaddr;
    private Integer status;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = true, insertable = true, updatable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "lastlogintime", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Timestamp lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @Basic
    @Column(name = "logintime", nullable = true, insertable = true, updatable = true)
    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    @Basic
    @Column(name = "logout_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Timestamp logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Basic
    @Column(name = "lastmacaddr", nullable = true, insertable = true, updatable = true, length = 128)
    public String getLastmacaddr() {
        return lastmacaddr;
    }

    public void setLastmacaddr(String lastmacaddr) {
        this.lastmacaddr = lastmacaddr;
    }

    @Basic
    @Column(name = "macaddr", nullable = true, insertable = true, updatable = true, length = 128)
    public String getMacaddr() {
        return macaddr;
    }

    public void setMacaddr(String macaddr) {
        this.macaddr = macaddr;
    }

    @Basic
    @Column(name = "lastipaddr", nullable = true, insertable = true, updatable = true, length = 64)
    public String getLastipaddr() {
        return lastipaddr;
    }

    public void setLastipaddr(String lastipaddr) {
        this.lastipaddr = lastipaddr;
    }

    @Basic
    @Column(name = "ipaddr", nullable = true, insertable = true, updatable = true, length = 64)
    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabUserLoginInfo that = (TabUserLoginInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (lastlogintime != null ? !lastlogintime.equals(that.lastlogintime) : that.lastlogintime != null)
            return false;
        if (logintime != null ? !logintime.equals(that.logintime) : that.logintime != null) return false;
        if (logoutTime != null ? !logoutTime.equals(that.logoutTime) : that.logoutTime != null) return false;
        if (lastmacaddr != null ? !lastmacaddr.equals(that.lastmacaddr) : that.lastmacaddr != null) return false;
        if (macaddr != null ? !macaddr.equals(that.macaddr) : that.macaddr != null) return false;
        if (lastipaddr != null ? !lastipaddr.equals(that.lastipaddr) : that.lastipaddr != null) return false;
        if (ipaddr != null ? !ipaddr.equals(that.ipaddr) : that.ipaddr != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (lastlogintime != null ? lastlogintime.hashCode() : 0);
        result = 31 * result + (logintime != null ? logintime.hashCode() : 0);
        result = 31 * result + (logoutTime != null ? logoutTime.hashCode() : 0);
        result = 31 * result + (lastmacaddr != null ? lastmacaddr.hashCode() : 0);
        result = 31 * result + (macaddr != null ? macaddr.hashCode() : 0);
        result = 31 * result + (lastipaddr != null ? lastipaddr.hashCode() : 0);
        result = 31 * result + (ipaddr != null ? ipaddr.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
