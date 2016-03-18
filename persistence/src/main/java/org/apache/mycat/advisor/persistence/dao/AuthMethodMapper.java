package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.AuthMethod;

public interface AuthMethodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthMethod record);

    int insertSelective(AuthMethod record);

    AuthMethod selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthMethod record);

    int updateByPrimaryKey(AuthMethod record);
}