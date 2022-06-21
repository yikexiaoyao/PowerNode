package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.exterface.model.BidInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BidInfo record);

    int insertSelective(BidInfo record);

    BidInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BidInfo record);

    int updateByPrimaryKey(BidInfo record);

    List<BidInfo> getBidInfoByLoanId(Integer loanId);

    /**
     * 交易总额
     */
    Double getTotalMoney();
}