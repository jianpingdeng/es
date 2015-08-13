package com.djp.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dengjianping on 2015/8/12.
 */
public class BaseDao<T> {
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean;

    public SqlSessionFactory getSqlSessionFactory() {
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getName(String name){
        return name;
    }
}
