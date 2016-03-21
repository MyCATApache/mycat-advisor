package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabMenu;

public interface TabMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabMenu record);

    int insertSelective(TabMenu record);

    TabMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabMenu record);

    int updateByPrimaryKey(TabMenu record);
}