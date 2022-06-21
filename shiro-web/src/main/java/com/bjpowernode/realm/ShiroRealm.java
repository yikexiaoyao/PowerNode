package com.bjpowernode.realm;

import com.bjpowernode.bean.Permission;
import com.bjpowernode.bean.User;
import com.bjpowernode.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();

        //查询数据库,先校验身份
        User user = userMapper.verifyPrincipal(principal);
        if(user == null){
            throw new UnknownAccountException();
        }

        //校验凭证
        //取出查询出来数据
        //取出正确的凭证
        String credential = user.getPassword();
        //取出盐
        String salt = user.getSalt();

        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(user, credential,
                        ByteSource.Util.bytes(salt), "shiroRealm");
        return simpleAuthenticationInfo;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //查询用户资源权限标识符，根据身份查询
        User user = (User) principals.getPrimaryPrincipal();

        List<Permission> permissions = userMapper.queryPermissions(user);

        //定义一个集合，存储权限资源表示
        List<String> permissonList = new ArrayList<>();
        for(Permission permission : permissions){
            permissonList.add(permission.getCode());
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissonList);
        return simpleAuthorizationInfo;
    }


}
