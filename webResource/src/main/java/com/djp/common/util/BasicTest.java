package com.djp.common.util;

import com.djp.common.core.BaseDao;
import com.djp.common.entity.User;
import com.djp.common.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * Created by dengjianping on 2015/8/13.
 */
public class BasicTest extends BaseDao {
    private UserService userService;
    @Before
    public void init() {
        ApplicationContext aCtx = new FileSystemXmlApplicationContext(
                "classpath:applicationContext.xml");
        userService = (UserService)aCtx.getBean("userService");
        assertNotNull(userService);
    }

    @Test
    public void domain(){
        User user = userService.findByUsername("admin");
        System.out.printf("user:"+user.getPassword());
    }
}
