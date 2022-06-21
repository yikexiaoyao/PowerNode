package com.bjpowernode.workbench.service;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.Contact;
import com.bjpowernode.workbench.bean.ContactRemark;

import java.util.List;

/**
 * @author cty
 * @date 2021/11/1 10:47
 */
public interface ContactService {
    List<Contact> list(int pageNum, int pageSize, Contact contact);

    List<User> queryUsers();

    ResultVo saveOrUpdate(Contact contact, User user);

    Contact queryById(String id);

    void deleteBatch(String ids);

    Contact toDetail(String id);

    ResultVo saveRemark(ContactRemark contactRemark, User user);

    void deleteRemark(String id);

    void updateRemark(ContactRemark contactRemark, User user);
}
