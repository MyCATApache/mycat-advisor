package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "tab_vip_buyinfo")
public class TabVipBuyinfo {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long userId;
    private Timestamp buyTime;
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

    @Basic
    @Column(name = "user_id", nullable = true, insertable = true, updatable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "buy_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }

    @Basic
    @Column(name = "month_size", nullable = true, insertable = true, updatable = true)
    public Integer getMonthSize() {
        return monthSize;
    }

    public void setMonthSize(Integer monthSize) {
        this.monthSize = monthSize;
    }

    @Basic
    @Column(name = "money", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Basic
    @Column(name = "deal_number", nullable = true, insertable = true, updatable = true, length = 32)
    public String getDealNumber() {
        return dealNumber;
    }

    public void setDealNumber(String dealNumber) {
        this.dealNumber = dealNumber;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "vip_id", nullable = true, insertable = true, updatable = true)
    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabVipBuyinfo that = (TabVipBuyinfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (buyTime != null ? !buyTime.equals(that.buyTime) : that.buyTime != null) return false;
        if (monthSize != null ? !monthSize.equals(that.monthSize) : that.monthSize != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (dealNumber != null ? !dealNumber.equals(that.dealNumber) : that.dealNumber != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (vipId != null ? !vipId.equals(that.vipId) : that.vipId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (buyTime != null ? buyTime.hashCode() : 0);
        result = 31 * result + (monthSize != null ? monthSize.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (dealNumber != null ? dealNumber.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (vipId != null ? vipId.hashCode() : 0);
        return result;
    }
}
