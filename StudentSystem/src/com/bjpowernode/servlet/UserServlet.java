package com.bjpowernode.servlet;

import com.bjpowernode.service.UserService;
import com.bjpowernode.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author cty
 * @date 2021/9/15 13:56
 */
@WebServlet(name = "user", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //设置utf-8字符集
        req.setCharacterEncoding("utf-8");
        //获取请求参数method
        String method = req.getParameter("method");
        //根据参数值不同，调用不同的方法，分发请求
        if (method.equals("login")) {
            this.login(req, resp);
        }
        if (method.equals("register")) {
            this.register(req, resp);
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取请求参数
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        //根据业务层的方法返回结果
        boolean result = userService.checkUserAndPwd(user, pwd);
        //根据结果返回不同的页面
        if (result) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/student?method=mainUI");
        } else {
            req.setAttribute("msg", "账号或者密码不匹配");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取请求参数
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        //根据业务层的方法返回结果
        int result = userService.register(user, pwd);
        //根据结果返回不同的页面
        if (result == 1) {
            //注册成功，跳转登录页面
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } else if (result == -1) {
            //账号已存在，返回登录页面
            req.setAttribute("msg", "账号已存在");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if (result == 0) {
            //注册失败，返回注册页面
            req.setAttribute("msg", "注册失败，请重新注册");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

}
