package com.bjpowernode.service;

import com.bjpowernode.bean.Order;

/**
 * @author cty
 * @date 2021/12/3 20:42
 */
public interface OrderService {
    Order addOrder(Integer userId, String goodName, Double price, Integer amount);
}
