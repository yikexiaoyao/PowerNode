package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 * @author cty
 * @date 2021/10/21 11:00
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new InternalResourceView("/index.jsp"));
        return modelAndView;
    }
}
