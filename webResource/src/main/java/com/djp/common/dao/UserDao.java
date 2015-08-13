package com.djp.common.dao;

import com.djp.common.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */
@Repository(value = "userDao")
public interface UserDao {

    Set<String> findRoles(User user);

    Set<String> findPermissions(User user);

    User findByUsername(User user);
}
