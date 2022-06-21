package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author cty
 * @date 2021/9/11 11:53
 */
@WebServlet(name = "test02", urlPatterns = "/test02")
public class Test02Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test02 servlet doGet ...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String name = config.getServletName();
        System.out.println("servlet-name:" + name);
        //String user = config.getInitParameter("user");
        //String pass = config.getInitParameter("pass");
        //System.out.println("user:" + user);
        //System.out.println("pass:" + pass);
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()){
            String key = names.nextElement();
            String value = config.getInitParameter(key);
            System.out.println(key + ":" + value);
        }
    }
}
