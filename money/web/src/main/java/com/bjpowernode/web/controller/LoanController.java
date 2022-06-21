package com.bjpowernode.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.common.utils.PageModel;
import com.bjpowernode.exterface.model.BidInfo;
import com.bjpowernode.exterface.model.LoanInfo;
import com.bjpowernode.exterface.service.BidInfoService;
import com.bjpowernode.exterface.service.LoanInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 产品控制层
 *
 * @author cty
 * @date 2021/12/16 21:51
 */
@Controller
public class LoanController {



    @Reference(interfaceClass = LoanInfoService.class, version = "1.0.0", retries = 3, timeout = 2000)
    LoanInfoService loanInfoService;

    @Reference(interfaceClass = BidInfoService.class, version = "1.0.0", retries = 3, timeout = 2000)
    BidInfoService bidInfoService;



    @RequestMapping("/loan")
    public String loan(@RequestParam(name = "ptype", required = true) Integer ptype, Long currentPage, Model model, HttpServletRequest request) {
        //产品信息
        PageModel pageModel = (PageModel) request.getSession().getAttribute("pageModel");
        if (pageModel == null) {
            pageModel = new PageModel(9);
            request.getSession().setAttribute("pageModel", pageModel);
        }

        //查询总记录数
        Long totalCount = loanInfoService.getLoanInfoCountByType(ptype);
        pageModel.setTotalCount(totalCount);

        //如果没有指定当前页 ，默认为首页
        if (currentPage == null || currentPage < pageModel.getFirstPage()) {
            //初始化当前页
            currentPage = 1L;
        }

        //设置尾页
        if (currentPage > pageModel.getLastPage()) {
            currentPage = pageModel.getLastPage();
        }

        pageModel.setCurrentPage(currentPage);

        List<LoanInfo> loanInfos = loanInfoService.getLoanInfoByTypeAndPageModel(ptype, pageModel);
        model.addAttribute("loanInfos", loanInfos);
        model.addAttribute("ptype", ptype);

        return "loan";
    }

    @RequestMapping("/loan/loanInfo")
    public String loanInfo(@RequestParam(name = "loanId", required = true) Integer loanId, Model model) {
        //产品详情
        LoanInfo loanInfo = loanInfoService.getLoanInfoById(loanId);
        model.addAttribute("loanInfo", loanInfo);

        //投资记录
        List<BidInfo> bidInfos = bidInfoService.getBidInfoByLoanId(loanId);
        model.addAttribute("bidInfos", bidInfos);

        return "loanInfo";
    }
}