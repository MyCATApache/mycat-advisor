package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "tab_order")
public class TabOrder {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long type;
    private Long placeId;
    private Long problemId;
    private Long advisorId;
    private Integer status;
    private String paynumber;
    private Integer paytype;
    private Integer orderStep;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, insertable = true, updatable = true)
    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Basic
    @Column(name = "place_id", nullable = true, insertable = true, updatable = true)
    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "problem_id", nullable = true, insertable = true, updatable = true)
    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    @Basic
    @Column(name = "advisor_id", nullable = true, insertable = true, updatable = true)
    public Long getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(Long advisorId) {
        this.advisorId = advisorId;
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
    @Column(name = "paynumber", nullable = true, insertable = true, updatable = true, length = 32)
    public String getPaynumber() {
        return paynumber;
    }

    public void setPaynumber(String paynumber) {
        this.paynumber = paynumber;
    }

    @Basic
    @Column(name = "paytype", nullable = true, insertable = true, updatable = true)
    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    @Basic
    @Column(name = "order_step", nullable = true, insertable = true, updatable = true)
    public Integer getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(Integer orderStep) {
        this.orderStep = orderStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabOrder tabOrder = (TabOrder) o;

        if (id != null ? !id.equals(tabOrder.id) : tabOrder.id != null) return false;
        if (type != null ? !type.equals(tabOrder.type) : tabOrder.type != null) return false;
        if (placeId != null ? !placeId.equals(tabOrder.placeId) : tabOrder.placeId != null) return false;
        if (problemId != null ? !problemId.equals(tabOrder.problemId) : tabOrder.problemId != null) return false;
        if (advisorId != null ? !advisorId.equals(tabOrder.advisorId) : tabOrder.advisorId != null) return false;
        if (status != null ? !status.equals(tabOrder.status) : tabOrder.status != null) return false;
        if (paynumber != null ? !paynumber.equals(tabOrder.paynumber) : tabOrder.paynumber != null) return false;
        if (paytype != null ? !paytype.equals(tabOrder.paytype) : tabOrder.paytype != null) return false;
        if (orderStep != null ? !orderStep.equals(tabOrder.orderStep) : tabOrder.orderStep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (placeId != null ? placeId.hashCode() : 0);
        result = 31 * result + (problemId != null ? problemId.hashCode() : 0);
        result = 31 * result + (advisorId != null ? advisorId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (paynumber != null ? paynumber.hashCode() : 0);
        result = 31 * result + (paytype != null ? paytype.hashCode() : 0);
        result = 31 * result + (orderStep != null ? orderStep.hashCode() : 0);
        return result;
    }
}
