package com.djp.common.core;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dengjianping on 2015/8/12.
 */
public class BaseDao {
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactoryBean sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public SqlSessionFactory getSessionFactory() {
        try {
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getName(Class clazz){
        return clazz.getName();
    }
}
