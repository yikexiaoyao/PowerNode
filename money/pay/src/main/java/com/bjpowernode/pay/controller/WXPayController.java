package com.bjpowernode.pay.controller;

import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付控制层
 *
 * @author cty
 * @date 2021/12/27 14:33
 */
public class WXPayController {
    @RequestMapping("/loan/pay/wxPay")
    @ResponseBody
    public Object wxPay(@RequestParam(value = "out_trade_no", required = true) String out_trade_no,
                        @RequestParam(value = "total_fee", required = true) String total_fee,
                        @RequestParam(value = "body", required = true) String body) throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("appid", "wx8a3fcf509313fd74");
        map.put("mch_id", "1361137902");
        map.put("nonce_str", WXPayUtil.generateNonceStr());
        map.put("body", body);
        map.put("out_trade_no", out_trade_no);

        //转换金额
        BigDecimal bigDecimal = new BigDecimal(total_fee);
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(100));
        int i = multiply.intValue();

        map.put("total_fee", i + "");
        map.put("spbill_create_ip", "127.0.0.1");
        map.put("notify_url", "http://localhost:9090/pay/wxPay");
        map.put("trade_type", "NATIVE");
        map.put("product_id", out_trade_no);

        //生成签名值:generateSignature保证数据安全
        map.put("sign", WXPayUtil.generateSignature(map, "367151c5fd0d50f1e34a68a802d6bbca"));

        String xml = WXPayUtil.mapToXml(map);

        //发起请求
        // String responseDataXml = HttpClientUtils.doPostByXml("https://api.mch.weixin.qq.com/pay/unifiedorder", xml);
        String responseDataXml = "";

        return WXPayUtil.xmlToMap(responseDataXml);

    }
}
