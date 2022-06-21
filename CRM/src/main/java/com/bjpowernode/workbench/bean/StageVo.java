package com.bjpowernode.workbench.bean;

import lombok.Data;

/**
 * @author cty
 * @date 2021/11/14 16:59
 */
@Data
public class StageVo {
    private String type;//图标的类型 绿圈、红x
    private String content;//阶段图标的内容
    private String possibility;//可能性
}
