package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class TabVipBuyInfo {
    private Long id;

    private Long userId;

    private Date buyTime;

    private Integer monthSize;

    private Float money;

    private String dealNumber;

    private Integer status;

    private Long vipId;

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

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Integer getMonthSize() {
        return monthSize;
    }

    public void setMonthSize(Integer monthSize) {
        this.monthSize = monthSize;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getDealNumber() {
        return dealNumber;
    }

    public void setDealNumber(String dealNumber) {
        this.dealNumber = dealNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }
}