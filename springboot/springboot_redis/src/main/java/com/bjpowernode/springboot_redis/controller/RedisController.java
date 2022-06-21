package com.bjpowernode.springboot_redis.controller;

import com.bjpowernode.springboot_redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cty
 * @date 2021/12/12 16:23
 */
@RestController
public class RedisController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/allStudentCount")
    private Object allStudentCount(HttpServletRequest request) {
        //初始化学生总人数
        long allStudentCount = 71;

        //线程池：线程数量最好是你的cpu数量倍数
        ExecutorService executorService = Executors.newFixedThreadPool(16);

        //模拟1000人并发
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    studentService.queryAllStudentCount();
                }
            });
        }

        return "学生总人数：" + allStudentCount;
    }

}
