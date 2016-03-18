package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabAdvisorTechnologicalType;

public interface TabAdvisorTechnologicalTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabAdvisorTechnologicalType record);

    int insertSelective(TabAdvisorTechnologicalType record);

    TabAdvisorTechnologicalType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabAdvisorTechnologicalType record);

    int updateByPrimaryKey(TabAdvisorTechnologicalType record);
}