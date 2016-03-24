package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "pay_channel")
public class PayChannel {
    @Id
    @Column(name = "channelno", nullable = false, insertable = true, updatable = true, length = 16)
    private String channelno;

    @Column(name = "channelname", nullable = true, insertable = true, updatable = true, length = 64)
    private String channelname;

    @Column(name = "channelcode", nullable = true, insertable = true, updatable = true, length = 16)
    private String channelcode;

    @Column(name = "channeltype", nullable = true, insertable = true, updatable = true, length = 2)
    private String channeltype;

    @Column(name = "tradingmethod", nullable = true, insertable = true, updatable = true, length = 128)
    private String tradingmethod;
    @Id
    @Column(name = "payaccount", nullable = false, insertable = true, updatable = true, length = 64)
    private String payaccount;

    @Column(name = "paybank", nullable = true, insertable = true, updatable = true, length = 128)
    private String paybank;

    @Column(name = "branchbank", nullable = true, insertable = true, updatable = true, length = 128)
    private String branchbank;

    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    private Byte status;

    @Column(name = "lastupdatetime", nullable = false, insertable = true, updatable = true)
    private Timestamp lastupdatetime;


    public String getChannelno() {
        return channelno;
    }

    public void setChannelno(String channelno) {
        this.channelno = channelno;
    }


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


    public String getPayaccount() {
        return payaccount;
    }

    public void setPayaccount(String payaccount) {
        this.payaccount = payaccount;
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


    public Timestamp getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Timestamp lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayChannel that = (PayChannel) o;

        if (channelno != null ? !channelno.equals(that.channelno) : that.channelno != null) return false;
        if (channelname != null ? !channelname.equals(that.channelname) : that.channelname != null) return false;
        if (channelcode != null ? !channelcode.equals(that.channelcode) : that.channelcode != null) return false;
        if (channeltype != null ? !channeltype.equals(that.channeltype) : that.channeltype != null) return false;
        if (tradingmethod != null ? !tradingmethod.equals(that.tradingmethod) : that.tradingmethod != null)
            return false;
        if (payaccount != null ? !payaccount.equals(that.payaccount) : that.payaccount != null) return false;
        if (paybank != null ? !paybank.equals(that.paybank) : that.paybank != null) return false;
        if (branchbank != null ? !branchbank.equals(that.branchbank) : that.branchbank != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (lastupdatetime != null ? !lastupdatetime.equals(that.lastupdatetime) : that.lastupdatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = channelno != null ? channelno.hashCode() : 0;
        result = 31 * result + (channelname != null ? channelname.hashCode() : 0);
        result = 31 * result + (channelcode != null ? channelcode.hashCode() : 0);
        result = 31 * result + (channeltype != null ? channeltype.hashCode() : 0);
        result = 31 * result + (tradingmethod != null ? tradingmethod.hashCode() : 0);
        result = 31 * result + (payaccount != null ? payaccount.hashCode() : 0);
        result = 31 * result + (paybank != null ? paybank.hashCode() : 0);
        result = 31 * result + (branchbank != null ? branchbank.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (lastupdatetime != null ? lastupdatetime.hashCode() : 0);
        return result;
    }
}
