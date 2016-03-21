package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabRole;

public interface TabRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabRole record);

    int insertSelective(TabRole record);

    TabRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabRole record);

    int updateByPrimaryKey(TabRole record);
}