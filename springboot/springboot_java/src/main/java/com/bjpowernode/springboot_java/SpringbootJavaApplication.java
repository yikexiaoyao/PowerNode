package com.bjpowernode.springboot_java;

import com.bjpowernode.springboot_java.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootJavaApplication {

    public static void main(String[] args) {
        /**
         * SpringBoot程序启动后，返回值是ConfigurableApplicationContext，它也是一个Spring容器对象
         * 它其它相当于原来Spring中启动容器ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("");
         */

        ConfigurableApplicationContext context = SpringApplication.run(SpringbootJavaApplication.class, args);
        UserServiceImpl userServiceImpl =(UserServiceImpl) context.getBean("userServiceImpl");
        System.out.println(userServiceImpl.sayBye());;
    }

}
