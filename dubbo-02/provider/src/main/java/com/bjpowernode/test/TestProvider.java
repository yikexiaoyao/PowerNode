package com.bjpowernode.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * @author cty
 * @date 2021/12/6 9:25
 */
public class TestProvider {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("provider.xml");

        //阻塞式方法
        //((ClassPathXmlApplicationContext) beanFactory).start();
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
