package com.djp.common.dao;

import com.djp.common.entity.User;

import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */
public interface UserDao {
    Set<String> findRoles(User user);

    Set<String> findPermissions(User user);

    User findByUsername(User user);
}
