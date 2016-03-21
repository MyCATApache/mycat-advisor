package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.RelMenuRole;

public interface RelMenuRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RelMenuRole record);

    int insertSelective(RelMenuRole record);

    RelMenuRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RelMenuRole record);

    int updateByPrimaryKey(RelMenuRole record);
}