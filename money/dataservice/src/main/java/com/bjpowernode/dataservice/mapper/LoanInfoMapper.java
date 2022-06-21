package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.exterface.model.LoanInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LoanInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanInfo record);

    int insertSelective(LoanInfo record);

    LoanInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanInfo record);

    int updateByPrimaryKey(LoanInfo record);

    double getLoanInfoHistoryRateAvg();

    Long getLoanInfoCountByType(Integer ptype);

    List<LoanInfo> getLoanInfosByTypeAndNums(Map<String, Object> map);

    int updateLoanInfoLeftMoneyReduceForInvest(Map<String, Object> map);

    List<LoanInfo> getLoanInfosByFullStatus();
}