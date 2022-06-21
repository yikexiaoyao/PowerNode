package com.bjpowernode.test;

import com.bjpowernode.bean.Order;
import com.bjpowernode.service.GoodService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cty
 * @date 2021/12/3 21:03
 */
public class TestConsumer {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("consumer.xml");
        GoodService goodService = (GoodService) beanFactory.getBean("goodService");
        Order order = goodService.buyGood(1, "宝马", 1000d, 3);
        System.out.println(order);
    }
}
