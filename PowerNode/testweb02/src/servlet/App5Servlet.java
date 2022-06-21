package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/13 17:26
 */
@WebServlet(name = "session2", urlPatterns = "/session2")
public class App5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("app5 servlet doGet ...");

        //session的获取
        HttpSession session = req.getSession();
        System.out.println(session.getId());
    }
}
