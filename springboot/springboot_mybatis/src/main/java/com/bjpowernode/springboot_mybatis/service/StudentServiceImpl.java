package com.bjpowernode.springboot_mybatis.service;

import com.bjpowernode.springboot_mybatis.mapper.StudentMapper;
import com.bjpowernode.springboot_mybatis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

/**
 * @author cty
 * @date 2021/12/10 21:37
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public Student queryStudentById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = FileNotFoundException.class)
    public int update(Student student) {
        int num = studentMapper.updateByPrimaryKeySelective(student);
        int j = 100 / 0;
        //  new FileInputStream("");
        return num;
    }
}
