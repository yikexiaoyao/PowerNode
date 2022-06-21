package com.bjpowernode.exterface.service;

import com.bjpowernode.exterface.model.RechargeRecord;

import java.util.List;

/**
 * 充值业务接口
 *
 * @author cty
 * @date 2021/12/24 17:00
 */
public interface RechargeRecordService {
    /**
     * 充值：充值
     */
    int recharge(RechargeRecord rechargeRecord);

    /**
     * 定时器：查询状态为0的订单
     */
    List<RechargeRecord> getRechargeRecordsByZero();

    /**
     * 充值：失败
     */
    void rechargeFail(String out_trade_no);

    /**
     * 充值：成功
     */
    int rechargeSuccess(String out_trade_no);
}
