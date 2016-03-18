package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabProblemEvaluate;

public interface TabProblemEvaluateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabProblemEvaluate record);

    int insertSelective(TabProblemEvaluate record);

    TabProblemEvaluate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabProblemEvaluate record);

    int updateByPrimaryKey(TabProblemEvaluate record);
}