package servlet;

import com.alibaba.fastjson.JSON;
import enity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author cty
 * @date 2021/9/23 11:21
 */
@WebServlet(name = "getStudentById",urlPatterns = "/getStudentById")
public class GetStudentByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求参数
        String id = req.getParameter("id");
        System.out.println("id:" + id);
        // 创建student对象
        Student student = new Student(1,"张三",20,"1","魔都","哪里挣钱哪里花，一份不能带回家");
        // 将对象转换为json格式字符串
        String str = JSON.toJSONString(student);
        System.out.println("json:" + str);
        // 异步请求的服务端程序返回数据的时候一定不能使用转发或者重定向返回页面
        // 直接使用响应输出流写数据到浏览器
        OutputStream os = resp.getOutputStream();
        os.write(str.getBytes("utf-8"));
        os.close();
    }
}
