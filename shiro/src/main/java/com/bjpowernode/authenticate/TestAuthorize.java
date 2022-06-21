package com.bjpowernode.authenticate;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Test;

/**
 * @author cty
 * @date 2021/11/16 17:26
 */
public class TestAuthorize {
    @Test
    public void test01() {
        //创建“SecurityFactory”，加载ini文件配置，并通过它创建SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:authorize/shiro-authorize.ini");

        //获取shiro核心：SecurityManager
        SecurityManager securityManager = factory.getInstance();

        //将SecurityManager托管到SecurityUtils工具类中（ops：之后可以不关注SecurityManager）
        SecurityUtils.setSecurityManager(securityManager);

        //subject作用：直接由用户使用，调用功能简单，底层调用SecurityManager相关流程
        Subject subject = SecurityUtils.getSubject();

        //通过subject身份认证
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
        //登录
        subject.login(token);

        //通过subject获取当前用户的登录状态
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);

        //检查权限
        try {
            subject.checkPermission("activity:update");
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }
    }
}
