package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabResource;

public interface TabResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabResource record);

    int insertSelective(TabResource record);

    TabResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabResource record);

    int updateByPrimaryKey(TabResource record);
}