package com.bjpowernode.model.service;

import com.bjpowernode.entity.Employee;

import java.util.List;

/**
 * @author cty
 * @date 2021/10/11 14:21
 */
public interface IEmployeeService {
    List<Employee> list();

    Employee get(int id);

    void save(Employee employee);

    void update(Employee employee);

    void delete(int id);
}
