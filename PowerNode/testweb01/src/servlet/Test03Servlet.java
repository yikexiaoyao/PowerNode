package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/11 17:01
 */
@WebServlet(name = "test03", urlPatterns = "/test03")
public class Test03Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test03 Servlet doGet......");

        //1.获取servletContext
        ServletContext context = req.getServletContext();

        //2.获取全局初始化参数
        String gender = context.getInitParameter("gender");
        String age = context.getInitParameter("age");
        System.out.println("gender:" + gender);
        System.out.println("age:" + age);


        //3.作为域对象保存数据，servletContext的作用域是全局的，每个组件都能访问
        String userId = (String) context.getAttribute("userId");
        System.out.println("userId:" + userId);

        //4.跳转页面--转发
        //context.getRequestDispatcher("/app1.html").forward(req, resp);
        req.getRequestDispatcher("/app1.html").forward(req, resp);

        //5.在request域对象中添加数据
        req.setAttribute("user", "admin");

        //6.转发跳转到Test04
        //context.getRequestDispatcher("/test04").forward(req, resp);
    }
}
