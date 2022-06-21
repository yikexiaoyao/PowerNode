package com.bjpowernode.service.impl;

import com.bjpowernode.Order;
import com.bjpowernode.OrderService;
import com.bjpowernode.util.UUIDUtil;

/**
 * @author cty
 * @date 2021/12/6 9:27
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public Order addOrder(Integer userId, String goodsName, Double price, Integer amount) {
        Order order = new Order();
        order.setId(UUIDUtil.uuid());
        order.setGoodsName(goodsName);
        order.setPrice(price);
        order.setAmount(amount);

        return order;
    }
}
