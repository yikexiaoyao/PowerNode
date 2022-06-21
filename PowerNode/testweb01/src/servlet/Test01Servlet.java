package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/11 11:47
 */
@WebServlet(name = "test01", urlPatterns = "/test01", loadOnStartup = 1)
public class Test01Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test01 servlet doGet ...");
    }

    @Override
    public void destroy() {
        //当servlet对象被销毁时执行这个方法，目的就是销毁对象前释放一些必须释放的资源
        System.out.println(("Test01 destory ..."));
    }

    @Override
    public void init() throws ServletException {
        //初始化servlet运行所必须的一些资源
        System.out.println("Test01 init ...");
    }
}
