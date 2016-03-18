package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabVipBuyInfo;

public interface TabVipBuyInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabVipBuyInfo record);

    int insertSelective(TabVipBuyInfo record);

    TabVipBuyInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabVipBuyInfo record);

    int updateByPrimaryKey(TabVipBuyInfo record);
}