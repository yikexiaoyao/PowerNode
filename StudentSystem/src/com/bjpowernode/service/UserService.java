package com.bjpowernode.service;

/**
 * @author cty
 * @date 2021/9/15 14:03
 */

/*
 *  注册功能
 *  @ String user 账号
 *  @ String pass 密码
 *  @ return int  注册结果状态码   1  注册成功  0  账号重复   -1 注册失败
 *
 * */
public interface UserService {
    //根据账号密码查看是否匹配
    boolean checkUserAndPwd(String user, String pwd);
    //根据账号检测是否重复
    int register(String user, String pwd);
}
