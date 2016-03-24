package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "pay_flow")
public class PayFlow {
    @Id
    @Column(name = "serialno", nullable = false, insertable = true, updatable = true)
    private Long serialno;
    @Column(name = "userid", nullable = true, insertable = true, updatable = true)
    private Long userid;
    @Column(name = "channelno", nullable = false, insertable = true, updatable = true, length = 16)
    private String channelno;
    @Column(name = "branchbank", nullable = true, insertable = true, updatable = true, length = 128)
    private String branchbank;
    @Column(name = "payaccount", nullable = false, insertable = true, updatable = true, length = 64)
    private String payaccount;
    @Column(name = "paybank", nullable = true, insertable = true, updatable = true, length = 128)
    private String paybank;
    @Column(name = "businesscode", nullable = true, insertable = true, updatable = true, length = 4)
    private String businesscode;
    @Column(name = "transactiondate", nullable = true, insertable = true, updatable = true)
    private Date transactiondate;
    @Column(name = "transactiontime", nullable = true, insertable = true, updatable = true)
    private Time transactiontime;
    @Column(name = "targetuserid", nullable = true, insertable = true, updatable = true)
    private Long targetuserid;
    @Column(name = "targetchannelno", nullable = true, insertable = true, updatable = true, length = 16)
    private String targetchannelno;
    @Column(name = "targetpayaccount", nullable = true, insertable = true, updatable = true, length = 64)
    private String targetpayaccount;
    @Column(name = "targetpaybank", nullable = true, insertable = true, updatable = true, length = 128)
    private String targetpaybank;
    @Column(name = "targetbranchbank", nullable = true, insertable = true, updatable = true, length = 128)
    private String targetbranchbank;
    @Column(name = "currencytype", nullable = true, insertable = true, updatable = true, length = 3)
    private String currencytype;
    @Column(name = "appamount", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal appamount;
    @Column(name = "specification", nullable = true, insertable = true, updatable = true, length = 256)
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

    public Time getTransactiontime() {
        return transactiontime;
    }

    public void setTransactiontime(Time transactiontime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayFlow payFlow = (PayFlow) o;

        if (serialno != null ? !serialno.equals(payFlow.serialno) : payFlow.serialno != null) return false;
        if (userid != null ? !userid.equals(payFlow.userid) : payFlow.userid != null) return false;
        if (channelno != null ? !channelno.equals(payFlow.channelno) : payFlow.channelno != null) return false;
        if (branchbank != null ? !branchbank.equals(payFlow.branchbank) : payFlow.branchbank != null) return false;
        if (payaccount != null ? !payaccount.equals(payFlow.payaccount) : payFlow.payaccount != null) return false;
        if (paybank != null ? !paybank.equals(payFlow.paybank) : payFlow.paybank != null) return false;
        if (businesscode != null ? !businesscode.equals(payFlow.businesscode) : payFlow.businesscode != null)
            return false;
        if (transactiondate != null ? !transactiondate.equals(payFlow.transactiondate) : payFlow.transactiondate != null)
            return false;
        if (transactiontime != null ? !transactiontime.equals(payFlow.transactiontime) : payFlow.transactiontime != null)
            return false;
        if (targetuserid != null ? !targetuserid.equals(payFlow.targetuserid) : payFlow.targetuserid != null)
            return false;
        if (targetchannelno != null ? !targetchannelno.equals(payFlow.targetchannelno) : payFlow.targetchannelno != null)
            return false;
        if (targetpayaccount != null ? !targetpayaccount.equals(payFlow.targetpayaccount) : payFlow.targetpayaccount != null)
            return false;
        if (targetpaybank != null ? !targetpaybank.equals(payFlow.targetpaybank) : payFlow.targetpaybank != null)
            return false;
        if (targetbranchbank != null ? !targetbranchbank.equals(payFlow.targetbranchbank) : payFlow.targetbranchbank != null)
            return false;
        if (currencytype != null ? !currencytype.equals(payFlow.currencytype) : payFlow.currencytype != null)
            return false;
        if (appamount != null ? !appamount.equals(payFlow.appamount) : payFlow.appamount != null) return false;
        if (specification != null ? !specification.equals(payFlow.specification) : payFlow.specification != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serialno != null ? serialno.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (channelno != null ? channelno.hashCode() : 0);
        result = 31 * result + (branchbank != null ? branchbank.hashCode() : 0);
        result = 31 * result + (payaccount != null ? payaccount.hashCode() : 0);
        result = 31 * result + (paybank != null ? paybank.hashCode() : 0);
        result = 31 * result + (businesscode != null ? businesscode.hashCode() : 0);
        result = 31 * result + (transactiondate != null ? transactiondate.hashCode() : 0);
        result = 31 * result + (transactiontime != null ? transactiontime.hashCode() : 0);
        result = 31 * result + (targetuserid != null ? targetuserid.hashCode() : 0);
        result = 31 * result + (targetchannelno != null ? targetchannelno.hashCode() : 0);
        result = 31 * result + (targetpayaccount != null ? targetpayaccount.hashCode() : 0);
        result = 31 * result + (targetpaybank != null ? targetpaybank.hashCode() : 0);
        result = 31 * result + (targetbranchbank != null ? targetbranchbank.hashCode() : 0);
        result = 31 * result + (currencytype != null ? currencytype.hashCode() : 0);
        result = 31 * result + (appamount != null ? appamount.hashCode() : 0);
        result = 31 * result + (specification != null ? specification.hashCode() : 0);
        return result;
    }
}
