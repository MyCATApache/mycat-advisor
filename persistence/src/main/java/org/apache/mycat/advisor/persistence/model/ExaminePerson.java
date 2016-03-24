package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "examine_person")
public class ExaminePerson {
    @Id
    @Column(name = "templateid", nullable = false, insertable = true, updatable = true)
    private Integer templateid;
    @Id
    @Column(name = "step", nullable = false, insertable = true, updatable = true)
    private Byte step;
    @Id
    @Column(name = "operatorid", nullable = false, insertable = true, updatable = true)
    private Long operatorid;

    @Column(name = "lastupdatetime", nullable = false, insertable = true, updatable = true)
    private Timestamp lastupdatetime;


    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }


    public Byte getStep() {
        return step;
    }

    public void setStep(Byte step) {
        this.step = step;
    }


    public Long getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Long operatorid) {
        this.operatorid = operatorid;
    }


    public Timestamp getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Timestamp lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExaminePerson that = (ExaminePerson) o;

        if (templateid != null ? !templateid.equals(that.templateid) : that.templateid != null) return false;
        if (step != null ? !step.equals(that.step) : that.step != null) return false;
        if (operatorid != null ? !operatorid.equals(that.operatorid) : that.operatorid != null) return false;
        if (lastupdatetime != null ? !lastupdatetime.equals(that.lastupdatetime) : that.lastupdatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateid != null ? templateid.hashCode() : 0;
        result = 31 * result + (step != null ? step.hashCode() : 0);
        result = 31 * result + (operatorid != null ? operatorid.hashCode() : 0);
        result = 31 * result + (lastupdatetime != null ? lastupdatetime.hashCode() : 0);
        return result;
    }
}
