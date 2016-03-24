package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "examine_operate")
public class ExamineOperate {
    @Id
    @Column(name = "examineid", nullable = false, insertable = true, updatable = true)
    private Long examineid;

    @Column(name = "templateid", nullable = true, insertable = true, updatable = true)
    private Integer templateid;

    @Column(name = "curstep", nullable = true, insertable = true, updatable = true)
    private Byte curstep;

    @Column(name = "questionid", nullable = true, insertable = true, updatable = true)
    private Long questionid;

    @Column(name = "operatorid", nullable = true, insertable = true, updatable = true)
    private Long operatorid;

    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    private Byte status;

    @Column(name = "describe", nullable = true, insertable = true, updatable = true, length = 256)
    private String describe;

    @Column(name = "operatetime", nullable = false, insertable = true, updatable = true)
    private Timestamp operatetime;


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


    public Timestamp getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Timestamp operatetime) {
        this.operatetime = operatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamineOperate that = (ExamineOperate) o;

        if (examineid != null ? !examineid.equals(that.examineid) : that.examineid != null) return false;
        if (templateid != null ? !templateid.equals(that.templateid) : that.templateid != null) return false;
        if (curstep != null ? !curstep.equals(that.curstep) : that.curstep != null) return false;
        if (questionid != null ? !questionid.equals(that.questionid) : that.questionid != null) return false;
        if (operatorid != null ? !operatorid.equals(that.operatorid) : that.operatorid != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (describe != null ? !describe.equals(that.describe) : that.describe != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = examineid != null ? examineid.hashCode() : 0;
        result = 31 * result + (templateid != null ? templateid.hashCode() : 0);
        result = 31 * result + (curstep != null ? curstep.hashCode() : 0);
        result = 31 * result + (questionid != null ? questionid.hashCode() : 0);
        result = 31 * result + (operatorid != null ? operatorid.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (describe != null ? describe.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        return result;
    }
}
