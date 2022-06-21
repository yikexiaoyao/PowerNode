package com.bjpowernode.service.impl;

import com.bjpowernode.*;

/**
 * @author cty
 * @date 2021/12/6 9:51
 */
public class GoodServiceImpl implements GoodService {
    private OrderService orderService;

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Order buyGood(Integer userId, String goodsName, Double price, Integer amount) {
        User user = userService.getInfo();
        Order order = orderService.addOrder(userId, goodsName, price, amount);
        order.setUser(user);
        return order;
    }
}
