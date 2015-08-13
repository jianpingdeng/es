package com.djp.common.service.impl;

import com.djp.common.dao.UserDao;
import com.djp.common.entity.User;
import com.djp.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public Set<String> findRoles(String username) {
        User user = new User();
        user.setUsername(username);
        return userDao.findRoles(user);
    }

    public Set<String> findPermissions(String username) {
        User user = new User();
        user.setUsername(username);
        return userDao.findPermissions(user);
    }

    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
       return userDao.findByUsername(user);
    }
}
