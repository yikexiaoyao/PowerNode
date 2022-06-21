package com.bjpowernode.springboot_redis.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author cty
 * @date 2021/12/12 16:26
 */
@Repository
public interface StudentMapper {
    Long selectAllStudentCount();
}
