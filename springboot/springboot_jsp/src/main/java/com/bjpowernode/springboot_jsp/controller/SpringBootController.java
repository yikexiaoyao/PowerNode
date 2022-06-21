package com.bjpowernode.springboot_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cty
 * @date 2021/12/10 20:53
 */
@Controller
public class SpringBootController {
    /**
     * http://localhost:9201/springboot_jsp/jsp
     */
    @RequestMapping("/jsp")
    public String jsp(Model model) {
        model.addAttribute("data","SpringBoot 前端使用JSP页面！");
        return "index";
    }
}
