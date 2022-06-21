package com.bjpowernode.service;

import com.bjpowernode.enity.Student;
import com.bjpowernode.vo.Page;

import java.util.List;

/**
 * @author cty
 * @date 2021/9/15 21:53
 */
public interface StudentService {
    //查询所有学生信息
    Page<Student> findStudents(String username, int age, int currentPage, int pageSize);
    //保存学生信息
    void save(Student student);
    //根据id查询学生信息
    Student findStudentById(int id);
    //修改学生信息
    void update(Student student);
    //删除学生信息
    void deleteStudentById(int id);
}
