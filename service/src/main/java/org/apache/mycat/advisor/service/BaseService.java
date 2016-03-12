package org.apache.mycat.advisor.service;

import java.io.Serializable;

/**
 * Created by cjl on 2016/3/11.
 */
public interface BaseService<T>{

    public boolean save(T o);

    public boolean del(Serializable id);

    public T get(Serializable id);

}
