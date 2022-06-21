package com.bjpowernode.springboot_springmvc.Controller;

/**
 * @author cty
 * @date 2021/12/12 14:59
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * query1和query2两个请求路径会发生请求路径冲突问题
 * query3与query1和query2发生请求不冲突
 * 注意：虽然两个路径写法改变了，但是由于传递的两个参数都是int值，所以不知道该交给哪个请求进行处理
 *      就会出现匹配模糊不清的异常，所以要想解决冲突，有两种方式：
 *      1.修改请求路径
 *      2.修改请求方式
 */
@RestController
public class RESTfulController2 {
    /**
     * id:订单标识
     * status：订单状态
     * 请求路径：http://localhost:9401/springboot_springmvc/order/{id}/{status}
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/order/{id}/{status}")
    public Object queryOrder(@PathVariable("id") Integer id,
                           @PathVariable("status") String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        return map;
    }

    /**
     * id:订单标识
     * status：订单状态
     * 请求路径：http://localhost:9401/springboot_springmvc/{id}/order/{status}
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/{id}/order/{status}")
    public Object queryOrder1(@PathVariable("id") Integer id,
                              @PathVariable("status") String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        return map;
    }

    /**
     * id:订单标识
     * status：订单状态
     * 请求路径：http://localhost:9401/springboot_springmvc/order/{status}/{id}
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/order/{status}/{id}")
    public Object queryOrder2(@PathVariable("id") Integer id,
                              @PathVariable("status") String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        return map;
    }

    /**
     * id:订单标识
     * status：订单状态
     * 请求路径：http://localhost:9401/springboot_springmvc/{status}/order/{id}
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/{status}/order/{id}")
    public Object queryOrder3(@PathVariable("id") Integer id,
                              @PathVariable("status") String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        return map;
    }
}
