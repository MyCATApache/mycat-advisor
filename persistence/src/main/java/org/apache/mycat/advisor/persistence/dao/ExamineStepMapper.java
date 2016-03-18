package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.ExamineStep;

public interface ExamineStepMapper {
    int deleteByPrimaryKey(Long examineid);

    int insert(ExamineStep record);

    int insertSelective(ExamineStep record);

    ExamineStep selectByPrimaryKey(Long examineid);

    int updateByPrimaryKeySelective(ExamineStep record);

    int updateByPrimaryKey(ExamineStep record);
}