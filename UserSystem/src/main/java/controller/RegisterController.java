package controller;

import entity.User;
import model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author cty
 * @date 2021/10/15 15:40
 */
@Controller
public class RegisterController {

    @Autowired
    IUserService userService;

    @RequestMapping("register")
    void register() {

    }

    @RequestMapping("saveRegister")
    String saveRegister(User user, HttpSession session) {
        userService.save(user);
        //注册完成后直接就是登录状态
        session.setAttribute(controller.LoginController.LOGIN_USER, user);
        return "redirect:/index";
    }
}
