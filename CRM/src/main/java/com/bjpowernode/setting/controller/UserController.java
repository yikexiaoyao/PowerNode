package com.bjpowernode.setting.controller;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmEnum;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.FileUploadUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/10/22 15:03
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping("/settings/user/login")
    @ResponseBody
    public ResultVo login(User user, HttpServletRequest request, String code) {
        ResultVo resultVo = new ResultVo();
        try {
            //获取正确的验证码
            String correctCode = (String) request.getSession().getAttribute("correctCode");
            //获取用户登录的ip地址 address
            String address = request.getRemoteAddr();
            user.setAllowIps(address);
            user = userService.login(user, code, correctCode);
            //把用户设置到Session中
            request.getSession().setAttribute("user", user);
            resultVo.setOk(true);
            resultVo.setMessage("登录成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
            return resultVo;
        }
        return resultVo;
    }

    //跳转到后台首页
    @RequestMapping("/settings/user/toIndex")
    public String toIndex() {
        return "/workbench/index";
    }

    //退出
    @RequestMapping("/settings/user/logout")
    public String logout(HttpSession session) {
        //从session中移除用户
        session.removeAttribute("user");
        //转发或者重定向到登录页面
        return "redirect:/login.jsp";
    }

    //异步校验用户输入的原始密码是否正确
    @RequestMapping("/settings/user/verifyOldPwd")
    @ResponseBody
    public ResultVo verifyOldPwd(HttpSession session, String oldPwd) {
        //获取当前登录用户
        User user = (User) session.getAttribute("user");
        ResultVo resultVo = new ResultVo();
        try {
            userService.verifyOldPwd(user, oldPwd);
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setOk(false);
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步上传头像
    @RequestMapping("/settings/user/fileUpload")
    @ResponseBody
    public ResultVo fileUpload(MultipartFile img, HttpServletRequest request) {
        ResultVo resultVo = FileUploadUtil.fileUpload(img, request);
        return resultVo;
    }

    //异步更新用户信息
    @RequestMapping("/settings/user/updateUser")
    @ResponseBody
    public ResultVo updateUser(User user) {
        ResultVo resultVo = new ResultVo();
        try {
            userService.updateUser(user);
            resultVo.setOk(true);
            resultVo.setMessage("更新用户信息成功");
        } catch (CrmException e) {
            resultVo.setOk(false);
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }
}
