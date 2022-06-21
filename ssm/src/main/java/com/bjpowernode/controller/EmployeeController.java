package com.bjpowernode.controller;

import com.bjpowernode.entity.Employee;
import com.bjpowernode.model.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cty
 * @date 2021/10/11 14:26
 */
@Controller // http://localhost:8080/ssm/employee/list
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    /**
     * 1.使用servlet API
     * 控制器的四个职责：
     * 1.接收请求当中的参数
     * 2.调用模型层
     * 3.往作用域放值(request,session,application)   xx.setAttribute(key,value)
     * 4.响应用户(请求转发，重定向，json，下载，图片)
     *
     * @return
     */
    @RequestMapping("list")
    /* void list(HttpServletRequest request, HttpServletResponse response)throws Exception{

        //1.接收请求当中的参数
        String age = request.getParameter("age");
        System.out.println("age:" + age + "======================================================================");

        //2.调用模型层
        List<Employee> list = employeeService.list();

        //3.往作用域放值
        request.setAttribute("employeeList", list);

        //4.响应用户
        request.getRequestDispatcher("/pages/employee/list.jsp").forward(request, response);
    }*/

    /**
     * 2.使用ModelAndView处理（springMVC API），这是个万金油
     */
    /*ModelAndView list(int age){// 1.接收请求当中的参数 String age = request.getParameter("age");

        System.out.println("age:" + age + "======================================================================");

        ModelAndView modelAndView = new ModelAndView();

        //2.调用模型层
        List<Employee> list = employeeService.list();

        //3.往作用域放值
        //Model: 被放在作用域当中的值称为Model
        modelAndView.addObject("employeeList", list);  //request.setAttribute("employeeList", list);/request.setAttribute("employeeList", lis2t)

        //4.响应用户

        //4.1请求转发
        // modelAndView.setView(new InternalResourceView("/pages/employee/list.jsp"));//请求转发
        //modelAndView.setViewName("employee/list");//ViewName: 把响应地址中介于视图解析器的前辍和后辍之间的那个字符串

        //modelAndView.setViewName("forward:list2");//如果要转发往另一个action，则在action前面加上"forward:"

        //4.2重定向
        //modelAndView.setView(new RedirectView("http://www.baidu.com"));//去外部
        //modelAndView.setView(new RedirectView("edit"));//去内部
        modelAndView.setViewName("redirect:edit");//重定向如何到视图xx.jsp?????????????????????????????不存在

        return modelAndView;
    }*/

    /**
     * 3.返回ViewName实现
     */
    /*String list(ArrayList<Employee> list) {// 1.接收请求当中的参数 String age = request.getParameter("age");

        //2.调用模型层
        List<Employee> dbList = employeeService.list();
        System.out.println(dbList.size());

        //3.往作用域放值
        //当形参为bean类型时(包括集中当中放Bean)，它会自动new，且会自动进入Model：request.setAttribute("employeeList", list)
        //Model的Name（ArributeName）是使用推断来产生的：Bean类型首字母小写 + 集合的类型首字母大字
        list.addAll(dbList);

        return "employee/list";//4.响应用户
    }*/

    /**
     * 4.返回ViewName实现
     */
    /* String list(int age, Map<String,Object> map){// 1.接收请求当中的参数 String age = request.getParameter("age");

        //2.调用模型层
        List<Employee> dbList = employeeService.list();

        //3.往作用域放值
        //当形参为Map类型时，Map会自动选择LinkedHashMap来New，且Map当中的所有entry它会自动进入Model：request.setAttribute("employeeList", list)

        //map.put(id, 1)
        //map.put(name,张三)
        //id:1    name:张三
        map.put("employeeList", dbList);//request.setAttribute("employeeList", list)


        return "employee/list";//4.响应用户
    }*/

    /**
     * 5.使用响应的约定(没有返回值实现,响应的约定：只要没有明确指出该如何应响用户，则默认的响应方式是ViewName做请求转发，且默认的ViewName为：namespace/action)
     */
    /* void list(ArrayList<Employee> list){//默认的ViewName是：employee/list

        //2.调用模型层
        List<Employee> dbList = employeeService.list();

        //3.往作用域放值
        list.addAll(dbList);//request.setAttribute("employeeList", list)
    }*/

    /**
     * 6.使用响应的约定(没有返回值实现,响应的约定：只要没有明确指出该如何应响用户，则默认的响应方式是ViewName做请求转发，且默认的ViewName为：namespace/action)
     */
    /*  void list(Map<String,Object> map){//默认的ViewName是：employee/list

        //2.调用模型层
        List<Employee> dbList = employeeService.list();

        //3.往作用域放值
        map.put("employeeList", dbList);//request.setAttribute("employeeList", list)
    }*/

    /**
     * 7.返回Bean型类型
     */
    /* List<Employee> list(int age){

        //2.调用模型层
        List<Employee> list = employeeService.list();

        //3.往作用域放值
        //当返回值为Bean类型时，则返回值自动进入Model，Model的Name（ArributeName）是使用推断来产生的：Bean类型首字母小写 + 集合的类型首字母大字
        //ViewName: employee/list
        return list;//request.setAttribute("employeeList",list)
    }*/

    /**
     * 8.返回Bean型类型
     */
    Map<String, Object> list() {

        Map<String, Object> map = new HashMap<>();

        //2.调用模型层
        List<Employee> list = employeeService.list();

        //3.往作用域放值
        //当返回类型为Map时，Map当中所有的Entry自动进入Model
        map.put("employeeList", list);//request.setAttribute("employeeList", list)
        return map;
    }

    @RequestMapping("edit")
    void edit(Employee employee, Integer emplId) {
        if (emplId != null) {   //用户是点修改进来的
            //从数据库中查询此员工信息
            Employee employeeDB = employeeService.get(emplId);
            BeanUtils.copyProperties(employeeDB, employee);
        }
    }

    @RequestMapping("save")
    String save(Employee employee) {
        if (employee.getEmplId() != null) {
            //如果员工有id，证明用户是从修改界面进来的
            employeeService.update(employee);
        } else {
            //如果员工没有id，证明用户是从新增界面进来的
            employeeService.save(employee);
        }
        return "redirect:list";
    }

    @RequestMapping("delete")
    String delete(int emplId) {
        employeeService.delete(emplId);
        return "redirect:list";
    }
}
