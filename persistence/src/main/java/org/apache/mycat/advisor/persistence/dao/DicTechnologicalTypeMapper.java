package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.DicTechnologicalType;

public interface DicTechnologicalTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DicTechnologicalType record);

    int insertSelective(DicTechnologicalType record);

    DicTechnologicalType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DicTechnologicalType record);

    int updateByPrimaryKey(DicTechnologicalType record);
}