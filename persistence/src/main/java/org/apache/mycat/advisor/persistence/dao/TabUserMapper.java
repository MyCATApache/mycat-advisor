package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabUser;

public interface TabUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabUser record);

    int insertSelective(TabUser record);

    TabUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabUser record);

    int updateByPrimaryKey(TabUser record);
}