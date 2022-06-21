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
 * @date 2021/9/13 11:49
 */
@WebServlet(name = "app2", urlPatterns = "/app2")
public class App2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("app2 servlet doGet ...");

        //读取cookie
        Cookie[] cookies = req.getCookies();
        //便利cookie数组
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String key = cookie.getName();
                String value = cookie.getValue();
                System.out.println(key + ":" + value);
            }
        }
    }
}
