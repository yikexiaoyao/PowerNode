package com.bjpowernode.authenticate;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Test;

/**
 * @author cty
 * @date 2021/11/15 21:11
 */
public class TestAuthenticate {
    //默认的Realm完成认证
    @Test
    public void test01() {
        //1、读取配置文件，生成安全管理器工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:authenticate/shiro-authenticate.ini");

        //2、从工厂中取出安全管理器 单例模式，只有有一个SecurityManager
        SecurityManager securityManager = factory.getInstance();

        //3、把SecurityManager设置到环境变量中 等同于封装工具类
        SecurityUtils.setSecurityManager(securityManager);

        //4、获取主体对象 subject:用户
        Subject subject = SecurityUtils.getSubject();

        //5、认证
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");

        //登录
        subject.login(token);
        //通过subject获取当前用户的登录状态
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);

        //登出
        subject.logout();
        //通过subject获取当前用户的登录状态
        authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
    }

    //自定义的Realm完成认证
    @Test
    public void test02() {
        //1、读取配置文件，生成安全管理器工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:authenticate/shiro-realm.ini");

        //2、从工厂中取出安全管理器 单例模式，只有有一个SecurityManager
        SecurityManager securityManager = factory.getInstance();

        //3、把SecurityManager设置到环境变量中 等同于封装工具类
        SecurityUtils.setSecurityManager(securityManager);

        //4、获取主体对象 subject:用户
        Subject subject = SecurityUtils.getSubject();

        //5、认证
        UsernamePasswordToken token = new UsernamePasswordToken("myRealm", "123");

        //登录
        subject.login(token);
        //通过subject获取当前用户的登录状态
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);

        //登出
        subject.logout();
        //通过subject获取当前用户的登录状态
        authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
    }

    //Shiro中支持的常见加密算法
    @Test
    public void test03() {

        //md5(md5())
        //Md5Hash
        String credential = "123456";
        String salt = "wangwu";
        int hashIterations = 2;
        Md5Hash md5Hash = new Md5Hash(credential, salt, hashIterations);
        System.out.println(md5Hash);

        //SimpleHash algorithmName:指定加密的算法 md5、sha-1、base64
        String algorithmName = "SHA-1";
        SimpleHash simpleHash = new SimpleHash(algorithmName, credential, salt, hashIterations);
        System.out.println(simpleHash);
    }

    //自定义的Realm完成加密认证
    @Test
    public void test04() {
        //1、读取配置文件，生成安全管理器工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:authenticate/shiro-md5.ini");

        //2、从工厂中取出安全管理器 单例模式，只有有一个SecurityManager
        SecurityManager securityManager = factory.getInstance();

        //3、把SecurityManager设置到环境变量中 等同于封装工具类
        SecurityUtils.setSecurityManager(securityManager);

        //4、获取主体对象 subject:用户
        Subject subject = SecurityUtils.getSubject();

        //5、认证
        UsernamePasswordToken token = new UsernamePasswordToken("md5Realm", "555");

        //登录
        subject.login(token);
        //通过subject获取当前用户的登录状态
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);

        //登出
        subject.logout();
        //通过subject获取当前用户的登录状态
        authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
    }
}
