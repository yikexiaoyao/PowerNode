package com.bjpowernode.workbench.controller;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.CommonUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.Customer;
import com.bjpowernode.workbench.bean.CustomerRemark;
import com.bjpowernode.workbench.service.CustomerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/2 10:56
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/workbench/customer/list")
    public PageInfo list(int pageNum, int pageSize, Customer customer) {
        List<Customer> customers = customerService.list(pageNum, pageSize, customer);
        PageInfo pageInfo = new PageInfo(customers);
        return pageInfo;
    }

    //异步查询所有者数据
    @RequestMapping("/workbench/customer/queryUsers")
    public List<User> queryUsers(){
        return customerService.queryUsers();
    }

    //异步保存客户
    @RequestMapping("/workbench/customer/saveOrUpdate")
    public ResultVo saveOrUpdate(Customer customer, HttpSession session){
        ResultVo resultVo = new ResultVo();
        try{
            User user = (User) session.getAttribute("user");
            resultVo = customerService.saveOrUpdate(customer,user);
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //根据主键查询客户
    @RequestMapping("/workbench/customer/queryById")
    public Customer queryById(String id){
        return customerService.queryById(id);
    }

    //批量删除
    @RequestMapping("/workbench/customer/deleteBatch")
    public ResultVo deleteBatch(String ids){
        ResultVo resultVo = new ResultVo();
        try{
            customerService.deleteBatch(ids);
            resultVo.setOk(true);
            resultVo.setMessage("删除客户成功");
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步查询客户详情页数据
    @RequestMapping("/workbench/customer/toDetail")
    public Customer toDetail(String id){
        return customerService.toDetail(id);
    }

    //客户备注的保存
    @RequestMapping("/workbench/customer/saveRemark")
    public ResultVo saveRemark(CustomerRemark customerRemark, HttpSession session){
        ResultVo resultVo = null;
        try{
            //获取当前登录用户
            User user = CommonUtil.getCurrentUser(session);
            resultVo = customerService.saveRemark(customerRemark,user);
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步删除备注
    @RequestMapping("/workbench/customer/deleteRemark")
    public ResultVo deleteRemark(String id){
        ResultVo resultVo = new ResultVo();
        try{
            customerService.deleteRemark(id);
            resultVo.setOk(true);
            resultVo.setMessage("删除备注成功");
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步修改备注
    @RequestMapping("/workbench/customer/updateRemark")
    public ResultVo updateRemark(CustomerRemark customerRemark,HttpSession session){
        ResultVo resultVo = new ResultVo();
        try{
            //获取登录用户
            User user = CommonUtil.getCurrentUser(session);
            customerService.updateRemark(customerRemark,user);
            resultVo.setOk(true);
            resultVo.setMessage("修改备注成功");
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }
}
