package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/3/20.
 */
public class Examinetemplet {
    @Id
    @Column(name = "templateid", nullable = false, insertable = true, updatable = true)
    private Integer templateid;
    @Column(name = "examinetype", nullable = true, insertable = true, updatable = true, length = 64)
    private String examinetype;
    @Column(name = "url", nullable = true, insertable = true, updatable = true, length = 1024)
    private String url;
    @Column(name = "describe", nullable = true, insertable = true, updatable = true, length = 256)
    private String describe;
    @Column(name = "lastupdatetime", nullable = false, insertable = true, updatable = true)
    private Timestamp lastupdatetime;


    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }


    public String getExaminetype() {
        return examinetype;
    }

    public void setExaminetype(String examinetype) {
        this.examinetype = examinetype;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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

        Examinetemplet that = (Examinetemplet) o;

        if (templateid != null ? !templateid.equals(that.templateid) : that.templateid != null) return false;
        if (examinetype != null ? !examinetype.equals(that.examinetype) : that.examinetype != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (describe != null ? !describe.equals(that.describe) : that.describe != null) return false;
        if (lastupdatetime != null ? !lastupdatetime.equals(that.lastupdatetime) : that.lastupdatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateid != null ? templateid.hashCode() : 0;
        result = 31 * result + (examinetype != null ? examinetype.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (describe != null ? describe.hashCode() : 0);
        result = 31 * result + (lastupdatetime != null ? lastupdatetime.hashCode() : 0);
        return result;
    }
}
