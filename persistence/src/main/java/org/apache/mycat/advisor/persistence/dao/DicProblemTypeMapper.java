package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.DicProblemType;

public interface DicProblemTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DicProblemType record);

    int insertSelective(DicProblemType record);

    DicProblemType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DicProblemType record);

    int updateByPrimaryKey(DicProblemType record);
}