package com.bjpowernode.dataservice;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bjpowernode.dataservice.mapper")
@EnableDubboConfiguration
public class DataserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataserviceApplication.class, args);
    }

}
