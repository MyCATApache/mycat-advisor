package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.SystemParam;

public interface SystemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemParam record);

    int insertSelective(SystemParam record);

    SystemParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemParam record);

    int updateByPrimaryKey(SystemParam record);
}