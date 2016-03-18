package org.apache.mycat.advisor.persistence.model;

public class TabProblemWarehouseWithBLOBs extends TabProblemWarehouse {
    private String problemDescribe;

    private String expectDescribe;

    private String processDescribe;

    public String getProblemDescribe() {
        return problemDescribe;
    }

    public void setProblemDescribe(String problemDescribe) {
        this.problemDescribe = problemDescribe;
    }

    public String getExpectDescribe() {
        return expectDescribe;
    }

    public void setExpectDescribe(String expectDescribe) {
        this.expectDescribe = expectDescribe;
    }

    public String getProcessDescribe() {
        return processDescribe;
    }

    public void setProcessDescribe(String processDescribe) {
        this.processDescribe = processDescribe;
    }
}