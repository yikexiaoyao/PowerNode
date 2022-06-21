package com.bjpowernode.workbench.service;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.workbench.bean.Tran;
import com.bjpowernode.workbench.bean.TranRemark;

import java.util.List;
import java.util.Map;

/**
 * @author cty
 * @date 2021/11/14 17:02
 */
public interface TranService {
    List<Tran> list(int pageNum, int pageSize, Tran tran);

    List<User> queryUsers();

    ResultVo saveOrUpdate(Tran tran, User user);

    Tran queryById(String id);

    void deleteBatch(String ids);

    Tran toDetail(String id);

    ResultVo saveRemark(TranRemark tranRemark, User user);

    void deleteRemark(String id);

    void updateRemark(TranRemark tranRemark, User user);

    List<String> queryCustomerName(String customerName);

    Tran queryStages(String id, Integer index, Map<String, String> stagePossibilityMap, User user);

    void clearHistory(String ids);
}
