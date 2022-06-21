package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cty
 * @date 2021/9/18 10:59
 */
@WebServlet(name = "showTimeAjax", urlPatterns = "/showTimeAjax")
public class ShowTimeAjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //创建格式化类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化时间
        String time = sdf.format(new Date());
        //异步请求的服务端程序返回数据的时候一定不能使用转发或者重定向返回页面
        //直接使用响应输出流写数据到浏览器
        OutputStream os = resp.getOutputStream();
        os.write(time.getBytes("utf-8"));
        os.close();
    }
}
