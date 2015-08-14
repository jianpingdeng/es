package com.djp.common.dao;

import com.djp.common.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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

    void insertUserEntity(User user);

    void updateUser(User user);
}
