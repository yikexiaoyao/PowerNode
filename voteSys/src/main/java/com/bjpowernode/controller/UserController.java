package com.bjpowernode.controller;

import com.bjpowernode.bean.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author cty
 * @date 2021/11/27 15:31
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public String login(User user, HttpSession session) {
        user = userService.login(user);
        if (user != null) {
            session.setAttribute("user", user);
            //查询所有文章数
            return "forward:/";
        }
        return "index";
    }
}
