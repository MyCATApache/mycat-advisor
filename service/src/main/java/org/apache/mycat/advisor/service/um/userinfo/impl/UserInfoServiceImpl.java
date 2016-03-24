package org.apache.mycat.advisor.service.um.userinfo.impl;

import org.apache.mycat.advisor.persistence.dao.TabUserInfoMapper;
import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.um.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cjl on 2016/3/20.
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<TabUserInfo> implements UserInfoService {
    @Autowired
    TabUserInfoMapper tabUserInfoMapper;
    @Override
    protected MyMapper<TabUserInfo> myMapper() {
        return tabUserInfoMapper;
    }

    @Override
    public TabUserInfo findUserByUsername(String userName) {
        TabUserInfo userInfo = new TabUserInfo();
        userInfo.setUsername(userName);

        return tabUserInfoMapper.selectOne(userInfo);
    }

    @Override
    public List<TabUserInfo> findAll() {
        return tabUserInfoMapper.selectAll();
    }

    @Override
    public TabUserInfo findByUsernameAndPassword(String username, String password) {
        TabUserInfo userInfo = new TabUserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        return tabUserInfoMapper.selectOne(userInfo);
    }

    @Override
    public boolean save(TabUserInfo o) {
        if (o.getId() != null) {
            o.setUpdateTime(new Date());
            return super.update(o);
        }
        o.setInsertTime(new Date());
        o.setUpdateTime(new Date());
        return super.save(o);
    }


}
