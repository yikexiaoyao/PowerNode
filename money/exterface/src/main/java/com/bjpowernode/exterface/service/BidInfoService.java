package com.bjpowernode.exterface.service;

import com.bjpowernode.exterface.model.BidInfo;

import java.util.List;
import java.util.Map;

/**
 * 投资业务接口
 *
 * @author cty
 * @date 2021/12/17 20:01
 */
public interface BidInfoService {
    /**
     * 累计成交额:投资总金额
     */
    Double getTotalMoney();

    /**
     * 投资记录
     */
    List<BidInfo> getBidInfoByLoanId(Integer loanId);

    /**
     * 投资：投资
     * @return
     */
    String invest(Map<String, Object> map);
}
