package com.bjpowernode.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import com.bjpowernode.common.utils.HttpClientUtils;
import com.bjpowernode.common.utils.ResultVo;
import com.bjpowernode.exterface.model.RechargeRecord;
import com.bjpowernode.exterface.model.User;
import com.bjpowernode.exterface.service.RechargeRecordService;
import com.bjpowernode.exterface.service.UserService;
import com.bjpowernode.pay.config.AlipayConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 充值的控制层
 *
 * @author cty
 * @date 2021/12/24 17:00
 */
@Controller
public class RechargeController {
    @Reference(interfaceClass = RechargeRecordService.class, version = "1.0.0", timeout = 20000)
    RechargeRecordService rechargeRecordService;

    @Reference(interfaceClass = UserService.class, version = "1.0.0", timeout = 20000)
    UserService userService;

    @RequestMapping("/loan/page/toRecharge")
    public String toRecharge() {
        return "toRecharge";
    }

    @PostMapping("/loan/page/aliPay")
    public String aliPay(@RequestParam(name = "rechargeMoney", required = true) Double rechargeMoney, HttpServletRequest request, Model model) {
        System.out.println("------aliPay------" + rechargeMoney);

        //校验：是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (!ObjectUtils.allNotNull(user)) {
            return "redirect:/loan/page/login";
        }

        //校验：实名认证
        if (!ObjectUtils.allNotNull(user.getName(), user.getIdCard())) {
            return "redirect:/loan/page/realName";
        }

        //生成充值订单
        RechargeRecord rechargeRecord = new RechargeRecord();
        rechargeRecord.setRechargeDesc("支付宝充值");
        rechargeRecord.setRechargeMoney(rechargeMoney);

        //订单号：唯一
        //思考多终端同时下单，订单号唯一问题
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(date);
        rechargeRecord.setRechargeNo(format + ResultVo.generateCode(3) + user.getId() + ResultVo.generateCode(3));
        rechargeRecord.setRechargeStatus(0 + "");
        rechargeRecord.setRechargeTime(date);
        rechargeRecord.setUid(user.getId());
        int num = rechargeRecordService.recharge(rechargeRecord);
        if (num != 1) {
            model.addAttribute("trade_msg", "订单生成失败");
            return "toRechargeBack";
        }

        //去支付
        System.out.println("------去支付------");
        model.addAttribute("rechargeRecord", rechargeRecord);

        //return "redirect:http://localhost:9103/pay/loan/pay/aliPay?out_trade_no=123&total_amount=230&subject=test&body=test";
        return "toAliPay";

    }

    @RequestMapping("/loan/page/payBack")
    public String payBack(HttpServletRequest request, Model model) throws Exception {
        /* *
         * 功能：支付宝服务器同步通知页面
         * 日期：2017-03-30
         * 说明：
         * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
         * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。


         *************************页面功能说明*************************
         * 该页面仅做页面展示，业务逻辑处理请勿在该页面执行
         */

        //获取支付宝GET过来反馈信息

        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //调用SDK验证签名:校验数据是否被修改
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            //——请在这里编写您的程序（以上代码仅作参考）——
            //查询订单交易状态
            String result = HttpClientUtils.doGet("http://localhost:9103/pay/loan/pay/queryOrder?out_trade_no=" + out_trade_no);
            System.out.println("result:" + result);
            JSONObject jsonObject = JSONObject.parseObject(result).getJSONObject("alipay_trade_query_response");
            //查询通讯码
            String code = jsonObject.getString("code");
            if (!StringUtils.equals("10000", code)) {
                //...


            }

            //查询交易状态
            String trade_status = jsonObject.getString("trade_status");

            //先查询订单信息，然后再修改订单状态

            if (StringUtils.equals("WAIT_BUYER_PAY", trade_status)) {
                //最后5分钟，发条短信给用户，催促用户支付


            }
            if (StringUtils.equals("TRADE_CLOSED", trade_status)) {
                //修改订单状态为2
                rechargeRecordService.rechargeFail(out_trade_no);
            }
            if (StringUtils.equals("TRADE_SUCCESS", trade_status)) {
                //修改订单状态为1   更新余额
                rechargeRecordService.rechargeSuccess(out_trade_no);
            }

        } else {
            model.addAttribute("trade_msg", "验签失败");
            return "toRechargeBack";
        }
        return "redirect:/loan/page/myCenter";
    }

    @PostMapping("/loan/page/wxPay")
    public String wxPay(@RequestParam(name = "rechargeMoney", required = true) Double rechargeMoney, HttpServletRequest request, Model model) {
        System.out.println("------wxPay------" + rechargeMoney);

        //校验：是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (!ObjectUtils.allNotNull(user)) {
            return "redirect:/loan/page/login";
        }

        //校验：实名认证
        if (!ObjectUtils.allNotNull(user.getName(), user.getIdCard())) {
            return "redirect:/loan/page/realName";
        }

        //生成充值订单
        RechargeRecord rechargeRecord = new RechargeRecord();
        rechargeRecord.setRechargeDesc("微信充值");
        rechargeRecord.setRechargeMoney(rechargeMoney);

        //订单号：唯一
        //思考多终端同时下单，订单号唯一问题
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(date);
        rechargeRecord.setRechargeNo(format + ResultVo.generateCode(3) + user.getId() + ResultVo.generateCode(3));
        rechargeRecord.setRechargeStatus(0 + "");
        rechargeRecord.setRechargeTime(date);
        rechargeRecord.setUid(user.getId());
        int num = rechargeRecordService.recharge(rechargeRecord);
        if (num != 1) {
            model.addAttribute("trade_msg", "订单生成失败");
            return "toRechargeBack";
        }

        //去支付
        System.out.println("------去支付------");

        model.addAttribute("rechargeRecord", rechargeRecord);
        //订单放入session中   推荐
        return "wx";
    }

    @GetMapping("/loan/page/QRcode")
    public void QRcode(@RequestParam(name = "rechargeNo", required = true) String rechargeNo, HttpServletResponse response, HttpServletRequest request) throws Exception {

        User user = (User) request.getSession().getAttribute("user");
        //根据订单号 查询 订单信息
        //RechargeRecord rechargeRecord= rechargeRecordService.queryRechargeRecordsByRechargeNo(rechargeNo);
        RechargeRecord rechargeRecord = null;
        if (!rechargeRecord.getUid().equals(user.getId())) {
            return;
        }

        Map<String, Object> parasMap = new HashMap<>();
        //新手宝
        parasMap.put("out_trade_no", rechargeNo);
        parasMap.put("total_fee", rechargeRecord.getRechargeMoney());
        parasMap.put("body", rechargeRecord.getRechargeDesc());

        String result = HttpClientUtils.doPost("/007", parasMap);
        String codeUrl = JSONObject.parseObject(result).getString("codeUrl");

        Map<EncodeHintType, Object> map = new HashMap<>();
        map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        //创建一个矩阵对象(二维码)  /pay/wxPay
        BitMatrix bitMatrix = new MultiFormatWriter().encode(codeUrl, BarcodeFormat.QR_CODE, 200, 200, map);
        //BitMatrix bitMatrix=new MultiFormatWriter().encode("https://img2.baidu.com/it/u=1130098213,1569486041&fm=26&fmt=auto", BarcodeFormat.QR_CODE,200,200, map);
        MatrixToImageWriter.writeToStream(bitMatrix, "jpg", response.getOutputStream());
    }
}
