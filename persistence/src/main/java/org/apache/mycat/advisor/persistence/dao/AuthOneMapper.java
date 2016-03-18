package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.AuthOne;

public interface AuthOneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthOne record);

    int insertSelective(AuthOne record);

    AuthOne selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthOne record);

    int updateByPrimaryKey(AuthOne record);
}