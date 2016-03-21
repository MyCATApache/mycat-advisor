package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabOrder;

public interface TabOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabOrder record);

    int insertSelective(TabOrder record);

    TabOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabOrder record);

    int updateByPrimaryKey(TabOrder record);
}