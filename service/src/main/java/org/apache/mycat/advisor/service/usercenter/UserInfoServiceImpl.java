package org.apache.mycat.advisor.service.usercenter;

import org.apache.mycat.advisor.persistence.dao.usercenter.UserInfoMapper;
import org.apache.mycat.advisor.persistence.model.usercenter.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * package: springboot.simple.service <br/>
 * functional describe:
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/3/13 16:02
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findById(Integer id) {
        return userInfoMapper.selectById(id);
    }
}
