package org.apache.mycat.advisor.service.um.company.impl;

import org.apache.mycat.advisor.persistence.dao.TabCompanyMapper;
import org.apache.mycat.advisor.persistence.model.TabCompany;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.um.company.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by cjl on 2016/3/22.
 */
@Service
public class UserCompanyServiceImpl extends BaseServiceImpl<TabCompany> implements UserCompanyService {
    @Autowired
    TabCompanyMapper mapper;


    @Override
    protected MyMapper<TabCompany> myMapper() {
        return mapper;
    }

    @Override
    public boolean save(TabCompany o) {
        if (o.getId() != null) {
            o.setUpdateTime(new Date());
            return super.update(o);
        }
        o.setDelFlag(0);
        o.setInsertTime(new Date());
        o.setUpdateTime(new Date());
        return super.save(o);
    }
}
