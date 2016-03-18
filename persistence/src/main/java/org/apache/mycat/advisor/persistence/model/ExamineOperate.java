package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class ExamineOperate {
    private Long examineid;

    private Integer templateid;

    private Byte curstep;

    private Long questionid;

    private Long operatorid;

    private Byte status;

    private String describe;

    private Date operatetime;

    public Long getExamineid() {
        return examineid;
    }

    public void setExamineid(Long examineid) {
        this.examineid = examineid;
    }

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    public Byte getCurstep() {
        return curstep;
    }

    public void setCurstep(Byte curstep) {
        this.curstep = curstep;
    }

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public Long getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Long operatorid) {
        this.operatorid = operatorid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }
}