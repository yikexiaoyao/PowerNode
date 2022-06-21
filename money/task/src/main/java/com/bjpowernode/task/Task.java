package com.bjpowernode.task;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.common.utils.HttpClientUtils;
import com.bjpowernode.exterface.model.RechargeRecord;
import com.bjpowernode.exterface.service.IncomeRecordService;
import com.bjpowernode.exterface.service.RechargeRecordService;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cty
 * @date 2021/12/23 20:13
 */
@Component
public class Task {
    @Reference(interfaceClass = IncomeRecordService.class, version = "1.0.0", timeout = 20000)
    IncomeRecordService incomeRecordService;

    @Reference(interfaceClass = RechargeRecordService.class, version = "1.0.0", timeout = 20000)
    RechargeRecordService rechargeRecordService;

    //生成收益计划
    //@Scheduled(cron = "0/5 * * * * ?")  //每五秒执行一次
    public void generatePlan() {
        System.out.println("------begin------");
        incomeRecordService.generatePlan();
        System.out.println("------end------");
    }

    //生成订单
    //@Scheduled(cron = "0/5 * * * * ?")  //每五秒执行一次
    @Scheduled(cron = "* 0/5 * * * ?")  //每五分钟执行一次
    public void doRechargeRecord() {
        System.out.println("-----begin-----");

        //查询状态为0的订单
        List<RechargeRecord> rechargeRecordList = rechargeRecordService.getRechargeRecordsByZero();

        //遍历订单，查询支付宝订单交易状态
        for (RechargeRecord rechargeRecord : rechargeRecordList) {
            String result = null;
            try {
                result = HttpClientUtils.doGet("http://localhost:9104/pay/loan/pay/queryOrder?out_trade_no=" + rechargeRecord.getRechargeNo());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("result=" + result);
            JSONObject jsonObject = JSONObject.parseObject(result).getJSONObject("alipay_trade_query_response");
            System.out.println("jsonObject=" + jsonObject);
            //查询通讯码
            String code = jsonObject.getString("code");
            if (StringUtils.equals("10000", code)) {
                //查询通讯码
                String trade_status = jsonObject.getString("trade_status");
                if (StringUtils.equals("WAIT_BUYER_PAY", trade_status)) {
                    //最后5分钟，发条短信给用户，催促用户支付


                }

                //处理订单
                if (StringUtils.equals("TRADE_CLOSED", trade_status)) {
                    //修改订单状态为2
                    rechargeRecordService.rechargeFail(rechargeRecord.getRechargeNo());
                }
                if (StringUtils.equals("TRADE_SUCCESS", trade_status)) {
                    //修改订单状态为1  更新余额
                    int num = rechargeRecordService.rechargeSuccess(rechargeRecord.getRechargeNo());
                    if (num == 1) {
                        //发信息提醒订单成功


                    }
                }
            }
        }

        System.out.println("-----end-----");
    }
}
