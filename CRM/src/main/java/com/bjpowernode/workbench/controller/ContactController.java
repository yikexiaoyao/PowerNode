package com.bjpowernode.workbench.controller;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.CommonUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.Activity;
import com.bjpowernode.workbench.bean.ActivityRemark;
import com.bjpowernode.workbench.bean.Contact;
import com.bjpowernode.workbench.bean.ContactRemark;
import com.bjpowernode.workbench.service.ContactService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/1 10:42
 */
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/workbench/contact/list")
    public PageInfo list(int pageNum, int pageSize, Contact contact) {
        List<Contact> contacts = contactService.list(pageNum, pageSize, contact);
        PageInfo pageInfo = new PageInfo(contacts);
        return pageInfo;
    }

    //异步查询所有者数据
    @RequestMapping("/workbench/contact/queryUsers")
    public List<User> queryUsers(){
        return contactService.queryUsers();
    }

    //异步保存联系人
    @RequestMapping("/workbench/contact/saveOrUpdate")
    public ResultVo saveOrUpdate(Contact contact, HttpSession session){
        ResultVo resultVo = new ResultVo();
        try{
            User user = (User) session.getAttribute("user");
            resultVo = contactService.saveOrUpdate(contact,user);
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //根据主键查询联系人
    @RequestMapping("/workbench/contact/queryById")
    public Contact queryById(String id){
        return contactService.queryById(id);
    }

    //批量删除
    @RequestMapping("/workbench/contact/deleteBatch")
    public ResultVo deleteBatch(String ids){
        ResultVo resultVo = new ResultVo();
        try{
            contactService.deleteBatch(ids);
            resultVo.setOk(true);
            resultVo.setMessage("删除联系人成功");
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步查询联系人详情页数据
    @RequestMapping("/workbench/contact/toDetail")
    public Contact toDetail(String id){
        return contactService.toDetail(id);
    }

    //联系人备注的保存
    @RequestMapping("/workbench/contact/saveRemark")
    public ResultVo saveRemark(ContactRemark contactRemark, HttpSession session){
        ResultVo resultVo = null;
        try{
            //获取当前登录用户
            User user = CommonUtil.getCurrentUser(session);
            resultVo = contactService.saveRemark(contactRemark,user);
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步删除备注
    @RequestMapping("/workbench/contact/deleteRemark")
    public ResultVo deleteRemark(String id){
        ResultVo resultVo = new ResultVo();
        try{
            contactService.deleteRemark(id);
            resultVo.setOk(true);
            resultVo.setMessage("删除备注成功");
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步修改备注
    @RequestMapping("/workbench/contact/updateRemark")
    public ResultVo updateRemark(ContactRemark contactRemark, HttpSession session){
        ResultVo resultVo = new ResultVo();
        try{
            //获取登录用户
            User user = CommonUtil.getCurrentUser(session);
            contactService.updateRemark(contactRemark,user);
            resultVo.setOk(true);
            resultVo.setMessage("修改备注成功");
        }catch (CrmException e){
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }
}
