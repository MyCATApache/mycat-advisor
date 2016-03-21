package org.apache.mycat.advisor.persistence.dao.usercenter;


import org.apache.mycat.advisor.persistence.model.usercenter.UserInfo;

/**
 * package: springboot.simple.dao <br/>
 * functional describe:
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/3/13 15:55
 */
//@MyBatisRepository
public interface UserInfoMapper {
    UserInfo selectById(Integer id);
}
