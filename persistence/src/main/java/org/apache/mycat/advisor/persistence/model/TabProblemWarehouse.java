package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/3/20.
 */
@javax.persistence.Table(name = "tab_problem_warehouse")
public class TabProblemWarehouse {
    @Id
    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long technologyTypeId;
    private Long problemTypeId;
    private String problemDescribe;
    private String problemKey;
    private String expectDescribe;
    private Long submitUserId;
    private Long processManId;
    private String processDescribe;
    private Integer processStep;
    private Timestamp stepUpdateTime;
    private Timestamp insertTime;
    private Timestamp processTime;
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

    @Basic
    @javax.persistence.Column(name = "technology_type_id", nullable = true, insertable = true, updatable = true)
    public Long getTechnologyTypeId() {
        return technologyTypeId;
    }

    public void setTechnologyTypeId(Long technologyTypeId) {
        this.technologyTypeId = technologyTypeId;
    }

    @Basic
    @javax.persistence.Column(name = "problem_type_id", nullable = true, insertable = true, updatable = true)
    public Long getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(Long problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    @Basic
    @javax.persistence.Column(name = "problem_describe", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getProblemDescribe() {
        return problemDescribe;
    }

    public void setProblemDescribe(String problemDescribe) {
        this.problemDescribe = problemDescribe;
    }

    @Basic
    @javax.persistence.Column(name = "problem_key", nullable = true, insertable = true, updatable = true, length = 50)
    public String getProblemKey() {
        return problemKey;
    }

    public void setProblemKey(String problemKey) {
        this.problemKey = problemKey;
    }

    @Basic
    @javax.persistence.Column(name = "expect_describe", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getExpectDescribe() {
        return expectDescribe;
    }

    public void setExpectDescribe(String expectDescribe) {
        this.expectDescribe = expectDescribe;
    }

    @Basic
    @javax.persistence.Column(name = "submit_user_id", nullable = true, insertable = true, updatable = true)
    public Long getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(Long submitUserId) {
        this.submitUserId = submitUserId;
    }

    @Basic
    @javax.persistence.Column(name = "process_man_id", nullable = true, insertable = true, updatable = true)
    public Long getProcessManId() {
        return processManId;
    }

    public void setProcessManId(Long processManId) {
        this.processManId = processManId;
    }

    @Basic
    @javax.persistence.Column(name = "process_describe", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getProcessDescribe() {
        return processDescribe;
    }

    public void setProcessDescribe(String processDescribe) {
        this.processDescribe = processDescribe;
    }

    @Basic
    @javax.persistence.Column(name = "process_step", nullable = true, insertable = true, updatable = true)
    public Integer getProcessStep() {
        return processStep;
    }

    public void setProcessStep(Integer processStep) {
        this.processStep = processStep;
    }

    @Basic
    @javax.persistence.Column(name = "step_update_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getStepUpdateTime() {
        return stepUpdateTime;
    }

    public void setStepUpdateTime(Timestamp stepUpdateTime) {
        this.stepUpdateTime = stepUpdateTime;
    }

    @Basic
    @javax.persistence.Column(name = "insert_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    @Basic
    @javax.persistence.Column(name = "process_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Timestamp processTime) {
        this.processTime = processTime;
    }

    @Basic
    @javax.persistence.Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @javax.persistence.Column(name = "click_rate", nullable = true, insertable = true, updatable = true)
    public Integer getClickRate() {
        return clickRate;
    }

    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    @Basic
    @javax.persistence.Column(name = "sort", nullable = true, insertable = true, updatable = true)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @javax.persistence.Column(name = "del_flag", nullable = true, insertable = true, updatable = true)
    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabProblemWarehouse that = (TabProblemWarehouse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (technologyTypeId != null ? !technologyTypeId.equals(that.technologyTypeId) : that.technologyTypeId != null)
            return false;
        if (problemTypeId != null ? !problemTypeId.equals(that.problemTypeId) : that.problemTypeId != null)
            return false;
        if (problemDescribe != null ? !problemDescribe.equals(that.problemDescribe) : that.problemDescribe != null)
            return false;
        if (problemKey != null ? !problemKey.equals(that.problemKey) : that.problemKey != null) return false;
        if (expectDescribe != null ? !expectDescribe.equals(that.expectDescribe) : that.expectDescribe != null)
            return false;
        if (submitUserId != null ? !submitUserId.equals(that.submitUserId) : that.submitUserId != null) return false;
        if (processManId != null ? !processManId.equals(that.processManId) : that.processManId != null) return false;
        if (processDescribe != null ? !processDescribe.equals(that.processDescribe) : that.processDescribe != null)
            return false;
        if (processStep != null ? !processStep.equals(that.processStep) : that.processStep != null) return false;
        if (stepUpdateTime != null ? !stepUpdateTime.equals(that.stepUpdateTime) : that.stepUpdateTime != null)
            return false;
        if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null) return false;
        if (processTime != null ? !processTime.equals(that.processTime) : that.processTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (clickRate != null ? !clickRate.equals(that.clickRate) : that.clickRate != null) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (technologyTypeId != null ? technologyTypeId.hashCode() : 0);
        result = 31 * result + (problemTypeId != null ? problemTypeId.hashCode() : 0);
        result = 31 * result + (problemDescribe != null ? problemDescribe.hashCode() : 0);
        result = 31 * result + (problemKey != null ? problemKey.hashCode() : 0);
        result = 31 * result + (expectDescribe != null ? expectDescribe.hashCode() : 0);
        result = 31 * result + (submitUserId != null ? submitUserId.hashCode() : 0);
        result = 31 * result + (processManId != null ? processManId.hashCode() : 0);
        result = 31 * result + (processDescribe != null ? processDescribe.hashCode() : 0);
        result = 31 * result + (processStep != null ? processStep.hashCode() : 0);
        result = 31 * result + (stepUpdateTime != null ? stepUpdateTime.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (processTime != null ? processTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (clickRate != null ? clickRate.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
