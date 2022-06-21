package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.enity.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.utils.JDBCUtils_bak;
import com.bjpowernode.vo.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author cty
 * @date 2021/9/15 21:56
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public Page<Student> findStudents(String username, int age, int currentPage, int pageSize) {
        Connection conn = null;
        Page<Student> page = null;
        try {
            //获取数据库连接
            conn = JDBCUtils_bak.getConnection();
            //查询所有学生信息，返回集合
            //计算分页开始的索引号
            int start = (currentPage - 1) * pageSize;
            List<Student> list= studentDao.findStudents(conn,username,age,start,pageSize);
            //查询总记录数
            int totalRecords = studentDao.findStudentCounts(conn,username,age);
            //将查询结果使用Page对象进行封装
            page = new Page<>(totalRecords, currentPage, pageSize, list);
            return page;
        } catch (SQLException e) {
            return new Page<Student>();
        } finally {
            //关闭资源
            JDBCUtils_bak.close(null, null, conn);
        }
    }

    @Override
    public void save(Student student) {
        Connection conn = null;
        try {
            conn = JDBCUtils_bak.getConnection();
            studentDao.insertStudent(conn, student);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_bak.close(null, null, conn);
        }
    }

    @Override
    public Student findStudentById(int id) {
        Connection conn = null;
        Student student = new Student();
        try {
            conn = JDBCUtils_bak.getConnection();
            student = studentDao.findStudentById(conn, id);
            return student;
        } catch (SQLException e) {
            return student;
        } finally {
            JDBCUtils_bak.close(null, null, conn);
        }
    }

    @Override
    public void update(Student student) {
        Connection conn = null;
        try {
            //初始化数据库连接
            conn = JDBCUtils_bak.getConnection();
            //调用dao层的update方法
            studentDao.update(conn, student);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_bak.close(null, null, conn);
        }
    }

    @Override
    public void deleteStudentById(int id) {
        Connection conn = null;
        try {
            conn = JDBCUtils_bak.getConnection();
            studentDao.deleteStudentById(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_bak.close(null, null, conn);
        }
    }
}
