package com.bjpowernode.exterface.service;

/**
 * 收益业务接口
 *
 * @author cty
 * @date 2021/12/23 20:17
 */
public interface IncomeRecordService {
    /**
     * 定时器:生成收益计划
     */
    void generatePlan();
}
