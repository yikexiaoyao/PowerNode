package com.bjpowernode.exterface.service;

import com.bjpowernode.exterface.model.FinanceAccount;

/**
 * 账户业务接口
 *
 * @author cty
 * @date 2021/12/20 21:50
 */
public interface FinanceService {
    /**
     * 登录后下拉：根据用户编号，查询余额
     */
    FinanceAccount getMoneyByUserId(Integer id);
}
