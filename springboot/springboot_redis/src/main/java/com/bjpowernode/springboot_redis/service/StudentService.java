package com.bjpowernode.springboot_redis.service;

/**
 * @author cty
 * @date 2021/12/12 16:24
 */
public interface StudentService {
    /**
     * 获取学生总人数
     * @return
     */
    Long queryAllStudentCount();
}
