package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.ExamineOperate;

public interface ExamineOperateMapper {
    int deleteByPrimaryKey(Long examineid);

    int insert(ExamineOperate record);

    int insertSelective(ExamineOperate record);

    ExamineOperate selectByPrimaryKey(Long examineid);

    int updateByPrimaryKeySelective(ExamineOperate record);

    int updateByPrimaryKey(ExamineOperate record);
}