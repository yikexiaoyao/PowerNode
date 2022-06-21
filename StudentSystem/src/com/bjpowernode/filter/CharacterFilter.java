package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/17 16:09
 */
public class CharacterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将请求转换为HttpServletRequest
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        //设置字符集
        req.setCharacterEncoding("utf-8");
        //放行
        filterChain.doFilter(req, servletResponse);
    }
}
