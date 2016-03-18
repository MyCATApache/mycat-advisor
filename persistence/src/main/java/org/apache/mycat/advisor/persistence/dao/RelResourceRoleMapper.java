package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.RelResourceRole;

public interface RelResourceRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RelResourceRole record);

    int insertSelective(RelResourceRole record);

    RelResourceRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RelResourceRole record);

    int updateByPrimaryKey(RelResourceRole record);
}