package com.bjpowernode.springboot_mybatis.service;

import com.bjpowernode.springboot_mybatis.model.Student;

/**
 * @author cty
 * @date 2021/12/10 21:37
 */
public interface StudentService {
    Student queryStudentById(int id);

    int update(Student student);
}
