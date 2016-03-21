package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabCompany;

public interface TabCompanyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabCompany record);

    int insertSelective(TabCompany record);

    TabCompany selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabCompany record);

    int updateByPrimaryKey(TabCompany record);
}