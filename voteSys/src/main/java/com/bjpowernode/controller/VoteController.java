package com.bjpowernode.controller;

import com.bjpowernode.bean.Article;
import com.bjpowernode.bean.ResultVo;
import com.bjpowernode.bean.User;
import com.bjpowernode.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/27 15:53
 */
@Controller
public class VoteController {
    @Autowired
    private VoteService voteService;

    @RequestMapping("/")
    public String toIndex(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "forward:/article/list";
        }
        return "forward:/login.jsp";
    }

    //发布文章
    @RequestMapping("/article/push")
    public String push(Article article, HttpSession session) {
        User user = (User) session.getAttribute("user");
        voteService.push(article, user);
        return "forward:/article/list";
    }

    //每页信息数量
    int pageSize = 5;

    //查询列表
    @RequestMapping("/article/list")
    public String list(Model model, @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "votes") String type,
                       @RequestParam(defaultValue = "asc") String ascOrDesc,
                       String option, String keyword) {
        List<Article> articles = null;

        if ("search".equals(option) && keyword != null && keyword != "") {
            //根据title模糊查询
            articles = voteService.search(keyword);

        } else {
            articles = voteService.list(type,pageSize, page, ascOrDesc);
        }

        //算出总记录数
        int total = voteService.count();

        //计算出总页数
        int pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

        model.addAttribute("pages", pages);
        model.addAttribute("pageNow", page);
        model.addAttribute("articles", articles);

        return "index";
    }

    //异步点赞
    @RequestMapping("/article/vote")
    @ResponseBody
    public ResultVo vote(String id, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        User user = (User) session.getAttribute("user");
        boolean voteOk = voteService.vote(id, user);
        //判断是否可以投票
        if (!voteOk) {
            resultVo.setMessage("不能重复投票");
        } else {
            resultVo.setOk(true);
        }
        return resultVo;
    }

}
