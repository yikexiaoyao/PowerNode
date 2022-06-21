package com.bjpowernode.base.interceptor;

import com.bjpowernode.base.util.CommonUtil;
import com.bjpowernode.setting.bean.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cty
 * @date 2021/11/12 14:46
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String uri = request.getRequestURI();

        //url:全球资源统一定位
        StringBuffer url = request.getRequestURL();*/

        //查看session中用户有没有登录
        HttpSession session = request.getSession();
        User currentUser =  CommonUtil.getCurrentUser(session);
        if(currentUser == null){
            //重定向到登录页面
            response.sendRedirect("/CRM/login.jsp");
        }
        return true;
    }

}
