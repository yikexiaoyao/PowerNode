package com.bjpowernode.model.dao;

import com.bjpowernode.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectAll();

    int deleteByPrimaryKey(Integer emplId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer emplId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}