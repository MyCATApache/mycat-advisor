package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "tab_advisor_technological_type")
public class TabAdvisorTechnologicalType {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long advisorrId;
    private Long typeId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "advisorr_id", nullable = true, insertable = true, updatable = true)
    public Long getAdvisorrId() {
        return advisorrId;
    }

    public void setAdvisorrId(Long advisorrId) {
        this.advisorrId = advisorrId;
    }

    @Basic
    @Column(name = "type_id", nullable = true, insertable = true, updatable = true)
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabAdvisorTechnologicalType that = (TabAdvisorTechnologicalType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (advisorrId != null ? !advisorrId.equals(that.advisorrId) : that.advisorrId != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (advisorrId != null ? advisorrId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        return result;
    }
}
