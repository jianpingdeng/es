package com.djp.common.service;

import com.djp.common.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */
public interface UserService {
    List<String> findRoles(User user);

    List<String> findPermissions(User user);

    User findByUsername(String username);
}
