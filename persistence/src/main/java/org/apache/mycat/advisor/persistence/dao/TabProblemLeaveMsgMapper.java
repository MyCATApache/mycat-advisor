package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabProblemLeaveMsg;

public interface TabProblemLeaveMsgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabProblemLeaveMsg record);

    int insertSelective(TabProblemLeaveMsg record);

    TabProblemLeaveMsg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TabProblemLeaveMsg record);

    int updateByPrimaryKey(TabProblemLeaveMsg record);
}