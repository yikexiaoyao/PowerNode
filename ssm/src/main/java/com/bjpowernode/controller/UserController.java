package com.bjpowernode.controller;

import com.bjpowernode.entity.User;
import com.bjpowernode.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * @author cty
 * @date 2021/10/12 10:30
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("list")
    List<User> list() {
        List<User> list = userService.list();
        return list;
    }

    @RequestMapping("add")
    void add() {

    }

    @RequestMapping("save")
    String save(User user) {
        userService.save(user);
        return "redirect:list";
    }

    @RequestMapping("edit")
    void edit(User user) {
        User userDB = userService.get(user.getUserId());
        BeanUtils.copyProperties(userDB, user);
    }

    @RequestMapping("saveUpdate")
    String saveUpdate(User user) {
        userService.update(user);
        return "redirect:list";
    }

    @RequestMapping("delete")
    String delete(int userId) {
        userService.delete(userId);
        return "redirect:list";
    }

    @RequestMapping("search")
    List<User> search(User user) {
        return userService.search(user);
    }

    @RequestMapping("delBatch")
    String delBatch(@RequestParam Set<Integer> userIds) {
        userService.delBatch(userIds);
        return "redirect:list";
    }
}
