package com.djp.common.core;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by dengjianping on 2015/8/12.
 */
public class BaseDao extends SqlMapClientDaoSupport {
    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;

    @PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    }

    public String getName(Class clazz){
        return clazz.getName();
    }
}
