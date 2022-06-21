package com.bjpowernode.springboot_servlet_filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/12/13 11:11
 */
@WebFilter(filterName = "MyFilter", urlPatterns = "*.do")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("----MyFilter---doFilter-----");
        chain.doFilter(req, resp);
        resp.getWriter().write("you complete me");
    }

    @Override
    public void destroy() {

    }
}
