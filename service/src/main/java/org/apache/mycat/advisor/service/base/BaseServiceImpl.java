package org.apache.mycat.advisor.service.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.Map;

/**
 * Created by cjl on 2016/3/18.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract MyMapper<T> myMapper();


    public Page<T> page(Map<String, Object> param) {
        int pageIndex = 0;
        int pageCount = 8;
        Object tmpIndex = param.get("pageIndex");
        Object tmpCount = param.get("pageCount");
        if (tmpIndex != null && StringUtils.isNotEmpty(tmpIndex.toString())) {
            pageIndex = Integer.parseInt(tmpIndex.toString());
        }
        if (tmpCount != null && StringUtils.isNotEmpty(tmpCount.toString())) {
            pageCount = Integer.parseInt(tmpCount.toString());
        }
        PageHelper.startPage(pageIndex+1, pageCount);
        PageInfo<T> pageInfo = new PageInfo<T>(myMapper().selectAll());
        return twoPage(pageInfo);
    }

    protected Page<T> twoPage(PageInfo<T> pageInfo) {
        return new Page<T>(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPageNum() - 1, pageInfo.getPageSize());
    }


    @Override
    public boolean save(T o) {
        int i = 0;
        i = myMapper().insert(o);
       /*
        if (o.getId() == null) {

        } else {
            i = postInfoMapper.updateByPrimaryKey(info);
        }*/
        return i > 0 ? true : false;
    }

    @Override
    public boolean delete(Long id) {
        return myMapper().deleteByPrimaryKey(id) > 0 ? true : false;
    }

    @Override
    public T get(long id) {
        return myMapper().selectByPrimaryKey(id);
    }

    @Override
    public boolean update(T o) {
        return myMapper().updateByPrimaryKey(o) > 0 ? true : false;
    }
}
