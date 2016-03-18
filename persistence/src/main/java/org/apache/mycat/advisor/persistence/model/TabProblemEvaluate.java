package org.apache.mycat.advisor.persistence.model;

public class TabProblemEvaluate {
    private Long id;

    private Long problemId;

    private String content;

    private Integer resultScore;

    private Integer responseScore;

    private Integer serveScore;

    private Integer status;

    private Long evalUserId;

    private Long processUserId;

    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getResultScore() {
        return resultScore;
    }

    public void setResultScore(Integer resultScore) {
        this.resultScore = resultScore;
    }

    public Integer getResponseScore() {
        return responseScore;
    }

    public void setResponseScore(Integer responseScore) {
        this.responseScore = responseScore;
    }

    public Integer getServeScore() {
        return serveScore;
    }

    public void setServeScore(Integer serveScore) {
        this.serveScore = serveScore;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getEvalUserId() {
        return evalUserId;
    }

    public void setEvalUserId(Long evalUserId) {
        this.evalUserId = evalUserId;
    }

    public Long getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Long processUserId) {
        this.processUserId = processUserId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}