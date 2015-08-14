package com.djp.common.dao;

import com.djp.common.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */

public interface IUserDao {

    Set<String> findRoles(User user);

    User selectUserByID(int id);

    Set<String> findPermissions(User user);

    User selectUserByUsername(String username);

    List<User> userListResult();

    boolean insertUserEntity(User user);

    void updateUser(User user);
}
