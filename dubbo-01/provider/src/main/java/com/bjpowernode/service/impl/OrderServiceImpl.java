package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Order;
import com.bjpowernode.service.OrderService;

import java.util.UUID;

/**
 * @author cty
 * @date 2021/12/3 20:44
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public Order addOrder(Integer userId, String goodName, Double price, Integer amount) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString().replace("-", ""));
        order.setGoodName(goodName);
        order.setPrice(price);
        order.setAmount(amount);
        return order;
    }
}
