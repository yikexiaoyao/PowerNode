package com.bjpowernode.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.EnumSet;
import java.util.Enumeration;

/**
 * @author cty
 * @date 2021/10/28 14:48
 */
@Controller
public class ViewController {
    //视图跳转的方法 /workbench/main/index /workbench/activity/index
    @RequestMapping({"/toView/{firstView}/{secondView}", "/toView/{firstView}/{secondView}/{thirdView}", "/toView/{firstView}/{secondView}/{thirdView}/{fourthView}"})
    public String toView(@PathVariable(value = "firstView", required = false) String firstView,
                         @PathVariable(value = "secondView", required = false) String secondView,
                         @PathVariable(value = "thirdView", required = false) String thirdView,
                         @PathVariable(value = "fourthView", required = false) String fourthView,
                         HttpServletRequest request) {
        //获取前台请求的所有参数的名字
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            //根据name获取value值
            String value = request.getParameter(name);
            request.setAttribute(name, value);
        }
        if (fourthView != null) {
            return firstView + File.separator + secondView + File.separator + thirdView + File.separator + fourthView;
        }
        if (thirdView != null) {
            return firstView + File.separator + secondView + File.separator + thirdView;
        }
        return firstView + File.separator + secondView;
    }
}
