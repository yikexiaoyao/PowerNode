package com.bjpowernode.controller;

import com.bjpowernode.bean.Permission;
import com.bjpowernode.bean.Role;
import com.bjpowernode.bean.User;
import com.bjpowernode.service.RoleService;
import com.bjpowernode.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //处理认证失败反馈给客户端
    @RequestMapping("/user/login")
    public String login(HttpServletRequest request){
        String exceptionPath = (String) request.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equals(exceptionPath)){
            request.setAttribute("message", "账号错误");
        }else if(IncorrectCredentialsException.class.getName().equals(exceptionPath)){
            request.setAttribute("message", "密码错误");
        }
        return "forward:/login.jsp";
    }


    //认证成功，跳转到后台首页
    @RequestMapping("/user/toIndex")
    public String toIndex(HttpSession session, Model model){
        //当前主体对象
        Subject subject = SecurityUtils.getSubject();
        //获取用户身份
        User user = (User) subject.getPrincipal();
        session.setAttribute("user",user);

        //查询用户的菜单权限
        List<Permission> menus = userService.queryMenus(user);
        model.addAttribute("menus", menus);
        return "workbench/index";
    }
}
