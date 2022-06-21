package com.bjpowernode.springboot_redis.service;

import com.bjpowernode.springboot_redis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author cty
 * @date 2021/12/12 16:35
 */
@Service
public class StudentServiceImpl implements com.bjpowernode.springboot_redis.service.StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Long queryAllStudentCount() {
        //从redis缓存中获取数据
        Long allStudentCount = (Long) redisTemplate.opsForValue().get("allStudentCount");
        if (allStudentCount == null) {
            synchronized (this) {
                allStudentCount = (Long) redisTemplate.opsForValue().get("allStudentCount");
                if (allStudentCount == null) {
                    //没有命中
                    System.out.println("----------查询数据库----------");
                    //查询数据
                    allStudentCount = studentMapper.selectAllStudentCount();
                    //放入缓存
                    redisTemplate.opsForValue().set("allStudentCount", allStudentCount, 20, TimeUnit.SECONDS);
                } else {
                    System.out.println("----------缓存命中----------");
                }
            }
        } else {
            System.out.println("----------缓存命中----------");
        }
        return allStudentCount;
    }
}
