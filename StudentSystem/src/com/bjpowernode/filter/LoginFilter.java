package com.bjpowernode.filter;

import com.bjpowernode.constant.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/17 16:04
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将请求转换为HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获取访问资源的URI
        String uri = req.getRequestURI();
        //设置无需登录访问的资源集合
        String[] urls = {"/StudentSystem/", "/StudentSystem/login.jsp", "/StudentSystem/index.jsp","/StudentSystem/register.jsp", "/StudentSystem/user"};
        //默认需要登录
        boolean flag = true;
        //遍历数组，判断资源是否需要登录
        for (String url : urls) {
            if (url.equals(uri)) {
                flag = false;
                break;
            }
        }
        //根据状态绝对校验
        if (flag) {
            //获取用户信息
            HttpSession session = req.getSession();
            Object user = session.getAttribute(Constant.USER_INFO);
            //判断账号存在情况
            if (user == null) {
                //没有登录。重定向到登录页面
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            } else {
                //登录，直接放行
                filterChain.doFilter(req, resp);
            }
        } else {
            //无需登录，直接放行
            filterChain.doFilter(req, resp);
        }
    }
}
