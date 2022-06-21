package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.exterface.model.RechargeRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeRecord record);

    int insertSelective(RechargeRecord record);

    RechargeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeRecord record);

    int updateByPrimaryKey(RechargeRecord record);

    List<RechargeRecord> selectRechargeRecordsByZero();

    void updateRechargeRecordFail(String out_trade_no);

    RechargeRecord selectRechargeRecordByRechargeNo(String out_trade_no);
}