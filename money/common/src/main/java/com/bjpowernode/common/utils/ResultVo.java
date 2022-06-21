package com.bjpowernode.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 工具类
 *
 * @author cty
 * @date 2021/12/17 19:47
 * {"code":1,"message":"","success":true}
 */
public class ResultVo {
    public static Map<String, Object> success() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "");
        map.put("success", true);
        return map;
    }

    public static Map<String, Object> success(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", msg);
        map.put("success", true);
        return map;
    }

    public static Map<String, Object> error() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("message", "");
        map.put("success", false);
        return map;
    }

    public static Map<String, Object> error(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("message", msg);
        map.put("success", false);
        return map;
    }

    //随机数
    public static String generateCode(int len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(Math.round(Math.random() * 9));
        }
        return stringBuilder.toString();
    }
}
