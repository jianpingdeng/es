package com.djp.common.service.impl;

import com.djp.common.dao.IUserDao;
import com.djp.common.entity.User;
import com.djp.common.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dengjianping on 2015/8/12.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource(name = "userDao")
    private IUserDao userDao;
    public List<String> findRoles(User user) {
     return userDao.findRoles(user);
    }

    public List<String> findPermissions(User user) {

        return userDao.findPermissions(user);
    }

    public User findByUsername(String username) {
        User user = userDao.selectUserByUsername(username);
        return user;
}
}
