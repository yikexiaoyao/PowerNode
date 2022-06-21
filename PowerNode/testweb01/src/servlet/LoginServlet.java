package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author cty
 * @date 2021/9/10 11:58
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login servlet doGet ...");

        //获取请求行中的内容
        String method = req.getMethod();
        String protocol = req.getProtocol();
        String url = req.getRequestURL().toString();
        String uri = req.getRequestURI();
        System.out.println("method=" + method);
        System.out.println("protocol=" + protocol);
        System.out.println("url=" + url);
        System.out.println("uri=" + uri);

        System.out.println("----------分割线----------");

        String head = req.getHeader("Accept");
        System.out.println("Accept=" + head);

        System.out.println("----------分割线----------");

        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + ":" + headerValue);
        }

        System.out.println("----------分割线----------");

        String path = req.getContextPath();
        System.out.println("path=" + path);

        System.out.println("----------分割线----------");

        //使用通用的方式获取请求参数
        req.setCharacterEncoding("utf-8");
        String user = req.getParameter("username");
        String pwd = req.getParameter("password");
        String[] aihao = req.getParameterValues("aihao");
        System.out.println("账号:" + user);
        System.out.println("密码:" + pwd);
        System.out.println("爱好:" + Arrays.toString(aihao));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login servlet doPost ...");

        //使用重定向返回网页
        //resp.setStatus(302);
        //resp.setHeader("Location", "/part03/success.html");
        //简单的方式实现重定向
        //resp.sendRedirect(req.getContextPath() + "/success.html");
        //resp.sendRedirect("https://www.taobao.com");
        resp.sendRedirect(req.getContextPath() + "/app");
    }
}
