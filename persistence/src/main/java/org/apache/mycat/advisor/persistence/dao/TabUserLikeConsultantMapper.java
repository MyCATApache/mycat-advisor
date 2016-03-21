package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabUserLikeConsultant;

public interface TabUserLikeConsultantMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabUserLikeConsultant record);

    int insertSelective(TabUserLikeConsultant record);

    TabUserLikeConsultant selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabUserLikeConsultant record);

    int updateByPrimaryKey(TabUserLikeConsultant record);
}