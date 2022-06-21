package com.bjpowernode.exterface.service;

import com.bjpowernode.exterface.model.User;

/**
 * 用户业务接口
 *
 * @author cty
 * @date 2021/12/15 17:44
 */
public interface UserService {
    /**
     * 平台用户数:注册总人数
     */
    Integer getUserCount();

    /**
     * 利用手机号查询用户数是否存在
     */
    Boolean checkPhone(String phone);

    /**
     * 注册：获取验证码
     */
    String pop(String phone);

    /**
     * 注册：注册
     */
    User register(String phone, String loginPassword);

    /**
     * 注册：放入验证码
     */
    void push(String phone, String code);

    /**
     * 实名认证：更新用户名和身份证
     */
    int member(User user1);

    /**
     * 登录
     */
    User login(String phone, String loginPassword);
}
