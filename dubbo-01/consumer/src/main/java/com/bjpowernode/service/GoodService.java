package com.bjpowernode.service;

import com.bjpowernode.bean.Order;

/**
 * @author cty
 * @date 2021/12/3 20:59
 */
public interface GoodService {
    Order buyGood(Integer userId, String goodName, double price, Integer amount);
}
