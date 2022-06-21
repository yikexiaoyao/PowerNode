package com.bjpowernode.springboot_springmvc.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cty
 * @date 2021/12/12 14:35
 */
@RestController
public class RESTfulController {
    /**
     * 添加学生
     * 请求地址：http://localhost:9401/springboot_springmvc/student/{name}/{age}
     * 请求方式：POST
     * @param name
     * @param age
     * @return
     */
    @PostMapping("/student/{name}/{age}")
    public Object addStudent(@PathVariable("name") String name,
                             @PathVariable("age") Integer age) {
        Map<String, Object> stuMap = new HashMap<>();
        stuMap.put("name", name);
        stuMap.put("age", age);
        return stuMap;
    }

    /**
     * 删除学生
     * 请求地址：http://localhost:9401/springboot_springmvc/student/{id}
     * 请求方式：DELETE
     * @param id
     * @return
     */
    @DeleteMapping("/student/{id}")
    public Object removeStudent(@PathVariable("id") Integer id) {
        return "删除的学生id为：" + id;
    }

    /**
     * 修改学生
     * 请求地址：http://localhost:9401/springboot_springmvc/student/{id}
     * 请求方式：PUT
     * @param id
     * @return
     */
    @PutMapping("/student/{id}")
    public Object modifyStudent(@PathVariable("id") Integer id) {
        return "修改的学生id为：" + id;
    }

    /**
     * 查询学生
     * 请求地址：http://localhost:9401/springboot_springmvc/student/{id}
     * 请求方式：GET
     * @param id
     * @return
     */
    @GetMapping("/student/{id}")
    public Object queryStudent(@PathVariable("id") Integer id) {
        return "查询的学生id为：" + id;
    }
}
