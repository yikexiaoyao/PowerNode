package com.bjpowernode.dataservice.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.common.utils.Constant;
import com.bjpowernode.dataservice.mapper.BidInfoMapper;
import com.bjpowernode.dataservice.mapper.FinanceAccountMapper;
import com.bjpowernode.dataservice.mapper.LoanInfoMapper;
import com.bjpowernode.exterface.model.BidInfo;
import com.bjpowernode.exterface.model.LoanInfo;
import com.bjpowernode.exterface.service.BidInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 投资业务实现类
 *
 * @author cty
 * @date 2021/12/17 20:04
 */
@Service(interfaceClass = BidInfoService.class, version = "1.0.0", retries = 3, timeout = 20000)
@Component
public class BidInfoServiceImpl implements BidInfoService {
    @Autowired
    BidInfoMapper bidInfoMapper;

    @Autowired
    LoanInfoMapper loanInfoMapper;

    @Autowired
    FinanceAccountMapper financeAccountMapper;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 累计成交额:投资总金额
     */
    @Override
    public Double getTotalMoney() {
        Double totalMoney = (Double) redisTemplate.opsForValue().get("TotalMoney");
        if (totalMoney == null) {
            totalMoney = bidInfoMapper.getTotalMoney();
            redisTemplate.opsForValue().set("TotalMoney", totalMoney, 20000, TimeUnit.SECONDS);
        }
        return totalMoney;
    }

    /**
     * 详情页面：根据编号查询投资记录
     */
    @Override
    public List<BidInfo> getBidInfoByLoanId(Integer loanId) {
        return bidInfoMapper.getBidInfoByLoanId(loanId);
    }

    /**
     * 投资：投资
     * 1、剩余可投金额减少
     * 2、账户余额减少
     * 3、是否满标
     * 4、添加投资记录
     *
     * @return
     */
    @Override
    @Transactional
    public String invest(Map<String, Object> map) {
        //查询产品版本号
        LoanInfo loanInfo = loanInfoMapper.selectByPrimaryKey((Integer) map.get("loanId"));

        //设置版本号
        map.put("version", loanInfo.getVersion());

        //剩余可投金额减少
        int num = loanInfoMapper.updateLoanInfoLeftMoneyReduceForInvest(map);
        if (num != 1) {
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Constant.BID_LOAN_LEFTMONEY_FAIL;
        }

        //账户余额减少
        num = financeAccountMapper.updateFinanceMoneyReduceForInvest(map);
        if (num != 1) {
            // throw  new RuntimeException("账户余额不足");
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Constant.BID_FINANACE_MONEY_FAIL;

        }

        //是否满标
        LoanInfo loanInfo1 = loanInfoMapper.selectByPrimaryKey((Integer) map.get("loanId"));
        if (loanInfo1.getLeftProductMoney() == 0 && loanInfo1.getProductStatus() == 0) {
            loanInfo1.setProductStatus(1);
            loanInfo1.setProductFullTime(new Date());
            num = loanInfoMapper.updateByPrimaryKey(loanInfo1);
            if (num != 1) {
                return Constant.BID_LOAN_STATUS_FAIL;
            }
        }

        //添加投资记录
        BidInfo bidInfo = new BidInfo();
        bidInfo.setBidMoney((Double) map.get("bidMoney"));
        bidInfo.setBidStatus(1);
        bidInfo.setBidTime(new Date());
        bidInfo.setLoanId((Integer) map.get("loanId"));
        bidInfo.setUid((Integer) map.get("userId"));

        num = bidInfoMapper.insertSelective(bidInfo);
        if (num != 1) {
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Constant.BID_INFO_FAIL;
        }

        return Constant.BID_INFO_SUCCESS;
    }
}
