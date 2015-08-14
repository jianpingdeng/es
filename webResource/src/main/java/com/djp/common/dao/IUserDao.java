package com.djp.common.dao;

import com.djp.common.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */

public interface IUserDao {

    List<String> findRoles(User user);

    User selectUserByID(int id);

    List<String> findPermissions(User user);

    User selectUserByUsername(String username);

    List<User> userListResult();

    boolean insertUserEntity(User user);

    void updateUser(User user);
}
