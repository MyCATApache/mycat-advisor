package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabAdviserScore;

public interface TabAdviserScoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabAdviserScore record);

    int insertSelective(TabAdviserScore record);

    TabAdviserScore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabAdviserScore record);

    int updateByPrimaryKey(TabAdviserScore record);
}