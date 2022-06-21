package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/13 11:41
 */
@WebServlet(name = "success", urlPatterns = "/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("success servlet doPost ...");

        //获取与对象中的账号
        String user = (String) req.getAttribute("USER");
        //设置返回数据的类型
        resp.setContentType("text/html;charset=utf-8");
        //使用流输出浏览器
        resp.getOutputStream().write((user + "登录成功").getBytes("utf-8"));
        resp.getOutputStream().close();
    }
}
