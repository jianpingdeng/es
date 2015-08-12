package com.djp.common.dao;

/**
 * Created by dengjianping on 2015/8/12.
 */
public interface BaseDao<T> {
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public void queryById(T t,Object id);
}
