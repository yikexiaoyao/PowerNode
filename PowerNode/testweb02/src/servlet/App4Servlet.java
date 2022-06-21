package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/13 17:09
 */
@WebServlet(name = "session1", urlPatterns = "/session1")
public class App4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("app4 servlet doGet ...");

        //session的获取
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        //session的有效期
        session.invalidate();
        session.setMaxInactiveInterval(60);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        //设置cookie的存活时间，将cookie保存在文件中
        cookie.setMaxAge(60*30);
        resp.addCookie(cookie);
    }
}
