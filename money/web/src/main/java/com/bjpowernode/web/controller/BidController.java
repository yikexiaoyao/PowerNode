package com.bjpowernode.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.common.utils.ResultVo;
import com.bjpowernode.exterface.model.LoanInfo;
import com.bjpowernode.exterface.model.User;
import com.bjpowernode.exterface.service.BidInfoService;
import com.bjpowernode.exterface.service.LoanInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 投资业务控制层
 *
 * @author cty
 * @date 2021/12/20 21:53
 */
@Controller
public class BidController {
    @Reference(interfaceClass = LoanInfoService.class, version = "1.0.0", timeout = 20000)
    LoanInfoService loanInfoService;

    @Reference(interfaceClass = BidInfoService.class, version = "1.0.0", timeout = 20000)
    BidInfoService bidInfoService;

    @RequestMapping("/loan/page/invest")
    @ResponseBody
    public Object invest(@RequestParam(name = "loanId", required = true) Integer loanId,
                         @RequestParam(name = "bidMoney", required = true) Double bidMoney,
                         HttpServletRequest request) {

        //校验：登录
        User user = (User) request.getSession().getAttribute("user");
        if (!ObjectUtils.allNotNull(user)) {
            return ResultVo.error("请先登录后，再进行投资~");
        }

        //校验：实名认证
        if (!ObjectUtils.allNotNull(user.getName(), user.getIdCard())) {
            return ResultVo.error("请完成实名认证后，再进行投资~");
        }

        //基础验证


        //剩余可投金额
        LoanInfo loanInfo = loanInfoService.getLoanInfoById(loanId);
        if (loanInfo.getLeftProductMoney() < bidMoney) {
            return ResultVo.error("您好，投资金额超过剩余可投金额" + loanInfo.getLeftProductMoney() + "元");
        }

        //单笔上下限
        if (loanInfo.getBidMaxLimit() < bidMoney || loanInfo.getBidMinLimit() > bidMoney) {
            return ResultVo.error("您好，您投资金额必须在" + loanInfo.getBidMinLimit() + "--" + loanInfo.getBidMaxLimit() + "之间");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("bidMoney", bidMoney);
        map.put("loanInfo", loanId);
        map.put("userId", user.getId());

        ExecutorService executorService = Executors.newFixedThreadPool(16);
        //模拟千人并发
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    bidInfoService.invest(map);
                }
            });
        }

        return ResultVo.success("投资成功");

    }
}
