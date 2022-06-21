package controller;

import entity.User;
import model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author cty
 * @date 2021/10/21 9:18
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("list")
    Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        List<User> list = userService.list();
        map.put("userList", list);
        return map;
    }

    @RequestMapping("edit")
    void edit(User user, Integer id) {
        if (id != null) {
            User userDB = userService.get(id);
            BeanUtils.copyProperties(userDB, user);
        }
    }

    @RequestMapping("save")
    String save(User user) {
        if (user.getId() != null) {
            userService.update(user);
        } else {
            userService.save(user);
        }
        return "redirect:list";
    }

    @RequestMapping("delete")
    String delete(int id) {
        userService.delete(id);
        return "redirect:list";
    }

    @RequestMapping("delBatch")
    String delBatch(@RequestParam Set<Integer> ids) {
        userService.delBatch(ids);
        return "redirect:list";
    }
}
