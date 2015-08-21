package com.djp.common.shiro.realm;

import com.djp.common.entity.User;
import com.djp.common.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dengjianping on 2015/8/12.
 */
public class ShiroJDBCRealm extends AuthorizingRealm {
    private Log log = LogFactory.getLog(ShiroJDBCRealm.class);
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = userService.findByUsername(username);
        Set<String> roles = new HashSet<String>();
        roles.addAll(userService.findRoles(user));
        authorizationInfo.setRoles(roles);
        Set<String> permissions = new HashSet<String>();
        permissions.addAll(userService.findPermissions(user));
        authorizationInfo.setStringPermissions(permissions);
        System.out.println("�����û�Ȩ�ޣ�"+Arrays.toString(permissions.toArray()));
        System.out.println("���ؽ�ɫ��"+ Arrays.toString(roles.toArray()));
        log.debug("�û�Ȩ�ޣ�" + permissions);
        log.debug("�û�Ȩ�ޣ�"+roles);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.findByUsername(username);
        if(user == null) throw new UnknownAccountException();//û�ҵ��ʺ�
        if(user.getLocked()==0) throw new LockedAccountException();//�˻�����

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName());

        return authenticationInfo;
    }
}
