package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.ExamineTemplet;

public interface ExamineTempletMapper {
    int deleteByPrimaryKey(Integer templateid);

    int insert(ExamineTemplet record);

    int insertSelective(ExamineTemplet record);

    ExamineTemplet selectByPrimaryKey(Integer templateid);

    int updateByPrimaryKeySelective(ExamineTemplet record);

    int updateByPrimaryKey(ExamineTemplet record);
}