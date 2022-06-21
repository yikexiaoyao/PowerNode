package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/11 21:33
 */
@WebServlet(name = "test04", urlPatterns = "/test04")
public class Test04Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test04 Servlet doGet......");

        String user = (String)req.getAttribute("user");
        System.out.println("user: " + user);
    }
}
