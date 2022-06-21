package com.bjpowernode.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.bjpowernode.bean.Activity;
import com.bjpowernode.bean.User;
import com.bjpowernode.util.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @author cty
 * @date 2021/11/23 16:10
 */
public class TestRedis {
    Jedis jedis = RedisUtil.getJedis();

    //测试string类型
    @Test
    public void test01() {

        jedis.select(0);
        jedis.set("name", "李梅");

        Long location = jedis.incr("location");

        System.out.println(location);
    }

    //测试hash类型
    @Test
    public void test02() {

        jedis.select(1);
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "旺财");
        data.put("age", "10");
        data.put("color", "红色");
        jedis.hmset("dog:1", data);
    }

    //测试hash类型存储对象
    @Test
    public void test03() {

        jedis.select(1);
        User user = new User();
        user.setUsername("王美玲");
        user.setPassword("333");
        user.setAge("20");

        //把对象转换成Map
        Map<String, Object> map = new HashMap<String, Object>();
        BeanUtil.beanToMap(user, map, false, true);
        Map<String, String> data = new HashMap<String, String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            data.put(entry.getKey(), entry.getValue() + "");
        }
        jedis.hmset("u:1", data);
    }

    //测试工具类 dbToRedis
    @Test
    public void test04() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setName("活动调查1");
        activity1.setCreateBy("张三1");

        Activity activity2 = new Activity();
        activity2.setName("活动调查2");
        activity2.setCreateBy("张三2");

        Activity activity3 = new Activity();
        activity3.setName("活动调查3");
        activity3.setCreateBy("张三3");

        activities.add(activity1);
        activities.add(activity2);
        activities.add(activity3);

        RedisUtil.dbToRedis(jedis, 10, "activity:", activities);
    }


    //测试从Redis中读取数据，把数据封装成对象
    @Test
    public void test05() {
        jedis.select(10);
        //取出满足条件所有的key
        Set<String> keys = jedis.keys("activity:*");

        List<Activity> activities = new ArrayList<Activity>();
        for (String key : keys) {
            Map<String, String> map = jedis.hgetAll(key);

            //把Map转换成对象
            Activity activity = BeanUtil.mapToBean(map, Activity.class, false, new CopyOptions().ignoreNullValue());
            activities.add(activity);
        }
        System.out.println(activities);

    }

    //测试工具类
    @Test
    public void test06() {
        List<Activity> activities = RedisUtil.redisToJava(jedis, 10, "activity:*", Activity.class);

        System.out.println(activities);
    }
}
