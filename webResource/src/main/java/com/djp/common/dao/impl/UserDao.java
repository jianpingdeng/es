package com.djp.common.dao.impl;

import com.djp.common.core.BaseDao;
import com.djp.common.dao.IUserDao;
import com.djp.common.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by dengjianping on 2015/8/14.
 */
@Component
public class UserDao extends BaseDao implements IUserDao {
    public Set<String> findRoles(User user) {
        return null;
    }

    public User selectUserByID(int id) {
        return null;
    }

    public Set<String> findPermissions(User user) {
        return null;
    }

    public User selectUserByUsername(String username) {
        User user = (User)getSqlMapClientTemplate().queryForObject("findUserByUsername",username);
        return user;
    }

    public List<User> userListResult() {
        return getSqlMapClientTemplate().queryForList("findAllUser");
    }

    public boolean insertUserEntity(User user) {
        User bean = (User)getSqlMapClientTemplate().insert("insertUser", user);
        return bean != null ? true : false;
    }

    public void updateUser(User user) {

    }
}
