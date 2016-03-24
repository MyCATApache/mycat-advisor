package org.apache.mycat.advisor.service.um.userinfo;

import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.service.base.BaseService;

import java.util.List;

/**
 * Created by cjl on 2016/3/20.
 */
public interface UserInfoService extends BaseService<TabUserInfo> {
    TabUserInfo findUserByUsername(String userName);

    List<TabUserInfo> findAll();

    TabUserInfo findByUsernameAndPassword(String email, String password);


}
