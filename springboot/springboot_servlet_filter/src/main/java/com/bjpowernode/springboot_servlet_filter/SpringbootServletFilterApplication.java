package com.bjpowernode.springboot_servlet_filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.bjpowernode.springboot_servlet_filter")
public class SpringbootServletFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServletFilterApplication.class, args);
    }

}
