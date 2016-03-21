package org.apache.mycat.advisor.persistence.model;

import java.util.Date;

public class ExaminePerson extends ExaminePersonKey {
    private Date lastupdatetime;

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}