package com.bjpowernode.workbench.service;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.Customer;
import com.bjpowernode.workbench.bean.CustomerRemark;

import java.util.List;

/**
 * @author cty
 * @date 2021/11/2 10:58
 */
public interface CustomerService {
    List<Customer> list(int pageNum, int pageSize, Customer customer);

    List<User> queryUsers();

    ResultVo saveOrUpdate(Customer customer, User user);

    Customer queryById(String id);

    void deleteBatch(String ids);

    Customer toDetail(String id);

    ResultVo saveRemark(CustomerRemark customerRemark, User user);

    void deleteRemark(String id);

    void updateRemark(CustomerRemark customerRemark, User user);
}
