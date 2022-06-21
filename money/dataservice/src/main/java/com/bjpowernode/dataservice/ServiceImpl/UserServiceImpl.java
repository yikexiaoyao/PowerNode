package com.bjpowernode.dataservice.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.dataservice.mapper.FinanceAccountMapper;
import com.bjpowernode.dataservice.mapper.UserMapper;
import com.bjpowernode.exterface.model.FinanceAccount;
import com.bjpowernode.exterface.model.User;
import com.bjpowernode.exterface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 用户业务实现类
 *
 * @author cty
 * @date 2021/12/15 17:50
 */
@Service(interfaceClass = UserService.class, version = "1.0.0", retries = 3, timeout = 20000)
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    FinanceAccountMapper financeAccountMapper;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 平台用户数:注册总人数
     */
    @Override
    public Integer getUserCount() {
        Integer count = (Integer) redisTemplate.opsForValue().get("count");
        if (count == null) {
            count = userMapper.getCount();
            redisTemplate.opsForValue().set("count", count, 50, TimeUnit.SECONDS);
        }
        return count;
    }

    /**
     * 注册：验证手机号码是否被注册
     */
    @Override
    public Boolean checkPhone(String phone) {
        Integer count = userMapper.getUserCountByPhone(phone);
        if (count == null || count == 0) {
            return true;
        }
        return false;
    }

    /**
     * 注册：获取验证码
     */
    @Override
    public String pop(String phone) {
        return (String) redisTemplate.opsForValue().get(phone);
    }

    /**
     * 注册：注册
     */
    @Override
    public User register(String phone, String loginPassword) {
        User user = new User();
        user.setPhone(phone);
        user.setLoginPassword(loginPassword);
        user.setAddTime(new Date());

        int num = userMapper.insertSelective(user);
        if (num == 1) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //送大礼
                    FinanceAccount financeAccount = new FinanceAccount();
                    financeAccount.setAvailableMoney(888d);
                    financeAccount.setUid(user.getId());
                    financeAccountMapper.insertSelective(financeAccount);
                }
            }).start();
            return user;
        }
        return null;
    }

    /**
     * 注册：放入验证码
     */
    @Override
    public void push(String phone, String code) {
        redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
    }

    /**
     * 实名认证：更新用户名和身份证
     */
    @Override
    public int member(User user1) {
        return userMapper.updateByPrimaryKeySelective(user1);
    }

    /**
     * 登录
     */
    @Override
    public User login(String phone, String loginPassword) {
        User user = userMapper.getUserByPhoneAndPassword(phone, loginPassword);
        if (user != null) {
            //设置最后一次登录时间
            user.setLastLoginTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }
}
