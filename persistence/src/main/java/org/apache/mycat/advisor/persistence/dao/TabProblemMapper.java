package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabProblem;
import org.apache.mycat.advisor.persistence.model.TabProblemWithBLOBs;

public interface TabProblemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabProblemWithBLOBs record);

    int insertSelective(TabProblemWithBLOBs record);

    TabProblemWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabProblemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TabProblemWithBLOBs record);

    int updateByPrimaryKey(TabProblem record);
}