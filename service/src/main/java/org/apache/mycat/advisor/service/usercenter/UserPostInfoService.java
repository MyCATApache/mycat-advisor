package org.apache.mycat.advisor.service.usercenter;


import org.apache.mycat.advisor.persistence.model.usercenter.UserPostInfo;
import org.apache.mycat.advisor.service.BaseService;

import java.util.Map;

public interface UserPostInfoService extends BaseService<UserPostInfo> {

    org.apache.mycat.advisor.common.controller.Page page(Map<String, Object> param);

}
