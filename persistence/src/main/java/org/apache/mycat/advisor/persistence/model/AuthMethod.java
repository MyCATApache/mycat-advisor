package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class AuthMethod {
    private Long id;

    private Long userId;

    private String logintype;

    private String loginname;

    private String encrypttype;

    private Byte enable;

    private Date lastupdatedate;

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

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getEncrypttype() {
        return encrypttype;
    }

    public void setEncrypttype(String encrypttype) {
        this.encrypttype = encrypttype;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public Date getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(Date lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }
}