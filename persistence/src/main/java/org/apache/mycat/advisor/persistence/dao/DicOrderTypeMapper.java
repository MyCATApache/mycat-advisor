package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.DicOrderType;

public interface DicOrderTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DicOrderType record);

    int insertSelective(DicOrderType record);

    DicOrderType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DicOrderType record);

    int updateByPrimaryKey(DicOrderType record);
}