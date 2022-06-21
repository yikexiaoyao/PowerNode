package com.bjpowernode.workbench.service;

import cn.hutool.poi.excel.ExcelWriter;
import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.Activity;
import com.bjpowernode.workbench.bean.ActivityRemark;

import java.util.List;

/**
 * @author cty
 * @date 2021/10/28 16:05
 */
public interface ActivityService {
    List<Activity> list(int pageNum, int pageSize, Activity activity);

    List<User> queryUsers();

    ResultVo saveOrUpdate(Activity activity, User user);

    Activity queryById(String id);

    void deleteBatch(String ids);

    Activity toDetail(String id);

    ResultVo saveRemark(ActivityRemark activityRemark, User user);

    void deleteRemark(String id);

    void updateRemark(ActivityRemark activityRemark, User user);

    ExcelWriter exportExcel();

}
