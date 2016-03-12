package org.apache.mycat.advisor.service.usercenter.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.mycat.advisor.persistence.base.MyMapper;
import org.apache.mycat.advisor.persistence.mapper.usercenter.UserPostInfoMapper;
import org.apache.mycat.advisor.persistence.model.usercenter.UserPostInfo;
import org.apache.mycat.advisor.service.BaseServiceImpl;
import org.apache.mycat.advisor.service.usercenter.UserPostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.Map;

/**
 * Created by cjl on 2016/3/11.
 */
@Service
public class UserPostInfoServiceImpl extends BaseServiceImpl<UserPostInfo> implements UserPostInfoService {
    @Autowired
    UserPostInfoMapper mapper;



    @Override
    public org.apache.mycat.advisor.common.controller.Page page(Map<String, Object> params) {
        int pageIndex = 0;
        int pageCount = 8;
        if (params.get("pageIndex")!=null&& StringUtil.isNotEmpty(params.get("pageIndex") + "")) {
            pageIndex = Integer.parseInt((String) params.get("pageIndex"));
        }
        if (params.get("pageCount")!=null&&StringUtil.isNotEmpty(params.get("pageCount")+"")) {
            pageCount = Integer.parseInt((String) params.get("pageCount"));
        }
        //pageHelper是从1开始的，所以这儿要加1
        PageHelper.startPage(pageIndex+1, pageCount);
        Example example = new Example(UserPostInfo.class);
        PageInfo<UserPostInfo> pageInfo = new PageInfo<>(mapper.selectByExample(example));
        return towPage(pageInfo);
    }



    @Override
    public boolean save(UserPostInfo userPostInfo) {
        System.out.println(userPostInfo);
        int i = 0;
        if (userPostInfo.getId() == null) {
            userPostInfo.setInsert_time(new Date());
            userPostInfo.setUpdate_time(new Date());
            userPostInfo.setStatus(1);
            userPostInfo.setDel_flag(0);
            i = mapper.insert(userPostInfo);
            System.out.println(i>0?"插入成功":"失败");
        } else {
            userPostInfo.setUpdate_time(new Date());
            i = mapper.updateByPrimaryKey(userPostInfo);
        }

        return i > 0 ? true : false;
    }

    @Override
    protected MyMapper<UserPostInfo> getMapper() {
        return mapper;
    }


}
