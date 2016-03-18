package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.RelUserRole;

public interface RelUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RelUserRole record);

    int insertSelective(RelUserRole record);

    RelUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RelUserRole record);

    int updateByPrimaryKey(RelUserRole record);
}