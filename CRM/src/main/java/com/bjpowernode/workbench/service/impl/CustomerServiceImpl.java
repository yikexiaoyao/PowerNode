package com.bjpowernode.workbench.service.impl;

import cn.hutool.core.util.StrUtil;
import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmEnum;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.DateTimeUtil;
import com.bjpowernode.base.util.UUIDUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.mapper.UserMapper;
import com.bjpowernode.workbench.bean.Customer;
import com.bjpowernode.workbench.bean.CustomerRemark;
import com.bjpowernode.workbench.mapper.CustomerMapper;
import com.bjpowernode.workbench.mapper.CustomerRemarkMapper;
import com.bjpowernode.workbench.service.CustomerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/2 10:58
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerRemarkMapper customerRemarkMapper;

    @Override
    public List<Customer> list(int pageNum, int pageSize, Customer customer) {

        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();

        //客户模糊查询 !null str.length!=0
        if(StrUtil.isNotEmpty(customer.getName())){
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andLike("name", "%" + customer.getName() + "%");
        }

        //所有者模糊查询
        if(StrUtil.isNotEmpty(customer.getOwner())){
            //根据用户的名字模糊查询出满足条件的用户
            Example example1 = new Example(User.class);
            example1.createCriteria().andLike("name", "%" + customer.getOwner() + "%");
            List<User> users = userMapper.selectByExample(example1);

            //定义一个集合，存储用户的主键
            List<String> ids = new ArrayList<>();
            for (User user : users) {
                ids.add(user.getId());
            }

            //根据查询出来的用户的外键查询客户
            criteria.andIn("owner", ids);
        }

        //公司座机模糊查询
        if(StrUtil.isNotEmpty(customer.getPhone())){
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andLike("phone", "%" + customer.getPhone() + "%");
        }

        //公司网站模糊查询
        if(StrUtil.isNotEmpty(customer.getWebsite())){
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andLike("website", "%" + customer.getWebsite() + "%");
        }

        //该行代码等同于 limit a,b 参数1:当前页码 参数2:每页记录数 a=(page-1)*pageSize,b
        PageHelper.startPage(pageNum, pageSize);
        //按发布时间降序排序
        example.setOrderByClause("createTime desc");
        List<Customer> customers =  customerMapper.selectByExample(example);
        for (Customer customer1 : customers) {
            String owner = customer1.getOwner();
            User user = userMapper.selectByPrimaryKey(owner);
            customer1.setOwner(user.getName());
        }
        return customers;
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.selectAll();
    }

    @Override
    public ResultVo saveOrUpdate(Customer customer, User user) {
        ResultVo resultVo = new ResultVo();
        //获取客户的主键
        String id = customer.getId();
        if(id == null){
            //添加
            //主键
            customer.setId(UUIDUtil.uuid());
            customer.setCreateTime(DateTimeUtil.getSysTime());
            customer.setCreateBy(user.getName());
            int count = customerMapper.insertSelective(customer);
            if(count == 0){
                throw new CrmException(CrmEnum.CUSTOMER_SAVE);
            }
            resultVo.setMessage("添加客户成功");
        }else{
            //修改
            customer.setEditTime(DateTimeUtil.getSysTime());
            customer.setEditBy(user.getName());
            int count = customerMapper.updateByPrimaryKeySelective(customer);
            if(count == 0){
                throw new CrmException(CrmEnum.CUSTOMER_UPDATE);
            }
            resultVo.setMessage("修改客户成功");
        }
        resultVo.setOk(true);
        return resultVo;
    }

    @Override
    public Customer queryById(String id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteBatch(String ids) {
        //把字符串分隔成成字符串数组
        String[] aids = ids.split(",");
        //使用Arrays[专门操作数组常用类]类
        List<String> idsList = Arrays.asList(aids);
        Example example = new Example(Customer.class);
        //delete from 表 where id in(1,2,3)
        example.createCriteria().andIn("id",idsList );
        customerMapper.deleteByExample(example);
    }

    @Override
    public Customer toDetail(String id) {
        //查询客户自身的信息
        Customer customer = customerMapper.selectByPrimaryKey(id);
        //处理所有者数据
        User user = userMapper.selectByPrimaryKey(customer.getOwner());

        customer.setOwner(user.getName());

        //查询客户的备注数据
        CustomerRemark customerRemark = new CustomerRemark();
        customerRemark.setCustomerId(id);
        List<CustomerRemark> customerRemarks = customerRemarkMapper.select(customerRemark);
        for (CustomerRemark remark : customerRemarks) {
            remark.setCustomerId(customer.getName());
        }

        customer.setCustomerRemarks(customerRemarks);
        return customer;
    }

    @Override
    public ResultVo saveRemark(CustomerRemark customerRemark, User user) {
        ResultVo resultVo = new ResultVo();
        //设置主键
        customerRemark.setId(UUIDUtil.uuid());
        //创建时间和创建者
        customerRemark.setCreateTime(DateTimeUtil.getSysTime());
        customerRemark.setCreateBy(user.getName());

        //所有者和头像
        customerRemark.setOwner(user.getId());
        customerRemark.setImg(user.getImg());

        customerRemarkMapper.insertSelective(customerRemark);

        resultVo.setT(customerRemark);
        resultVo.setOk(true);
        resultVo.setMessage("添加备注成功");

        //查询备注对应的客户
        Customer customer = customerMapper.selectByPrimaryKey(customerRemark.getCustomerId());
        customerRemark.setCustomerId(customer.getName());
        return resultVo;
    }

    @Override
    public void deleteRemark(String id) {
        customerRemarkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateRemark(CustomerRemark customerRemark, User user) {
        //设置修改时间和修改者
        customerRemark.setEditTime(DateTimeUtil.getSysTime());
        customerRemark.setEditBy(user.getName());
        customerRemark.setEditFlag("1");

        customerRemarkMapper.updateByPrimaryKeySelective(customerRemark);
    }
}
