package org.apache.mycat.advisor.common.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2015/10/24.
 */

public class Page<E> implements Serializable {

    private static final long serialVersionUID = 3886253477440783048L;

    public static final String location = "";

    public List<E> list;
    public Map<String, Object> pageInfo;

    /**
     *
     * @param list
     *            泛型数据列表
     * @param totalCount
     *            总数据
     * @param pageIndex
     *            页码
     * @param pageCount
     *            每页显示条数
     */
    public Page(List<E> list, Long totalCount, int pageIndex, int pageCount) {

        LinkedHashMap<String, Object> pageInfo = new LinkedHashMap<String, Object>();
        pageInfo.put("totalCount", totalCount);
        pageInfo.put("pageIndex", pageIndex);
        pageInfo.put("pageCount", pageCount);
        this.pageInfo = pageInfo;
        this.list = list;
    }

    public Map<String, Object> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Map<String, Object> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public static String getLocation() {
        return location;
    }
}

