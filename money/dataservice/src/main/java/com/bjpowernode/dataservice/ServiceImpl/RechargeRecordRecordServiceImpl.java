package com.bjpowernode.dataservice.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.dataservice.mapper.FinanceAccountMapper;
import com.bjpowernode.dataservice.mapper.RechargeRecordMapper;
import com.bjpowernode.exterface.model.RechargeRecord;
import com.bjpowernode.exterface.service.RechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * 充值业务实现类
 *
 * @author cty
 * @date 2021/12/24 17:01
 */
@Service(interfaceClass = RechargeRecordService.class, version = "1.0.0", timeout = 20000)
@Component
public class RechargeRecordRecordServiceImpl implements RechargeRecordService {
    @Autowired
    RechargeRecordMapper rechargeRecordMapper;

    @Autowired
    FinanceAccountMapper financeAccountMapper;

    //充值：充值
    @Override
    public int recharge(RechargeRecord rechargeRecord) {
        return rechargeRecordMapper.insertSelective(rechargeRecord);
    }

    // 定时器：查询状态为0的订单
    @Override
    public List<RechargeRecord> getRechargeRecordsByZero() {
        return rechargeRecordMapper.selectRechargeRecordsByZero();
    }

    //充值：失败
    @Override
    public void rechargeFail(String out_trade_no) {
        rechargeRecordMapper.updateRechargeRecordFail(out_trade_no);
    }

    //充值：成功
    @Override
    @Transactional
    public int rechargeSuccess(String out_trade_no) {
        RechargeRecord rechargeRecord = rechargeRecordMapper.selectRechargeRecordByRechargeNo(out_trade_no);
        rechargeRecord.setRechargeStatus(1 + "");
        int num = rechargeRecordMapper.updateByPrimaryKeySelective(rechargeRecord);
        if (num != 1) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        num = financeAccountMapper.updateFinanceMoneyIncreaseForRecharge(rechargeRecord.getUid(), rechargeRecord.getRechargeMoney());
        if (num != 1) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }
}
