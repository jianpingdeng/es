package com.djp.common.dao.impl;

import com.djp.common.dao.BaseDao;
import com.djp.common.dao.UserDao;
import com.djp.common.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.Assert;

import java.util.Set;

/**
 * Created by dengjianping on 2015/8/13.
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    private static final String QUERY_BY_USRENAME=".selectUserByUsername";
    public Set<String> findRoles(User user) {
        return null;
    }

    public Set<String> findPermissions(User user) {
        return null;
    }

    public User findByUsername(User user) {
        SqlSession session = getSqlSessionFactory().openSession();
        User result = session.selectOne(getName(User.class.getName())+QUERY_BY_USRENAME,user);
        session.close();
        return result;
    }
}
