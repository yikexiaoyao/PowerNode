package com.bjpowernode.setting.service.impl;

import com.bjpowernode.base.exception.CrmEnum;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.DateTimeUtil;
import com.bjpowernode.base.util.MD5Util;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.mapper.UserMapper;
import com.bjpowernode.setting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author cty
 * @date 2021/10/24 22:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user, String code, String correctCode) {
        //ip
        String ip = user.getAllowIps();
        //密码加密
        user.setLoginPwd(MD5Util.getMD5(user.getLoginPwd()));
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("loginAct", user.getLoginAct())
                .andEqualTo("loginPwd", user.getLoginPwd());
        List<User> users = userMapper.selectByExample(example);

        //校验验证码是否正确
        if (!correctCode.equals(code)) {
            throw new CrmException(CrmEnum.USER_LOGIN_ERROR_CODE);
        }

        //用户输入的用户名和密码是否正确
        if (users.size() == 0) {
            //用户不存在或者用户名和密码输入错误
            throw new CrmException(CrmEnum.USER_LOGIN_USERNAME_PASSWORD);
        }

        //获取到用户名和账号输入正确的用户
        user = users.get(0);
        String expireTime = user.getExpireTime();
        String now = DateTimeUtil.getSysTime();
        if (expireTime.compareTo(now) < 0) {
            //账号失效了
            throw new CrmException(CrmEnum.USER_LOGIN_EXPIRED_TIME);
        }

        //账号被锁定
        if ("0".equals(user.getLockState())) {
            throw new CrmException(CrmEnum.USER_LOGIN_LOCKED_STATE);
        }

        //不允许登录的ip地址 ip1,ip2
        String allowIps = user.getAllowIps();
        if (!allowIps.contains(ip)) {
            throw new CrmException(CrmEnum.USER_LOGIN_ALLOWED_IP);
        }

        return user;
    }

    @Override
    public void verifyOldPwd(User user, String oldPwd) {
        String loginPwd = MD5Util.getMD5(oldPwd);
        if (!loginPwd.equals(user.getLoginPwd())) {
            throw new CrmException(CrmEnum.USER_UPDATE_PASSWORD);
        }
    }

    @Override
    public void updateUser(User user) {
        //密码加密
        user.setLoginPwd(MD5Util.getMD5(user.getLoginPwd()));
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count == 0) {
            throw new CrmException(CrmEnum.USER_UPDATE_INFO);
        }
    }
}
