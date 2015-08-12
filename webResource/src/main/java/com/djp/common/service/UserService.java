package com.djp.common.service;

import com.djp.common.entity.User;

import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */
public interface UserService {
    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    User findByUsername(String username);
}
