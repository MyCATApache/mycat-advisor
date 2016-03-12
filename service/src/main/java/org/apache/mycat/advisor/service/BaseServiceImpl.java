package org.apache.mycat.advisor.service;

import com.github.pagehelper.PageInfo;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.base.MyMapper;
import org.apache.mycat.advisor.persistence.model.usercenter.UserPostInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tk.mybatis.mapper.util.StringUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/11.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    private Class<T> entityClass;





    public BaseServiceImpl(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass =  (Class)params[0];
    }

    public Page<T> selectPage(String sql,Map<String,Object> params) {

        int pageIndex = 0;
        int pageCount = 8;
        if (params.get("pageIndex")!=null&&StringUtil.isNotEmpty(params.get("pageIndex")+"")) {
            pageIndex = Integer.parseInt((String) params.get("pageIndex"));
        }
        if (params.get("pageCount")!=null&&StringUtil.isNotEmpty(params.get("pageCount")+"")) {
            pageCount = Integer.parseInt((String) params.get("pageCount"));
        }
        sql = sql.toLowerCase();
        String count = sql.substring(sql.indexOf(" from"));
        count = "select count(1) as size " + count;
        Map tmp = jdbcTemplate.queryForMap(count);
        long rowCount=0;
        if (tmp.get("size") != null) {
            rowCount = Long.parseLong(tmp.get("size") + "");
        }
        sql += " limit "+pageIndex*pageCount+","+pageCount;

        RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(entityClass);
        List<T> dtos = (List<T>) jdbcTemplate.queryForList(sql,rowMapper);
        return new Page<T>(dtos,rowCount,pageIndex,pageCount);
    }

    protected Page towPage(PageInfo<UserPostInfo> pageInfo) {
        return new Page(pageInfo.getList(),pageInfo.getTotal(),pageInfo.getPageNum()-1,pageInfo.getPageSize());
    }

    @Override
    public boolean save(T o) {
        int i = getMapper().insert(o);

        return i > 0 ? true : false;
    }

    @Override
    public boolean del(Serializable id) {
        int i = getMapper().deleteByPrimaryKey(id);

        return i > 0 ? true : false;
    }

    @Override
    public T get(Serializable id) {
        return getMapper().selectByPrimaryKey(id);
    }

    protected abstract MyMapper<T> getMapper();
}
