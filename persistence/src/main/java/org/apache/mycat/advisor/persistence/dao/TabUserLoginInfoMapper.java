package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabUserLoginInfo;

public interface TabUserLoginInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabUserLoginInfo record);

    int insertSelective(TabUserLoginInfo record);

    TabUserLoginInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabUserLoginInfo record);

    int updateByPrimaryKey(TabUserLoginInfo record);
}