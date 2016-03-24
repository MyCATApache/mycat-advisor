package org.apache.mycat.advisor.service.base;

import org.apache.mycat.advisor.common.controller.Page;

import java.util.Map;

/**
 * Created by cjl on 2016/3/18.
 */
public interface BaseService<T> {
    Page<T> page(Map<String, Object> param);

    boolean  save(T o);

    boolean update(T o);

    boolean delete(Long id);

    T get(long id);
}
