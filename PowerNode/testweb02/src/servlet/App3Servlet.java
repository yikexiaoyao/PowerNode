package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cty
 * @date 2021/9/13 15:02
 */
@WebServlet(name = "app3", urlPatterns = "/app3")
public class App3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("app3 servlet doGet ...");

        //默认上次访问时间是当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(new Date());
        String lastTime = now;
        //读取cookie
        Cookie[] cookies = req.getCookies();
        //遍历cookie数组
        if (cookies != null) {
            for(Cookie cookie : cookies) {
                String key = cookie.getName();
                if (key.equals(lastTime)) {
                    lastTime = cookie.getValue();
                }
            }
        }
        //创建新的cookie对象，保存本次访问时间，将作为下次访问的上次访问时间
        Cookie cookie1 = new Cookie("lastTime", now);
        resp.addCookie(cookie1);
        //向浏览器输出上次访问时间
        resp.setContentType("text/html;charset=utf-8");
        resp.getOutputStream().write(lastTime.getBytes("utf-8"));
        resp.getOutputStream().close();
    }
}
