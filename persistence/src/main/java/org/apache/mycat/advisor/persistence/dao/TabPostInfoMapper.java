package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabPostInfo;

public interface TabPostInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabPostInfo record);

    int insertSelective(TabPostInfo record);

    TabPostInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabPostInfo record);

    int updateByPrimaryKey(TabPostInfo record);
}