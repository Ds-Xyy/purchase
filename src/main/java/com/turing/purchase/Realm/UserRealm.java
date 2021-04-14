package com.turing.purchase.Realm;

import com.turing.purchase.entity.SysUsers;
import com.turing.purchase.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class UserRealm  extends AuthorizingRealm {

    @Autowired
      UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证开始执行...");
        //获取令牌中的用户信息
        String principal = (String) token.getPrincipal();
//        从数据库查询
       SysUsers user=  userService.findByName(principal);


//        判断对象是否为空
        if(!ObjectUtils.isEmpty(user)){//不为空
            System.out.println("不为空");
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassWord(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
        return null;
    }
}