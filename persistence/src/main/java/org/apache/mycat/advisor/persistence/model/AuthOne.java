package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class AuthOne {
    private Long id;

    private Byte loginstatus;

    private String password;

    private Byte failcount;

    private String onlinestatus;

    private Date lastupdatedate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(Byte loginstatus) {
        this.loginstatus = loginstatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getFailcount() {
        return failcount;
    }

    public void setFailcount(Byte failcount) {
        this.failcount = failcount;
    }

    public String getOnlinestatus() {
        return onlinestatus;
    }

    public void setOnlinestatus(String onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    public Date getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(Date lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }
}