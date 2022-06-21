package controller;

import entity.User;
import model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cty
 * @date 2021/10/21 11:02
 */
@Controller
@RequestMapping("ajax")
public class AjaxController {

    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping("getUser")
    Map<String, Object> getUser(String userName) {
        Map<String, Object> map = new HashMap<>();
        //根据用户名查询它是否可用
        User user = userService.getByUserName(userName);
        if (user != null) {
            //说明用户名不可用，被占用了
            map.put("result", 0);
        } else {
            //说明用户名可用
            map.put("result", 1);
        }
        return map;
    }
}
