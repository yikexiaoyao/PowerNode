package com.bjpowernode.controller;

import com.bjpowernode.GoodService;
import com.bjpowernode.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cty
 * @date 2021/12/6 9:50
 */
@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("/buy")
    @ResponseBody
    public Order buy(Integer userId, String goodsName, Double price, Integer amount){
        return goodService.buyGood(userId, goodsName, price, amount);
    }

}
