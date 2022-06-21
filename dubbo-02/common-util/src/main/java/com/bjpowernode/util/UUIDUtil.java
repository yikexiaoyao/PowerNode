package com.bjpowernode.util;

import java.util.UUID;

/**
 * @author cty
 * @date 2021/12/6 10:05
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
