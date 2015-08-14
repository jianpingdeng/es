package com.djp.common.service.impl;

import com.djp.common.core.BaseDao;
import com.djp.common.dao.IUserDao;
import com.djp.common.entity.User;
import com.djp.common.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource(name = "userDao")
    private IUserDao userDao;
    public Set<String> findRoles(String username) {
     return null;
    }

    public Set<String> findPermissions(String username) {
       return null;
    }

    public User findByUsername(String username) {
        User user = userDao.selectUserByUsername(username);
        return user;
}
}
