package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "tab_problem_evaluate")
public class TabProblemEvaluate {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
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

    @Basic
    @Column(name = "problem_id", nullable = true, insertable = true, updatable = true)
    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    @Basic
    @Column(name = "content", nullable = true, insertable = true, updatable = true, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "result_score", nullable = true, insertable = true, updatable = true)
    public Integer getResultScore() {
        return resultScore;
    }

    public void setResultScore(Integer resultScore) {
        this.resultScore = resultScore;
    }

    @Basic
    @Column(name = "response_score", nullable = true, insertable = true, updatable = true)
    public Integer getResponseScore() {
        return responseScore;
    }

    public void setResponseScore(Integer responseScore) {
        this.responseScore = responseScore;
    }

    @Basic
    @Column(name = "serve_score", nullable = true, insertable = true, updatable = true)
    public Integer getServeScore() {
        return serveScore;
    }

    public void setServeScore(Integer serveScore) {
        this.serveScore = serveScore;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "eval_user_id", nullable = true, insertable = true, updatable = true)
    public Long getEvalUserId() {
        return evalUserId;
    }

    public void setEvalUserId(Long evalUserId) {
        this.evalUserId = evalUserId;
    }

    @Basic
    @Column(name = "process_user_id", nullable = true, insertable = true, updatable = true)
    public Long getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Long processUserId) {
        this.processUserId = processUserId;
    }

    @Basic
    @Column(name = "order_id", nullable = true, insertable = true, updatable = true)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabProblemEvaluate that = (TabProblemEvaluate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (problemId != null ? !problemId.equals(that.problemId) : that.problemId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (resultScore != null ? !resultScore.equals(that.resultScore) : that.resultScore != null) return false;
        if (responseScore != null ? !responseScore.equals(that.responseScore) : that.responseScore != null)
            return false;
        if (serveScore != null ? !serveScore.equals(that.serveScore) : that.serveScore != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (evalUserId != null ? !evalUserId.equals(that.evalUserId) : that.evalUserId != null) return false;
        if (processUserId != null ? !processUserId.equals(that.processUserId) : that.processUserId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (problemId != null ? problemId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (resultScore != null ? resultScore.hashCode() : 0);
        result = 31 * result + (responseScore != null ? responseScore.hashCode() : 0);
        result = 31 * result + (serveScore != null ? serveScore.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (evalUserId != null ? evalUserId.hashCode() : 0);
        result = 31 * result + (processUserId != null ? processUserId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }
}
