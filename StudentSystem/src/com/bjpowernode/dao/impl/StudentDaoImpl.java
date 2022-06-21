package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.enity.Student;
import com.bjpowernode.utils.JDBCUtils_bak;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cty
 * @date 2021/9/15 22:01
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findStudents(Connection conn, String username, int age, int start, int pageSize) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            //创建sql语句
            String sql = "select * from tb_student where 1=1";
            //根据查询条件判断sql语句
            if (username != null && !username.equals("")) {
                sql += " and name like ?";
            }
            if (age > 0) {
                sql += " and age = ?";
            }
            sql += " limit ?,?";
            //创建statement
            statement = conn.prepareStatement(sql);
            //添加查询条件
            int count = 1;
            if (username != null && !username.equals("")) {
                statement.setString(count++, "%" + username + "%");
            }
            if (age > 0) {
                statement.setInt(count++, age);
            }
            statement.setInt(count++, start);
            statement.setInt(count++, pageSize);
            //执行sql语句
            rs = statement.executeQuery();
            //读取返回结果
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int sage = rs.getInt(3);
                String gender = rs.getString(4);
                String address = rs.getString(5);
                String remark = rs.getString(6);
                Student student = new Student(id, name, sage, gender, address, remark);
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            return list;
        } finally {
            JDBCUtils_bak.close(rs, statement, null);
        }
    }

    @Override
    public void insertStudent(Connection conn, Student student) {
        PreparedStatement statement = null;
        try {
            //创建sql语句
            String sql = "insert into tb_student(name,age,gender,address,remark) values(?,?,?,?,?)";
            statement = conn.prepareStatement(sql);
            //创建statement
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getRemark());
            //执行sql语句
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_bak.close(null, statement, null);
        }
    }

    @Override
    public Student findStudentById(Connection conn, int id) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Student student = new Student();
        try {
            //创建sql语句
            String sql = "select * from tb_student where id = ?";
            //创建statement
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            //执行sql语句
            rs = statement.executeQuery();
            //读取返回结果
            if (rs.next()) {
                int sid = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String gender = rs.getString(4);
                String address = rs.getString(5);
                String remark = rs.getString(6);
                student = new Student(sid, name, age, gender, address, remark);
            }
            return student;
        } catch (SQLException e) {
            return student;
        } finally {
            JDBCUtils_bak.close(rs, statement, null);
        }
    }

    @Override
    public void update(Connection conn, Student student) {
        PreparedStatement statement = null;
        try {
            //创建sql语句
            String sql = "update tb_student set name = ?, age = ?, gender = ?, address = ?, remark = ? where id = ?";
            //创建statement
            statement = conn.prepareStatement(sql);
            //添加参数
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getRemark());
            statement.setInt(6, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_bak.close(null, statement, null);
        }
    }

    @Override
    public void deleteStudentById(Connection conn, int id) {
        PreparedStatement statement = null;
        try {
            //创建sql语句
            String sql = "delete from tb_student where id = ?";
            //创建statement
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            //执行sql语句
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_bak.close(null, statement, null);
        }
    }

    @Override
    public int findStudentCounts(Connection conn, String username, int age) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        int num = 0;
        try {
            //创建sql语句
            String sql = "select count(0) from tb_student where 1=1";
            //根据查询条件拼接sql语句
            if (username != null && !username.equals("")) {
                sql += " and name like ?";
            }
            if (age > 0) {
                sql += " and age = ?";
            }
            //创建statement
            statement = conn.prepareStatement(sql);
            //添加查询条件
            int count = 1;
            if (username != null && !username.equals("")) {
                statement.setString(count++, "%" + username + "%");
            }
            if (age > 0) {
                statement.setInt(count++, age);
            }
            //执行sql语句
            rs = statement.executeQuery();
            //读取返回结果
            if (rs.next()) {
                num = rs.getInt(1);
            }
            return num;
        } catch (SQLException e) {
            return num;
        } finally {
            JDBCUtils_bak.close(rs, statement, null);
        }
    }
}
