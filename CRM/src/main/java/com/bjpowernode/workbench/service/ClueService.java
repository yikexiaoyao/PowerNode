package com.bjpowernode.workbench.service;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.*;

import java.util.List;

/**
 * @author cty
 * @date 2021/11/4 16:07
 */
public interface ClueService {
    List<Clue> list(int pageNum, int pageSize, Clue clue);

    List<User> queryUsers();

    ResultVo saveOrUpdate(Clue clue, User user);

    Clue queryById(String id);

    void deleteBatch(String ids);

    Clue toDetail(String id);

    ResultVo saveRemark(ClueRemark clueRemark, User user);

    void deleteRemark(String id);

    void updateRemark(ClueRemark clueRemark, User user);

    List<Activity> searchActivity(String name, String id);

    ResultVo bind(String id, String ids, User user);

    void unbind(ActivityClueRelation activityClueRelation);

    Clue toConvert(String id);

    void convert(String id, String isCreateTransaction, Tran tran, User user);

    List<Activity> queryRelationActivities(String id, String name);
}
