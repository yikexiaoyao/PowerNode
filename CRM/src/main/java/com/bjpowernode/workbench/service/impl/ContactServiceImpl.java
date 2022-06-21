package com.bjpowernode.workbench.service.impl;

import cn.hutool.core.util.StrUtil;
import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmEnum;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.DateTimeUtil;
import com.bjpowernode.base.util.UUIDUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.mapper.UserMapper;
import com.bjpowernode.workbench.bean.Contact;
import com.bjpowernode.workbench.bean.ContactRemark;
import com.bjpowernode.workbench.bean.Customer;
import com.bjpowernode.workbench.mapper.ContactMapper;
import com.bjpowernode.workbench.mapper.ContactRemarkMapper;
import com.bjpowernode.workbench.mapper.CustomerMapper;
import com.bjpowernode.workbench.service.ContactService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/1 10:48
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private ContactRemarkMapper contactRemarkMapper;

    @Override
    public List<Contact> list(int pageNum, int pageSize, Contact contact) {

        Example example = new Example(Contact.class);
        Example.Criteria criteria = example.createCriteria();
        System.out.println("contact ======================================== " + contact);

        //所有者模糊查询
        if (StrUtil.isNotEmpty(contact.getOwner())) {
            //根据用户的名字模糊查询出满足条件的用户
            Example example1 = new Example(User.class);
            example1.createCriteria().andLike("name", "%" + contact.getOwner() + "%");
            List<User> users = userMapper.selectByExample(example1);

            //定义一个集合，存储用户的主键
            List<String> ids1 = new ArrayList<>();
            for (User user : users) {
                ids1.add(user.getId());
            }

            //根据查询出来的用户的外键查询联系人
            criteria.andIn("owner", ids1);
        }

        //联系人模糊查询
        if (StrUtil.isNotEmpty(contact.getFullname())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andLike("fullname", "%" + contact.getFullname() + "%");
        }

        //客户名称模糊查询
        if (StrUtil.isNotEmpty(contact.getCustomerId())) {
            //根据客户的名字模糊查询出满足条件的客户
            Example example2 = new Example(Customer.class);
            //参数1:实体类属性名 参数2:实际的参数
            example2.createCriteria().andLike("name", "%" + contact.getCustomerId() + "%");
            List<Customer> customers = customerMapper.selectByExample(example2);

            //定义一个集合，存储客户的主键
            List<String> ids2 = new ArrayList<>();
            for (Customer customer : customers) {
                ids2.add(customer.getId());
            }

            //根据查询出来的用户的外键查询联系人
            criteria.andIn("customerId", ids2);
        }

        //来源查询
        if (!"---请选择---".equals(contact.getSource())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andEqualTo("source", contact.getSource());
        }

        //生日查询
        if (StrUtil.isNotEmpty(contact.getBirth())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andEqualTo("birth", contact.getBirth());
        }

        //该行代码等同于 limit a,b 参数1:当前页码 参数2:每页记录数 a=(page-1)*pageSize,b
        PageHelper.startPage(pageNum, pageSize);
        //按发布时间降序排序
        example.setOrderByClause("createTime desc");

        List<Contact> contacts = contactMapper.selectByExample(example);
        for (Contact contact1 : contacts) {
            String owner = contact1.getOwner();
            User user = userMapper.selectByPrimaryKey(owner);
            contact1.setOwner(user.getName());

            String customerId = contact1.getCustomerId();
            Customer customer = customerMapper.selectByPrimaryKey(customerId);
            contact1.setCustomerId(customer.getName());
        }

        return contacts;
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.selectAll();
    }

    @Override
    public ResultVo saveOrUpdate(Contact contact, User user) {
        ResultVo resultVo = new ResultVo();
        //获取联系人的主键
        String id = contact.getId();
        String customerName = contact.getCustomerId();
        Example example = new Example(Customer.class);
        example.createCriteria().andEqualTo("name", customerName);
        Customer customer1 = customerMapper.selectOneByExample(example);
        if (id == null) {
            //添加
            //主键
            if (customer1 == null) {
                Customer customer = new Customer();
                customer.setId(UUIDUtil.uuid());
                customer.setOwner(contact.getOwner());
                customer.setName(contact.getCustomerId());
                contact.setCustomerId(customer.getId());
                customerMapper.insertSelective(customer);
            }
            contact.setId(UUIDUtil.uuid());
            contact.setCreateTime(DateTimeUtil.getSysTime());
            contact.setCreateBy(user.getName());
            int count = contactMapper.insertSelective(contact);
            if (count == 0) {
                throw new CrmException(CrmEnum.CONTACT_SAVE);
            }
            resultVo.setMessage("添加联系人成功");
        } else {
            //修改
            if (customer1 == null) {
                Customer customer = new Customer();
                customer.setId(UUIDUtil.uuid());
                customer.setOwner(contact.getOwner());
                customer.setName(contact.getCustomerId());
                contact.setCustomerId(customer.getId());
                customerMapper.insertSelective(customer);
            }
            contact.setEditTime(DateTimeUtil.getSysTime());
            contact.setEditBy(user.getName());
            int count = contactMapper.updateByPrimaryKeySelective(contact);
            if (count == 0) {
                throw new CrmException(CrmEnum.CONTACT_UPDATE);
            }
            resultVo.setMessage("修改联系人成功");
        }
        resultVo.setOk(true);
        return resultVo;
    }

    @Override
    public Contact queryById(String id) {
        Contact contact = contactMapper.selectByPrimaryKey(id);
        Customer customer = customerMapper.selectByPrimaryKey(contact.getCustomerId());
        contact.setCustomerId(customer.getName());
        return contact;
    }

    @Override
    public void deleteBatch(String ids) {
        //把字符串分隔成成字符串数组
        String[] aids = ids.split(",");
        //使用Arrays[专门操作数组常用类]类
        List<String> idsList = Arrays.asList(aids);
        Example example = new Example(Contact.class);
        //delete from 表 where id in(1,2,3)
        example.createCriteria().andIn("id", idsList);
        contactMapper.deleteByExample(example);
    }

    @Override
    public Contact toDetail(String id) {
        //查询联系人自身的信息
        Contact contact = contactMapper.selectByPrimaryKey(id);
        //处理所有者数据
        User user = userMapper.selectByPrimaryKey(contact.getOwner());

        contact.setOwner(user.getName());

        //查询联系人的备注数据
        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setContactId(id);
        List<ContactRemark> contactRemarks = contactRemarkMapper.select(contactRemark);
        for (ContactRemark remark : contactRemarks) {
            remark.setContactId(contact.getFullname());
        }

        contact.setContactRemarks(contactRemarks);
        return contact;
    }

    @Override
    public ResultVo saveRemark(ContactRemark contactRemark, User user) {
        ResultVo resultVo = new ResultVo();
        //设置主键
        contactRemark.setId(UUIDUtil.uuid());
        //创建时间和创建者
        contactRemark.setCreateTime(DateTimeUtil.getSysTime());
        contactRemark.setCreateBy(user.getName());

        //所有者和头像
        contactRemark.setOwner(user.getId());
        contactRemark.setImg(user.getImg());

        contactRemarkMapper.insertSelective(contactRemark);

        resultVo.setT(contactRemark);
        resultVo.setOk(true);
        resultVo.setMessage("添加备注成功");

        //查询备注对应的联系人
        Contact contact = contactMapper.selectByPrimaryKey(contactRemark.getContactId());
        contactRemark.setContactId(contact.getFullname());
        return resultVo;
    }

    @Override
    public void deleteRemark(String id) {
        contactRemarkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateRemark(ContactRemark contactRemark, User user) {
        //设置修改时间和修改者
        contactRemark.setEditBy(user.getName());
        contactRemark.setEditTime(DateTimeUtil.getSysTime());
        contactRemark.setEditFlag("1");
        contactRemarkMapper.updateByPrimaryKeySelective(contactRemark);
    }
}
