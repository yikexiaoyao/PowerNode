package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/13 11:33
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login servlet doPost ...");

        //获取提交账号
        String user = req.getParameter("userName");
        //将账号保存在域对象中
        req.setAttribute("USER", user);
        //重定向到successServlet
        req.getRequestDispatcher("/success").forward(req, resp);
    }
}
