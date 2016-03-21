package org.apache.mycat.advisor.service.usercenter;


import org.apache.mycat.advisor.persistence.model.usercenter.UserInfo;

/**
 * package: springboot.simple.service <br/>
 * functional describe:
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/3/13 16:01
 */
public interface UserInfoService {
    UserInfo findById(Integer id);
}
