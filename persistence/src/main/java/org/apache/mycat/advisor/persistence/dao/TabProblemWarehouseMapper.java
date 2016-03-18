package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabProblemWarehouse;
import org.apache.mycat.advisor.persistence.model.TabProblemWarehouseWithBLOBs;

public interface TabProblemWarehouseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabProblemWarehouseWithBLOBs record);

    int insertSelective(TabProblemWarehouseWithBLOBs record);

    TabProblemWarehouseWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabProblemWarehouseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TabProblemWarehouseWithBLOBs record);

    int updateByPrimaryKey(TabProblemWarehouse record);
}