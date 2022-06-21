package com.bjpowernode.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;

/**
 * @author cty
 * @date 2021/11/27 15:26
 */
public class RedisUtil {
    public static Jedis getJedis(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(100);
        JedisPool jedisPool =
                new JedisPool(config,"192.168.129.101",6379,1000,"123456");
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    /**
     *
     * @param jedis
     * @param index:库的索引
     * @param keyPattern:存储对象的key
     * @param data:实际的数据
     * @param <T>
     */
    //把数据库数据存储到Redis中
    public static <T> void dbToRedis(Jedis jedis, int index, String keyPattern, List<T> data){
        //选库
        jedis.select(index);

        for (T t : data) {
            String key = keyPattern + jedis.incr(keyPattern.replace(":", "") + "Index");
            Map<String,Object> map = new HashMap<String, Object>();
            BeanUtil.beanToMap(t,map,false, true);
            Map<String,String> map2 = new HashMap<String, String>();
            mapToMap(map,map2);
            jedis.hmset(key,map2);
        }

    }
    //把数据库数据存储到Redis中
    public static <T> void dbToRedis(Jedis jedis, int index, String keyPattern,T data){
        //选库
        jedis.select(index);

        Map<String,Object> map = new HashMap<String, Object>();
        BeanUtil.beanToMap(data,map,false, true);
        Map<String,String> map2 = new HashMap<String, String>();
        mapToMap(map,map2);
        jedis.hmset(keyPattern,map2);

    }

    //Map<String,Object>转换成Map<String,String>
    public static void mapToMap(Map<String,Object> map1,Map<String,String> map2){
        for(Map.Entry<String,Object> entry : map1.entrySet()){
            map2.put(entry.getKey(), entry.getValue() + "");
        }
    }

    //把Redis中数据查询出来封装到对象中
    public static <T> List<T> redisToJava(Jedis jedis, int index, String keyPattern, Class<T> tClass){
        jedis.select(index);
        //匹配满足条件的key
        Set<String> keys = jedis.keys(keyPattern);

        List<T> beans = new ArrayList<T>();
        for (String key : keys) {
            Map<String, String> map = jedis.hgetAll(key);

            //把Map转换成Bean对象
            T t = BeanUtil.mapToBean(map, tClass, false, new CopyOptions().ignoreNullValue());
            beans.add(t);
        }
        return beans;
    }
}
