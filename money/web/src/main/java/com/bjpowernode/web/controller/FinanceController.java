package com.bjpowernode.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.common.utils.ResultVo;
import com.bjpowernode.exterface.model.FinanceAccount;
import com.bjpowernode.exterface.model.User;
import com.bjpowernode.exterface.service.FinanceService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 账户业务控制层
 *
 * @author cty
 * @date 2021/12/20 21:49
 */
@Controller
public class FinanceController {
    @Reference(interfaceClass = FinanceService.class, version = "1.0.0", timeout = 2000)
    FinanceService financeService;

    @GetMapping("/loan/page/queryMoney")
    @ResponseBody
    public Object queryMoney(HttpServletRequest request) {
        //校验：是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (!ObjectUtils.allNotNull(user)) {
            return ResultVo.error("请先登录后，再查询余额~");
        }

        FinanceAccount financeAccount = financeService.getMoneyByUserId(user.getId());
        System.out.println(financeAccount);
        if (!ObjectUtils.allNotNull(financeAccount)) {
            return ResultVo.error("系统繁忙，请稍后查询");
        }

        request.getSession().setAttribute("financeAccount", financeAccount);

        return ResultVo.success(financeAccount.getAvailableMoney() + "");
    }
}
