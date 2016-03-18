package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.SensitiveWord;

public interface SensitiveWordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SensitiveWord record);

    int insertSelective(SensitiveWord record);

    SensitiveWord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SensitiveWord record);

    int updateByPrimaryKey(SensitiveWord record);
}