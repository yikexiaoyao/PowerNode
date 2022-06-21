package com.bjpowernode.base.bean;

import lombok.Data;

/**
 * @author cty
 * @date 2021/10/24 22:57
 */
@Data
public class ResultVo<T> {
    private boolean isOk;   //用户操作情况
    private String message; //返回给客户端
    private T t;    //给客户端返回的数据
}
