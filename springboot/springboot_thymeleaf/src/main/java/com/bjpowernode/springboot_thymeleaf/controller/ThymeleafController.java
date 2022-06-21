package com.bjpowernode.springboot_thymeleaf.controller;

import com.bjpowernode.springboot_thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author cty
 * @date 2021/12/13 11:59
 */
@Controller
public class ThymeleafController {
    /**
     * http://localhost:9701/springboot_thymeleaf/thymeleaf/index
     */
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model) {

        model.addAttribute("data", "恭喜您，SpringBoot集成Thymeleaf成功");

        return "index";
    }

    /**
     * http://localhost:9701/springboot_thymeleaf/expression/user
     */
    @RequestMapping(value = "/expression/user")
    public String user(Model model) {
        User user = new User();

        user.setId(100);
        user.setPhone("13700000000");
        user.setNick("张三");
        user.setAddress("北京市亦庄");

        model.addAttribute("user", user);

        return "user";
    }

    /**
     * http://localhost:9701/springboot_thymeleaf/expression/url
     */
    @RequestMapping(value = "/expression/url")
    public String url(Model model) {
        User user = new User();

        user.setId(100);
        user.setPhone("13700000000");
        user.setNick("张三");
        user.setAddress("北京市亦庄");

        model.addAttribute("user", user);

        return "url";
    }

    @RequestMapping(value = "/expression/common")
    public String common(Model model, String sname) {
        // System.out.println("sname:"+sname);
        User user = new User();

        user.setId(100);
        user.setPhone("13700000000");
        user.setNick("张三");
        user.setAddress("北京市亦庄");

        model.addAttribute("user", user);

        return "common";
    }

    @RequestMapping("/each/list")
    public String eachList(Model model) {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(100 + i);
            user.setNick("张" + i);
            user.setPhone("1361234567" + i);
            user.setAddress("北京市大兴区" + i);
            userList.add(user);
        }
        model.addAttribute("userList", userList);

        return "each";
    }


    @RequestMapping("/each/set")
    public String eachSet(Model model) {
        Set<User> userSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(100 + i);
            user.setNick("张" + i);
            user.setPhone("1361234567" + i);
            user.setAddress("北京市大兴区" + i);
            userSet.add(user);
        }
        model.addAttribute("userSet", userSet);

        return "each";
    }

    @RequestMapping(value = "/each/map")
    public String eachMap(Model model) {

        Map<Integer, Object> userMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(100 + i);
            user.setNick("张" + i);
            user.setPhone("1370000000" + i);
            user.setAddress("北京市大兴区" + i);

            userMap.put(i, user);
        }
        model.addAttribute("userMap", userMap);

        return "each";
    }


    @RequestMapping(value = "/condition")
    public String condition(Model model) {
        model.addAttribute("sex", 1);
        return "condition";
    }

    @RequestMapping(value = "/expression/inline")
    public String inline(Model model, String sname) {

        User user = new User();

        user.setId(100);
        user.setPhone("13700000000");
        user.setNick("张三");
        user.setAddress("北京市亦庄");

        model.addAttribute("user", user);

        return "inline";
    }


    @RequestMapping(value = "/expression/literal")
    public String literal(Model model, String sname) {

        User user = new User();

        user.setId(100);
        user.setPhone("13700000000");
        user.setNick("张三");
        user.setAddress("北京市亦庄");

        model.addAttribute("user", user);
        model.addAttribute("cunPage", 20);
        model.addAttribute("totalPage", 258);
        model.addAttribute("sex", "1");

        return "literal";
    }


    @RequestMapping(value = "/expression/scope")
    public String scope(Model model, String sname, HttpServletRequest request) {

        User user = new User();

        user.setId(100);
        user.setPhone("13700000000");
        user.setNick("张三");
        user.setAddress("北京市亦庄");

        model.addAttribute("user", user);
        model.addAttribute("cunPage", 20);
        model.addAttribute("totalPage", 258);
        model.addAttribute("sex", "1");
        request.getSession().setAttribute("birthday", new Date());
        request.setAttribute("salary", 123456.4567898);

        return "scope";
    }
}
