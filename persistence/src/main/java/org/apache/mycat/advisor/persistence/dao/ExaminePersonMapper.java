package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.ExaminePerson;
import org.apache.mycat.advisor.persistence.model.ExaminePersonKey;

public interface ExaminePersonMapper {
    int deleteByPrimaryKey(ExaminePersonKey key);

    int insert(ExaminePerson record);

    int insertSelective(ExaminePerson record);

    ExaminePerson selectByPrimaryKey(ExaminePersonKey key);

    int updateByPrimaryKeySelective(ExaminePerson record);

    int updateByPrimaryKey(ExaminePerson record);
}