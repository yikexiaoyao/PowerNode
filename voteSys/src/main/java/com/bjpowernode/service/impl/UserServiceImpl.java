package com.bjpowernode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.bjpowernode.bean.User;
import com.bjpowernode.service.UserService;
import com.bjpowernode.util.RedisUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * @author cty
 * @date 2021/11/27 15:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User login(User user) {
        Jedis jedis = RedisUtil.getJedis();
        //选址Redis 14数据库
        jedis.select(14);
        //查询所有满足条件的用户key
        Set<String> keys = jedis.keys("user:*");
        for (String key : keys) {
            //取出key对应的用户对象的所有属性名和属性值
            Map<String, String> map = jedis.hgetAll(key);
            User user1 = BeanUtil.mapToBean(map, User.class, false, new CopyOptions().ignoreNullValue());
            if (user.getUsername().equals(user1.getUsername()) && user.getPassword().equals(user1.getPassword())) {
                return user1;
            }
        }
        return null;
    }
}
