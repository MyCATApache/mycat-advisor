package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "system_param")
public class SystemParam {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private String cKey;
    private String cName;
    private String defaultValue;
    private String cValue;
    private String validType;
    private Timestamp lastupdatetime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "c_key", nullable = true, insertable = true, updatable = true, length = 32)
    public String getcKey() {
        return cKey;
    }

    public void setcKey(String cKey) {
        this.cKey = cKey;
    }

    @Basic
    @Column(name = "c_name", nullable = true, insertable = true, updatable = true, length = 128)
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "default_value", nullable = true, insertable = true, updatable = true, length = 32)
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Basic
    @Column(name = "c_value", nullable = true, insertable = true, updatable = true, length = 32)
    public String getcValue() {
        return cValue;
    }

    public void setcValue(String cValue) {
        this.cValue = cValue;
    }

    @Basic
    @Column(name = "valid_type", nullable = true, insertable = true, updatable = true, length = 32)
    public String getValidType() {
        return validType;
    }

    public void setValidType(String validType) {
        this.validType = validType;
    }

    @Basic
    @Column(name = "lastupdatetime", nullable = false, insertable = true, updatable = true)
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

        SystemParam that = (SystemParam) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cKey != null ? !cKey.equals(that.cKey) : that.cKey != null) return false;
        if (cName != null ? !cName.equals(that.cName) : that.cName != null) return false;
        if (defaultValue != null ? !defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;
        if (cValue != null ? !cValue.equals(that.cValue) : that.cValue != null) return false;
        if (validType != null ? !validType.equals(that.validType) : that.validType != null) return false;
        if (lastupdatetime != null ? !lastupdatetime.equals(that.lastupdatetime) : that.lastupdatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cKey != null ? cKey.hashCode() : 0);
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = 31 * result + (defaultValue != null ? defaultValue.hashCode() : 0);
        result = 31 * result + (cValue != null ? cValue.hashCode() : 0);
        result = 31 * result + (validType != null ? validType.hashCode() : 0);
        result = 31 * result + (lastupdatetime != null ? lastupdatetime.hashCode() : 0);
        return result;
    }
}
