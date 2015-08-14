package com.djp.common.dao.impl;

import com.djp.common.core.BaseDao;
import com.djp.common.dao.IUserDao;
import com.djp.common.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dengjianping on 2015/8/14.
 */
@Component
public class UserDao extends BaseDao implements IUserDao {
    public List<String> findRoles(User user) {
        List<String> roles = getSqlMapClientTemplate().queryForList("findRoles", user);
        return roles;
    }

    public User selectUserByID(int id) {
        return null;
    }

    public List<String> findPermissions(User user) {
        List<String> permissions = getSqlMapClientTemplate().queryForList("findPermissions",user);
        return permissions;
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
