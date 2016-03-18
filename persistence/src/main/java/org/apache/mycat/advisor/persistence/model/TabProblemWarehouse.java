package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class TabProblemWarehouse {
    private Long id;

    private Long technologyTypeId;

    private Long problemTypeId;

    private String problemKey;

    private Long submitUserId;

    private Long processManId;

    private Integer processStep;

    private Date stepUpdateTime;

    private Date insertTime;

    private Date processTime;

    private Integer status;

    private Integer clickRate;

    private Integer sort;

    private Integer delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTechnologyTypeId() {
        return technologyTypeId;
    }

    public void setTechnologyTypeId(Long technologyTypeId) {
        this.technologyTypeId = technologyTypeId;
    }

    public Long getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(Long problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    public String getProblemKey() {
        return problemKey;
    }

    public void setProblemKey(String problemKey) {
        this.problemKey = problemKey;
    }

    public Long getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(Long submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Long getProcessManId() {
        return processManId;
    }

    public void setProcessManId(Long processManId) {
        this.processManId = processManId;
    }

    public Integer getProcessStep() {
        return processStep;
    }

    public void setProcessStep(Integer processStep) {
        this.processStep = processStep;
    }

    public Date getStepUpdateTime() {
        return stepUpdateTime;
    }

    public void setStepUpdateTime(Date stepUpdateTime) {
        this.stepUpdateTime = stepUpdateTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClickRate() {
        return clickRate;
    }

    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}