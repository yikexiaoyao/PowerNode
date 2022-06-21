package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author cty
 * @date 2021/9/23 11:19
 */
@WebServlet(name = "checkUserAjax",urlPatterns = "/checkUserAjax")
public class CheckUserAjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求参数
        String user = req.getParameter("user");
        // 校验账号是否可用
        String[] users = {"zhangsan","lisi","wangwu"};

        String msg = "可用";
        for (String u : users){
            if (u.equals(user)){
                msg = "账号冲突";
                break;
            }
        }
        // 异步请求的服务端程序返回数据的时候一定不能使用转发或者重定向返回页面
        // 直接使用响应输出流写数据到浏览器
        OutputStream os = resp.getOutputStream();
        os.write(msg.getBytes("utf-8"));
        os.close();
    }
}
