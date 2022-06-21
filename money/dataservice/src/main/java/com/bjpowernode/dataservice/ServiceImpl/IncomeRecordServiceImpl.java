package com.bjpowernode.dataservice.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.dataservice.mapper.BidInfoMapper;
import com.bjpowernode.dataservice.mapper.IncomeRecordMapper;
import com.bjpowernode.dataservice.mapper.LoanInfoMapper;
import com.bjpowernode.exterface.model.BidInfo;
import com.bjpowernode.exterface.model.IncomeRecord;
import com.bjpowernode.exterface.model.LoanInfo;
import com.bjpowernode.exterface.service.IncomeRecordService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 收益业务实现类
 *
 * @author cty
 * @date 2021/12/23 20:19
 */
@Service(interfaceClass = IncomeRecordService.class, version = "1.0.0", timeout = 20000)
@Component
public class IncomeRecordServiceImpl implements IncomeRecordService {
    @Autowired
    LoanInfoMapper loanInfoMapper;
    @Autowired
    BidInfoMapper bidInfoMapper;
    @Autowired
    IncomeRecordMapper incomeRecordMapper;

    /**
     * 定时器:生成收益计划
     * 1、查询 满标产品==>List
     * 2、遍历满标产品，根据满标产品查询投资记录==>List
     * 3、遍历投资记录，生成收益计划 （一条投资记录 对应 一条收益计划）
     * 4、修改产品状态2
     */
    @Override
    @Transactional
    public void generatePlan() {
        //查询满标产品
        List<LoanInfo> loanInfos = loanInfoMapper.getLoanInfosByFullStatus();

        //遍历满标产品
        for (LoanInfo loanInfo : loanInfos) {
            List<BidInfo> bidInfos = bidInfoMapper.getBidInfoByLoanId(loanInfo.getId());
            //遍历投资记录，生成收益计划
            for (BidInfo bidInfo : bidInfos) {
                IncomeRecord incomeRecord = new IncomeRecord();
                //获取投资ID和投资金额
                incomeRecord.setBidId(bidInfo.getId());
                incomeRecord.setBidMoney(bidInfo.getBidMoney());

                //获取产品满标时间和周期
                Date productFullTime = loanInfo.getProductFullTime();
                Integer cycle = loanInfo.getCycle();

                //定义返现时间和收益金额
                Date cashDate = null;
                Double income = null;
                Integer productType = loanInfo.getProductType();
                if (productType == 0) {
                    cashDate = DateUtils.addDays(productFullTime, cycle);
                    //日收益
                    income = loanInfo.getRate() / 100 / 365 * cycle * bidInfo.getBidMoney();
                } else {
                    //月收益
                    cashDate = DateUtils.addDays(productFullTime, cycle);
                    income = loanInfo.getRate() / 100 / 365 * cycle * 30 * bidInfo.getBidMoney();
                }
                incomeRecord.setIncomeDate(cashDate);
                incomeRecord.setIncomeMoney(new BigDecimal(income).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                incomeRecord.setIncomeStatus(0);    //0 未返现     1   已返现
                incomeRecord.setLoanId(bidInfo.getLoanId());
                incomeRecord.setUid(bidInfo.getUid());
                incomeRecordMapper.insertSelective(incomeRecord);
            }

            //修改产品状态2
            loanInfo.setProductStatus(2);   //0 未满标  1已满标    2  满标
            loanInfoMapper.updateByPrimaryKeySelective(loanInfo);
        }
    }
}
