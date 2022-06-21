package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/13 11:26
 */
@WebServlet(name = "app1", urlPatterns = "/app1")
public class App1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("app1 servlet doGet ...");

        //创建cookie对象
        Cookie cookie1 = new Cookie("user", "admin");
        Cookie cookie2 = new Cookie("pwd", "123456");
        //设置cookie，单位（秒）
        cookie1.setMaxAge(60);
        cookie2.setMaxAge(60);
        //将cookie使用响应发送到客户端
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
