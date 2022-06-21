package com.bjpowernode;

/**
 * @author cty
 * @date 2021/12/6 10:02
 */
public interface OrderService {
    Order addOrder(Integer userId, String goodsName, Double price, Integer amount);
}
