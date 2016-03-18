package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabUserType;

public interface TabUserTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabUserType record);

    int insertSelective(TabUserType record);

    TabUserType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabUserType record);

    int updateByPrimaryKey(TabUserType record);
}