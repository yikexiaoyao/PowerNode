package com.bjpowernode.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author cty
 * @date 2021/11/15 21:12
 */
public class MD5Realm extends AuthorizingRealm {

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1、现获取用户输入的身份
        Object principal = token.getPrincipal();

        //2、查询数据库校验身份是否合法 查询数据库过程省略
        String result = "123";
        if (result == null) {
            throw new UnknownAccountException();
        }

        //3、从查询出来的结果 正确的凭证，正确的盐
        String correctCredential = "ea570d329247cefd39ffe1058e6d76b9";
        String salt = "haha";
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, correctCredential, ByteSource.Util.bytes(salt), "md5Realm");
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
