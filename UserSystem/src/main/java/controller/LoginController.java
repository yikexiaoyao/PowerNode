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
public class LoginController {

    public static final String LOGIN_USER = "LoginUser";

    @Autowired
    IUserService userService;

    @RequestMapping("login")
    void login() {

    }

    @RequestMapping("saveLogin")
    String saveLogin(User user, HttpSession session) {
        User userDB = userService.getByUserName(user.getUserName());
        if (userDB != null && user.getUserPwd().equals(userDB.getUserPwd())) {
            session.setAttribute(LOGIN_USER, userDB);
            return "redirect:index";
        } else {
            user.setMsg("登录失败,用户名或密码无效");
            return "login";
        }
    }

    @RequestMapping("logout")
    String logout(HttpSession session) {
        session.removeAttribute(LOGIN_USER);
        return "redirect:login";
    }
}
