package com.bjpowernode.base.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cty
 * @date 2021/10/25 16:03
 */
@Controller
public class VerifyCodeController {
    @RequestMapping("/settings/user/code")
    public void code(HttpSession session, HttpServletResponse response) throws IOException {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(140, 45, 4, 20);
        //获取图片上的验证码
        String code = captcha.getCode();

        //把验证码字符存储在Session中
        session.setAttribute("correctCode", code);
        captcha.write(response.getOutputStream());
    }
}
