package com.bjpowernode.springboot_mybatis.controller;

import com.bjpowernode.springboot_mybatis.model.Student;
import com.bjpowernode.springboot_mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cty
 * @date 2021/12/10 21:36
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * http://localhost:9301/springboot_mybatis/student
     */
    @RequestMapping(value = "/student")
    @ResponseBody
    public Object student() {

        Student student = studentService.queryStudentById(3);

        return student;
    }

    /**
     * http://localhost:9301/springboot_mybatis/update
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        Student student = new Student();
        student.setId(1);
        student.setName("Mark");
        student.setAge(100);

        int updateCount = studentService.update(student);

        return updateCount;
    }
}
