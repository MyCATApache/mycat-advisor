/*
        Copyright  DR.YangLong

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.apache.mycat.advisor.common.cache;


import org.apache.mycat.advisor.common.exception.NoSuchCacheException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;

/**
 * functional describe:Ehcacahe CRUD操作封装
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0 2015/5/14 16:29
 */
public class EhCacheDao {
    private static final String DEFAULT_CACHE_NAME = "global";
    private static final String DEFAULT_CACHE_KEY = "default_key";
    private CacheManager cacheManager;
    /**
     * MUST define a cache as the system default cache
     */
    private String defaultCacheName = DEFAULT_CACHE_NAME;
    private String defaultCacheKey = DEFAULT_CACHE_KEY;

    /**
     * 用cache的名称获取cache
     *
     * @param cacheName cache名称
     * @return Cache
     */
    public Cache getCache(String cacheName) {
        Cache cache = this.getCacheManager().getCache(cacheName);
        return cache;
    }

    /**
     * 获取所有cache的名称
     *
     * @return 所有Cache的名称
     */
    public Collection<String> getCacheNames() {
        Collection<String> collection = this.getCacheManager().getCacheNames();
        return collection;
    }

    public void set(String cacheName, String key, Object object) throws NoSuchCacheException {
        cacheName = cacheName == null ? defaultCacheName : cacheName;
        Cache cache = getCache(cacheName);
        if (cache == null) {
            throw new NoSuchCacheException("没有以" + cacheName + "命名的Cache！");
        }
        key = (key == null || "".equals(key)) ? defaultCacheKey : key;
        cache.put(key, object);
    }

    public Object get(String cacheName, String key) throws NoSuchCacheException {
        cacheName = cacheName == null ? defaultCacheName : cacheName;
        Cache cache = getCache(cacheName);
        if (cache == null) {
            throw new NoSuchCacheException("没有以" + cacheName + "命名的Cache！");
        }
        key = (key == null || "".equals(key)) ? defaultCacheKey : key;
        Cache.ValueWrapper value = cache.get(key);
        Object realValue=null;
        if(value!=null) {
            realValue = value.get();
        }
        return realValue;
    }

    public void remove(String cacheName, String key) throws NoSuchCacheException {
        cacheName = cacheName == null ? defaultCacheName : cacheName;
        Cache cache = getCache(cacheName);
        if (cache == null) {
            throw new NoSuchCacheException("没有以" + cacheName + "命名的Cache！");
        }
        cache.evict(key);
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public String getDefaultCacheName() {
        return defaultCacheName;
    }

    public void setDefaultCacheName(String defaultCacheName) {
        this.defaultCacheName = defaultCacheName;
    }

    public String getDefaultCacheKey() {
        return defaultCacheKey;
    }

    public void setDefaultCacheKey(String defaultCacheKey) {
        this.defaultCacheKey = defaultCacheKey;
    }
}
