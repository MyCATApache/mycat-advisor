package org.apache.mycat.advisor.persistence.model;

public class SensitiveWord {
    private Long id;

    private String groupName;

    private String sensitiveword;

    private Byte enable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSensitiveword() {
        return sensitiveword;
    }

    public void setSensitiveword(String sensitiveword) {
        this.sensitiveword = sensitiveword;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }
}