package org.apache.mycat.advisor.persistence.model;

import java.math.BigDecimal;
import java.util.Date;

public class PayFlow {
    private Long serialno;

    private Long userid;

    private String channelno;

    private String branchbank;

    private String payaccount;

    private String paybank;

    private String businesscode;

    private Date transactiondate;

    private Date transactiontime;

    private Long targetuserid;

    private String targetchannelno;

    private String targetpayaccount;

    private String targetpaybank;

    private String targetbranchbank;

    private String currencytype;

    private BigDecimal appamount;

    private String specification;

    public Long getSerialno() {
        return serialno;
    }

    public void setSerialno(Long serialno) {
        this.serialno = serialno;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getChannelno() {
        return channelno;
    }

    public void setChannelno(String channelno) {
        this.channelno = channelno;
    }

    public String getBranchbank() {
        return branchbank;
    }

    public void setBranchbank(String branchbank) {
        this.branchbank = branchbank;
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

    public String getBusinesscode() {
        return businesscode;
    }

    public void setBusinesscode(String businesscode) {
        this.businesscode = businesscode;
    }

    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    public Date getTransactiontime() {
        return transactiontime;
    }

    public void setTransactiontime(Date transactiontime) {
        this.transactiontime = transactiontime;
    }

    public Long getTargetuserid() {
        return targetuserid;
    }

    public void setTargetuserid(Long targetuserid) {
        this.targetuserid = targetuserid;
    }

    public String getTargetchannelno() {
        return targetchannelno;
    }

    public void setTargetchannelno(String targetchannelno) {
        this.targetchannelno = targetchannelno;
    }

    public String getTargetpayaccount() {
        return targetpayaccount;
    }

    public void setTargetpayaccount(String targetpayaccount) {
        this.targetpayaccount = targetpayaccount;
    }

    public String getTargetpaybank() {
        return targetpaybank;
    }

    public void setTargetpaybank(String targetpaybank) {
        this.targetpaybank = targetpaybank;
    }

    public String getTargetbranchbank() {
        return targetbranchbank;
    }

    public void setTargetbranchbank(String targetbranchbank) {
        this.targetbranchbank = targetbranchbank;
    }

    public String getCurrencytype() {
        return currencytype;
    }

    public void setCurrencytype(String currencytype) {
        this.currencytype = currencytype;
    }

    public BigDecimal getAppamount() {
        return appamount;
    }

    public void setAppamount(BigDecimal appamount) {
        this.appamount = appamount;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}