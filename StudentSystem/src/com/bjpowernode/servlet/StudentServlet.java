package com.bjpowernode.servlet;

import com.bjpowernode.constant.Constant;
import com.bjpowernode.enity.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.vo.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/9/15 21:49
 */
@WebServlet(name = "student", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置utf-8字符集
        req.setCharacterEncoding("utf-8");
        //获取请求参数method
        String method = req.getParameter("method");
        //根据请求值不同，调用不同的方法，分发请求
        if (method.equals("mainUI")) {
            this.mainUI(req, resp);
        } else if (method.equals("addUI")) {
            this.addUI(req, resp);
        } else if (method.equals("add")) {
            this.add(req, resp);
        } else if (method.equals("editUI")) {
            this.editUI(req, resp);
        } else if (method.equals("edit")) {
            this.edit(req, resp);
        } else if (method.equals("delete")) {
            this.delete(req, resp);
        } else if (method.equals("logout")) {
            this.logout(req, resp);
        }
    }

    protected void mainUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取查询条件
        String username = req.getParameter("username");
        String sage = req.getParameter("sage");
        String no = req.getParameter("no");
        int age = 0;
        if (sage != null && !sage.equals("")){
            age = Integer.parseInt(sage);
        }
        //如果告诉服务端显示第几页，就根据要求进行查询，如果没有告诉，默认显示第一页
        int currentPage = 1;
        if (no != null && !no.equals("")) {
            currentPage = Integer.parseInt(no);
        }
        //查询所有的学生信息
        Page<Student> page = studentService.findStudents(username, age, currentPage, Constant.PAGE_SIZE);
        //将查询到的学生信息保存在req对象中
        req.setAttribute("username", username);
        req.setAttribute("sage", sage);
        req.setAttribute("page", page);
        //转发跳转到mainUI.jsp
        req.getRequestDispatcher("/mainUI.jsp").forward(req, resp);
    }

    //添加学生信息
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求参数
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        //将域中获取的age（String）进行类型转换为sage（int）
        int sage = 0;
        if (age != null && !age.equals("")) {
            sage = Integer.parseInt(age);
        }
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String remark = req.getParameter("remark");
        //将请求参数封装为student对象
        Student student = new Student(0, name, sage, gender, address, remark);
        //执行service的保存方法
        studentService.save(student);
        //重定向跳转到列表页面
        resp.sendRedirect(req.getContextPath() + "/student?method=mainUI");
    }

    protected void addUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发跳转到add.jsp
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    //修改学生信息
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求参数
        String id = req.getParameter("id");
        //将域中获取的id（String）进行类型转换为id（int）
        int sid = 0;
        if (id != "" && !id.equals("")) {
            sid = Integer.parseInt(id);
        }
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        //将域中获取的age（String）进行类型转换为sage（int）
        int sage = 0;
        if (age != null && !age.equals("")) {
            sage = Integer.parseInt(age);
        }
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String remark = req.getParameter("remark");
        //将请求参数封装为student对象
        Student student = new Student(sid, name, sage, gender, address, remark);
        //执行service的保存方法
        studentService.update(student);
        //重定向跳转到列表页面
        resp.sendRedirect(req.getContextPath() + "/student?method=mainUI");
    }

    protected void editUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id请求参数
        String sid = req.getParameter("id");
        int id = 0;
        if (sid != null && !sid.equals("")) {
            id = Integer.parseInt(sid);
        }
        //将请求参数封装为student对象
        Student student = studentService.findStudentById(id);
        //将student对象保存到request域对象中
        req.setAttribute("student", student);
        //转发跳转到edit.jsp
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    //删除学生信息
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求参数
        String sid = req.getParameter("id");
        int id = 0;
        if (sid != null && !sid.equals("")) {
            id = Integer.parseInt(sid);
        }
        studentService.deleteStudentById(id);
        //重定向跳转到列表页面
        resp.sendRedirect (req.getContextPath() + "/student?method=mainUI");
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //使整个客户端对应的Session失效，里面的所有东西清空，同时释放资源
        req.getSession().invalidate();
        //重定向跳转到列表页面
        resp.sendRedirect (req.getContextPath() + "/login.jsp");
    }

}
