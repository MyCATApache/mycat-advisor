package org.apache.mycat.advisor.persistence.model;

public class TabOrder {
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public Long getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(Long advisorId) {
        this.advisorId = advisorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPaynumber() {
        return paynumber;
    }

    public void setPaynumber(String paynumber) {
        this.paynumber = paynumber;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(Integer orderStep) {
        this.orderStep = orderStep;
    }
}