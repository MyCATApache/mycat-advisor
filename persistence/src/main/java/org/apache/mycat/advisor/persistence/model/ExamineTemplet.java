package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class ExamineTemplet {
    private Integer templateid;

    private String examinetype;

    private String url;

    private String describe;

    private Date lastupdatetime;

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

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}