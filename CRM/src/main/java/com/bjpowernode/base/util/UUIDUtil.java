package com.bjpowernode.base.util;

import java.util.UUID;

/**
 * @author cty
 * @date 2021/10/23 20:37
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
