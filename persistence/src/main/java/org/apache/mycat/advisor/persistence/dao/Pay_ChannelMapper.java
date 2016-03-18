package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.Pay_Channel;
import org.apache.mycat.advisor.persistence.model.Pay_ChannelKey;

public interface Pay_ChannelMapper {
    int deleteByPrimaryKey(Pay_ChannelKey key);

    int insert(Pay_Channel record);

    int insertSelective(Pay_Channel record);

    Pay_Channel selectByPrimaryKey(Pay_ChannelKey key);

    int updateByPrimaryKeySelective(Pay_Channel record);

    int updateByPrimaryKey(Pay_Channel record);
}