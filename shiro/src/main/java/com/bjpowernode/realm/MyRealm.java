package com.bjpowernode.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author cty
 * @date 2021/11/15 21:16
 */
public class MyRealm extends AuthorizingRealm {

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1、获取用户输入的身份 principal:zhangsan
        Object principal = authenticationToken.getPrincipal();

        //2、查询数据库过程，此处省略
        String result = "abc";
        if (result == null) {
            throw new UnknownAccountException();
        }

        //3、校验凭证 获取查询出来的正确的凭证
        String correctCredential = "123";
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, correctCredential, "myRealm");
        return simpleAuthenticationInfo;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
