package com.bjpowernode.pay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 * 修改日期：2017-04-05
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000116686435";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC/KRxWTwzM/RdCgPirt0o/jbgMsB2G7QWHLX1YNCXRI2tiJazd+4usGJJM0C0elziVPid+NmmP6esNQtEOJgn+4qSQTXt/dtf2TaR244LzgO4qm+JPACECoQMObd9Vh+Xiiz4jfM1ortp+rFIXtjt+RcZ31t9dFM4YywHoey22i549+WCQsII5f/c5lg+B87UO/vLmTFcQFbSEjaOZvf89grMk00vqmJ5flGxIEBhCZwUzt26rjGnQlaN47nw7IMkBQV3SbVQjc8YPE5EgJeGmT2t2cK36LoVfjI6KwWcsV4IR8U9tfnHpQs6lhUpp/+9B+2Z8YZXCANCFVv6tSSwfAgMBAAECggEAJ18WQQiDAG1YLxBVJzjXCAPuVl6nljSXIOJToKkM6Og8o7hSxF2cxNNCvqNZx6UpuENW6v3V/BgXm2GZoSpggKi5cCclOnmFvWr8ZqgxPmndo9T7ZX4HTn1PHdevWfRleqVnJPP9coQg6FohhlS4KCfC2sfctVUlpaGaQQGtxpzbILEHLnHL8B1Ju1Yjjj2XExMM9bLGF2XpH2kzgxFDhvNem3zt4XhGkZDP3s6tC1RqDXYPFDJQQ09POE5HAO7xYIEzHqwaV5u7JYTRQmYDGttUwQoWM5pTT56eCWvuA53ZRXz66MCH6KX4fFpWHWRJeUFVxg6VlOdF6HXB0a2uwQKBgQD6zC5fga1T47oHpJqenWZJugjtt9HTmBTDyGXCELoLyvIT+BZSuyN3QKM3rgVoeSbeLXC9Lbvb7v1nKUQFqSxKGa4ys1d1Ge9MXnHcM50xuyKqa4OwDbK91t8WIgglvZwyBSg5w0VIVy0817LRANd9bXcycGoQhVLD+pcPPgyKEQKBgQDDIDy5rnVFlroHPUlzAn8hztUrvmVaC1Rq9pomt55b6Cxz9Fe+/aaJ+TZKHbrOPrwf25nd8UB7Q5R4Zu1s6Z2qHn0jKIHX1e3fb8T341SUIuNTc5Acp3ndkrsYI1j1RkyckgjDn8PKJoM+/kh4bgFvQm08NqvHK/lKL5GT4OOjLwKBgALcybq1VDEc7EaiDlG5Ii29PdTYwEBWAAasBt1MK5Nu4YxwzHBtSl5WEobUKaOjnlny0tKV7wr3k1TWF7yozaSa3m4dteXUQfLxMQN+Y1Dp/d9MEtizj1KzXSB3ivhDTcEUZf0iyWul8xI6tAPGqq73zOB6f/toSiWKeqbl4mbBAoGBALoz7T8UKHz71RJLfefunftZMTvJOVawMSLRqVEBMHFsId+VcJal32MTGqenrzhZzZRpL3AIZQw79VbggfnJBdftuGTwptedIp5yPnh/y5qBoIVmZkOx3i1/dGMYeC+3oixXf12O/HvQPLbEWcvyzhOqRCuN0GcEo6QTuMxxc0mpAoGBAPga/6lsHna8UzJ2sLOdoVSw+M+iqRqXOfiLER64OE3+s7lI9w3Isg6yGMyXyMS1mkzQgkomx0kg1r0BQ9ygIXmAFSUDid8YcZRlS/cDj6HaoQ6fMtuwSs518YORzGeV4M7t7WDYyyhXXWbjjc2dMDwtDfDSXQ5uEKZzRC5NWoxU";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy0syXSl/Y3PQwc+MfM+u9cAQkMH1I1etofIXQipN4MSuq0KiS06C9Ni4U+XyJO/3IMEVazHAXi1fQtuemynZJBecpYZ2liipc557s4YWU868jZVyZ3ZBQCHrBTwfDIMkstx0lSbb5yn0pF18E2his/hBS361eI1pRa/iyHQiSr/UOeibqvYKTVp0TSqhp4wlCw2X2sRXq3UcSTqu95cBOvIJ9HrNcq4MVfFZnye2TR1mtDhAw3rLbK1qx1FgOIEINHBZY9298YoFij/02ooRMQ856vNqYJrSir8KBGICgTZbDRMcZ5WLiki9zQkLvo8EgvZE70xv2ixuSPYFXkgDPwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:9102/web/loan/page/payBack";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9102/web/loan/page/payBack";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
