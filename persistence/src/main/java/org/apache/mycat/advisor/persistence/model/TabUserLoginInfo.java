package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class TabUserLoginInfo {
    private Long id;

    private Long userId;

    private Date lastlogintime;

    private Date logintime;

    private Date logoutTime;

    private String lastmacaddr;

    private String macaddr;

    private String lastipaddr;

    private String ipaddr;

    private Integer status;

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

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getLastmacaddr() {
        return lastmacaddr;
    }

    public void setLastmacaddr(String lastmacaddr) {
        this.lastmacaddr = lastmacaddr;
    }

    public String getMacaddr() {
        return macaddr;
    }

    public void setMacaddr(String macaddr) {
        this.macaddr = macaddr;
    }

    public String getLastipaddr() {
        return lastipaddr;
    }

    public void setLastipaddr(String lastipaddr) {
        this.lastipaddr = lastipaddr;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}