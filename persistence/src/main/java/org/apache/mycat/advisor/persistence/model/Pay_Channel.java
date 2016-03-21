package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class Pay_Channel extends Pay_ChannelKey {
    private String channelname;

    private String channelcode;

    private String channeltype;

    private String tradingmethod;

    private String paybank;

    private String branchbank;

    private Byte status;

    private Date lastupdatetime;

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode;
    }

    public String getChanneltype() {
        return channeltype;
    }

    public void setChanneltype(String channeltype) {
        this.channeltype = channeltype;
    }

    public String getTradingmethod() {
        return tradingmethod;
    }

    public void setTradingmethod(String tradingmethod) {
        this.tradingmethod = tradingmethod;
    }

    public String getPaybank() {
        return paybank;
    }

    public void setPaybank(String paybank) {
        this.paybank = paybank;
    }

    public String getBranchbank() {
        return branchbank;
    }

    public void setBranchbank(String branchbank) {
        this.branchbank = branchbank;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}