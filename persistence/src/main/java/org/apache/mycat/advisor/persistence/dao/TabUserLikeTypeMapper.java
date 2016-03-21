package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabUserLikeType;

public interface TabUserLikeTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabUserLikeType record);

    int insertSelective(TabUserLikeType record);

    TabUserLikeType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabUserLikeType record);

    int updateByPrimaryKey(TabUserLikeType record);
}