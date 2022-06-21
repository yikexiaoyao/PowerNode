package com.bjpowernode.workbench.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.CommonUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.Activity;
import com.bjpowernode.workbench.bean.ActivityRemark;
import com.bjpowernode.workbench.service.ActivityService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author cty
 * @date 2021/10/28 15:57
 */
@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workbench/activity/list")
    @ResponseBody
    public PageInfo list(int pageNum, int pageSize, Activity activity) {
        List<Activity> activities = activityService.list(pageNum, pageSize, activity);
        PageInfo pageInfo = new PageInfo(activities);
        return pageInfo;
    }

    //异步查询所有者数据
    @RequestMapping("/workbench/activity/queryUsers")
    @ResponseBody
    public List<User> queryUsers() {
        return activityService.queryUsers();
    }

    //异步保存市场活动
    @RequestMapping("/workbench/activity/saveOrUpdate")
    @ResponseBody
    public ResultVo saveOrUpdate(Activity activity, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            User user = (User) session.getAttribute("user");
            resultVo = activityService.saveOrUpdate(activity, user);
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //根据主键查询市场活动
    @RequestMapping("/workbench/activity/queryById")
    @ResponseBody
    public Activity queryById(String id) {
        return activityService.queryById(id);
    }

    //批量删除
    @RequestMapping("/workbench/activity/deleteBatch")
    @ResponseBody
    public ResultVo deleteBatch(String ids) {
        ResultVo resultVo = new ResultVo();
        try {
            activityService.deleteBatch(ids);
            resultVo.setOk(true);
            resultVo.setMessage("删除市场活动成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步查询市场活动详情页数据
    @RequestMapping("/workbench/activity/toDetail")
    @ResponseBody
    public Activity toDetail(String id) {
        return activityService.toDetail(id);
    }

    //市场活动备注的保存
    @RequestMapping("/workbench/activity/saveRemark")
    @ResponseBody
    public ResultVo saveRemark(ActivityRemark activityRemark, HttpSession session) {
        ResultVo resultVo = null;
        try {
            //获取当前登录用户
            User user = CommonUtil.getCurrentUser(session);
            resultVo = activityService.saveRemark(activityRemark, user);
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步删除备注
    @RequestMapping("/workbench/activity/deleteRemark")
    @ResponseBody
    public ResultVo deleteRemark(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            activityService.deleteRemark(id);
            resultVo.setOk(true);
            resultVo.setMessage("删除备注成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //异步修改备注
    @RequestMapping("/workbench/activity/updateRemark")
    @ResponseBody
    public ResultVo updateRemark(ActivityRemark activityRemark, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            User user = CommonUtil.getCurrentUser(session);
            activityService.updateRemark(activityRemark, user);
            resultVo.setOk(true);
            resultVo.setMessage("修改备注成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    @RequestMapping("/workbench/activity/update")
    @ResponseBody
    public ResultVo updateRemark(Activity activity, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            User user = CommonUtil.getCurrentUser(session);
            activityService.update(activity, user);
            resultVo.setOk(true);
            resultVo.setMessage("修改备注成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }

    //导出报表
    @RequestMapping("/workbench/activity/exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        ExcelWriter writer = activityService.exportExcel();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=activity.xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream, true);
        writer.close();
        IoUtil.close(outputStream);
    }
}
