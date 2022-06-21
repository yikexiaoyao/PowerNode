package servlet;

import enity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/23 11:24
 */
@WebServlet(name = "app",urlPatterns = "/app")
public class AppServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = req.getSession();
        System.out.println(session.getId());

        // 给session中添加数据
        // session.setAttribute("user", "admin");
        // session.setAttribute("user", "lisi");
        // session.removeAttribute("user");

        Student student = new Student(1,"张三",20,"1","魔都","哪里挣钱哪里花，一份不能带回家");
        session.setAttribute("s1", student);
        session.removeAttribute("s1");
        //session.invalidate();
    }
}
