package com.bjpowernode.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.exterface.model.LoanInfo;
import com.bjpowernode.exterface.service.BidInfoService;
import com.bjpowernode.exterface.service.LoanInfoService;
import com.bjpowernode.exterface.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制层
 *
 * @author cty
 * @date 2021/12/14 20:55
 */
@Controller
public class IndexController {
    /**
     * http://localhost:9102/web/index
     */
    @Reference(interfaceClass = UserService.class, version = "1.0.0", retries = 3, timeout = 2000)
    UserService userService;
    @Reference(interfaceClass = LoanInfoService.class, version = "1.0.0", retries = 3, timeout = 2000)
    LoanInfoService loanInfoService;
    @Reference(interfaceClass = BidInfoService.class, version = "1.0.0", retries = 3, timeout = 2000)
    BidInfoService bidInfoService;

    @RequestMapping("/index")
    public String index(Model model) {
        //使用缓存redis
        //动力金融网历史年化收益率: 产品平均利率
        Double loanInfoHistoryRateAvg = loanInfoService.getLoanInfoHistoryRateAvg();
        loanInfoHistoryRateAvg = Double.parseDouble(String.format("%.2f", loanInfoHistoryRateAvg));
        model.addAttribute("loanInfoHistoryRateAvg", loanInfoHistoryRateAvg);

        //平台用户数:注册总人数
        Integer userCount = userService.getUserCount();
        model.addAttribute("userCount", userCount);

        //累计成交额:投资总金额
        Double totalMoney = bidInfoService.getTotalMoney();
        model.addAttribute("totalMoney", totalMoney);

        Map<String, Object> map = new HashMap<>();

        /**
         * ptype    产品类型
         * start    从数据库第几条数据开始查询
         * amount  查询几条数据
         */
        //新手宝
        map.put("ptype", 0);
        map.put("start", 0);
        map.put("amount", 1);
        List<LoanInfo> loanList = loanInfoService.getLoanInfoByTypeAndNums(map);
        model.addAttribute("loanList", loanList);

        //优选标
        map.put("ptype", 1);
        map.put("start", 0);
        map.put("amount", 4);
        List<LoanInfo> loanList2 = loanInfoService.getLoanInfoByTypeAndNums(map);
        model.addAttribute("loanList2", loanList2);

        //散标
        map.put("ptype", 2);
        map.put("start", 0);
        map.put("amount", 8);
        List<LoanInfo> loanList3 = loanInfoService.getLoanInfoByTypeAndNums(map);
        model.addAttribute("loanList3", loanList3);

        return "index";
    }
}
