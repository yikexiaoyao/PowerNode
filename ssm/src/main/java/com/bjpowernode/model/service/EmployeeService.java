package com.bjpowernode.model.service;

import com.bjpowernode.entity.Employee;
import com.bjpowernode.model.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cty
 * @date 2021/10/11 14:22
 */
@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> list() {
        return employeeMapper.selectAll();
    }

    @Override
    public Employee get(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void delete(int id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}
