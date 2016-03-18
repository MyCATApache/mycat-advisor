package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabAdvisorProblemType;

public interface TabAdvisorProblemTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabAdvisorProblemType record);

    int insertSelective(TabAdvisorProblemType record);

    TabAdvisorProblemType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabAdvisorProblemType record);

    int updateByPrimaryKey(TabAdvisorProblemType record);
}