package com.bjpowernode.springboot_servlet_filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/12/13 11:11
 */
@WebServlet(name = "MyServlet", urlPatterns = "/MyServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("-----MyServlet----doGet---");
        resp.getWriter().write("I only have eyes for you");
    }
}
