package com.bjpowernode.web.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.common.utils.ResultVo;
import com.bjpowernode.exterface.model.User;
import com.bjpowernode.exterface.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制层
 *
 * @author cty
 * @date 2021/12/17 20:15
 */
@Controller
public class UserController {
    @Reference(interfaceClass = UserService.class, version = "1.0.0", retries = 3, timeout = 2000)
    UserService userService;

    @RequestMapping("/loan/page/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/loan/page/checkPhone")
    @ResponseBody
    public Object checkPhone(@RequestParam(name = "phone", required = true) String phone) {
        //利用手机号查询用户数是否存在
        Boolean inputPhone = userService.checkPhone(phone);
        if (!inputPhone) {
            return ResultVo.error("此手机号已注册");
        }
        return ResultVo.success();
    }

    @RequestMapping("/loan/page/registerSubmit")
    @ResponseBody
    public Object registerSubmit(@RequestParam(name = "phone", required = true) String phone,
                                 @RequestParam(name = "loginPassword", required = true) String loginPassword,
                                 @RequestParam(name = "messageCode", required = true) String messageCode,
                                 HttpServletRequest request) {
        //校验：验证码
        String code = userService.pop(phone);
        if (!StringUtils.equals(messageCode, code)) {
            return ResultVo.error("验证码错误");
        }

        User user = userService.register(phone, loginPassword);
        if (!ObjectUtils.allNotNull(user)) {
            return ResultVo.error("注册失败");
        }

        //注册成功
        request.getSession().setAttribute("user", user);

        return ResultVo.success();
    }

    @RequestMapping("/loan/page/messageCode")
    @ResponseBody
    public Object getMessageCode(@RequestParam(name = "phone", required = true) String phone) throws Exception {
        //url:https://way.jd.com/kaixintong/kaixintong?mobile=13205516161&content=【凯信通】您的验证码是：123456&appkey=a057a7f5817f6aabc2a72a1db7e9a515

        String code = ResultVo.generateCode(6);
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("appkey", "a057a7f5817f6aabc2a72a1db7e9a515");
        map.put("content", "您的验证码为：" + code);

        //模拟报文
        String result = "{\n" +
                "    \"code\": \"10000\",\n" +
                "    \"charge\": false,\n" +
                "    \"remain\": 0,\n" +
                "    \"msg\": \"查询成功\",\n" +
                "    \"result\": \"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\" ?><returnsms>\\n <returnstatus>Success</returnstatus>\\n <message>ok</message>\\n <remainpoint>-7908770</remainpoint>\\n <taskID>204366499</taskID>\\n <successCounts>1</successCounts></returnsms>\",\n" +
                "    \"requestId\": \"693b46b053b44c409832b466a4467dee\"\n" +
                "}\n";

        JSONObject jsonObject = JSONObject.parseObject(result);
        String code1 = jsonObject.getString("code");

        if (!StringUtils.equals(code1, "10000")) {
            return ResultVo.error("通讯异常");
        }

        String xml = jsonObject.getString("result");
        String text = DocumentHelper.parseText(xml).getRootElement().elementText("returnstatus");

        if (!StringUtils.equals("Success", text)) {
            return ResultVo.error("验证码发送失败");
        }

        //验证码放入redis中
        userService.push(phone, code);

        return ResultVo.success(code);
    }

    @RequestMapping("/loan/page/realName")
    public String realName() {
        return "realName";
    }


    @RequestMapping("/codeImg")
    public void regCodeImg(HttpSession session, HttpServletResponse response) throws IOException {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(140, 45, 4, 20);
        //获取图片上的验证码
        String code = captcha.getCode();
        //把验证码字符存储在Session中
        session.setAttribute("code", code);
        captcha.write(response.getOutputStream());
    }

    @RequestMapping("/loan/page/realNameSubmit")
    @ResponseBody
    public Object realNameSubmit(@RequestParam(name = "phone", required = true) String phone,
                                 @RequestParam(name = "realName", required = true) String realName,
                                 @RequestParam(name = "idCard", required = true) String idCard,
                                 @RequestParam(name = "captcha", required = true) String captcha,
                                 HttpSession session, HttpServletRequest request) {


        //校验：图形验证码
        //获得存储在session中的验证码
        String checkCode = (String) session.getAttribute("code");
        //判断验证码是否正确
        if (captcha == null || !checkCode.equals(captcha)) {
            //提示验证码不正确！
            return ResultVo.error("验证码错误");
        }

        //校验：是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (!ObjectUtils.allNotNull(user)) {
            return ResultVo.error("请先登录，再实名认证");
        }

        //实名认证
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        map.put("idCard", idCard);
        map.put("realName", realName);
        String result = "{\n" +
                "    \"code\": \"10000\",\n" +
                "    \"charge\": false,\n" +
                "    \"remain\": 1305,\n" +
                "    \"msg\": \"查询成功\",\n" +
                "    \"result\": {\n" +
                "        \"error_code\": 0,\n" +
                "        \"reason\": \"成功\",\n" +
                "        \"result\": {\n" +
                "            \"realname\": \"乐天磊\",\n" +
                "            \"idcard\": \"350721197702134399\",\n" +
                "            \"isok\": true\n" +
                "        }\n" +
                "    }\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(result);
        String code1 = jsonObject.getString("code");
        if (!StringUtils.equals(code1, "10000")) {
            return ResultVo.error("通讯异常");
        }

        Boolean isok = jsonObject.getJSONObject("result").getJSONObject("result").getBoolean("isok");
        if (!isok) {
            return ResultVo.error("身份证与姓名不匹配哦");
        }

        //更新用户信息
        User user1 = new User();
        user1.setId(user.getId());
        user1.setName(realName);
        user1.setIdCard(idCard);

        int num = userService.member(user1);
        if (num != 1) {
            return ResultVo.error("实名认证失败");
        }

        //更新session中登录身份状态
        user.setName(realName);
        user.setIdCard(idCard);

        return ResultVo.success();
    }

    @RequestMapping("/loan/page/login")
    public String login(String redirectUrl, Model model) {
        model.addAttribute("redirectUrl", redirectUrl);
        System.out.println("redirectUrl:" + redirectUrl);
        return "login";
    }

    @RequestMapping("/loan/page/loginSubmit")
    @ResponseBody
    public Object loginSubmit(@RequestParam(name = "phone", required = true) String phone,
                              @RequestParam(name = "loginPassword", required = true) String loginPassword,
                              @RequestParam(name = "captcha", required = true) String captcha,
                              HttpSession session, HttpServletRequest request) {
        //校验：图形验证码
        //获得存储在session中的验证码
        String checkCode = (String) session.getAttribute("code");
        //判断验证码是否正确
        if (captcha == null || !checkCode.equals(captcha)) {
            //提示验证码不正确！
            return ResultVo.error("验证码错误");
        }

        //登录：登录
        User user = userService.login(phone, loginPassword);
        System.out.println(user);
        if (!ObjectUtils.allNotNull(user)) {
            return ResultVo.error("账户名与密码不匹配，请重新输入");
        }

        //登录成功
        request.getSession().setAttribute("user", user);

        return ResultVo.success();
    }

    @RequestMapping("/loan/page/logout")
    public String logout(HttpServletRequest request) {
        // 使session失效
        request.getSession().invalidate();

        return "redirect:/index";
    }

    @RequestMapping("/loan/page/myCenter")
    public String myCenter() {
        return "myCenter";
    }

}