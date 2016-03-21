package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabVip;

public interface TabVipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabVip record);

    int insertSelective(TabVip record);

    TabVip selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabVip record);

    int updateByPrimaryKey(TabVip record);
}