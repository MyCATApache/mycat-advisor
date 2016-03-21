package org.apache.mycat.advisor.persistence.model;

public class TabAdvisorTechnologicalType {
    private Long id;

    private Long advisorrId;

    private Long typeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdvisorrId() {
        return advisorrId;
    }

    public void setAdvisorrId(Long advisorrId) {
        this.advisorrId = advisorrId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}