package org.apache.mycat.advisor.service.um.userpost.impl;

import org.apache.mycat.advisor.persistence.dao.TabPostInfoMapper;
import org.apache.mycat.advisor.persistence.model.TabPostInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.um.userpost.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by cjl on 2016/3/18.
 */
@Service
public class UserPostServiceImpl extends BaseServiceImpl<TabPostInfo> implements UserPostService {
    @Autowired
    private TabPostInfoMapper postInfoMapper;


    @Override
    protected MyMapper myMapper() {
        return postInfoMapper;
    }

    @Override
    public TabPostInfo get(long id) {
        TabPostInfo tabPostInfo = new TabPostInfo();
        tabPostInfo.setId(id);

        return postInfoMapper.selectByPrimaryKey(new Long(id));
    }

    @Override
    public boolean save(TabPostInfo o) {
        if (o.getId() != null) {
            o.setUpdateTime(new Date());
            return super.update(o);
        }
        o.setStatus(1);
        o.setDelFlag(0);
        o.setUpdateTime(new Date());
        o.setInsertTime(new Date());
        return super.save(o);
    }
}
