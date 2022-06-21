package com.bjpowernode.dao;

import com.bjpowernode.enity.Student;

import java.sql.Connection;
import java.util.List;

/**
 * @author cty
 * @date 2021/9/15 21:57
 */
public interface StudentDao {
    //返回学生信息
    List<Student> findStudents(Connection conn, String username, int age, int start, int pageSize);
    //执行添加操作
    void insertStudent(Connection conn, Student student);
    //根据id查询学生信息
    Student findStudentById(Connection conn, int id);
    //修改学生信息
    void update(Connection conn, Student student);
    //删除学生信息
    void deleteStudentById(Connection conn, int id);
    //根据查询条件计算总记录数
    int findStudentCounts(Connection conn, String username, int age);
}
