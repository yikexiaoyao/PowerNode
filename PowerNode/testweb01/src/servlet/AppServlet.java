package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author cty
 * @date 2021/9/10 19:17
 */
@WebServlet(name = "app", urlPatterns = "/app")
public class AppServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("app servlet doGet ...");
        System.out.println(new Date());
        //设置响应状态码
        //resp.setStatus(404);
        //resp.sendError(404);
        //resp.sendError(404, "页面找不到了");
        //刷新页面 3秒 重定向
        resp.setHeader("Refresh", "3;url=https://www.baidu.com");
    }
}
