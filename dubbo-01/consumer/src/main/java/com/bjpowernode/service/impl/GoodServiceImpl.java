package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Order;
import com.bjpowernode.service.GoodService;
import com.bjpowernode.service.OrderService;

/**
 * @author cty
 * @date 2021/12/3 21:01
 */
public class GoodServiceImpl implements GoodService {

    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Order buyGood(Integer userId, String goodName, double price, Integer amount) {
        return orderService.addOrder(userId, goodName, price, amount);
    }
}
