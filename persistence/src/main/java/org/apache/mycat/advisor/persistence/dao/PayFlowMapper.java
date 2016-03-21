package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.PayFlow;

public interface PayFlowMapper {
    int deleteByPrimaryKey(Long serialno);

    int insert(PayFlow record);

    int insertSelective(PayFlow record);

    PayFlow selectByPrimaryKey(Long serialno);

    int updateByPrimaryKeySelective(PayFlow record);

    int updateByPrimaryKey(PayFlow record);
}