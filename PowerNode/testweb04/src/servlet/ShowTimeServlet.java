package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cty
 * @date 2021/9/18 10:35
 */
@WebServlet(name = "showTime", urlPatterns = "/showTime")
public class ShowTimeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建格式化类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化时间
        String time = sdf.format(new Date());
        //将时间保存在request对象中
        req.setAttribute("time", time);
        //转发页面
        req.getRequestDispatcher("/showTime01.jsp").forward(req, resp);
    }
}
