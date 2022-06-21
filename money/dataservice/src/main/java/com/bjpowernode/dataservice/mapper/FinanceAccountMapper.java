package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.exterface.model.FinanceAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface FinanceAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinanceAccount record);

    int insertSelective(FinanceAccount record);

    FinanceAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinanceAccount record);

    int updateByPrimaryKey(FinanceAccount record);

    /**
     * 登录后下拉：根据用户编号，查询余额
     */
    FinanceAccount getMoneyByUserId(Integer id);

    /**
     * 投资：账户余额减少
     */
    int updateFinanceMoneyReduceForInvest(Map<String, Object> map);

    /**
     * 充值：更新账户余额
     */
    int updateFinanceMoneyIncreaseForRecharge(@Param("uid") Integer uid, @Param("rechargeMoney") Double rechargeMoney);
}