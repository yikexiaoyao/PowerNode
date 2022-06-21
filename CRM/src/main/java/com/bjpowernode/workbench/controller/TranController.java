package com.bjpowernode.workbench.controller;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.CommonUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.Tran;
import com.bjpowernode.workbench.bean.TranRemark;
import com.bjpowernode.workbench.service.TranService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author cty
 * @date 2021/11/14 17:02
 */
@RestController
public class TranController {
    @Autowired
    private TranService tranService;

    @RequestMapping("/workbench/tran/list")
    public PageInfo list(int pageNum, int pageSize, Tran tran) {
        List<Tran> trans = tranService.list(pageNum, pageSize, tran);
        PageInfo pageInfo = new PageInfo(trans);
        return pageInfo;
    }

    //异步查询所有者数据
    @RequestMapping("/workbench/tran/queryUsers")
    public List<User> queryUsers() {
        return tranService.queryUsers();
    }

    //异步保存交易
    @RequestMapping("/workbench/tran/saveOrUpdate")
    public ResultVo saveOrUpdate(Tran tran, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            User user = (User) session.getAttribute("user");
            resultVo = tranService.saveOrUpdate(tran, user);
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //根据主键查询交易
    @RequestMapping("/workbench/tran/queryById")
    public Tran queryById(String id) {
        return tranService.queryById(id);
    }

    //批量删除
    @RequestMapping("/workbench/tran/deleteBatch")
    public ResultVo deleteBatch(String ids) {
        ResultVo resultVo = new ResultVo();
        try {
            tranService.deleteBatch(ids);
            resultVo.setOk(true);
            resultVo.setMessage("删除市场活动成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步查询交易详情页数据
    @RequestMapping("/workbench/tran/toDetail")
    public Tran toDetail(String id) {
        return tranService.toDetail(id);
    }

    //交易备注的保存
    @RequestMapping("/workbench/tran/saveRemark")
    public ResultVo saveRemark(TranRemark tranRemark, HttpSession session) {
        ResultVo resultVo = null;
        try {
            //获取当前登录用户
            User user = CommonUtil.getCurrentUser(session);
            resultVo = tranService.saveRemark(tranRemark, user);
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步删除备注
    @RequestMapping("/workbench/tran/deleteRemark")
    public ResultVo deleteRemark(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            tranService.deleteRemark(id);
            resultVo.setOk(true);
            resultVo.setMessage("删除备注成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步修改备注
    @RequestMapping("/workbench/tran/updateRemark")
    public ResultVo updateRemark(TranRemark tranRemark, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            User user = CommonUtil.getCurrentUser(session);
            tranService.updateRemark(tranRemark, user);
            resultVo.setOk(true);
            resultVo.setMessage("修改备注成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //客户名称自动补全
    @RequestMapping("/workbench/tran/queryCustomerName")
    public List<String> queryCustomerName(String customerName){
        return tranService.queryCustomerName(customerName);
    }

    //异步查询阶段和可能性
    @RequestMapping("/workbench/tran/stagePossibility")
    public String stagePossibility(String stage, HttpSession session){
        Map<String,String> stagePossibilityMap = (Map<String, String>) session.getServletContext().getAttribute("stagePossibilityMap");
        return stagePossibilityMap.get(stage);
    }

    //异步查询交易阶段图标
    @RequestMapping("/workbench/tran/queryStages")
    public Tran queryStages(String id,Integer index, HttpSession session){
        //获取当前登录用户
        User user = CommonUtil.getCurrentUser(session);
        Map<String,String> stagePossibilityMap = (Map<String, String>) session.getServletContext().getAttribute("stagePossibilityMap");
        Tran tran = tranService.queryStages(id,index,stagePossibilityMap,user);
        return tran;
    }

    //清空历史
    @RequestMapping("/workbench/tran/clearHistory")
    public ResultVo clearHistory(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            tranService.clearHistory(id);
            resultVo.setOk(true);
            resultVo.setMessage("清空历史成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }
}
