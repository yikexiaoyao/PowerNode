package com.bjpowernode.workbench.controller;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.CommonUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.*;
import com.bjpowernode.workbench.service.ClueService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/4 16:04
 */
@RestController
public class ClueController {

    @Autowired
    private ClueService clueService;

    @RequestMapping("/workbench/clue/list")
    public PageInfo list(int pageNum, int pageSize, Clue clue) {
        List<Clue> clues = clueService.list(pageNum, pageSize, clue);
        PageInfo pageInfo = new PageInfo(clues);
        return pageInfo;
    }

    //异步查询所有者数据
    @RequestMapping("/workbench/clue/queryUsers")
    public List<User> queryUsers() {
        return clueService.queryUsers();
    }

    //异步保存线索
    @RequestMapping("/workbench/clue/saveOrUpdate")
    public ResultVo saveOrUpdate(Clue clue, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            User user = (User) session.getAttribute("user");
            resultVo = clueService.saveOrUpdate(clue, user);
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    @RequestMapping("/workbench/clue/queryById")
    public Clue queryById(String id) {
        Clue clue = clueService.queryById(id);
        return clue;
    }

    //批量删除
    @RequestMapping("/workbench/clue/deleteBatch")
    public ResultVo deleteBatch(String ids) {
        ResultVo resultVo = new ResultVo();
        try {
            clueService.deleteBatch(ids);
            resultVo.setOk(true);
            resultVo.setMessage("删除线索成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步查询线索详情页数据
    @RequestMapping("/workbench/clue/toDetail")
    public Clue toDetail(String id) {
        return clueService.toDetail(id);
    }

    //线索备注的保存
    @RequestMapping("/workbench/clue/saveRemark")
    public ResultVo saveRemark(ClueRemark clueRemark, HttpSession session) {
        ResultVo resultVo = null;
        try {
            //获取当前登录用户
            User user = CommonUtil.getCurrentUser(session);
            resultVo = clueService.saveRemark(clueRemark, user);
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步删除备注
    @RequestMapping("/workbench/clue/deleteRemark")
    public ResultVo deleteRemark(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            clueService.deleteRemark(id);
            resultVo.setOk(true);
            resultVo.setMessage("删除备注成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步修改备注
    @RequestMapping("/workbench/clue/updateRemark")
    public ResultVo updateRemark(ClueRemark clueRemark, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            //获取登录用户
            User user = CommonUtil.getCurrentUser(session);
            clueService.updateRemark(clueRemark, user);
            resultVo.setOk(true);
            resultVo.setMessage("修改备注成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步查询市场活动
    @RequestMapping("/workbench/clue/searchActivity")
    public List<Activity> searchActivity(String name, String id) {
        return clueService.searchActivity(name, id);
    }

    //异步绑定关联市场活动
    @RequestMapping("/workbench/clue/bind")
    public ResultVo bind(String id, String ids, HttpSession session) {
        ResultVo resultVo = null;
        try {
            User user = (User) session.getAttribute("user");
            resultVo = clueService.bind(id, ids, user);
        } catch (CrmException e) {
            e.printStackTrace();
        }
        return resultVo;
    }

    //解除绑定
    @RequestMapping("/workbench/clue/unbind")
    public ResultVo unbind(ActivityClueRelation activityClueRelation) {
        ResultVo resultVo = new ResultVo();
        try {
            clueService.unbind(activityClueRelation);
            resultVo.setOk(true);
            resultVo.setMessage("解绑成功");
        } catch (CrmException e) {
            e.printStackTrace();
        }
        return resultVo;
    }

    //异步查询转换页面的线索数据
    @RequestMapping("/workbench/clue/toConvert")
    public Clue toConvert(String id) {
        return clueService.toConvert(id);
    }

    //异步转换
    @RequestMapping("/workbench/clue/convert")
    public ResultVo convert(String id, String isCreateTransaction, Tran tran, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            User user = CommonUtil.getCurrentUser(session);
            clueService.convert(id, isCreateTransaction, tran, user);
            resultVo.setOk(true);
            resultVo.setMessage("转换成功");
        } catch (CrmException e) {
            e.printStackTrace();
        }
        return resultVo;
    }

    //异步查询当前线索已经关联的市场活动
    @RequestMapping("/workbench/clue/queryRelationActivities")
    public List<Activity> queryRelationActivities(String id, String name) {
        return clueService.queryRelationActivities(id, name);
    }
}
